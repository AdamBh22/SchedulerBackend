package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
