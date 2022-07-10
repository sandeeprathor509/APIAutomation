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
public class PhotoService {
    @Autowired
    RestUtils restUtils;

    @Autowired
    CustomConfig customConfig;

    public Response getPhotos() throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/photos");
        return restUtils.call(reqMap);
    }

    public Response getPhotosByAlbumId(String albumId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/photos");
        reqMap.put("queryParams","albumId="+albumId);
        return restUtils.call(reqMap);
    }

    public Response getPhotosById(String photoId) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("reqMethod", "GET");
        reqMap.put("url", customConfig.getBaseURI() + "/albums/"+photoId);
        return restUtils.call(reqMap);
    }
}
