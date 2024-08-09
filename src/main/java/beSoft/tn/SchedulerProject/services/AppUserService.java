package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.AppUserMapper;
import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.dto.RecentDto;
import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.model.Project;
import beSoft.tn.SchedulerProject.model.Recent;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUserDto> findAllAppUsers() {
        List<AppUser> list = appUserRepository.findAll();
        return list.stream().map(AppUserMapper.INSTANCE::appUserToAppUserDto).collect(Collectors.toList());
    }

    public AppUserDto findAppUserById(Integer id) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        return optionalAppUser.map(AppUserMapper.INSTANCE::appUserToAppUserDto).orElse(null);
    }

    public AppUserDto save(AppUserDto appUserDto) {
        AppUser appUser = AppUserMapper.INSTANCE.appUserDtoToAppUser(appUserDto);
        AppUser user = appUserRepository.save(appUser);
        return AppUserMapper.INSTANCE.appUserToAppUserDto(user);
    }

    public List<ProjectDto> getProjectsByUserId(Integer userId) {
        AppUser user = appUserRepository.findById(userId).orElse(null);
        if(user == null || user.getProjects().isEmpty()) {
            return Collections.emptyList();
        }
        List<Project> projects = user.getProjects();
        return projects.stream().map(AppUserMapper.INSTANCE::projectToProjectDto).collect(Collectors.toList());
    }

    public List<RecentDto> getRecentsByUserId(Integer userId) {
        AppUser user = appUserRepository.findById(userId).orElse(null);
        if(user == null || user.getRecents().isEmpty()) {
            return Collections.emptyList();
        }
        List<Recent> recents = user.getRecents();
        return recents.stream().map(AppUserMapper.INSTANCE::recentToRecentDto).collect(Collectors.toList());
    }
}
