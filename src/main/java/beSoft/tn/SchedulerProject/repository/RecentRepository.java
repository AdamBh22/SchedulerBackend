package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Recent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Integer> {
}
