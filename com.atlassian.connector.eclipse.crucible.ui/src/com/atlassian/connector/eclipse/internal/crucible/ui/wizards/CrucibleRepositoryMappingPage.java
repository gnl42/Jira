/*******************************************************************************
 * Copyright (c) 2009 Atlassian and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlassian - initial API and implementation
 ******************************************************************************/

package com.atlassian.connector.eclipse.internal.crucible.ui.wizards;

import com.atlassian.connector.eclipse.fisheye.ui.preferences.AddOrEditFishEyeMappingDialog;
import com.atlassian.connector.eclipse.internal.crucible.core.TaskRepositoryUtil;
import com.atlassian.connector.eclipse.internal.crucible.ui.CrucibleUiUtil;
import com.atlassian.connector.eclipse.internal.fisheye.ui.FishEyeImages;
import com.atlassian.theplugin.commons.crucible.api.model.Repository;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class CrucibleRepositoryMappingPage extends WizardPage {

	private final Map<String, String> repositoryMappings;

	private final TaskRepository taskRepository;

	private TableViewer repositoriesMappingViewer;

	private Set<Repository> cachedRepositories;

	protected CrucibleRepositoryMappingPage(String pageName, TaskRepository repository) {
		super(pageName);

		this.repositoryMappings = TaskRepositoryUtil.getScmRepositoryMappings(repository);
		this.taskRepository = repository;

	}

	public Composite createRepositoryMappingComposite(Composite composite, int hSizeHint) {
		final Composite mappingComposite = new Composite(composite, SWT.NONE);

		final Table table = new Table(mappingComposite, SWT.BORDER);
		table.setHeaderVisible(true);

		GridDataFactory.fillDefaults().hint(hSizeHint, 100).grab(true, true).applyTo(table);
		repositoriesMappingViewer = new TableViewer(table);
		repositoriesMappingViewer.setContentProvider(new ArrayContentProvider());

		final TableViewerColumn column1 = new TableViewerColumn(repositoriesMappingViewer, SWT.NONE);
		column1.getColumn().setText("SCM Path");
		column1.getColumn().setWidth(500);
		column1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return FishEyeImages.getImage(FishEyeImages.REPOSITORY);
			}
		});

		final TableViewerColumn column2 = new TableViewerColumn(repositoriesMappingViewer, SWT.NONE);
		column2.getColumn().setText("Crucible Repository");
		column2.getColumn().setWidth(200);
		column2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String mapping = repositoryMappings.get(element);
				if (mapping != null) {
					return mapping;
				}
				return "";
			}
		});

		final Button editButton = new Button(mappingComposite, SWT.PUSH);
		editButton.setText("Edit...");
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editRepositoryMapping();
			}
		});
		editButton.setEnabled(false);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(editButton);

		table.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				editRepositoryMapping();
			}

			public void widgetSelected(SelectionEvent e) {
				ISelection selection = repositoriesMappingViewer.getSelection();
				if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
					editButton.setEnabled(true);
				} else {
					editButton.setEnabled(false);
				}
			}

		});

		repositoriesMappingViewer.setInput(getMappingViewerInput());
		return mappingComposite;
	}

	private void editRepositoryMapping() {
		ISelection selection = repositoriesMappingViewer.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			String scmPath = ((IStructuredSelection) selection).getFirstElement().toString();
			if (cachedRepositories == null) {
				cachedRepositories = CrucibleUiUtil.getCachedRepositories(taskRepository);
			}

			String sourceRepository = repositoryMappings.get(scmPath);

			AddOrEditFishEyeMappingDialog dialog = new AddOrEditFishEyeMappingDialog(
					repositoriesMappingViewer.getTable().getShell(), taskRepository, scmPath, sourceRepository);

			dialog.setTaskRepositoryEnabled(false);

			if (dialog.open() == Window.OK) {
				repositoryMappings.remove(scmPath); // remove old mapping
				repositoryMappings.put(dialog.getScmPath(), dialog.getSourceRepository());
				repositoriesMappingViewer.setInput(getMappingViewerInput());

				final Map<String, String> repositoryMappingsCopy = new HashMap<String, String>(
						repositoryMappings.size());
				for (Map.Entry<String, String> entry : repositoryMappings.entrySet()) {
					if (entry.getValue() != null) {
						repositoryMappingsCopy.put(entry.getKey(), entry.getValue());
					}
				}
				TaskRepositoryUtil.setScmRepositoryMappings(taskRepository, repositoryMappingsCopy);
			}
		}
		validatePage();
	}

	protected Control createUpdateRepositoryDataButton(Composite composite) {
		Button updateData = new Button(composite, SWT.PUSH);
		updateData.setText("Update Repository Data");
		final WizardPage mainPage = this;
		updateData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CrucibleUiUtil.updateTaskRepositoryCache(taskRepository, getContainer(), mainPage);
				clearCachedCrucibleRepositories();
			}
		});

		return updateData;
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if (visible && !CrucibleUiUtil.hasCachedData(getTaskRepository())) {
			final WizardPage page = this;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (!CrucibleUiUtil.hasCachedData(getTaskRepository())) {
						CrucibleUiUtil.updateTaskRepositoryCache(taskRepository, getContainer(), page);
					}
				}
			});
		}
	}

	public TaskRepository getTaskRepository() {
		return taskRepository;
	}

	public Map<String, String> getRepositoryMappings() {
		return repositoryMappings;
	}

	protected void clearCachedCrucibleRepositories() {
		cachedRepositories = null;
	}

	protected abstract void validatePage();

	protected abstract Collection<String> getMappingViewerInput();

	protected void refreshRepositoriesMappingViewer() {
		repositoriesMappingViewer.setInput(getMappingViewerInput());
	}

}
