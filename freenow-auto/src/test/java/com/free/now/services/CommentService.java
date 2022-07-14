package com.free.now.services;

import com.free.now.configs.CustomConfig;
import com.free.now.utilities.RestUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class CommentService {

    @Autowired
    RestUtils restUtils;

    @Autowired
    CustomConfig customConfig;

    public Response getCommentByPostId(String postID) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/comments");
        reqMap.put("queryParams", "postId=" + postID);
        return restUtils.call(reqMap);
    }
}
