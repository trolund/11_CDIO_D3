package jdbc_test;

/**
 * Created by absencia on 3/19/17.
 */

import java.sql.*;

public class JDBCTest {
    // Her er en gist med alt relevant database code: https://gist.github.com/InAbsencia/188bd72a58e87ba21244d2c00c56e308
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // I skal nok ændre denne her til Oracle variant. Den er: com.mysql.jdbc.Driver
        // Class.forName("org.mariadb.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Driver loaded!");

        // Ændre dette til jeres respektive database, username og password.
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "password");

        System.out.println("It works!");
        conn.close();
    }

}
