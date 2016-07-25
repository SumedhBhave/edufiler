package com.edusys.dao;

import com.edusys.dto.InstituteBranchDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InstituteBranchDAO {
    public InstituteBranchDTO getBranchDetailsWithName(String name) {
        Connection connection = null;
        Statement statement = null;
        InstituteBranchDTO instituteBranchDTO = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM institute_branch where name = \"")
                    .append(name).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            instituteBranchDTO = new InstituteBranchDTO();
            while (resultSet.next()) {
                instituteBranchDTO.setName(name);
                instituteBranchDTO.setId(resultSet.getInt("id"));
                instituteBranchDTO.setAddress(resultSet.getString("address"));
                instituteBranchDTO.setCityId(resultSet.getInt("city_id"));
                rowCount++;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instituteBranchDTO;
    }
}
