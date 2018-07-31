package com.menschmaschine.worker.controller;

import com.menschmaschine.worker.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TasksRepository tasksRepository;

  @GetMapping
  public Object findAll() {
    return tasksRepository.findAll();
  }
}
