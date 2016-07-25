package com.edusys.dao;

import com.edusys.dto.response.LoginResponseDTO;
import com.edusys.exceptions.UserNotFoundException;

import java.sql.*;

public class UsersDAO {
    public LoginResponseDTO getUserDetailsWithName(String name) throws UserNotFoundException{
        Connection connection = null;
        Statement statement = null;
        LoginResponseDTO loginResponseDTO = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT id, password, status, type_id, sessionId FROM users where name = \"")
                    .append(name).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            loginResponseDTO = new LoginResponseDTO();
            while (resultSet.next()) {
                loginResponseDTO.setUserName(name);
                loginResponseDTO.setId(resultSet.getInt("id"));
                loginResponseDTO.setPassword(resultSet.getString("password"));
                loginResponseDTO.setStatus(resultSet.getString("status"));
                loginResponseDTO.setTypeId(resultSet.getInt("type_id"));
                loginResponseDTO.setSessionId(resultSet.getString("sessionId"));
                rowCount++;
            }
            if (rowCount == 0) {
                throw new UserNotFoundException("User name invalid");
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
        return loginResponseDTO;
    }

    public LoginResponseDTO getUserDetailsWithId(int userId) throws UserNotFoundException{
        Connection connection = null;
        Statement statement = null;
        LoginResponseDTO loginResponseDTO = null;
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT id, name, password, status, type_id, session_id FROM users where id = \"")
                    .append(userId).append("\"");
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            loginResponseDTO = new LoginResponseDTO();
            while (resultSet.next()) {
                loginResponseDTO.setUserName(resultSet.getString("name"));
                loginResponseDTO.setId(resultSet.getInt("id"));
                loginResponseDTO.setPassword(resultSet.getString("password"));
                loginResponseDTO.setStatus(resultSet.getString("status"));
                loginResponseDTO.setTypeId(resultSet.getInt("type_id"));
                loginResponseDTO.setSessionId(resultSet.getString("session_id"));
                rowCount++;
            }
            if (rowCount == 0) {
                throw new UserNotFoundException("User id invalid");
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
        return loginResponseDTO;
    }

    public Boolean updateSessionId(int userId, String sessionId)
            throws SQLException {
        boolean isUpdated = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            connection = new ConnectionHandler().getConnection();
            connection.setAutoCommit(false);
            StringBuffer query = new StringBuffer(
                    "UPDATE users SET sessionId = '").append(sessionId)
                    .append("' WHERE id = ").append(userId);
            preparedStatement = connection.prepareStatement(query.toString());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                isUpdated = Boolean.TRUE;
            } else {
                connection.rollback();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    public String getSessionIdForUserId(
            int userId) throws SQLException, UserNotFoundException {
        Connection connection = null;
        Statement statement = null;
        String sessionId = "";
        try {
            connection = new ConnectionHandler().getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder(
                    "SELECT sessionId FROM users where id = ")
                    .append(userId);
            ResultSet resultSet = statement.executeQuery(query.toString());
            int rowCount = 0;
            while (resultSet.next()) {
                sessionId = resultSet.getString("sessionId");
                rowCount++;
            }
            if (rowCount == 0) {
                throw new UserNotFoundException("User name invalid");
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
        return sessionId;
    }
}
