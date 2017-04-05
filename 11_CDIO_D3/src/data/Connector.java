package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * Database connector class.
 * 
 * This class has the responsibility to load database information and SQL queries 
 * as start up as well as to maintain them and update them accordingly.
 */
public class Connector {

	/*
	 * 
	 */
	private final String MYSQL_CONFIG_FILE = "/home/absencia/workspace/11_CDIO_D3/11_CDIO_D3/mysql_mariadb.config";
	private final String SQL_CONFIG_FILE = "/home/absencia/workspace/11_CDIO_D3/11_CDIO_D3/sql.config";

	//private final String MYSQL_CONFIG_FILE = "/Users/troelslund/git/11_CDIO_D3_2/11_CDIO_D3/mysql_oracle.config";
	//private final String SQL_CONFIG_FILE = "/Users/troelslund/git/11_CDIO_D3_2/11_CDIO_D3/sql.config";

	private String driverClass;
	private String driver;
	private String host;
	private int port;
	private String database;
	private String username;
	private String password;

	private Connection connection;
	private Map<String, String> sqlHashMap;

	private static final Connector instance = new Connector();

	private Connector() {
		sqlHashMap = new HashMap<>();
		loadConnectorProperties();
		createSQLProperties();
		loadSQLProperties();

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

	private void loadConnectorProperties() {
		Properties p = new Properties();
		try (InputStream is = new FileInputStream(MYSQL_CONFIG_FILE)) {
			p.load(is);
			this.driverClass = p.getProperty("DRIVER_CLASS");
			this.driver = p.getProperty("DRIVER");
			this.host = p.getProperty("HOST");
			this.port = Integer.parseInt(p.getProperty("PORT"));
			this.database = p.getProperty("DATABASE");
			this.username = p.getProperty("USERNAME");
			this.password = p.getProperty("PASSWORD");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createSQLProperties() {
		Properties p = new Properties();
		// Operator SQL
		p.setProperty("getOprSql", "SELECT * FROM operatoer WHERE opr_id = ?");
		p.setProperty("getOprListSql", "SELECT * FROM operatoer");
		p.setProperty("createOprSql", "INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password) VALUES (?, ?, ?, ?, ?)");
		p.setProperty("updateOprSql", "UPDATE operatoer SET opr_navn = ?, ini = ?, cpr = ?, password = ? WHERE opr_id = ?");
		p.setProperty("deleteOprSql", "DELETE FROM operatoer WHERE opr_id = ?");

		// ProductBatchComponent SQL
		p.setProperty("getPBCSql", "SELECT * FROM produktbatchkomponent WHERE pb_id = ? AND rb_id = ?");
		p.setProperty("getPBCListIdSql", "SELECT * FROM produktbatchkomponent WHERE pb_id = ?");
		p.setProperty("getPBCListSql", "SELECT * FROM produktbatchkomponent");
		p.setProperty("createPBCSql", "INSERT INTO produktbatchkomponent(pb_id, rb_id, tara, netto, opr_id) VALUES (?, ?, ?, ?, ?)");
		p.setProperty("updatePBCSql", "UPDATE produktbatchkomponent SET tara = ?, netto = ? WHERE pb_id = ? AND rb_id = ? AND opr_id = ?");
		p.setProperty("deletePBCSql", "DELETE FROM produktbatchkomponent WHERE pb_id = ? AND rb_id = ?");

		// ProductBatch SQL
		p.setProperty("getPBSql", "SELECT * FROM produktbatch WHERE pb_id = ?");
		p.setProperty("getPBListSql", "SELECT * FROM produktbatch");
		p.setProperty("createPBSql", "INSERT INTO produktbatch(pb_id, status, recept_id) VALUES (?, ?, ?)");
		p.setProperty("updatePBSql", "UPDATE produktbatch SET status = ? WHERE pb_id = ? AND recept_id = ?");
		p.setProperty("deletePBSql", "DELETE FROM produktbatch WHERE pb_id = ?");

		// RaavareBatch SQL
		p.setProperty("getRBSql", "SELECT * FROM raavarebatch WHERE rb_id = ?");
		p.setProperty("getRBListSql", "SELECT * FROM raavarebatch");
		p.setProperty("getRBListIdSql", "SELECT * FROM raavarebatch WHERE rb_id = ?");
		p.setProperty("createRBSql", "INSERT INTO raavarebatch(rb_id, raavare_id, maengde) VALUES (?, ?, ?)");
		p.setProperty("updateRBSql", "UPDATE raavarebatch SET maengde = ? WHERE rb_id = ? AND raavare_id = ?");
		p.setProperty("deleteRBSql", "DELETE FROM raavarebatch WHERE rb_id = ?");

		// Raavare SQL

		// ReceptComponent SQL

		// Recept SQL

		// Role SQL
		p.setProperty("getOprRolesSql", "SELECT * FROM rolle WHERE opr_id = ?");
		p.setProperty("getRoleListSql", "SELECT * FROM rolle");
		p.setProperty("createRoleSql", "INSERT INTO rolle(opr_id, rolle_navn) VALUES (?, ?)");
		p.setProperty("deleteRoleSql", "DELETE FROM rolle WHERE opr_id = ? AND rolle_navn = ?");

		FileOutputStream fs = null;
		try {
			File file = new File(SQL_CONFIG_FILE);
			fs = new FileOutputStream(file);
			p.store(fs, SQL_CONFIG_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadSQLProperties() {
		Properties p = new Properties();
		try (InputStream is = new FileInputStream(SQL_CONFIG_FILE)) {
			p.load(is);
			for (String key : p.stringPropertyNames()) {
				String value = p.getProperty(key);
				sqlHashMap.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cleanup(PreparedStatement stmt, ResultSet rs) throws SQLException {
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
	}

	public void cleanup(PreparedStatement stmt) throws SQLException {
		if (stmt != null) stmt.close();
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public String getSQL(String key) {
		return sqlHashMap.get(key);
	}

	public Connection getConnection() {
		return connection;
	}

	public static synchronized Connector getInstance() {
		return instance;
	}

}