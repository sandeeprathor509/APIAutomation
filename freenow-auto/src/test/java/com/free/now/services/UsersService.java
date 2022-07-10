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
public class UsersService {
    @Autowired
    RestUtils restUtils;

    @Autowired
    CustomConfig customConfig;

    public Response getUser() throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/users");
        return restUtils.call(reqMap);
    }

    public Response getSpecificUser(String userId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/users/"+userId);
        return restUtils.call(reqMap);
    }

    public Response getSpecificRequestForUser(String userId, String request) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "POST");
        reqMap.put("url", customConfig.getBaseURI() + "/users/"+userId+"/"+request);
        return restUtils.call(reqMap);
    }

    public Response getSpecificFieldByUserId(String field, String userId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/"+field+"?userId="+userId);
        return restUtils.call(reqMap);
    }
}
