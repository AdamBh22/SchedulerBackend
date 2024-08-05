package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
