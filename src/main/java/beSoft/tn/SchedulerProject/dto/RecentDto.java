package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentDto {
    private Integer id;
    private String name;
    private String type;
    private AppUserDto user;
}
