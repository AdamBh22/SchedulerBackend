package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
