package net.pixomania.dbtest.client.models;

import net.pixomania.dbtest.client.Main;

import java.sql.*;

public class Test {
	protected int testid;

	public Test(int type) {
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO tests (date, type, database_type) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setInt(2, type);
			pst.setInt(3, Main.testing_database);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) testid = rs.getInt(1);
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionPool.returnConnection(conn);
	}

}
