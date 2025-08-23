package com.yash.models;

import java.util.Date;

public class TaskAssignment {
    private String tId;
    private String assignedTo;
    private Date assignedAt;

    public TaskAssignment() {}

    public TaskAssignment(String tId, String assignedTo, Date assignedAt) {
        this.tId = tId;
        this.assignedTo = assignedTo;
        this.assignedAt = assignedAt;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(Date assignedAt) {
        this.assignedAt = assignedAt;
    }
}
