package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ProjectDto {
    private Integer id;
    private String name;
    private AppUserDto owner;
}
