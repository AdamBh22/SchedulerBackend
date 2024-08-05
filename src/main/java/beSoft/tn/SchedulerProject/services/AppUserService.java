package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
 //   @Override
    public List<AppUserDto> findAllAppUsers() {
        List<AppUser> list = appUserRepository.findAll();
    return list.stream().map((AppUser)->mapToAppUserDto(AppUser)).collect(Collectors.toList());
    }

    public AppUserDto findAppUserById(Integer id) {
        AppUser appUser = appUserRepository.findById(id).orElse(null);
        return mapToAppUserDto(appUser);
    }

    public AppUserDto save(AppUser appUser) {
        AppUser savedAppUser= appUserRepository.save(appUser);
        return mapToAppUserDto(savedAppUser);
    }

    public AppUserDto update(AppUser appUser) {
        AppUser savedAppUser= appUserRepository.save(appUser);
        return mapToAppUserDto(savedAppUser);
    }

    private AppUserDto mapToAppUserDto(AppUser appUser) {
        if (appUser == null) {
            return null;
        }

        return AppUserDto.builder()
                .id(appUser.getId())
                .fullName(appUser.getFullName())
                .email(appUser.getEmail())
                .role(appUser.getRole())
                .tasks(appUser.getTasks() != null ? appUser.getTasks().stream().map(this::mapToTaskDto).collect(Collectors.toList()) : null)
                .comments(appUser.getComments() != null ? appUser.getComments().stream().map(this::mapToCommentDto).collect(Collectors.toList()) : null)
                .activities(appUser.getActivities() != null ? appUser.getActivities().stream().map(this::mapToActivityDto).collect(Collectors.toList()) : null)
                .recents(appUser.getRecents() != null ? appUser.getRecents().stream().map(this::mapToRecentDto).collect(Collectors.toList()) : null)
                .projects(appUser.getProjects() != null ? appUser.getProjects().stream().map(this::mapToProjectDto).collect(Collectors.toList()) : null)
                .build();
    }

    private TaskDto mapToTaskDto(Task task) {
        if (task == null) {
            return null;
        }

        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .priority(task.getPriority())
                .description(task.getDescription())
                .status(task.getStatus())
                .starting(task.getStarting())
                .ending(task.getEnding())
                .assignedTo(task.getAssignedTo() != null ? mapToAppUserDto(task.getAssignedTo()) : null)
                .project(task.getProject() != null ? mapToProjectDto(task.getProject()) : null)
                .comments(task.getComments() != null ? task.getComments().stream().map(this::mapToCommentDto).collect(Collectors.toList()) : null)
                .activities(task.getActivities() != null ? task.getActivities().stream().map(this::mapToActivityDto).collect(Collectors.toList()) : null)
                .dependencies(task.getDependencies() != null ? task.getDependencies().stream().map(this::mapToDependencyDto).collect(Collectors.toList()) : null)
                .build();
    }

    private CommentDto mapToCommentDto(Comment comment) {
        if (comment == null) {
            return null;
        }

        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .author(mapToAppUserDto(comment.getAuthor()))
                .build();
    }

    private ActivityDto mapToActivityDto(Activity activity) {
        if (activity == null) {
            return null;
        }

        return ActivityDto.builder()
                .id(activity.getId())
                .name(activity.getName())
                .user(mapToAppUserDto(activity.getUser()))
                .task(mapToTaskDto(activity.getTask()))
                .build();
    }

    private RecentDto mapToRecentDto(Recent recent) {
        if (recent == null) {
            return null;
        }

        return RecentDto.builder()
                .id(recent.getId())
                .name(recent.getName())
                .user(mapToAppUserDto(recent.getUser()))
                .type(recent.getType().name())
                .build();
    }

    private ProjectDto mapToProjectDto(Project project) {
        if (project == null) {
            return null;
        }

        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .build();
    }
    private DependencyDto mapToDependencyDto(Dependency dependency) {
        if (dependency == null) {
            return null;
        }
        return DependencyDto.builder()
                .id(dependency.getId())
                .status(dependency.getStatus())
                .task1(mapToTaskDto(dependency.getTask1()))
                .task2(mapToTaskDto(dependency.getTask2()))
                .build();
    }
}