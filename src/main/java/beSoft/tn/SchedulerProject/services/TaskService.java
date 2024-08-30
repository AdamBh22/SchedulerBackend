package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.*;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    DependencyMapper dependencyMapper;

    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    AppUserRepository appUserRepository;

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::taskToTaskDto).toList();
    }

    public TaskDto getTaskById(Integer id) {
        Task task = taskRepository.findById(id).orElse(null);
        return taskMapper.taskToTaskDto(task);
    }


    public TaskDto Save(TaskDto taskDto) {
        Task task = taskMapper.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);

        ActivityDto activityDto = new ActivityDto();
        activityDto.setTask(taskMapper.taskToTaskDto(savedTask));
        activityDto.setUserId(savedTask.getUserId());
        activityDto.setName("_CREATE_TASK_");
        activityDto.setStartTime(new Date());
        activityService.save(activityDto);

        return taskMapper.taskToTaskDto(savedTask);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }



    public List<ActivityDto> getAllActivitiesByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getActivities() == null || task.getActivities().isEmpty()) {
            return Collections.emptyList();
        }
        List<Activity> activities = task.getActivities();
        return activities.stream().map(activityMapper::activityToActivityDto).collect(Collectors.toList());
    }

    public List<CommentDto> getAllCommentsByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getComments() == null || task.getComments().isEmpty()) {
            return Collections.emptyList();
        }
        List<Comment> comments = task.getComments();
        return comments.stream()
                .map(commentMapper::commentToCommentDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> getAllTasksByStatus(String status) {
        List<Task> tasks = taskRepository.findAllByStatus(status);
        return tasks.stream().map(taskMapper::taskToTaskDto).toList();
    }

    public List<DependencyDto> getAllDependenciesByTaskId(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null || task.getDependencies() == null || task.getDependencies().isEmpty()) {
            return Collections.emptyList();
        }
        List<Dependency> dependencies = task.getDependencies();
        return dependencies.stream().map(dependencyMapper::dependencyToDependencyDto).collect(Collectors.toList());
    }


    public AppUserDto getUser(Integer taskId){
        Task task = taskRepository.findById(taskId).orElse(null);
        Integer userId = task.getUserId();
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        return appUserMapper.appUserToAppUserDto(appUser);
    }


    public TaskDto update(TaskDto taskDto, Integer taskId) {
        taskDto.setId(taskId);
        Task task=taskMapper.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(task);

        ActivityDto activityDto = new ActivityDto();
        activityDto.setTask(taskMapper.taskToTaskDto(savedTask));
        activityDto.setUserId(savedTask.getUserId());
        activityDto.setName("_UPDATE_TASK_");
        activityDto.setStartTime(new Date());
        activityService.save(activityDto);

        return taskMapper.taskToTaskDto(savedTask);
    }


    public List<TaskDto> getTasksForToday(Integer userId) {
        LocalDate today = LocalDate.now();
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        List<Task> tasksForToday = tasks.stream()
                .filter(task -> {
                    LocalDate startDate = task.getStarting();
                    LocalDate endDate = task.getEnding();
                    return startDate != null && endDate != null && !startDate.isAfter(today) && !endDate.isBefore(today);
                })
                .collect(Collectors.toList());
        return tasksForToday.stream()
                .map(taskMapper::taskToTaskDto)
                .collect(Collectors.toList());
    }

}
