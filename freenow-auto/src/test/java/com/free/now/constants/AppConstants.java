package com.free.now.constants;

import com.free.now.models.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
public class AppConstants {
    private List<Users> users;
    private List<Album> albums;
    private List<Posts> posts;
    private List<Photos> photos;
}
