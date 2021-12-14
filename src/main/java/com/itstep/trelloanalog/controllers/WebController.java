package com.itstep.trelloanalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class WebController {
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/")
    public String index(Model mav) {
        mav.addAttribute("users", userService.allUsers());
        mav.addAttribute("user",new DbUser());
        mav.addAttribute("project",new Project());
        return "mainPage";
    }

    @GetMapping("/all-tasks")
    public String allTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "redirect:/";
    }

    @GetMapping("/get-task/{id}")
    public String getTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTask(id));
        return "redirect:/";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("comment") String comment,
                          @RequestParam("status_id") Long statusId,
                          @RequestParam("worktype_id") Long worktypeId,
                          @RequestParam("started_at") Date startedAt,
                          @RequestParam("finished_at") Date finishedAt) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setComment(comment);
        task.setStatus(statusService.getStatus(statusId));
        task.setWorkType(workTypeService.getWorkType(worktypeId));
        task.setStartedAt(startedAt);
        task.setFinishedAt(finishedAt);

        taskService.addOrUpdateTask(task);
        return "redirect:/";
    }

    @PostMapping("/edit-task")
    public String editTask(@RequestParam("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("comment") String comment,
                           @RequestParam("status_id") Long statusId,
                           @RequestParam("worktype_id") Long worktypeId,
                           @RequestParam("started_at") Date startedAt,
                           @RequestParam("finished_at") Date finishedAt) {
        Task task = new Task(name,description,comment,
                statusService.getStatus(statusId),
                workTypeService.getWorkType(worktypeId),
                null, startedAt, finishedAt
                );
        task.setId(id);
        taskService.addOrUpdateTask(task);

        return "redirect:/";
    }

    @PostMapping("/delete-task")
    public String deleteTask(@RequestParam("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

}
