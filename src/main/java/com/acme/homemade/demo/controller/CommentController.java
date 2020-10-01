package com.acme.homemade.demo.controller;

import com.acme.homemade.demo.domain.model.Comment;
import com.acme.homemade.demo.domain.service.CommentService;
import com.acme.homemade.demo.resource.CommentResource;
import com.acme.homemade.demo.resource.SaveCommentResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CommentService commentService;

    @GetMapping("/publications/comments/{publicationId}")
    public Page<CommentResource> getAllCommentsByPublicationId(
            @PathVariable Long publicationId, Pageable pageable) {
        Page<Comment> commentPage = commentService.getAllCommentByPublicationId(publicationId, pageable);
        List<CommentResource> resources = commentPage
                .getContent()
                .stream().map(
                        this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/publications/comments/users/{userId}")
    public Page<CommentResource> getAllCommentsByUserId(
            @PathVariable Long userId, Pageable pageable) {
        Page<Comment> commentPage = commentService.getAllCommentByUserId(userId, pageable);
        List<CommentResource> resources = commentPage
                .getContent()
                .stream().map(
                        this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/publications/{publicationId}/users/{userId}/comments")
    public CommentResource createComment(
            @PathVariable(value = "publicationId") Long publicationId,
            @PathVariable(value = "userId") Long userId,
            @Valid @RequestBody SaveCommentResource resource) {
        return convertToResource(commentService.createComment(publicationId,userId, convertToEntity(resource) ));
    }

    @PutMapping("/publications/{publicationId}/users/{userId}/comments/{commentId}")
    public CommentResource updateComment(
            @PathVariable (value = "publicationId") Long publicationId,
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "commentId") Long commentId,
            @Valid @RequestBody SaveCommentResource resource){
        return convertToResource(commentService.updateComment(publicationId, userId, commentId, convertToEntity(resource)));
    }

    @DeleteMapping("/publications/{publicationId}/users/{userId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(
            @PathVariable (value = "publicationId") Long publicationId,
            @PathVariable (value = "userId") Long userId,
            @PathVariable (value = "commentId") Long commentId){
        return commentService.deleteComment(publicationId, userId, commentId);
    }

    private Comment convertToEntity(SaveCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    private CommentResource convertToResource(Comment entity) {
        return mapper.map(entity, CommentResource.class);
    }

}
