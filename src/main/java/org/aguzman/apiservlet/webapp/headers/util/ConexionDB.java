package org.aguzman.apiservlet.webapp.headers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static String url ="jdbc:mysql://localhost:3306/java_curso";
    private static String username ="root";
    private static String password = "sasa";

    public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
