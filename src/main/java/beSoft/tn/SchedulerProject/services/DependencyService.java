package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.Mapper.DependencyMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ActivityRepository;
import beSoft.tn.SchedulerProject.repository.DependencyRepository;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependencyService {
    @Autowired
    DependencyRepository dependencyRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    DependencyMapper dependencyMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;

    public DependencyDto findById(Integer id) {
        Dependency dependency=dependencyRepository.findById(id).orElse(null);
        return dependencyMapper.dependencyToDependencyDto(dependency);
    }

    public List<DependencyDto> findAll() {
        List<Dependency> dependencies = dependencyRepository.findAll();
        return dependencies.stream().map(dependencyMapper::dependencyToDependencyDto).toList();
    }

    public DependencyDto save(DependencyDto dependencyDto) {
        TaskDto taskDto=dependencyDto.getTask();
        ActivityDto activityDto=new ActivityDto();
        activityDto.setTask(taskDto);
        activityDto.setUserId(dependencyDto.getUserId());
        activityDto.setName("_ADD_DEPENDENCY_");
        Activity activity= activityMapper.activityDtoToActivity(activityDto);
        activityDto.setStartTime(new Date());
        activityRepository.save(activity);
        Dependency dependency=dependencyMapper.dependencyDtoToDependency(dependencyDto);
        return dependencyMapper.dependencyToDependencyDto(dependencyRepository.save(dependency));
    }

    public void delete(Integer id) {
        dependencyRepository.deleteById(id);
    }


    public DependencyDto update(Integer id, DependencyDto dependencyDto) {
        dependencyDto.setId(id);
        Dependency dependency=dependencyMapper.dependencyDtoToDependency(dependencyDto);
        return dependencyMapper.dependencyToDependencyDto(dependencyRepository.save(dependency));
    }

    public TaskDto relatedTask(Integer id) {
        Dependency dependency=dependencyRepository.findById(id).orElse(null);
        Task task=taskRepository.findById(dependency.getRelatedTaskId()).orElse(null);
        return taskMapper.taskToTaskDto(task);
    }

    public DependencyDto getDependencyByTaskId(Integer taskId) {
        return dependencyMapper.dependencyToDependencyDto(dependencyRepository.findById(taskId).orElse(null));
    }

}
