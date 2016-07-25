package com.edusys.service;

import com.edusys.request.StudentRequest;
import com.edusys.request.bo.StudentRequestBO;
import com.edusys.requesthandler.StudentRequestHandler;
import com.edusys.requesthandler.helper.RequestValidator;
import com.edusys.response.CreateStudentResponse;
import com.edusys.response.util.ResponseGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/student")
public class StudentService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createStudent(StudentRequest studentRequest, @HeaderParam("sessionId") String sessionId){
        if (sessionId != null && RequestValidator.isRequestValid(sessionId)) {
            StudentRequestBO studentRequestBO = new StudentRequestBO();
            studentRequestBO.setName(studentRequest.getName());
            studentRequestBO.setAddress(studentRequest.getAddress());
            studentRequestBO.setCollege(studentRequest.getCollege());
            studentRequestBO.setGender(studentRequest.getGender());
            studentRequestBO.setAdmissionDate(studentRequest.getDateOfBirth());
            studentRequestBO.setDateOfBirth(studentRequest.getDateOfBirth());
            studentRequestBO.setInstituteName(studentRequest.getInstituteName());
            studentRequestBO.setImagePath(studentRequest.getImagePath());
            studentRequestBO.setMobile(studentRequest.getMobile());
            studentRequestBO.setParentName(studentRequest.getParentName());
            studentRequestBO.setParentOccupation(studentRequest.getParentOccupation());
            studentRequestBO.setParentRelation(studentRequest.getParentRelation());
            studentRequestBO.setParentPhone(studentRequest.getParentPhone());
            CreateStudentResponse createStudentResponse = new CreateStudentResponse();
            StudentRequestHandler studentRequestHandler = new StudentRequestHandler();
            try {
                int id = studentRequestHandler.insertStudent(studentRequestBO);
                createStudentResponse.setFailureMessage("");
                createStudentResponse.setSuccessMessage(String.valueOf(id));
            } catch (SQLException sqlException) {
                createStudentResponse.setFailureMessage("Student Creation Failed");
                createStudentResponse.setSuccessMessage("");
            }
            return ResponseGenerator.generateResponse(createStudentResponse);
        }else {
            return ResponseGenerator.generateResponse(RequestValidator.getUnautheticatedResponse());
        }
    }
}
