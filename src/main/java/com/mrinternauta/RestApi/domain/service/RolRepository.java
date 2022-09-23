package com.mrinternauta.RestApi.domain.service;
import com.mrinternauta.RestApi.domain.dto.RolDomain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RolRepository {
    public Optional<List<RolDomain>> findAll();
    public Optional<RolDomain> findById(Long id);
    public Optional<RolDomain> findByUserId(Long id);
    public Optional<RolDomain> save(RolDomain newRol);
    public Optional<RolDomain> update(RolDomain newRol, Long id);
    public void delete(Long id);
}
