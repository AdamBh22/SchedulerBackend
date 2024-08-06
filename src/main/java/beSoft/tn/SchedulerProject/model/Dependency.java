package beSoft.tn.SchedulerProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Dependency {
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    @JsonBackReference
    @OneToOne
    private Task ParentTask;
    @JsonBackReference
    @OneToOne
    private Task ChildTask2;
}
