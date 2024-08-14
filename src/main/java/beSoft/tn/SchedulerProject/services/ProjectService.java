package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.AppUserProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.ProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.AppUserProjectRepository;
import beSoft.tn.SchedulerProject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    AppUserProjectRepository appUserProjectRepository;

    @Autowired
    AppUserProjectMapper appUserProjectMapper;

    public List<ProjectDto> findAll() {
        List<Project> projects = repository.findAll();
        return projects.stream().map(projectMapper::projectToProjectDto).toList();
    }

    public ProjectDto findById(Integer id) {
        Project project= repository.findById(id).orElse(null);
        return projectMapper.projectToProjectDto(project);
    }

    public ProjectDto save(ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        Project savedProject= repository.save(project);
        Project result=savedProject;
        return projectMapper.projectToProjectDto(result);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
    public List<TaskDto> findTasksById(Integer projectId) {
        Project project = repository.findById(projectId).orElse(null);
        if(project == null || project.getTasks() == null) {
            return Collections.emptyList();
        }
        List<Task> tasks = project.getTasks();
        return tasks.stream().map(taskMapper::taskToTaskDto).toList();
    }

    public List<AppUserProjectDto> findAllAppUserProjects(Integer projectId) {
        List<AppUserProject> appUserProjectList=appUserProjectRepository.findByProjectId(projectId);
        return appUserProjectList.stream().map(appUserProjectMapper::appUserProjectToAppUserProjectDto).collect(Collectors.toList());
    }

    public List<AppUserDto> findUsersByProjectId(Integer projectId) {
        List<AppUserProjectDto> appUserProjectDtoList=findAllAppUserProjects(projectId);
        return appUserProjectDtoList.stream().map(AppUserProjectDto::getUser).collect(Collectors.toList());
    }

    public ProjectDto update(ProjectDto projectDto, Integer projectId) {
        projectDto.setId(projectId);
        Project project = projectMapper.projectDtoToProject(projectDto);
        Project savedProject= repository.save(project);
        return projectMapper.projectToProjectDto(savedProject);
    }
}
