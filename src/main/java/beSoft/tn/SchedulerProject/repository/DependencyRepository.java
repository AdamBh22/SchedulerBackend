package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Dependency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependencyRepository extends JpaRepository<Dependency, Integer> {
}
