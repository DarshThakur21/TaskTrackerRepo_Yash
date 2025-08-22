package com.yash.tasktracker.dao;


import com.yash.tasktracker.models.User;
import com.yash.tasktracker.models.UserRole;

import java.util.List;

public interface UserDAO {
    void registerUser(User user);
    void assignRole(int userId, UserRole role);
    List<User> getAllUsers();
    List<User> getManagers();
    void removeUser(int userId);
}