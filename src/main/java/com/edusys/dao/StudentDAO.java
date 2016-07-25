package com.edusys.dao;

import com.edusys.dto.request.StudentRequestDTO;

import java.sql.*;

/**
 * Created by Sumedh on 26-06-2016.
 */
public class StudentDAO {
    public Integer createStudent(StudentRequestDTO studentRequestDTO) throws SQLException{

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        StringBuilder query = new StringBuilder("INSERT INTO student(name, college, image_path, mobile, address, admission_date, date_of_birth,");
        query.append("gender, parent_name, parent_occupation, parent_phone, parent_relation, institute_branch_id, status) values (?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");
        Integer id = 0;
        try {
            int parameterIndex = 1;
            connection = new ConnectionHandler().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection
                    .prepareStatement(query.toString());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getName());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getCollege());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getImagePath());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getMobile());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getAddress());
            preparedStatement.setTimestamp(parameterIndex++,
                    studentRequestDTO.getAdmissionDate());
            preparedStatement.setTimestamp(parameterIndex++,
                    studentRequestDTO.getDateOfBirth());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getGender());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getParentName());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getParentOccupation());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getParentPhone());
            preparedStatement.setString(parameterIndex++,
                    studentRequestDTO.getParentRelation());
            preparedStatement.setInt(parameterIndex++,
                    studentRequestDTO.getInstituteBranchId());
            preparedStatement.setString(parameterIndex++,
                    "A");
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }

            try {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException(
                            "Creating student failed, no ID obtained.");
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException sqlException) {
            connection.rollback();
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
}
