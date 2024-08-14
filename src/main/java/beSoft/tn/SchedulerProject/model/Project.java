package beSoft.tn.SchedulerProject.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project",fetch = FetchType.LAZY)
    private List<Task> tasks;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project",fetch = FetchType.LAZY)
    private List<AppUserProject> appUserProjects;

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<AppUserProject> getAppUserProjects() {
        return appUserProjects;
    }

    public void setAppUserProjects(List<AppUserProject> appUserProjects) {
        this.appUserProjects = appUserProjects;
    }
}
