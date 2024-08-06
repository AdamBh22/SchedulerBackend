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
        Comment comment = CommentMapper.INSTANCE.toEntity(commentDto);
        return CommentMapper.INSTANCE.toDto(commentRepository.save(comment));
    }

    public CommentDto getById(Integer id) {
        Comment comment= commentRepository.findById(id).orElse(null);
        return CommentMapper.INSTANCE.toDto(comment);
    }

    public List<CommentDto> getAll() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(CommentMapper.INSTANCE::toDto).toList();
    }

}
