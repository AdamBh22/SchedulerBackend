package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.CommentDto;
import beSoft.tn.SchedulerProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import beSoft.tn.SchedulerProject.model.Comment;

import java.util.List;
@Controller
@RestController
public class CommentController {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/comments")
    public CommentDto createComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return commentService.getAll();
    }
    @GetMapping("/comments/{id}")
    public CommentDto getComment(@PathVariable Integer id) {
        return commentService.getById(id);
    }
}
