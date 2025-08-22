package com.yash.smarttasktracker.entity;


import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String role; // "ADMIN", "MANAGER", "USER"

    private List<Task> assignedTasks = new ArrayList<>(); // multiple assigned tasks
//    private List<PersonalTask> personalTasks = new ArrayList<>(); // personal tasks

    public User() {}

    public User(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<Task> getAssignedTasks() { return assignedTasks; }
    public void setAssignedTasks(List<Task> assignedTasks) { this.assignedTasks = assignedTasks; }

//    public List<PersonalTask> getPersonalTasks() { return personalTasks; }
//    public void setPersonalTasks(List<PersonalTask> personalTasks) { this.personalTasks = personalTasks; }


    // toString
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', role='" + role + "'}";
    }
}