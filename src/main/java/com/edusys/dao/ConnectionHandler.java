package com.edusys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
    private String url;
    private String driver;
    private String userName;
    private String password;

    public ConnectionHandler() {
		userName = "root";
        password = "root";
		url = "jdbc:mysql://localhost:3306/eduSys";
		driver = "com.mysql.jdbc.Driver";
      /*  String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");;
        password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");;
        url = "jdbc:mysql://"+host+":"+port+"/eduSys";
        driver = "com.mysql.jdbc.Driver";*/

    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
