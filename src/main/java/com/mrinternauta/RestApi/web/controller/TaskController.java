package com.mrinternauta.RestApi.web.controller;

import com.mrinternauta.RestApi.domain.dto.TaskDomain;
import com.mrinternauta.RestApi.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/")
    public List<TaskDomain> getAll(){
        return taskService.findAll();
    }

    @GetMapping(path = "/{id}")
    TaskDomain findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping(path = "/")
    public TaskDomain save(@RequestBody TaskDomain taskDomain){
        //TODO: Validar
        return taskService.save(taskDomain);
    }
    @PutMapping(path = "/{id}")
    public TaskDomain update(@RequestBody TaskDomain taskDomain, @PathVariable Long id){
        //TODO: Validar
        return  taskService.update(taskDomain, id);
    }
    @DeleteMapping(path = "/{id}")
    public Boolean delete(@PathVariable Long id){
        return taskService.delete(id);
    }
    @GetMapping(path ="/byUserId")
    public List<TaskDomain> findByEmail(@RequestParam Long id){
        return taskService.findAllByUserId(id);
    }
}
