package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE= Mappers.getMapper(TaskMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "priority",target = "priority")
    @Mapping(source = "description",target = "description")
    @Mapping(source = "status",target = "status")
    @Mapping(source = "starting",target = "ending")
    @Mapping(source = "assignedTo",target = "assignedTo")
    @Mapping(source = "project",target = "project")
    @Mapping(source = "comments",target = "comments")
    @Mapping(source = "activities",target = "activities")
    @Mapping(source = "dependencies",target = "dependencies")
    TaskDto toDto(Task task);


    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "priority",target = "priority")
    @Mapping(source = "description",target = "description")
    @Mapping(source = "status",target = "status")
    @Mapping(source = "starting",target = "ending")
    @Mapping(source = "assignedTo",target = "assignedTo")
    @Mapping(source = "project",target = "project")
    @Mapping(source = "comments",target = "comments")
    @Mapping(source = "activities",target = "activities")
    @Mapping(source = "dependencies",target = "dependencies")
    Task toEntity(TaskDto dto);
}
