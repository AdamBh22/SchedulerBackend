package beSoft.tn.SchedulerProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Integer id;
    private String fullName;
    private String email;
    private String role;
    private String password;
    private List<TaskDto> tasks;
    private List<CommentDto> comments;
    private List<ActivityDto> activities;
    private List<RecentDto> recents;
    private List<ProjectDto> projects;
}
