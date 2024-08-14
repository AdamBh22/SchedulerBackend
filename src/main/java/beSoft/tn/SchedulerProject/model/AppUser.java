package beSoft.tn.SchedulerProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_user_id")
    private Integer id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String role;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Recent> recents;

    @OneToMany(mappedBy = "user")
    private List<AppUserProject> appUserProject;

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


    public List<Recent> getRecents() {
        return recents;
    }

    public void setRecents(List<Recent> recents) {
        this.recents = recents;
    }

    public List<AppUserProject> getAppUserProject() {
        return appUserProject;
    }
    public void setAppUserProject(List<AppUserProject> appUserProject) {
        this.appUserProject = appUserProject;
    }
}
