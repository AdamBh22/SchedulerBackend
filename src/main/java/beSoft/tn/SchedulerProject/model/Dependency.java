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
public class Dependency {
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    @OneToOne
    private Task task1;
    @OneToOne
    private Task task2;
}
