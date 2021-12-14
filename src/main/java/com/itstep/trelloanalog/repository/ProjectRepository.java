package com.itstep.trelloanalog.repository;

import com.itstep.trelloanalog.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectByDeletedAtNull();
    Project findProjectByDeletedAtNullAndId(Long id);
}
