package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(Integer commentId);

    Comment saveComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteById(Integer commentId);

    List<Comment> findAllByCourseId(Integer id);
}
