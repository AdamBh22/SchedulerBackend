package beSoft.tn.SchedulerProject.repository;

import beSoft.tn.SchedulerProject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
