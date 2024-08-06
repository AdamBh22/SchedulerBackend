package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Integer id;
    private String name;
    private AppUserDto owner;
    private List<TaskDto> tasks;
}
