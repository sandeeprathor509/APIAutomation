package com.free.now.utilities;

import com.github.jknack.handlebars.Handlebars;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * This class is read only do not modify anything here
 */
@Log4j
@Component
public class RestUtils {

    public Response call(Map<String, String> inputMap) throws Throwable {
        String requestMethod = inputMap.get("reqMethod").toUpperCase();
        String[] supportedAPIMethod = {"POST", "PUT", "GET"};
        if (!Arrays.asList(supportedAPIMethod).contains(requestMethod)) {
            throw new Exception("Unsupported API Method");
        }

        Response response = null;
        RestAssured.baseURI = new Handlebars().compileInline(inputMap.get("url")).apply(inputMap);
        RequestSpecification request = RestAssured.given();
        if (!inputMap.containsKey("contentType"))
            request.header("Content-Type", ContentType.JSON);

        if (inputMap.containsKey("authToken")) {
            request.header("Authorization", "Bearer " + inputMap.get("authToken"));
        }

        if (inputMap.containsKey("reqBody")) {
            request.body(inputMap.get("reqBody"));
        }

        if (inputMap.containsKey("queryParams")) {
            String[] params = inputMap.get("queryParams").split("&");
            for (String param : params) {
                request = request.queryParam(param.split("=")[0],param.split("=")[1]);
            }
        }

        switch (requestMethod) {
            case "GET": {
                response = request.get();
                break;
            }
            case "PUT": {
                response = request.put();
                break;
            }
            case "POST": {
                response = request.post();
                break;
            }
            case "DELETE": {
                response = request.delete();
                break;
            }
        }

        if (response != null) {
            log.info("----------------------------------------------- API CALL DETAILS -----------------------------------------------");
            log.info(requestMethod + " call to " + RestAssured.baseURI + ", completed with status code : " + response.getStatusCode());
            log.info(inputMap.containsKey("reqBody") ? ("Request Body :" + inputMap.get("reqBody")) : "Request body is empty");
            log.info("Response : " + response.body().asString());
            log.info("----------------------------------------------------------------------------------------------------------------\n");
        }

        return response;
    }

}
