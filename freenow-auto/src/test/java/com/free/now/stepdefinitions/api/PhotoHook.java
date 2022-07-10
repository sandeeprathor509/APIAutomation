package com.free.now.stepdefinitions.api;

import com.free.now.models.*;
import com.free.now.services.PhotoService;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class PhotoHook {

    @Autowired
    PhotoService photoService;

    @And("Get the list of photos")
    public void getPhotosList() throws Throwable{
        Response response = photoService.getPhotos();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "Lists of posts is not available");
        System.out.println(response.jsonPath().getList("", Photos.class));
    }

    @And("Filtering out the photo by using the albumId {string}")
    public void getPhotoByAlbumId(String albumId) throws Throwable{
        Response response = photoService.getPhotosByAlbumId(albumId);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "Lists of posts is not available");
        List<Photos> photos = response.jsonPath().getList("", Photos.class);
        for(Photos photo: photos){
            Assert.assertEquals(photo.getAlbumId(), albumId,
                    "Album id is not matching");
        }
    }
}
