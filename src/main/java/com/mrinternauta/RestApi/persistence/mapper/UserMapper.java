package com.mrinternauta.RestApi.persistence.mapper;

import com.mrinternauta.RestApi.domain.dto.UserDomain;
import com.mrinternauta.RestApi.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { RolMapper.class, TaskMapper.class })
public interface UserMapper {
    @Mapping(target = "rol", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    UserDomain toUserDomain(User user);

    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "rol", ignore = true)
    List<UserDomain> toUsersDomain(List<User> users);
    @InheritInverseConfiguration
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "rol", ignore = true)
    User toUser(UserDomain userDomain);

}
