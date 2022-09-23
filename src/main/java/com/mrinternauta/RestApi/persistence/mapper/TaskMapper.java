package com.mrinternauta.RestApi.persistence.mapper;

import com.mrinternauta.RestApi.domain.dto.TaskDomain;
import com.mrinternauta.RestApi.persistence.entity.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TaskMapper {
    @Mapping(target = "user", ignore = true)
    TaskDomain toTaskDomain(Task task);
    List<TaskDomain> ToTasksDomain (List<Task> tasks);
    @InheritInverseConfiguration
    Task toTask(TaskDomain task);
}
