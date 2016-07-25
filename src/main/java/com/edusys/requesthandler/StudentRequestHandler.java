package com.edusys.requesthandler;

import com.edusys.dao.InstituteBranchDAO;
import com.edusys.dao.StudentDAO;
import com.edusys.dto.request.StudentRequestDTO;
import com.edusys.request.bo.StudentRequestBO;
import com.edusys.util.DateUtil;

import java.sql.SQLException;

public class StudentRequestHandler {

    public int insertStudent(StudentRequestBO studentRequestBO) throws SQLException{
        StudentDAO studentDAO = new StudentDAO();
        int id= studentDAO.createStudent(buildStudentRequestDTOFromBO(studentRequestBO));
        return id;
    }

    private StudentRequestDTO buildStudentRequestDTOFromBO(StudentRequestBO studentRequestBO){
        InstituteBranchDAO instituteBranchDAO = new InstituteBranchDAO();
        StudentRequestDTO studentRequestDTO = new StudentRequestDTO();
        studentRequestDTO.setName(studentRequestBO.getName());
        studentRequestDTO.setCollege(studentRequestBO.getCollege());
        studentRequestDTO.setImagePath(studentRequestBO.getImagePath());
        studentRequestDTO.setMobile(studentRequestBO.getMobile());
        studentRequestDTO.setGender(studentRequestBO.getGender());
        studentRequestDTO.setAddress(studentRequestBO.getAddress());
        studentRequestDTO.setParentName(studentRequestBO.getParentName());
        studentRequestDTO.setParentOccupation(studentRequestBO.getParentOccupation());
        studentRequestDTO.setParentRelation(studentRequestBO.getParentRelation());
        studentRequestDTO.setParentPhone(studentRequestBO.getParentPhone());
        studentRequestDTO.setDateOfBirth(DateUtil.getTimeStampFromString(studentRequestBO.getDateOfBirth()));
        studentRequestDTO.setAdmissionDate(DateUtil.getTimeStampFromString(studentRequestBO.getAdmissionDate()));
        studentRequestDTO.setInstituteBranchId(instituteBranchDAO.getBranchDetailsWithName(studentRequestBO.getInstituteName()).getId());
        return studentRequestDTO;
    }
}
