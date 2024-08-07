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
    private TaskDto ParentTask;
    private TaskDto ChildTask;

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

    public TaskDto getParentTask() {
        return ParentTask;
    }

    public void setParentTask(TaskDto parentTask) {
        ParentTask = parentTask;
    }

    public TaskDto getChildTask() {
        return ChildTask;
    }

    public void setChildTask(TaskDto childTask) {
        ChildTask = childTask;
    }
}
