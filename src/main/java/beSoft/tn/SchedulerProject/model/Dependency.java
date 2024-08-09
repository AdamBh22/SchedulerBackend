package beSoft.tn.SchedulerProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    private Integer relatedTaskId;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    private Integer UserId;
    @JsonBackReference
    @ManyToOne
    private Task Task;

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

    public Integer getRelatedTaskId() {
        return relatedTaskId;
    }

    public void setRelatedTaskId(Integer relatedTaskId) {
        this.relatedTaskId = relatedTaskId;
    }

    public beSoft.tn.SchedulerProject.model.Task getTask() {
        return Task;
    }

    public void setTask(beSoft.tn.SchedulerProject.model.Task task) {
        Task = task;
    }
}
