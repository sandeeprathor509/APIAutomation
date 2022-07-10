package com.free.now.stepdefinitions.api;

import com.free.now.constants.AppConstants;
import com.free.now.models.*;
import com.free.now.services.AlbumService;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class AlbumHook {

    @Autowired
    AppConstants appConstants;

    @Autowired
    AlbumService albumService;

    @And("Get the list of album")
    public void getListOfAlbum() throws Throwable {
        Response response = albumService.getAlbum();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "Album list is not present");
    }

    @And("Get the list of album by userId {string}")
    public void getAlbumByUserId(String userId) throws Throwable {
        Response response = albumService.getAlbumByUserId(userId);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,
                "User is not present");
        List<Album> albumInfo = response.jsonPath().getList("", Album.class);
        appConstants.setAlbums(albumInfo);
        for(Album album: albumInfo){
            Assert.assertEquals(album.getUserId(), userId,
                    "User id is not available in the album");
        }

    }

}
