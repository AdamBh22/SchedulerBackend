package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ProjectMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;

    public List<ProjectDto> findAll() {
        List<Project> projects = repository.findAll();
        return projects.stream().map(ProjectMapper.INSTANCE::toDto).toList();
    }

    public ProjectDto findById(Integer id) {
        Project project= repository.findById(id).orElse(null);
        return ProjectMapper.INSTANCE.toDto(project);
    }

    public ProjectDto save(ProjectDto projectDto) {
        Project project = ProjectMapper.INSTANCE.toEntity(projectDto);
        Project savedProject= repository.save(project);
        return ProjectMapper.INSTANCE.toDto(savedProject);
    }

}
