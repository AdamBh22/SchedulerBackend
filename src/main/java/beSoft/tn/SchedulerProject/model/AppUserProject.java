package beSoft.tn.SchedulerProject.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="app_user_project")
public class AppUserProject {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private AppUser user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    public AppUserProject(Integer id, AppUser user, Project project) {
        this.id = id;
        this.user = user;
        this.project = project;
    }


    public AppUserProject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
