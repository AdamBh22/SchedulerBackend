package beSoft.tn.SchedulerProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String role;
    private String password;
    @OneToMany
    private List<Task> tasks;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Activity> activities;
    @OneToMany
    private List<Recent> recents;
    @OneToMany
    private List<Project> projects;
}
