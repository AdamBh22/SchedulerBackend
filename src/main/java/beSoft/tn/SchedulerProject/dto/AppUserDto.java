package beSoft.tn.SchedulerProject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class AppUserDto {
    private Integer id;
    private String fullName;
    private String email;
    private String role;
    private List<TaskDto> tasks;
    private List<CommentDto> comments;
    private List<ActivityDto> activities;
    private List<RecentDto> recents;
    private List<ProjectDto> projects;
}
