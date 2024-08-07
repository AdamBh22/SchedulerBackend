package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public ActivityDto save(ActivityDto activityDto) {
        Activity activity=ActivityMapper.INSTANCE.activityDtoToActivity(activityDto);
        Activity savedActivity=activityRepository.save(activity);
        return ActivityMapper.INSTANCE.activityToActivityDto(savedActivity);
    }
    public ActivityDto findById(Integer id) {
        Activity result=activityRepository.findById(id).orElse(null);
         return ActivityMapper.INSTANCE.activityToActivityDto(result);
    }
    public List<ActivityDto> findAll() {
        List<Activity> activities=activityRepository.findAll();
        return activities.stream().map(ActivityMapper.INSTANCE::activityToActivityDto).collect(Collectors.toList());
    }
}
