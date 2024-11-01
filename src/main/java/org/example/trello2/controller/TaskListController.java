package org.example.trello2.controller;

import org.example.trello2.model.TaskList;
import org.example.trello2.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasklists")
public class TaskListController {

    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskLists() {
        List<TaskList> taskLists = taskListService.getAllTaskLists();
        return ResponseEntity.ok(taskLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskList> getTaskListById(@PathVariable Long id) {
        TaskList taskList = taskListService.getTaskListById(id);
        return ResponseEntity.ok(taskList);
    }

    @PostMapping
    public ResponseEntity<TaskList> createTaskList(@RequestBody TaskList taskList) {
        TaskList createdTaskList = taskListService.createTaskList(taskList);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskList> updateTaskList(@PathVariable Long id, @RequestBody TaskList taskListDetails) {
        TaskList updatedTaskList = taskListService.updateTaskList(id, taskListDetails);
        return ResponseEntity.ok(updatedTaskList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable Long id) {
        taskListService.deleteTaskList(id);
        return ResponseEntity.noContent().build();
    }
}
