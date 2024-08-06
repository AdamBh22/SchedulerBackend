package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.DependencyDto;
import beSoft.tn.SchedulerProject.model.Dependency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DependencyMapper {
    DependencyMapper INSTANCE= Mappers.getMapper(DependencyMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "status",target = "status")
    @Mapping(source = "ParentTask",target = "ParentTask")
    @Mapping(source = "ChildTask",target = "ChildTask")
    DependencyDto toDto(Dependency dependency);



    @Mapping(source = "id",target = "id")
    @Mapping(source = "status",target = "status")
    @Mapping(source = "ParentTask",target = "ParentTask")
    @Mapping(source = "ChildTask",target = "ChildTask")
    Dependency toEntity(DependencyDto dependencyDto);
}
