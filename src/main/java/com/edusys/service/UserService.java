package com.edusys.service;

import com.edusys.exceptions.UserNotFoundException;
import com.edusys.request.LoginRequest;
import com.edusys.request.bo.LoginRequestBO;
import com.edusys.requesthandler.UserRequestHandler;
import com.edusys.requesthandler.helper.RequestValidator;
import com.edusys.response.LoginResponse;
import com.edusys.response.bo.LoginResponseBO;
import com.edusys.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/user")
public class UserService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginRequest loginRequest) {
        LoginRequestBO loginRequestBO = new LoginRequestBO();
        loginRequestBO.setUserName(loginRequest.getUserName());
        loginRequestBO.setPassword(loginRequest.getPassword());
        UserRequestHandler userRequestHandler = new UserRequestHandler();
        LoginResponse loginResponse = new LoginResponse();
        try {
            LoginResponseBO loginResponseBO = userRequestHandler
                    .login(loginRequestBO);
            if (loginResponseBO.getSessionId() != null) {
                loginResponse.setFailureMessage("");
                loginResponse.setSuccessMessage(String.valueOf(loginResponseBO
                        .getSessionId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            loginResponse.setSuccessMessage("");
            loginResponse.setFailureMessage(e.getMessage());
        }
        return ResponseGenerator.generateResponse(loginResponse);
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@HeaderParam("sessionId") String sessionId) {
        if (sessionId != null && RequestValidator.isRequestValid(sessionId)) {
            LoginResponse loginResponse = new LoginResponse();
            try {
                UserRequestHandler userRequestHandler = new UserRequestHandler();
                String[] sessionIdParts = sessionId.split("@");
                Boolean isLoggedOut = userRequestHandler.logout(Integer.parseInt(sessionIdParts[1]), sessionIdParts[0]);

                if (isLoggedOut) {
                    loginResponse.setSuccessMessage("SUCCESS");
                    loginResponse.setFailureMessage("");
                } else {
                    loginResponse.setSuccessMessage("");
                    loginResponse.setFailureMessage("FAILURE");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (UserNotFoundException e) {
                loginResponse.setSuccessMessage("");
                loginResponse.setFailureMessage(e.getMessage());

            }
            return ResponseGenerator.generateResponse(loginResponse);
        } else {
            return ResponseGenerator.generateResponse(RequestValidator.getUnautheticatedResponse());
        }
    }
}
