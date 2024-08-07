package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.TaskMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper.INSTANCE::taskToTaskDto).toList();
    }

    public TaskDto getTaskById(Integer id) {
        Task task=taskRepository.findById(id).orElse(null);
        return TaskMapper.INSTANCE.taskToTaskDto(task);
    }

    public TaskDto Save(TaskDto taskDto) {
        Task task=TaskMapper.INSTANCE.taskDtoToTask(taskDto);
        return TaskMapper.INSTANCE.taskToTaskDto(taskRepository.save(task));
    }
}
