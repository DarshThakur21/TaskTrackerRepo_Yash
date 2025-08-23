package com.yash.models;



import java.util.Date;

public class TaskSubmission extends Task {
    private String tId;
    private String submittedBy;
    private Date submittedAt;
    private TaskStatus status;

    public TaskSubmission() {}

    public TaskSubmission(String tId, String submittedBy, Date submittedAt, TaskStatus status) {
        this.tId = tId;
        this.submittedBy = submittedBy;
        this.submittedAt = submittedAt;
        this.status = status;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
