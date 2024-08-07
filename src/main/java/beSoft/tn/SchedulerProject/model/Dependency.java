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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task getParentTask() {
        return ParentTask;
    }

    public void setParentTask(Task parentTask) {
        ParentTask = parentTask;
    }

    public Task getChildTask2() {
        return ChildTask2;
    }

    public void setChildTask2(Task childTask2) {
        ChildTask2 = childTask2;
    }
}
