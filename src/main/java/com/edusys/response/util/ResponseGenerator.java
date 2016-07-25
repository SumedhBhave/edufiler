package com.edusys.response.util;
import javax.ws.rs.core.Response;

public class ResponseGenerator {
    public static Response generateResponse(Object responseObject) {
        return Response
                .ok()
                // 200
                .entity(responseObject)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, DELETE, PUT").build();
    }
}
