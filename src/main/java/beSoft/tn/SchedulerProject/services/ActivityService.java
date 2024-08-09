package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ActivityRepository;
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

    public ActivityDto save(ActivityDto activityDto) {

        Activity activity = ActivityMapper.INSTANCE.activityDtoToActivity(activityDto);
        Activity savedActivity = activityRepository.save(activity);

        Task associatedTask = savedActivity.getTask();
        if (associatedTask != null) {
            if (associatedTask.getActivities() == null) {
                associatedTask.setActivities(new ArrayList<>());
            }
            associatedTask.getActivities().add(savedActivity);
            taskRepository.save(associatedTask);
        }

        return ActivityMapper.INSTANCE.activityToActivityDto(savedActivity);
    }

    public ActivityDto findById(Integer id) {
        Activity result = activityRepository.findById(id).orElse(null);
        return ActivityMapper.INSTANCE.activityToActivityDto(result);
    }

    public List<ActivityDto> findAll() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(ActivityMapper.INSTANCE::activityToActivityDto).collect(Collectors.toList());
    }

    public ActivityDto updateId(ActivityDto activityDto, Integer id) {
        if (activityDto == null) {
            return null;
        }
        activityDto.setId(id);
        Activity activity = ActivityMapper.INSTANCE.activityDtoToActivity(activityDto);
        Activity savedActivity = activityRepository.save(activity);
        return ActivityMapper.INSTANCE.activityToActivityDto(savedActivity);
    }

    public void deleteById(Integer id) {
        activityRepository.deleteById(id);
    }

    public ActivityDto updateName(ActivityDto activityDto, String name) {
        if (activityDto == null) {
            return null;
        }
        activityDto.setName(name);
        Activity activity = ActivityMapper.INSTANCE.activityDtoToActivity(activityDto);
        Activity savedActivity = activityRepository.save(activity);
        return ActivityMapper.INSTANCE.activityToActivityDto(savedActivity);
    }
}
