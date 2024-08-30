package beSoft.tn.SchedulerProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto {
    private Integer id;
    private String name;
    private List<AppUserProjectDto> appUserProjects;
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

    public List<AppUserProjectDto> getAppUserProjects() {
        return appUserProjects;
    }

    public void setAppUserProjects(List<AppUserProjectDto> appUserProjects) {
        this.appUserProjects = appUserProjects;
    }
}
