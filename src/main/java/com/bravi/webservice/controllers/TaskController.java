package com.bravi.webservice.controllers;

import com.bravi.webservice.models.Task;
import com.bravi.webservice.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/task")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        this.taskRepository.save(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        List<Task> tasks = new ArrayList<>();
        tasks = this.taskRepository.findAll();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Task>> getById(@PathVariable Integer id) {
        Optional<Task> task;
        try {
            task = this.taskRepository.findById(id);
            return new ResponseEntity<Optional<Task>>(task, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Optional<Task>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Task>> deleteById(@PathVariable Integer id) {
        Optional<Task> task;
        try {
            this.taskRepository.deleteById(id);
            return new ResponseEntity<Optional<Task>>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Optional<Task>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Task> update(@PathVariable Integer id, @RequestBody Task newTask){
        return this.taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setDoInAt(newTask.getDoInAt());
                    task.setDoneAt(newTask.getDoneAt());
                    task.setSpendTime(newTask.getSpendTime());

                    return ResponseEntity.ok().body(this.taskRepository.save(task));
                }).orElse(ResponseEntity.notFound().build());
    }
}
