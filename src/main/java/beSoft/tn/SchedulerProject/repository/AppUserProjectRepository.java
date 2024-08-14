package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.model.AppUserProject;
import beSoft.tn.SchedulerProject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserProjectRepository extends JpaRepository<AppUserProject, Integer> {
    List<AppUserProject> findByProjectId(Integer projectId);
    List<AppUserProject> findByUserId(Integer userId);
}
