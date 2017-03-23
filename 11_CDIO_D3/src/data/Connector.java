package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connector {

    private final String CONFIG_FILE = "mysql_oracle.config";
    private String driverClass;
    private String driver;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    private Connection connection;

    private static final Connector instance = new Connector();

    private Connector() {
        loadProperties();
        try {
            Class.forName(driverClass);
            String url = driver + "://" + host + ":" + port + "/" + database;
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("DEBUG: [" + this.getClass().getName() + "] Status: Successfully connected to MySQL database,\nhost '" + host + "' with user '" + username + "'.");
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

    public void cleanup(PreparedStatement stmt, ResultSet rs) throws SQLException {
        if (stmt != null)
            stmt.close();
        if (rs != null)
            rs.close();
    }

    public void cleanup(PreparedStatement stmt) throws SQLException {
        if (stmt != null)
            stmt.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized Connector getInstance() {
        return instance;
    }

}