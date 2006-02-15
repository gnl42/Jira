/*******************************************************************************
 * Copyright (c) 2006 - 2006 Mylar eclipse.org project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Mylar project committers - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylar.internal.jira;

import org.eclipse.mylar.internal.core.util.MylarStatusHandler;
import org.eclipse.mylar.internal.tasklist.AbstractQueryHit;
import org.eclipse.mylar.internal.tasklist.AbstractRepositoryClient;
import org.eclipse.mylar.internal.tasklist.AbstractRepositoryTask;
import org.eclipse.mylar.internal.tasklist.MylarTaskListPlugin;
import org.eclipse.mylar.internal.tasklist.TaskRepository;
import org.tigris.jira.core.model.Issue;

/**
 * Represents an issue returned as the result of a Jira Filter (Query)
 * 
 * @author Wesley Coelho (initial integration patch)
 * @author Mik Kersten
 */
public class JiraFilterHit extends AbstractQueryHit {

	private Issue issue = null;

	private AbstractRepositoryTask task = null;

	public JiraFilterHit(Issue issue) {	
		this.issue = issue;
		TaskRepository repository = MylarTaskListPlugin.getRepositoryManager().getDefaultRepository(
				MylarJiraPlugin.JIRA_REPOSITORY_KIND);
		if (repository != null) {
			setRepositoryUrl(repository.getUrl() + MylarJiraPlugin.ISSUE_URL_PREFIX + issue.getKey());
		} else {
			MylarStatusHandler.fail(new RuntimeException("JiraFilterHit couldn't get repository"),
					"Couldn't get repository for Jira Hit", false);
		}
		task = getOrCreateCorrespondingTask();
	}
	
	public Issue getIssue() {
		return issue;
	}

	public AbstractRepositoryTask getOrCreateCorrespondingTask() {
		if (task == null) {
			String summary = issue.getSummary();
			task = new JiraTask(getRepositoryUrl(), summary, true);
			AbstractRepositoryClient client = MylarTaskListPlugin.getRepositoryManager().getRepositoryClient(
					MylarJiraPlugin.JIRA_REPOSITORY_KIND);
			if (client != null) {
				client.addTaskToArchive(task);
			} else {
				MylarStatusHandler.log("No Jira Client for Jira Task", this);
			}
		}
		if (issue != null && issue.getPriority() != null) {
			String translatedPriority = JiraTask.PriorityLevel.fromPriority(issue.getPriority()).toString();
			task.setPriority(translatedPriority);
			task.setKind(issue.getType().getName());
		} 
		return task;
	}

	/**
	 * @return null if there is no corresponding report
	 */
	public AbstractRepositoryTask getCorrespondingTask() {
		return task;
	}

	public void setCorrespondingTask(AbstractRepositoryTask task) {
		this.task = task;
	}

	public boolean isCompleted() {
		if (issue != null && issue.getStatus() != null) {
			return issue.getStatus().isClosed() || issue.getStatus().isResolved();
		} else {
			return false;
		}
	}

	public boolean isDragAndDropEnabled() {
		return false;
	}

	public String getPriority() { 
		return task.getPriority();
	}

	public String getDescription() {
		return issue.getSummary();
	}

	public void setDescription(String description) {
		task.setDescription(description);
	}

	public String getHandleIdentifier() {
		return getRepositoryUrl();
	}

	public void setHandleIdentifier(String id) {
		task.setHandleIdentifier(id);
	}

	public boolean isLocal() {
		return false;
	}

}