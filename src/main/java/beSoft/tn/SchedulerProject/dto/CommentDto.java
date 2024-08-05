package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.model.Task;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentDto {
    private Integer id;
    private String text;
    private AppUserDto author;
    private TaskDto task;
}
