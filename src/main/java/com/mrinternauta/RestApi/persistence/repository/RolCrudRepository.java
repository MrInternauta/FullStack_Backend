package com.mrinternauta.RestApi.persistence.repository;
import com.mrinternauta.RestApi.persistence.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolCrudRepository extends CrudRepository<Rol, Long> {
    public List<Rol> findAll();
    public Optional<Rol> findById(Long id);
    public Optional<Rol> findByUsersId(Long id);
}
