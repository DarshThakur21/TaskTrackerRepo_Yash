package com.yash.tasktracker.controller;


import com.yash.tasktracker.models.User;
import com.yash.tasktracker.models.UserRole;
import com.yash.tasktracker.service.UserService;


public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        // Register users
        service.registerUser(new User("Alice", "alice@example.com", UserRole.ADMIN));
        service.registerUser(new User("Bob", "bob@example.com", UserRole.MANAGER));
        service.registerUser(new User("Charlie", "charlie@example.com", UserRole.EMPLOYEE));

        // Assign role
        service.assignRole(3, UserRole.MANAGER); // Charlie → Manager

        // Get all users
        System.out.println("All Users:");
        service.getAllUsers().forEach(System.out::println);

        // Get managers
        System.out.println("\nManagers:");
        service.getManagers().forEach(System.out::println);

        // Remove user
        service.removeUser(2); // Remove Bob
        System.out.println("\nAfter removing Bob:");
        service.getAllUsers().forEach(System.out::println);
    }
}