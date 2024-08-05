package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
