package beSoft.tn.SchedulerProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne
    private AppUser user;
    @OneToOne
    private Task task;
}
