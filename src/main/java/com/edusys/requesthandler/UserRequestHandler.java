package com.edusys.requesthandler;

import com.edusys.dao.UsersDAO;
import com.edusys.dto.response.LoginResponseDTO;
import com.edusys.exceptions.UserNotFoundException;
import com.edusys.request.bo.LoginRequestBO;
import com.edusys.response.bo.LoginResponseBO;

import java.sql.SQLException;
import java.util.*;

public class UserRequestHandler {
    public LoginResponseBO login(LoginRequestBO loginRequestBO)
            throws SQLException, UserNotFoundException {
        UsersDAO usersDAO = new UsersDAO();
        LoginResponseDTO loginResponseDTO = usersDAO
                .getUserDetailsWithName(loginRequestBO.getUserName());
        LoginResponseBO loginResponseBO = new LoginResponseBO();
        Boolean isValidUser = loginRequestBO.getUserName().equals(loginResponseDTO.getUserName()) && loginRequestBO.getPassword().equals(loginResponseDTO.getPassword());
        if (isValidUser) {
            Long newSessionId = new Date().getTime();
            if(loginResponseDTO.getSessionId() == null) {
                usersDAO.updateSessionId(loginResponseDTO.getId(), String.valueOf(newSessionId));
            }else{
                usersDAO.updateSessionId(loginResponseDTO.getId(),loginResponseDTO.getSessionId()+"@@"+ String.valueOf(newSessionId));
            }
            loginResponseBO.setSessionId(newSessionId+"@"+loginResponseDTO.getId());
        }
        return loginResponseBO;
    }

    public Boolean logout(int userId, String sessionIdOfUser) throws SQLException, UserNotFoundException {
        Boolean isLoggedOut = Boolean.FALSE;
        try {
            UsersDAO usersDAO = new UsersDAO();
            String sessionId = usersDAO.getSessionIdForUserId(userId);
            List sessionIds = Arrays.asList(sessionId.split("@@"));
            String updatedSessions = getSeparatorSeparatedStringFromListWithParamExcluded(sessionIds, "@@", sessionIdOfUser);
            isLoggedOut = usersDAO.updateSessionId(userId, updatedSessions);
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return isLoggedOut;
    }

    private String getSeparatorSeparatedStringFromListWithParamExcluded(List<String> collectionOfStrings, String separator, String exclusion) {
        StringBuilder result = new StringBuilder();
        Iterator<String> collectionOfStringsIterator = collectionOfStrings.iterator();
        while (collectionOfStringsIterator.hasNext()) {
            String s= collectionOfStringsIterator.next();
            if(!s.equals(exclusion)) {
                result.append("" + s + "");
                result.append(separator);
            }
        }
        return result.length() > 0 ? result.substring(0, result.length() - separator.length()) : "";
    }
}
