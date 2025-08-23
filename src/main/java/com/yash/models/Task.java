package com.yash.models;


import com.yash.models.TaskPriority;
import com.yash.models.TaskStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    private String tId;
    private String name;
    private String description;
    private TaskStatus taskStatus;
    private TaskPriority priority;
    private Date createdDate;
    private Date submittedAt;
    private String submittedBy;

    private List<TaskAssignment> assignments;
    private List<TaskSubmission> submissions;

    public Task() {
        this.assignments = new ArrayList();
        this.submissions = new ArrayList();
    }

    public Task(String tId, String name, String description, TaskStatus taskStatus,
                TaskPriority priority, Date createdDate) {
        this.tId = tId;
        this.name = name;
        this.description = description;
        this.taskStatus = taskStatus;
        this.priority = priority;
        this.createdDate = createdDate;
        this.assignments = new ArrayList();
        this.submissions = new ArrayList();
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public List<TaskAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<TaskAssignment> assignments) {
        this.assignments = assignments;
    }

    public List<TaskSubmission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<TaskSubmission> submissions) {
        this.submissions = submissions;
    }
}
