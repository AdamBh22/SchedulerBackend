package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.CommentMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public CommentDto save(CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDto);
        return CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }

    public CommentDto getById(Integer id) {
        Comment comment= commentRepository.findById(id).orElse(null);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    public List<CommentDto> getAll() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(CommentMapper.INSTANCE::commentToCommentDto).toList();
    }

    public CommentDto delete(Integer id) {
        Comment comment=commentRepository.findById(id).orElse(null);
        commentRepository.delete(comment);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    public CommentDto update(String text, CommentDto commentDto) {
        if(commentDto==null) {
            return null;
        }
        commentDto.setText(text);
        Comment comment=CommentMapper.INSTANCE.commentDtoToComment(commentDto);
        return CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(comment));
    }

}
