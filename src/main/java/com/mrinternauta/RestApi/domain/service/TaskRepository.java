package com.mrinternauta.RestApi.domain.service;

import com.mrinternauta.RestApi.domain.dto.TaskDomain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository {
    public Optional<List<TaskDomain>> findAll();
    public Optional<TaskDomain> findById(Long id);
    public Optional<List<TaskDomain>> findAllByUserId(Long id);
    public Optional<TaskDomain> save(TaskDomain newTask);
    public Optional<TaskDomain> update(TaskDomain newTask, Long id) ;
    public void delete(Long id);
}
