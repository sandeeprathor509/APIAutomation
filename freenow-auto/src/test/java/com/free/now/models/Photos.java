package com.free.now.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Photos {

    @JsonProperty("albumId")
    private String albumId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
}
