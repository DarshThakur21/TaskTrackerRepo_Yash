package com.yash.dao;


import com.yash.models.Task;

import java.util.List;

public interface TaskDAO {
    void create(Task task);
    Task read(String tId);
    List<Task> readAll();
    void update(Task task);
    void delete(String tId);
}

