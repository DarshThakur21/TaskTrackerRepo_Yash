package com.yash.tasktracker.service;

import com.yash.tasktracker.dao.UserDAO;
import com.yash.tasktracker.daoimpl.UserDAOImpl;
import com.yash.tasktracker.models.User;
import com.yash.tasktracker.models.UserRole;

import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

    public void assignRole(int userId, UserRole role) {
        userDAO.assignRole(userId, role);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public List<User> getManagers() {
        return userDAO.getManagers();
    }

    public void removeUser(int userId) {
        userDAO.removeUser(userId);
    }
}