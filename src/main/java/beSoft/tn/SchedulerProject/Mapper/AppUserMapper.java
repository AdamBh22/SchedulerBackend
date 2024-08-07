package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppUserMapper {
    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);


    AppUser appUserDtoToAppUser(AppUserDto appUserDto);
    AppUserDto appUserToAppUserDto(AppUser appUser);
    List<AppUserDto> appUserListToAppUserDtoList(List<AppUser> appUserList);
    List<AppUser> appUserDtoListToAppUserList(List<AppUserDto> appUserDtoList);


    Project projectDtoToProject(ProjectDto projectDto);
    ProjectDto projectToProjectDto(Project project);
    List<Project> projectDtoListToProjectList(List<ProjectDto> projectDtoList);
    List<ProjectDto> projectListToProjectDtoList(List<Project> projectList);


    Comment commentDtoToComment(CommentDto commentDto);
    CommentDto commentToCommentDto(Comment comment);
    List<Comment> commentDtoListToCommentList(List<CommentDto> commentDtoList);
    List<CommentDto> commentListToCommentDtoList(List<Comment> commentList);


    Activity activityDtoToActivity(ActivityDto activityDto);
    ActivityDto activityToActivityDto(Activity activity);
    List<Activity> activityDtoListToActivityList(List<ActivityDto> activityDtoList);
    List<ActivityDto> activityListToActivityDtoList(List<Activity> activityList);


    Dependency dependencyDtoToDependency(DependencyDto dependencyDto);
    DependencyDto dependencyToDependencyDto(Dependency dependency);
    List<Dependency> dependencyDtoListToDependencyList(List<DependencyDto> dependencyDtoList);
    List<DependencyDto> dependencyListToDependencyDtoList(List<Dependency> dependencyList);


    Recent recentDtoToRecent(RecentDto recentDto);
    RecentDto recentToRecentDto(Recent recent);
    List<Recent> recentDtoListToRecentList(List<RecentDto> recentDtoList);
    List<RecentDto> recentListToRecentDtoList(List<Recent> recentList);


    Task taskDtoToTask(TaskDto taskDto);
    TaskDto taskToTaskDto(Task task);
    List<Task> taskDtoListToTaskList(List<TaskDto> taskDtoList);
    List<TaskDto> taskListToTaskDtoList(List<Task> taskList);
}
