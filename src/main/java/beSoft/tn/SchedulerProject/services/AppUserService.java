package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.AppUserMapper;
import beSoft.tn.SchedulerProject.Mapper.AppUserProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.ProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.AppUserProjectRepository;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;
    @Autowired
    AppUserMapper appUserMapper;
    @Autowired
    AppUserProjectService appUserProjectService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    AppUserProjectRepository appUserProjectRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    AppUserProjectMapper appUserProjectMapper;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUserDto> findAllAppUsers() {
        List<AppUser> list = appUserRepository.findAll();
        return list.stream().map(appUserMapper::appUserToAppUserDto).collect(Collectors.toList());
    }

    public AppUserDto findAppUserById(Integer id) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        return optionalAppUser.map(appUserMapper::appUserToAppUserDto).orElse(null);
    }

    public AppUserDto save(AppUserDto appUserDto) {
        AppUser appUser = appUserMapper.appUserDtoToAppUser(appUserDto);
        AppUser user = appUserRepository.save(appUser);
        return appUserMapper.appUserToAppUserDto(user);
    }

    public List<TaskDto> findAllTasks(Integer userId) {
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return tasks.stream().map(taskMapper::taskToTaskDto).toList();
    }

    public List<AppUserProjectDto> findAllAppUserProjects(Integer userId) {
        List<AppUserProject> appUserProjectList=appUserProjectRepository.findByUserId(userId);
        return appUserProjectList.stream().map(appUserProjectMapper::appUserProjectToAppUserProjectDto).collect(Collectors.toList());
    }

    public List<ProjectDto> findAllProjects(Integer userId) {
        List<AppUserProjectDto> appUserProjectDtoList=findAllAppUserProjects(userId);
        return appUserProjectDtoList.stream().map(AppUserProjectDto::getProject).collect(Collectors.toList());
    }


    public AppUserDto updateAppUser(Integer userId, AppUserDto appUserDto) {
        appUserDto.setId(userId);
        AppUser appUser = appUserMapper.appUserDtoToAppUser(appUserDto);
        AppUser user = appUserRepository.save(appUser);
        return appUserMapper.appUserToAppUserDto(user);
    }
}
