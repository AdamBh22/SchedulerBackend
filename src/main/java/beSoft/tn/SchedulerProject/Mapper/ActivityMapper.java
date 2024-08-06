package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.ActivityDto;
import beSoft.tn.SchedulerProject.model.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "user",target = "user")
    @Mapping(source = "task",target = "task")
    ActivityDto toDto(Activity a);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "user",target = "user")
    @Mapping(source = "task",target = "task")
    Activity toEntity(ActivityDto dto);
}
