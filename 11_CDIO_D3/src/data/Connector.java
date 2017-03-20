package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connector {

    private final String CONFIG_FILE = "/src/mysql.config";
    private String driverClass;
    private String driver;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    private Connection connection;

    public Connector() {
        loadProperties();
        try {
            Class.forName(driverClass);
            String url = driver + "://" + host + ":" + port + "/" + database;
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet doQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public void doUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(CONFIG_FILE)) {
            properties.load(is);
            this.driverClass = properties.getProperty("DRIVER_CLASS");
            this.driver = properties.getProperty("DRIVER");
            this.host = properties.getProperty("HOST");
            this.port = Integer.parseInt(properties.getProperty("PORT"));
            this.database = properties.getProperty("DATABASE");
            this.username = properties.getProperty("USERNAME");
            this.password = properties.getProperty("PASSWORD");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}