package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.ActivityMapper;
import beSoft.tn.SchedulerProject.Mapper.CommentMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ActivityService activityService;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ActivityMapper activityMapper;

    public CommentDto save(CommentDto commentDto) {
        Comment comment = commentMapper.commentDtoToComment(commentDto);
        Comment savedComment = commentRepository.save(comment);

        TaskDto taskDto=commentDto.getTask();

        ActivityDto activityDto=new ActivityDto();
        activityDto.setTask(taskDto);
        activityDto.setUserId(commentDto.getUserId());
        activityDto.setName("_ADD_COMMENT_");
        activityDto.setStartTime(new Date());
        activityService.save(activityDto);

        return commentMapper.commentToCommentDto(savedComment);
    }

    public CommentDto getById(Integer id) {
        Comment comment= commentRepository.findById(id).orElse(null);
        return commentMapper.commentToCommentDto(comment);
    }

    public List<CommentDto> getAll() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(commentMapper::commentToCommentDto).toList();
    }

    public CommentDto delete(Integer id) {
        Comment comment=commentRepository.findById(id).orElse(null);
        commentRepository.delete(comment);
        return commentMapper.commentToCommentDto(comment);
    }


    public CommentDto update(Integer id, CommentDto commentDto) {
        commentDto.setId(id);
        Comment comment=commentRepository.findById(id).orElse(null);
        commentRepository.save(comment);
        return commentMapper.commentToCommentDto(comment);
    }

    public List<CommentDto> getCommentsByTaskId(Integer taskId) {
        List<Comment> comments=commentRepository.findByTaskId(taskId);
        return comments.stream().map(commentMapper::commentToCommentDto).toList();
    }
}
