package beSoft.tn.SchedulerProject.model;

import beSoft.tn.SchedulerProject.dto.RecentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Recent {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private RecentType type;
    @JsonBackReference
    @OneToOne
    private AppUser user;
}
