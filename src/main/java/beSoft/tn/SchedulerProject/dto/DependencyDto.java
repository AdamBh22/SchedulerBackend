package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.Task;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DependencyDto {
    private Integer id;
    private String status;
    private TaskDto task1;
    private TaskDto task2;
}
