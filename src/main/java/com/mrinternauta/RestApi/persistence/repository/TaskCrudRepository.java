package com.mrinternauta.RestApi.persistence.repository;
import com.mrinternauta.RestApi.persistence.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskCrudRepository extends CrudRepository<Task, Long> {
    public List<Task> findAll();
    public Optional<Task> findById(Long id);
    public Optional<List<Task>> findAllByUserId(Long id);
}
