package com.itstep.trelloanalog.service;

import com.itstep.trelloanalog.entities.Project;
import com.itstep.trelloanalog.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService  {
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.findProjectByDeletedAtNull();
    }

    @Override
    public Project getProjectById(Long id) {
        return this.projectRepository.findProjectByDeletedAtNullAndId(id);
    }

    @Override
    public Project addProject(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public Project saveProject(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        project.setDeletedAt(new Date());
        this.projectRepository.save(project);
    }
}
