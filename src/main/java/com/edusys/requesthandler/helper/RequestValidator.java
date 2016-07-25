package com.edusys.requesthandler.helper;

import com.edusys.dao.UsersDAO;
import com.edusys.exceptions.UserNotFoundException;
import com.edusys.response.RequestAuthenticationResponse;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RequestValidator {
    public static Boolean isRequestValid(String sessionId){
        String[] sessionIdParts = sessionId.split("@");
        Boolean isValidRequest = Boolean.FALSE;
        try {
            String sessionIdForUser = new UsersDAO().getSessionIdForUserId(Integer.parseInt(sessionIdParts[1]));
            List<String> sessions;
            if(sessionIdForUser != null){
                sessions = Arrays.asList(sessionIdForUser.split("@@"));
                if(sessions.contains(sessionIdParts[0])){
                    isValidRequest = Boolean.TRUE;
                }
            }else {
                isValidRequest = Boolean.FALSE;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return Boolean.FALSE;
        }

        return isValidRequest;
    }

    public static RequestAuthenticationResponse getUnautheticatedResponse(){
        RequestAuthenticationResponse requestAuthenticationResponse = new RequestAuthenticationResponse();
        requestAuthenticationResponse.setFailureMessage("Unauthorized access");
        return requestAuthenticationResponse;
    }
}
