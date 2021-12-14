package com.itstep.trelloanalog.service;

import com.itstep.trelloanalog.entities.Project;

import java.util.List;

public interface ProjectService {
   List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project addProject(Project project);

    Project saveProject(Project project);

    void deleteProject(Project project);
}
