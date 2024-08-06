package beSoft.tn.SchedulerProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    @JsonBackReference
    @OneToOne
    private AppUser assignedTo;
    @JsonBackReference
    @OneToOne
    private Project project;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Activity> activities;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependency> dependencies;
}
