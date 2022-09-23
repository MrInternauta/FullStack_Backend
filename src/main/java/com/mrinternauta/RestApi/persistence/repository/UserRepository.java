package com.mrinternauta.RestApi.persistence.repository;

import com.mrinternauta.RestApi.domain.dto.UserDomain;
import com.mrinternauta.RestApi.persistence.entity.User;
import com.mrinternauta.RestApi.persistence.mapper.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements com.mrinternauta.RestApi.domain.service.UserRepository {
    private final Log LOGGER = LogFactory.getLog(UserRepository.class);
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Optional<List<UserDomain>> findAll() {
        try{
            return Optional.of(userMapper.toUsersDomain(userCrudRepository.findAll()));
        }
        catch (Exception e){
            List<UserDomain> listaempty =  new ArrayList<>();
            return Optional.of(listaempty);
        }
    }

    @Override
    public Optional<UserDomain> findById(Long id) {
        try{
            Optional<User> user = userCrudRepository.findById(id);
            if (user.isPresent()){
                return Optional.of(userMapper.toUserDomain(user.get()));
            }else{
                UserDomain userDomain = new UserDomain();
                return Optional.of(userDomain);
            }
        }
        catch (Exception e){
            UserDomain userDomainEmpty = new UserDomain();
            return Optional.of(userDomainEmpty);
        }
    }

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        try{
            Optional<User> user = userCrudRepository.findByEmail(email);
            if (user.isPresent()){
                return Optional.of(userMapper.toUserDomain(user.get()));
            }else{
                UserDomain userDomain = new UserDomain();
                return Optional.of(userDomain);
            }
        }
        catch (Exception e){
            UserDomain userDomainEmpty = new UserDomain();
            return Optional.of(userDomainEmpty);
        }
    }

    @Override
    public Optional<UserDomain> save(UserDomain userDomain) {

        try{
            User user = userMapper.toUser(userDomain);
            User userSaved =  userCrudRepository.save(user);
            return  Optional.of(userMapper.toUserDomain(userSaved));
        }
        catch (Exception e){
            UserDomain userDomainEmpty = new UserDomain();
            return Optional.of(userDomainEmpty);
        }

    }

    @Override
    public Optional<UserDomain> update(UserDomain newUser, Long id) {
        UserDomain userDomain = new UserDomain();
        try{
            Optional<UserDomain> user2 = userCrudRepository.findById(id).map(
                            user -> {
                                user.setEmail(newUser.getEmail());
                                user.setName(newUser.getName());
                                user.setImageUrl(newUser.getImageUrl());
                                user.setPassword(newUser.getPassword());
                                user.setLastLogin(newUser.getLastLogin());
                                user.setIdRol(newUser.getIdRol());
                                User userSave = userMapper.toUser(userMapper.toUserDomain(user));
                                return userMapper.toUserDomain(userCrudRepository.save(userSave));
                            }
                    );

            if (user2.isPresent()){
                return Optional.of((user2.get()));
            }else{
                return Optional.of(userDomain);
            }
        }
        catch (Exception e){
            return Optional.of(userDomain);
        }

    }

    public void delete(Long id) {
        userCrudRepository.delete(new User(id));
    }
}
