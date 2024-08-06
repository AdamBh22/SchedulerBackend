package beSoft.tn.SchedulerProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Activity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToOne
    private AppUser user;
    @JsonBackReference
    @OneToOne
    private Task task;
}
