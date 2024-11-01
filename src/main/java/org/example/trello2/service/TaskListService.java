package org.example.trello2.service;

import org.example.trello2.model.TaskList;
import org.example.trello2.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    public TaskList getTaskListById(Long id) {
        Optional<TaskList> taskListOptional = taskListRepository.findById(id);
        return taskListOptional.orElse(null); // ou lançar uma exceção, se preferir
    }

    public TaskList createTaskList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    public TaskList updateTaskList(Long id, TaskList taskListDetails) {
        TaskList taskListToUpdate = getTaskListById(id);
        if (taskListToUpdate != null) {
            taskListToUpdate.setNome(taskListDetails.getNome()); // ajuste conforme os campos do seu modelo
            return taskListRepository.save(taskListToUpdate);
        }
        return null; // ou lançar uma exceção
    }

    public void deleteTaskList(Long id) {
        taskListRepository.deleteById(id);
    }
}
