package beSoft.tn.SchedulerProject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class TaskDto {
    private Integer id;
    private String name;
    private String priority;
    private String description;
    private String status;
    private LocalDate starting;
    private LocalDate ending;
    private AppUserDto assignedTo;
    private ProjectDto project;
    private List<CommentDto> comments;
    private List<ActivityDto> activities;
    private List<DependencyDto> dependencies;
}
