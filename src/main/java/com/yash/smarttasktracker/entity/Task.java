package com.yash.smarttasktracker.entity;

import java.util.ArrayList;
import java.util.List;

class Task {
    private Long id;
    private String title;
    private String description;

    private User manager; // manager who created/assigned
    private List<User> assignedUsers = new ArrayList<>(); // multiple users
//    private List<SubTask> subTasks = new ArrayList<>();

    public Task() {}

    public Task(Long id, String title, String description, User manager) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.manager = manager;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getManager() { return manager; }
    public void setManager(User manager) { this.manager = manager; }

    public List<User> getAssignedUsers() { return assignedUsers; }
    public void setAssignedUsers(List<User> assignedUsers) { this.assignedUsers = assignedUsers; }

//    public List<SubTask> getSubTasks() { return subTasks; }
//    public void setSubTasks(List<SubTask> subTasks) { this.subTasks = subTasks; }



    // toString
    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + "'}";
    }
}
