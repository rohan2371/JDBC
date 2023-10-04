package com.student.mgmt.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection connection;
    public static Connection createConn() {
        try {
            // step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step2 create the connection object
            String user = "root";
            String password = "1234";
            String url = "jdbc:mysql://localhost:3306/jdbcdb";
            connection = DriverManager.getConnection(url, user, password);


        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return connection;
    }
}
