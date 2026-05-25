package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

   
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }


    public Task updateTask(Long id, Task updatedTask) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());

        return repository.save(task);
    }

    
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}