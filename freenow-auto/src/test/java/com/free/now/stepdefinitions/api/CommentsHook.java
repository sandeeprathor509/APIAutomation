package com.free.now.stepdefinitions.api;

import com.free.now.constants.AppConstants;
import com.free.now.models.Comment;
import com.free.now.services.CommentService;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class CommentsHook {

    @Autowired
    AppConstants appConstants;

    @Autowired
    Comment comment;

    @Autowired
    CommentService commentService;

    @And("Search for the saved user email using postId")
    public void getEmailUsingPostId() throws Throwable {
        for(int i=1; i<=appConstants.getPostId().size(); i++){
            Response response = commentService.getCommentByPostId(appConstants.getPostId().get(i));
            List<Comment> commentList = response.jsonPath().getList("", Comment.class);
            for(Comment comment1: commentList){
                appConstants.setEmail(Collections.singletonList(comment1.getEmail()));
            }
            if(comment.getEmail().equalsIgnoreCase(appConstants.getUserEmail())){
                System.out.println("Email Found "+comment.getEmail());
            } else {
                System.out.println("There is no email with the following address");
            }
        }
    }
}
