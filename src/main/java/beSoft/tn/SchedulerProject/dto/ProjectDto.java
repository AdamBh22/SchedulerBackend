package beSoft.tn.SchedulerProject.dto;

import beSoft.tn.SchedulerProject.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Integer id;
    private String name;
    private List<AppUserDto> users;
    private List<TaskDto> tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public List<AppUserDto> getUsers() {
        return users;
    }

    public void setUsers(List<AppUserDto> users) {
        this.users = users;
    }
}
