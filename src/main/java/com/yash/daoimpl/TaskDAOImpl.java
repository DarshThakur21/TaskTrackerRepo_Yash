package com.yash.daoimpl;

import com.yash.dao.TaskDAO;
import com.yash.models.Task;
import com.yash.models.TaskPriority;
import com.yash.models.TaskStatus;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    private Connection connection;

    public TaskDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(Task task) {
        try {
            String sql = "INSERT INTO tasks (id, name, description, status, priority, created_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.gettId());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            stmt.setString(4, task.getTaskStatus().toString());
            stmt.setString(5, task.getPriority().toString());
            stmt.setDate(6, new java.sql.Date(task.getCreatedDate().getTime()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Task read(String tId) {
        Task task = null;
        try {
            String sql = "SELECT * FROM tasks WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                task = new Task();
                task.settId(rs.getString("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setTaskStatus(TaskStatus.valueOf(rs.getString("status")));
                task.setPriority(TaskPriority.valueOf(rs.getString("priority")));
                task.setCreatedDate(rs.getDate("created_date"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public List<Task> readAll() {
        List<Task> tasks = new ArrayList();
        try {
            String sql = "SELECT * FROM tasks";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Task task = new Task();
                task.settId(rs.getString("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setTaskStatus(TaskStatus.valueOf(rs.getString("status")));
                task.setPriority(TaskPriority.valueOf(rs.getString("priority")));
                task.setCreatedDate(rs.getDate("created_date"));
                tasks.add(task);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void update(Task task) {
        try {
            String sql = "UPDATE tasks SET name = ?, description = ?, status = ?, priority = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getTaskStatus().toString());
            stmt.setString(4, task.getPriority().toString());
            stmt.setString(5, task.gettId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String tId) {
        try {
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
