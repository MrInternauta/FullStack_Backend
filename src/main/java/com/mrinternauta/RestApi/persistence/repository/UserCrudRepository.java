package com.mrinternauta.RestApi.persistence.repository;
import com.mrinternauta.RestApi.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public Optional<User> findByEmail(String email);
}
