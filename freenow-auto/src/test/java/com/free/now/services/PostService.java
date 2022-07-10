package com.free.now.services;

import com.free.now.configs.CustomConfig;
import com.free.now.utilities.RestUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class PostService {

    @Autowired
    RestUtils restUtils;

    @Autowired
    CustomConfig customConfig;

    public Response getPosts() throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/posts");
        return restUtils.call(reqMap);
    }

    public Response createPosts(Object requestBody) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "POST");
        reqMap.put("url", customConfig.getBaseURI() + "/posts");
        return restUtils.call(reqMap);
    }

    public Response updatePost(String requestBody, String postId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "PUT");
        reqMap.put("url", customConfig.getBaseURI() + "/posts/"+"postId");
        return restUtils.call(reqMap);
    }

    public Response getPostByUserId(String userId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/posts");
        reqMap.put("queryParams","userId="+userId);
        return restUtils.call(reqMap);
    }
}
