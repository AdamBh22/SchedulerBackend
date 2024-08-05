package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyRepository extends JpaRepository<Dependency, Integer> {
}
