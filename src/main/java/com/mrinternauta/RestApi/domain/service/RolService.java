package com.mrinternauta.RestApi.domain.service;

import com.mrinternauta.RestApi.domain.dto.RolDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<RolDomain> findAll(){
        return rolRepository.findAll().orElse(new ArrayList<>());
    }

    public RolDomain findById(Long id){
        return rolRepository.findById(id).orElse(new RolDomain());
    }
    public RolDomain findByUserId(Long id){
        return rolRepository.findByUserId(id).orElse(new RolDomain());
    }

    public RolDomain save(RolDomain newRol){
        return rolRepository.save(newRol).orElse(new RolDomain());
    }
    public RolDomain update(RolDomain newRol, Long id){
        return  rolRepository.update(newRol, id).orElse(new RolDomain());
    }
    public Boolean delete(Long id) {
        try{
            Optional<RolDomain> rol = rolRepository.findById(id);
            if (rol.isPresent()){
                rolRepository.delete(id);
                return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }
}
