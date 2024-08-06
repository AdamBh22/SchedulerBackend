package beSoft.tn.SchedulerProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {
    private Integer id;
    private String name;
    private AppUserDto user;
    private TaskDto task;
}
