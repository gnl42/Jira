/*******************************************************************************
 * Copyright (c) 2004, 2007 Mylyn project committers and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.mylyn.internal.jira.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.mylyn.internal.jira.core.JiraCustomQuery;
import org.eclipse.mylyn.internal.jira.core.model.filter.ContentFilter;
import org.eclipse.mylyn.internal.jira.core.model.filter.FilterDefinition;
import org.eclipse.mylyn.tasks.core.RepositoryTaskData;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.AbstractDuplicateDetector;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.mylyn.tasks.ui.editors.AbstractNewRepositoryTaskEditor;
import org.eclipse.mylyn.tasks.ui.search.SearchHitCollector;

/**
 * Stack Trace duplicate detector
 * 
 * @author Eugene Kuleshov
 */
public class JiraStackTraceDuplicateDetector extends AbstractDuplicateDetector {

	private static final String NO_STACK_MESSAGE = "Unable to locate a stack trace in the description text.";

	@Override
	public SearchHitCollector getSearchHitCollector(TaskRepository repository, RepositoryTaskData taskData) {
		String searchString = AbstractNewRepositoryTaskEditor.getStackTraceFromDescription(taskData.getDescription());
		if (searchString == null) {
			MessageDialog.openWarning(null, "No Stack Trace Found", NO_STACK_MESSAGE);
			return null;
		}

		String encoding = repository.getCharacterEncoding();

		FilterDefinition filter = new FilterDefinition();
		filter.setContentFilter(new ContentFilter(searchString, false, true, false, true));

		JiraCustomQuery query = new JiraCustomQuery(repository.getRepositoryUrl(), filter, encoding);

		return new SearchHitCollector(TasksUi.getTaskListManager().getTaskList(), repository, query);
	}

}
