package beSoft.tn.SchedulerProject.dto;




public class ActivityDto {
    private Integer id;
    private String name;
    private AppUserDto user;
    private TaskDto task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public AppUserDto getUser() {
        return user;
    }
    public void setUser(AppUserDto user) {
        this.user = user;
    }
}
