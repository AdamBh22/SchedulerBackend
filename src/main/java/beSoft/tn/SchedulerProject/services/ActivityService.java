package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.Mapper.AppUserMapper;
import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ActivityRepository;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AppUserMapper appUserMapper;

    public ActivityDto save(ActivityDto activityDto) {

        Activity activity = activityMapper.activityDtoToActivity(activityDto);
        Activity savedActivity = activityRepository.save(activity);

        Task associatedTask = savedActivity.getTask();
        if (associatedTask != null) {
            if (associatedTask.getActivities() == null) {
                associatedTask.setActivities(new ArrayList<>());
            }
            associatedTask.getActivities().add(savedActivity);
            taskRepository.save(associatedTask);
        }

        return activityMapper.activityToActivityDto(savedActivity);
    }

    public ActivityDto findById(Integer id) {
        Activity result = activityRepository.findById(id).orElse(null);
        return activityMapper.activityToActivityDto(result);
    }

    public List<ActivityDto> findAll() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(activityMapper::activityToActivityDto).collect(Collectors.toList());
    }

    public AppUserDto findAppUserById(Integer id) {
        Activity activity = activityRepository.findById(id).orElse(null);
        AppUser appUser = appUserRepository.findById(activity.getUserId()).orElse(null);
        return appUserMapper.appUserToAppUserDto(appUser);
    }
}
