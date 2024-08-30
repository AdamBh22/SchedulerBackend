package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Recent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Integer> {
    List<Recent> findByUserId(Integer userId);
}
