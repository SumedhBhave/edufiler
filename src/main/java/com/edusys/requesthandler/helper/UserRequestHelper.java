package com.edusys.requesthandler.helper;

import com.edusys.dto.request.LoginRequestDTO;
import com.edusys.request.bo.LoginRequestBO;

public class UserRequestHelper {
    public static LoginRequestDTO buildLoginRequestDTOFromBO(LoginRequestBO loginRequestBO){
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setUserName(loginRequestBO.getUserName());
        loginRequestDTO.setPassword(loginRequestBO.getPassword());
        return loginRequestDTO;
    }
}
