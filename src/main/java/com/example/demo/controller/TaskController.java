package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

   
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

  
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        return service.updateTask(id, task);
    }

   @DeleteMapping("/{id}")
public String deleteTask(@PathVariable("id") Long id) {

    service.deleteTask(id);

    return "Task deleted successfully";
}
}