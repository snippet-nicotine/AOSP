package planning.dao.ressource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesBdd {

	private Connection conn;

	public AccesBdd() {


		try {
			Class.forName(RequeteSql.strNomDriver);
			conn = DriverManager.getConnection(RequeteSql.dbURL);
		} catch (ClassNotFoundException e) {
			System.out.println("=== AccesBdD : Probleme de config du driver ojdbc");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme ouverture connection");
		}
	}

	public int executeUpdate(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}

	public int executeUpdate(PreparedStatement pstmt) throws SQLException {
		int retour = pstmt.executeUpdate();
		return retour;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery(sql);
		return rs;
	}

	public ResultSet executeQuery(PreparedStatement pstmt) throws SQLException {
		ResultSet rs =  pstmt.executeQuery();
		return rs;
	}

	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement updateTest = null;
		try {
			updateTest = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme getPreparedStatement");
			e.printStackTrace();
		}
		return updateTest;
	}

	public void close() {
		try {
			if (!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
	}

}


