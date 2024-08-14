package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.AppUserMapper;
import beSoft.tn.SchedulerProject.Mapper.AppUserProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.ProjectMapper;
import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.dto.AppUserProjectDto;
import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.model.AppUserProject;
import beSoft.tn.SchedulerProject.model.Project;
import beSoft.tn.SchedulerProject.model.Recent;
import beSoft.tn.SchedulerProject.repository.AppUserProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppUserProjectService {
    @Autowired
    private AppUserProjectRepository appUserProjectRepository;
    @Autowired
    private AppUserProjectMapper appUserProjectMapper;
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private ProjectMapper projectMapper;

    public AppUserProjectDto save(AppUserProjectDto appUserProjectDto) {
        AppUserProject appUserProject = appUserProjectMapper.appUserProjectDtoToAppUserProject(appUserProjectDto);
        appUserProjectRepository.save(appUserProject);
        return appUserProjectMapper.appUserProjectToAppUserProjectDto(appUserProject);
    }

    public List<AppUserProjectDto> findAll() {
        List<AppUserProject> appUserProjects = appUserProjectRepository.findAll();
        return appUserProjects.stream().map(appUserProjectMapper::appUserProjectToAppUserProjectDto).collect(Collectors.toList());
    }

    public AppUserProjectDto findById(Integer id) {
        Optional<AppUserProject> appUserProject = appUserProjectRepository.findById(id);
        return appUserProject.map(appUserProjectMapper::appUserProjectToAppUserProjectDto).orElse(null);
    }

}
