package com.mrinternauta.RestApi.domain.service;

import com.mrinternauta.RestApi.domain.dto.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDomain> getAll(){
        return userRepository.findAll().orElse(new ArrayList<>());
    }
    public UserDomain findById(Long id){
        return userRepository.findById(id).orElse(new UserDomain());
    }
    public UserDomain findByEmail(String email){
        return userRepository.findByEmail(email).orElse(new UserDomain());
    }

    public UserDomain save(UserDomain user){
        return userRepository.save(user).orElse(new UserDomain() );
    }

    public UserDomain update(UserDomain newUser, Long id){
        return  userRepository.update(newUser, id).orElse(new UserDomain() );
    }

    public Boolean delete(Long id){
        try{
            Optional<UserDomain> user = userRepository.findById(id);
            if (user.isPresent()){
                userRepository.delete(id);
                return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

}
