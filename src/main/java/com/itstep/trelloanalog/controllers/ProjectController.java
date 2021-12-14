package com.itstep.trelloanalog.controllers;

import com.itstep.trelloanalog.entities.Project;
import com.itstep.trelloanalog.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("project")
public class ProjectController {
    private final ProjectService projectService;


    @PostMapping("/add-project")
    public String addProject(@ModelAttribute Project project, Model model){
        if(project.getName().isEmpty() || project.getName().equals(null)){
            return "op_error_400";
        }
        projectService.addProject(project);

        return "mainPage";
    }
}
