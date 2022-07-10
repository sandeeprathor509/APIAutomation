package com.free.now.stepdefinitions.api;

import com.free.now.models.*;
import com.free.now.services.PostService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostHook {

    @Autowired
    PostService postService;

    @And("Get the list of posts")
    public void getPostsList() throws Throwable {
        Response response = postService.getPosts();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "Lists of posts is not available");
        System.out.println(response.jsonPath().getList("",Posts.class));
    }

    @And("Get the posts with the {string} userId")
    public void getPostWithUserId(String userId) throws Throwable {
        Response response = postService.getPostByUserId(userId);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "Post for the searched userid is not present");
        List<Posts> postInfo = response.jsonPath().getList("", Posts.class);
        for(Posts posts: postInfo){
            Assert.assertEquals(posts.getUserId(), userId,
                    "User id is not matching");
        }
    }

    @Then("Create a user with title {string} and body as {string} for the user {string}")
    public void createUser(String title, String body, String userId) throws Throwable {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("title",title);
        requestBody.put("body",body);
        requestBody.put("userId", userId);
        Response response = postService.createPosts(requestBody);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED,
                "Unable to create a post");
    }
}
