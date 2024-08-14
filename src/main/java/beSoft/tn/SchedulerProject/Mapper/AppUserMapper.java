package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserMapper {

    public AppUserProject appUserProjectDtoToAppUserProject(AppUserProjectDto dto) {
        if ( dto == null ) {
            return null;
        }

        AppUserProject appUserProject = new AppUserProject();

        appUserProject.setId( dto.getId() );
        appUserProject.setUser( appUserDtoToAppUser( dto.getUser() ) );
        appUserProject.setProject( projectDtoToProject( dto.getProject() ) );

        return appUserProject;
    }
    public AppUserProjectDto appUserProjectToAppUserProjectDto(AppUserProject appUserProject) {
        if ( appUserProject == null ) {
            return null;
        }

        AppUserProjectDto appUserProjectDto = new AppUserProjectDto();

        appUserProjectDto.setId( appUserProject.getId() );
        appUserProjectDto.setUser( null );
        appUserProjectDto.setProject( projectToProjectDto( appUserProject.getProject() ) );

        return appUserProjectDto;
    }


    public List<AppUserProject> appUserProjectDtoToAppUserProjectList(List<AppUserProjectDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppUserProject> list = new ArrayList<AppUserProject>( dtoList.size() );
        for ( AppUserProjectDto appUserProjectDto : dtoList ) {
            list.add( appUserProjectDtoToAppUserProject( appUserProjectDto ) );
        }

        return list;
    }

    public List<AppUserProjectDto> appUserProjectListToAppUserProjectList(List<AppUserProject> appUserProjectList) {
        if ( appUserProjectList == null ) {
            return null;
        }

        List<AppUserProjectDto> list = new ArrayList<AppUserProjectDto>( appUserProjectList.size() );
        for ( AppUserProject appUserProject : appUserProjectList ) {
            list.add( appUserProjectToAppUserProjectDto( appUserProject ) );
        }

        return list;
    }

    public AppUser appUserDtoToAppUser(AppUserDto appUserDto) {
        if ( appUserDto == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( appUserDto.getId() );
        appUser.setFullName( appUserDto.getFullName() );
        appUser.setEmail( appUserDto.getEmail() );
        appUser.setRole( appUserDto.getRole() );
        appUser.setPassword( appUserDto.getPassword() );
        appUser.setRecents( recentDtoListToRecentList( appUserDto.getRecents() ) );
        appUser.setAppUserProject(appUserProjectDtoToAppUserProjectList(appUserDto.getAppUserProjects()));
        return appUser;
    }

    public AppUserDto appUserToAppUserDto(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserDto appUserDto = new AppUserDto();

        appUserDto.setId( appUser.getId() );
        appUserDto.setFullName( appUser.getFullName() );
        appUserDto.setEmail( appUser.getEmail() );
        appUserDto.setRole( appUser.getRole() );
        appUserDto.setPassword( appUser.getPassword() );
        appUserDto.setRecents( recentListToRecentDtoList( appUser.getRecents() ) );
        appUserDto.setAppUserProjects(appUserProjectListToAppUserProjectList(appUser.getAppUserProject()));
        return appUserDto;
    }

    public List<AppUserDto> appUserListToAppUserDtoList(List<AppUser> appUserList) {
        if ( appUserList == null ) {
            return null;
        }

        List<AppUserDto> list = new ArrayList<AppUserDto>( appUserList.size() );
        for ( AppUser appUser : appUserList ) {
            list.add( appUserToAppUserDto( appUser ) );
        }

        return list;
    }

    public List<AppUser> appUserDtoListToAppUserList(List<AppUserDto> appUserDtoList) {
        if ( appUserDtoList == null ) {
            return null;
        }

        List<AppUser> list = new ArrayList<AppUser>( appUserDtoList.size() );
        for ( AppUserDto appUserDto : appUserDtoList ) {
            list.add( appUserDtoToAppUser( appUserDto ) );
        }

        return list;
    }

    public Project projectDtoToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setName( projectDto.getName() );
        project.setTasks( taskDtoListToTaskList( projectDto.getTasks() ) );
        project.setAppUserProjects( appUserProjectDtoToAppUserProjectList( projectDto.getAppUserProjects() ) );

        return project;
    }

    public ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setTasks( null);
        projectDto.setAppUserProjects( null );

        return projectDto;
    }

    public List<Project> projectDtoListToProjectList(List<ProjectDto> projectDtoList) {
        if ( projectDtoList == null ) {
            return null;
        }

        List<Project> list = new ArrayList<Project>( projectDtoList.size() );
        for ( ProjectDto projectDto : projectDtoList ) {
            list.add( projectDtoToProject( projectDto ) );
        }

        return list;
    }

    public List<ProjectDto> projectListToProjectDtoList(List<Project> projectList) {
        if ( projectList == null ) {
            return null;
        }

        List<ProjectDto> list = new ArrayList<ProjectDto>( projectList.size() );
        for ( Project project : projectList ) {
            list.add( projectToProjectDto( project ) );
        }

        return list;
    }

    public Comment commentDtoToComment(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDto.getId() );
        comment.setText( commentDto.getText() );
        comment.setTask( taskDtoToTask( commentDto.getTask() ) );
        comment.setUserId( commentDto.getUserId() );

        return comment;
    }

    public CommentDto commentToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( comment.getId() );
        commentDto.setText( comment.getText() );
        commentDto.setTask( taskToTaskDto( comment.getTask() ) );
        commentDto.setUserId( comment.getUserId() );

        return commentDto;
    }

    public List<Comment> commentDtoListToCommentList(List<CommentDto> commentDtoList) {
        if ( commentDtoList == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentDtoList.size() );
        for ( CommentDto commentDto : commentDtoList ) {
            list.add( commentDtoToComment( commentDto ) );
        }

        return list;
    }

    public List<CommentDto> commentListToCommentDtoList(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( commentToCommentDto( comment ) );
        }

        return list;
    }

    public Activity activityDtoToActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setStartTime( activityDto.getStartTime() );
        activity.setId( activityDto.getId() );
        activity.setName( activityDto.getName() );
        activity.setTask( taskDtoToTask( activityDto.getTask() ) );
        activity.setUserId( activityDto.getUserId() );

        return activity;
    }

    public ActivityDto activityToActivityDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        activityDto.setStartTime( activity.getStartTime() );
        activityDto.setId( activity.getId() );
        activityDto.setName( activity.getName() );
        activityDto.setTask( taskToTaskDto( activity.getTask() ) );
        activityDto.setUserId( activity.getUserId() );

        return activityDto;
    }

    public List<Activity> activityDtoListToActivityList(List<ActivityDto> activityDtoList) {
        if ( activityDtoList == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( activityDtoList.size() );
        for ( ActivityDto activityDto : activityDtoList ) {
            list.add( activityDtoToActivity( activityDto ) );
        }

        return list;
    }

    public List<ActivityDto> activityListToActivityDtoList(List<Activity> activityList) {
        if ( activityList == null ) {
            return null;
        }

        List<ActivityDto> list = new ArrayList<ActivityDto>( activityList.size() );
        for ( Activity activity : activityList ) {
            list.add( activityToActivityDto( activity ) );
        }

        return list;
    }

    public Dependency dependencyDtoToDependency(DependencyDto dependencyDto) {
        if ( dependencyDto == null ) {
            return null;
        }

        Dependency dependency = new Dependency();

        dependency.setUserId( dependencyDto.getUserId() );
        dependency.setId( dependencyDto.getId() );
        dependency.setStatus( dependencyDto.getStatus() );
        dependency.setRelatedTaskId( dependencyDto.getRelatedTaskId() );
        dependency.setTask( taskDtoToTask( dependencyDto.getTask() ) );

        return dependency;
    }

    public DependencyDto dependencyToDependencyDto(Dependency dependency) {
        if ( dependency == null ) {
            return null;
        }

        DependencyDto dependencyDto = new DependencyDto();

        dependencyDto.setUserId( dependency.getUserId() );
        dependencyDto.setId( dependency.getId() );
        dependencyDto.setStatus( dependency.getStatus() );
        dependencyDto.setRelatedTaskId( dependency.getRelatedTaskId() );
        dependencyDto.setTask( taskToTaskDto( dependency.getTask() ) );

        return dependencyDto;
    }

    public List<Dependency> dependencyDtoListToDependencyList(List<DependencyDto> dependencyDtoList) {
        if ( dependencyDtoList == null ) {
            return null;
        }

        List<Dependency> list = new ArrayList<Dependency>( dependencyDtoList.size() );
        for ( DependencyDto dependencyDto : dependencyDtoList ) {
            list.add( dependencyDtoToDependency( dependencyDto ) );
        }

        return list;
    }

    public List<DependencyDto> dependencyListToDependencyDtoList(List<Dependency> dependencyList) {
        if ( dependencyList == null ) {
            return null;
        }

        List<DependencyDto> list = new ArrayList<DependencyDto>( dependencyList.size() );
        for ( Dependency dependency : dependencyList ) {
            list.add( dependencyToDependencyDto( dependency ) );
        }

        return list;
    }

    public Recent recentDtoToRecent(RecentDto recentDto) {
        if ( recentDto == null ) {
            return null;
        }

        Recent recent = new Recent();

        recent.setId( recentDto.getId() );
        recent.setUser( appUserDtoToAppUser( recentDto.getUser() ) );
        recent.setType( recentDto.getType() );
        recent.setDate( recentDto.getDate() );

        return recent;
    }

    public RecentDto recentToRecentDto(Recent recent) {
        if ( recent == null ) {
            return null;
        }

        RecentDto recentDto = new RecentDto();

        recentDto.setId( recent.getId() );
        recentDto.setType( recent.getType() );
        recentDto.setUser( null );
        recentDto.setDate( recent.getDate() );

        return recentDto;
    }

    public List<Recent> recentDtoListToRecentList(List<RecentDto> recentDtoList) {
        if ( recentDtoList == null ) {
            return null;
        }

        List<Recent> list = new ArrayList<Recent>( recentDtoList.size() );
        for ( RecentDto recentDto : recentDtoList ) {
            list.add( recentDtoToRecent( recentDto ) );
        }

        return list;
    }

    public List<RecentDto> recentListToRecentDtoList(List<Recent> recentList) {
        if ( recentList == null ) {
            return null;
        }

        List<RecentDto> list = new ArrayList<RecentDto>( recentList.size() );
        for ( Recent recent : recentList ) {
            list.add( recentToRecentDto( recent ) );
        }

        return list;
    }

    public Task taskDtoToTask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDto.getId() );
        task.setName( taskDto.getName() );
        task.setPriority( taskDto.getPriority() );
        task.setDescription( taskDto.getDescription() );
        task.setStatus( taskDto.getStatus() );
        task.setStarting( taskDto.getStarting() );
        task.setEnding( taskDto.getEnding() );
        task.setProject( projectDtoToProject( taskDto.getProject() ) );
        task.setComments( commentDtoListToCommentList( taskDto.getComments() ) );
        task.setActivities( activityDtoListToActivityList( taskDto.getActivities() ) );
        task.setDependencies( dependencyDtoListToDependencyList( taskDto.getDependencies() ) );
        task.setUserId( taskDto.getUserId() );

        return task;
    }

    public TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setId( task.getId() );
        taskDto.setName( task.getName() );
        taskDto.setPriority( task.getPriority() );
        taskDto.setDescription( task.getDescription() );
        taskDto.setStatus( task.getStatus() );
        taskDto.setStarting( task.getStarting() );
        taskDto.setEnding( task.getEnding() );
        taskDto.setUserId( task.getUserId() );
        taskDto.setProject( projectToProjectDto( task.getProject() ) );
        taskDto.setComments( commentListToCommentDtoList( task.getComments() ) );
        taskDto.setActivities( activityListToActivityDtoList( task.getActivities() ) );
        taskDto.setDependencies( dependencyListToDependencyDtoList( task.getDependencies() ) );

        return taskDto;
    }

    public List<Task> taskDtoListToTaskList(List<TaskDto> taskDtoList) {
        if ( taskDtoList == null ) {
            return null;
        }

        List<Task> list = new ArrayList<Task>( taskDtoList.size() );
        for ( TaskDto taskDto : taskDtoList ) {
            list.add( taskDtoToTask( taskDto ) );
        }

        return list;
    }

    public List<TaskDto> taskListToTaskDtoList(List<Task> taskList) {
        if ( taskList == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( taskList.size() );
        for ( Task task : taskList ) {
            list.add( taskToTaskDto( task ) );
        }

        return list;
    }
}
