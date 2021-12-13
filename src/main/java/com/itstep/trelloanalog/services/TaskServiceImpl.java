package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.Task;
import com.itstep.trelloanalog.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getTask(Long id) {
        return this.taskRepository.findTaskByDeletedAtIsNullAndId(id);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findTasksByDeletedAtIsNull();
    }

    @Override
    public Task getTasksByProjectId(Long projectId) {
        return null;
    }

    @Override
    public Task addOrUpdateTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.getById(id);
        task.setDeletedAt(new Date());
        this.taskRepository.save(task);
    }
}
