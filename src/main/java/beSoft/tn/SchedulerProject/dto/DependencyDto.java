package beSoft.tn.SchedulerProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependencyDto {
    private Integer id;
    private String status;
    private Integer relatedTaskId;
    private TaskDto task;

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

    public TaskDto getTask() {
        return task;
    }

    public void setTask(TaskDto task) {
        this.task = task;
    }
}
