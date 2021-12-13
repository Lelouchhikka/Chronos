package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    Task getTask(Long id);

    List<Task> getTasks();

    Task getTasksByProjectId(Long projectId);

    Task addOrUpdateTask(Task task);

    void deleteTask(Long id);

}
