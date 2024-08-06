package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "owner",target = "owner")
    @Mapping(source = "tasks",target = "tasks")
    ProjectDto toDto(Project project);


    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "owner",target = "owner")
    @Mapping(source = "tasks",target = "tasks")
    Project toEntity(ProjectDto projectDto);
}
