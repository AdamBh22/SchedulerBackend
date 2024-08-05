package beSoft.tn.SchedulerProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany
    private List<Task> tasks;
    @OneToOne
    private AppUser owner;
}
