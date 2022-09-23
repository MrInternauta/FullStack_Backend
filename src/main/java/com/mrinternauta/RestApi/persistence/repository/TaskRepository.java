package com.mrinternauta.RestApi.persistence.repository;

import com.mrinternauta.RestApi.domain.dto.TaskDomain;
import com.mrinternauta.RestApi.persistence.entity.Task;
import com.mrinternauta.RestApi.persistence.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository implements com.mrinternauta.RestApi.domain.service.TaskRepository {
    @Autowired
    private TaskCrudRepository taskCrudRepository;
    @Autowired
    private TaskMapper taskMapper;


    @Override
    public Optional<List<TaskDomain>> findAll() {
        try{
            return Optional.of(taskMapper.ToTasksDomain(taskCrudRepository.findAll()));
        }
        catch (Exception e){
            List<TaskDomain> list = new ArrayList<>();
            return Optional.of(list);
        }
    }

    @Override
    public Optional<TaskDomain> findById(Long id) {
        TaskDomain taskDomain = new TaskDomain();
        try{
            Optional<Task> task = taskCrudRepository.findById(id);
            if (task.isPresent()){
                return Optional.of(taskMapper.toTaskDomain(task.get()));
            }else{
                return Optional.of(taskDomain);
            }
        }
        catch (Exception e){
            return Optional.of(taskDomain);
        }
    }

    @Override
    public Optional<List<TaskDomain>>  findAllByUserId(Long id) {
        try{
            return Optional.of(taskMapper.ToTasksDomain(taskCrudRepository.findAllByUserId(id).get()));
        }
        catch (Exception e){
            List<TaskDomain> list = new ArrayList<>();
            return Optional.of(list);
        }
    }

    @Override
    public Optional<TaskDomain> save(TaskDomain newTask) {
        TaskDomain taskDomain = new TaskDomain();
        try{
            Task task = taskMapper.toTask(newTask);
            taskCrudRepository.save(task);
            return Optional.of(taskMapper.toTaskDomain(task));
        }
        catch (Exception e){
            return Optional.of(taskDomain);
        }
    }

    @Override
    public Optional<TaskDomain> update(TaskDomain newTask, Long id) {
        TaskDomain taskDomain = new TaskDomain();
        try{
            Optional<Task> task2 = taskCrudRepository.findById(id)
                    .map(
                            task -> {
                                task.setName(newTask.getName());
                                task.setDone(newTask.getDone());
                                return taskCrudRepository.save(task);
                            }
                    );
            if (task2.isPresent()){
                return Optional.of(taskMapper.toTaskDomain(task2.get()));
            }else{
                return Optional.of(taskDomain);
            }
        }
        catch (Exception e){
            return Optional.of(taskDomain);
        }
    }

    public void delete(Long id) {
        taskCrudRepository.delete(new Task(id));
    }


}
