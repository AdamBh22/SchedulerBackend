package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.Mapper.CommentMapper;
import beSoft.tn.SchedulerProject.Mapper.DependencyMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ActivityRepository;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ActivityService activityService;

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper.INSTANCE::taskToTaskDto).toList();
    }

    public TaskDto getTaskById(Integer id) {
        Task task = taskRepository.findById(id).orElse(null);
        return TaskMapper.INSTANCE.taskToTaskDto(task);
    }


    public TaskDto Save(TaskDto taskDto) {
        Task task = TaskMapper.INSTANCE.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);

        ActivityDto activityDto = new ActivityDto();
        activityDto.setTask(TaskMapper.INSTANCE.taskToTaskDto(savedTask));
        activityDto.setUserId(savedTask.getUserId());
        activityDto.setName("_CREATE_TASK_");
        activityDto.setStartTime(new Date());
        ActivityDto activity=activityService.save(activityDto);

        savedTask.setActivities(Collections.singletonList(TaskMapper.INSTANCE.activityDtoToActivity(activity)));
        return TaskMapper.INSTANCE.taskToTaskDto(savedTask);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }



    public TaskDto updateStatus(TaskDto taskDto, String Status) {
        if (taskDto == null) {
            return null;
        }
        Task task = TaskMapper.INSTANCE.taskDtoToTask(taskDto);
        task.setStatus(Status);
        return TaskMapper.INSTANCE.taskToTaskDto(taskRepository.save(task));
    }

    public List<ActivityDto> getAllActivitiesByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getActivities() == null || task.getActivities().isEmpty()) {
            return Collections.emptyList();
        }
        List<Activity> activities = task.getActivities();
        return activities.stream().map(ActivityMapper.INSTANCE::activityToActivityDto).collect(Collectors.toList());
    }

    public List<CommentDto> getAllCommentsByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getComments() == null || task.getComments().isEmpty()) {
            return Collections.emptyList();
        }
        List<Comment> comments = task.getComments();
        return comments.stream()
                .map(CommentMapper.INSTANCE::commentToCommentDto)
                .collect(Collectors.toList());
    }


    public List<DependencyDto> getAllDependenciesByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getDependencies() == null || task.getDependencies().isEmpty()) {
            return Collections.emptyList();
        }
        List<Dependency> dependencies = task.getDependencies();
        return dependencies.stream().map(DependencyMapper.INSTANCE::dependencyToDependencyDto).collect(Collectors.toList());
    }
}
