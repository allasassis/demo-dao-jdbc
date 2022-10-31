package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) { // se a conexão com o banco de dados for nula, usaremos o método debaixo para
							// pegar os dados do banco
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl"); // aqui pegamos o dado "dburl", porque é assim que está
															// definido no arquivo
				conn = DriverManager.getConnection(url, props); // aqui conectamos com o banco de dados manualmente, com
																// a url e as outras informações
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
		return conn;
	}

	public static void closeConnection() {
		try {
		if (conn != null) {
			conn.close();
		}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	private static Properties loadProperties() { // esse método pega as propriedades do banco de dados, do arquivo
													// db.properties
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
