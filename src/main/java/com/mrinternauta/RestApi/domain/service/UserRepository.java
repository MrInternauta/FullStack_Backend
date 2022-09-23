package com.mrinternauta.RestApi.domain.service;


import com.mrinternauta.RestApi.domain.dto.UserDomain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository {
    public Optional<List<UserDomain>> findAll();
    public Optional<UserDomain> findById(Long id);
    public Optional<UserDomain> findByEmail(String email);
    public Optional<UserDomain> save(UserDomain user);
    public Optional<UserDomain> update(UserDomain newUser, Long id);
    public void delete(Long id);
}
