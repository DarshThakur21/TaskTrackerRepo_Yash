package com.yash.controller;



import com.yash.models.TaskPriority;
import com.yash.models.TaskStatus;
import com.yash.utils.DBConnection;
import com.yash.daoimpl.TaskDAOImpl;

import com.yash.models.Task;
import com.yash.service.TaskService;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection not established.");
            return;
        }

        TaskService service = new TaskService(new TaskDAOImpl(conn));

        // Create a new task
        Task task = new Task("T002", "Design Homepage", "Create layout for homepage",
                TaskStatus.ASSIGNED, TaskPriority.HIGH, new Date());
        service.createTask(task);
        System.out.println("Task created.");

        // Read task by ID
        Task fetched = service.getTaskById("T001");
        System.out.println("Fetched Task: " + fetched.getName());

        // Update task
        fetched.setDescription("Update homepage layout with new branding");
        fetched.setTaskStatus(TaskStatus.IN_PROGRESS);
        service.updateTask(fetched);
        System.out.println("Task updated.");

        // List all tasks
        List<Task> allTasks = service.getAllTasks();
        System.out.println("All Tasks:");
        for (int i = 0; i < allTasks.size(); i++) {
            System.out.println("- " + allTasks.get(i).getName());
        }

        // Delete task
//        service.deleteTask("T001");
//        System.out.println("Task deleted.");
    }
}

