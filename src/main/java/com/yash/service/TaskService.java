package com.yash.service;


import com.yash.dao.TaskDAO;
import com.yash.models.Task;

import java.util.List;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void createTask(Task task) {
        taskDAO.create(task);
    }

    public Task getTaskById(String tId) {
        return taskDAO.read(tId);
    }

    public List<Task> getAllTasks() {
        return taskDAO.readAll();
    }

    public void updateTask(Task task) {
        taskDAO.update(task);
    }

    public void deleteTask(String tId) {
        taskDAO.delete(tId);
    }
}

