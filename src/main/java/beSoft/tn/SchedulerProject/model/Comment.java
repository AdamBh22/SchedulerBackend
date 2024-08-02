package beSoft.tn.SchedulerProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    @OneToOne
    private AppUser author;
    @OneToOne
    private Task task;
}
