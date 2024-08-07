package beSoft.tn.SchedulerProject.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto{
    private Integer id;
    private String fullName;
    private String email;
    private String role;
    private String password;
    private List<TaskDto> tasks;
    private List<CommentDto> comments;
    private List<ActivityDto> activities;
    private List<RecentDto> recents;
    private List<ProjectDto> projects;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<ActivityDto> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDto> activities) {
        this.activities = activities;
    }

    public List<RecentDto> getRecents() {
        return recents;
    }

    public void setRecents(List<RecentDto> recents) {
        this.recents = recents;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
}
