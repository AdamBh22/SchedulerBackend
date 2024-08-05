package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecentDto {
    private Integer id;
    private String name;
    private String type;
    private AppUserDto user;
}
