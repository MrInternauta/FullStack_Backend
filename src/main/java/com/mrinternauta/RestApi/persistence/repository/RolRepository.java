package com.mrinternauta.RestApi.persistence.repository;

import com.mrinternauta.RestApi.domain.dto.RolDomain;
import com.mrinternauta.RestApi.persistence.entity.Rol;
import com.mrinternauta.RestApi.persistence.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements com.mrinternauta.RestApi.domain.service.RolRepository {
    @Autowired
    private RolCrudRepository rolCrudRepository;
    @Autowired
    private RolMapper rolMapper;

    @Override
    public Optional<List<RolDomain>> findAll() {
        try{
            return Optional.of(rolMapper.toRolesDomain(rolCrudRepository.findAll()));
        }
        catch (Exception e){
            List<RolDomain> list = new ArrayList<>();
            return Optional.of(list);
        }
    }

    @Override
    public Optional<RolDomain> findById(Long id) {
        RolDomain rolDomain = new RolDomain();
        try{
            Optional<Rol> rol = rolCrudRepository.findById(id);
            if (rol.isPresent()){
                return Optional.of(rolMapper.toRolDomain(rol.get()));
            }else{
                return Optional.of(rolDomain);
            }
        }
        catch (Exception e){
            return Optional.of(rolDomain);
        }
    }

    @Override
    public Optional<RolDomain> findByUserId(Long id) {
        RolDomain rolDomain = new RolDomain();
        try{
            Optional<Rol> rol = rolCrudRepository.findByUsersId(id);
            if (rol.isPresent()){
                return Optional.of(rolMapper.toRolDomain(rol.get()));
            }else{
                return Optional.of(rolDomain);
            }
        }
        catch (Exception e){
            return Optional.of(rolDomain);
        }
    }


    @Override
    public Optional<RolDomain> save(RolDomain newRol) {
        RolDomain rolDomain = new RolDomain();
        try{
            Rol rol = rolCrudRepository.save(rolMapper.toRol(newRol));
            return Optional.of(rolMapper.toRolDomain(rol));
        }
        catch (Exception e){
            return Optional.of(rolDomain);
        }
    }

    @Override
    public Optional<RolDomain> update(RolDomain newRol, Long id) {
        return Optional.of(rolMapper.toRolDomain(update(rolMapper.toRol(newRol), id)));
    }

    private Rol update(Rol newRol, Long id) {
        Optional<Rol> rolUpdated = rolCrudRepository.findById(id)
                .map(
                        rol -> {
                            rol.setName(newRol.getName());
                            rol.setDescription(newRol.getDescription());
                            return rolCrudRepository.save(rol);
                        }
                );
        if (rolUpdated.isPresent())
            return rolUpdated.get();
        else
            return new Rol();
    }

    public void delete(Long id) {
        rolCrudRepository.delete(new Rol(id));
    }






}
