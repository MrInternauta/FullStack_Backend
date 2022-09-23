package com.mrinternauta.RestApi.persistence.mapper;

import com.mrinternauta.RestApi.domain.dto.RolDomain;
import com.mrinternauta.RestApi.persistence.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RolMapper {
    RolDomain toRolDomain(Rol rol);
    @Mapping(target = "users", ignore = true)
    List<RolDomain> toRolesDomain(List<Rol> roles);
    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    Rol toRol(RolDomain rol);
}
