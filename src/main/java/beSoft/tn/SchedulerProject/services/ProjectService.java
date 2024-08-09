package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ProjectMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;

    public List<ProjectDto> findAll() {
        List<Project> projects = repository.findAll();
        return projects.stream().map(ProjectMapper.INSTANCE::projectToProjectDto).toList();
    }

    public ProjectDto findById(Integer id) {
        Project project= repository.findById(id).orElse(null);
        return ProjectMapper.INSTANCE.projectToProjectDto(project);
    }

    public ProjectDto save(ProjectDto projectDto) {
        Project project = ProjectMapper.INSTANCE.projectDtoToProject(projectDto);
        Project savedProject= repository.save(project);
        return ProjectMapper.INSTANCE.projectToProjectDto(savedProject);
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
        return tasks.stream().map(TaskMapper.INSTANCE::taskToTaskDto).toList();
    }

}
