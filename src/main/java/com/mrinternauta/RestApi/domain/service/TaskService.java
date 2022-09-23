package com.mrinternauta.RestApi.domain.service;

import com.mrinternauta.RestApi.domain.dto.TaskDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDomain> findAll(){
        return  taskRepository.findAll().orElse(new ArrayList<>());
    }
    public TaskDomain findById(Long id){
        return taskRepository.findById(id).orElse(new TaskDomain());
    }
    public List<TaskDomain> findAllByUserId(Long id){
        return taskRepository.findAllByUserId(id).orElse(new ArrayList<>());
    }

    public TaskDomain save(TaskDomain taskDomain){
        return taskRepository.save(taskDomain).orElse(new TaskDomain());
    }
    public TaskDomain update(TaskDomain newTask, Long id){
        return taskRepository.update(newTask, id).orElse(new TaskDomain());
    }
    public Boolean delete(Long id){
        try{
            Optional<TaskDomain> taskDomain = taskRepository.findById(id);
            if (taskDomain.isPresent()){
                taskRepository.delete(id);
                return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

}
