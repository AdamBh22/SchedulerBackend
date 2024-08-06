package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.CommentDto;
import beSoft.tn.SchedulerProject.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "text",target = "text")
    @Mapping(source = "author",target = "author")
    @Mapping(source = "task",target = "task")
    CommentDto toDto(Comment comment);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "text",target = "text")
    @Mapping(source = "author",target = "author")
    @Mapping(source = "task",target = "task")
    Comment toEntity(CommentDto commentDto);
}
