package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "fullName",target = "fullName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "role",target = "role")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "tasks",target = "tasks")
    @Mapping(source = "comments",target = "comments")
    @Mapping(source = "activities",target = "activities")
    @Mapping(source = "recents",target = "recents")
    @Mapping(source = "projects",target = "projects")
    AppUserDto toDto(AppUser appUser);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "fullName",target = "fullName")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "role",target = "role")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "tasks",target = "tasks")
    @Mapping(source = "comments",target = "comments")
    @Mapping(source = "activities",target = "activities")
    @Mapping(source = "recents",target = "recents")
    @Mapping(source = "projects",target = "projects")
    AppUser toEntity(AppUserDto appUserDto);
}
