package com.itstep.trelloanalog.repositories;

import com.itstep.trelloanalog.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByDeletedAtIsNull();

    Task findTaskByDeletedAtIsNullAndId(Long id);
}
