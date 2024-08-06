package beSoft.tn.SchedulerProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependencyDto {
    private Integer id;
    private String status;
    private TaskDto ParentTask;
    private TaskDto ChildTask;
}
