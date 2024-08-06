package beSoft.tn.SchedulerProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
