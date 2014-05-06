package net.pixomania.dbtest.result.database;

import java.sql.*;

public class Database {
	private Connection conn;

	public Database(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://alternia:3306/result", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long calculateRequestTotal(int testId) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT timevalue, array_index FROM responses, responses_parts WHERE responses.test_id = ? AND responses_parts.response_id = responses.response_id");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			long total = 0;
			long start = 0;
			while(rs.next()){
				if(rs.getInt(2) == 0) {
					start = rs.getLong(1);
				} else if (rs.getInt(2) == 4) {
					total += rs.getLong(1) - start;
				}
			}
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public long calculateDatabaseTotal(int testId) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT timevalue, array_index FROM responses, responses_parts WHERE responses.test_id = ? AND responses_parts.response_id = responses.response_id");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			long total = 0;
			long start = 0;
			while (rs.next()) {
				if (rs.getInt(2) == 2) {
					start = rs.getLong(1);
				} else if (rs.getInt(2) == 3) {
					total += rs.getLong(1) - start;
				}
			}
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double calculateAverageRequest(int testId) {
		long total = calculateRequestTotal(testId);
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT count(*) FROM responses WHERE responses.test_id = ?");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			rs.next();
			return ((double)total/rs.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double calculateAverageDatabase(int testId) {
		long total = calculateDatabaseTotal(testId);
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT count(*) FROM responses WHERE responses.test_id = ?");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			rs.next();
			return ((double) total / rs.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double calculateRequestTotalAverage(int testId1, int testId2, int testId3) {
		long total1 = calculateRequestTotal(testId1);
		long total2 = calculateRequestTotal(testId2);
		long total3 = calculateRequestTotal(testId3);

		long total = total1 + total2 + total3;
		return ((double)total/3.0);
	}

	public double calculateDatabaseTotalAverage(int testId1, int testId2, int testId3) {
		long total1 = calculateDatabaseTotal(testId1);
		long total2 = calculateDatabaseTotal(testId2);
		long total3 = calculateDatabaseTotal(testId3);

		long total = total1 + total2 + total3;
		return ((double) total / 3.0);
	}

	public double calculateAverageRequestAverage(int testId1, int testId2, int testId3) {
		double total1 = calculateAverageRequest(testId1);
		double total2 = calculateAverageRequest(testId2);
		double total3 = calculateAverageRequest(testId3);

		double total = total1 + total2 + total3;
		return (total / 3.0);
	}

	public double calculateAverageDatabaseAverage(int testId1, int testId2, int testId3) {
		double total1 = calculateAverageDatabase(testId1);
		double total2 = calculateAverageDatabase(testId2);
		double total3 = calculateAverageDatabase(testId3);

		double total = total1 + total2 + total3;
		return (total / 3.0);
	}
}
