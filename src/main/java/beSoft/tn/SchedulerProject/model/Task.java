package beSoft.tn.SchedulerProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String priority;
    private String description;
    private String status;
    private LocalDate starting;
    private LocalDate ending;
    @OneToOne
    private AppUser assignedTo;
    @OneToOne
    private Project project;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Activity> activities;
    @OneToMany
    private List<Dependency> dependencies;
}
