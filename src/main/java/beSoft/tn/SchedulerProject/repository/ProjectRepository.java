package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
