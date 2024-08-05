package beSoft.tn.SchedulerProject.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActivityDto {
    private Integer id;
    private String name;
    private AppUserDto user;
    private TaskDto task;
}
