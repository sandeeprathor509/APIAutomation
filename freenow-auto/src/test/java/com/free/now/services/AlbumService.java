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
public class AlbumService {
    @Autowired
    RestUtils restUtils;

    @Autowired
    CustomConfig customConfig;

    public Response getAlbum() throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/albums");
        return restUtils.call(reqMap);
    }

    public Response getAlbumByUserId(String userId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/albums");
        reqMap.put("queryParams","userId="+userId);
        return restUtils.call(reqMap);
    }
}
