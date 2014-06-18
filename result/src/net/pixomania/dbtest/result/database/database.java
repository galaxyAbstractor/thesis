package net.pixomania.dbtest.result.database;

import java.io.*;
import java.sql.*;

public class Database {
	private Connection conn;
	private int selectmax;

	public Database(int selectmax){
		this.selectmax = selectmax;
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
			int i = 0;
			while(rs.next()){
				if(rs.getInt(2) == 0) {
					start = rs.getLong(1);
				} else if (rs.getInt(2) == 4) {
					total += rs.getLong(1) - start;
					i++;
					if (i == this.selectmax) break;
				}
			}
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void scatter(int testId) {
		File f = new File("output.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			PreparedStatement pst = conn.prepareStatement("SELECT timevalue, array_index FROM responses, responses_parts WHERE responses.test_id = ? AND responses_parts.response_id = responses.response_id");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			long total = 0;
			long start = 0;
			int i = 0;
			while (rs.next()) {
				if (rs.getInt(2) == 2) {
					start = rs.getLong(1);
				} else if (rs.getInt(2) == 3) {
					bw.write(i + "\t" + (rs.getLong(1) - start) + "\n");
					i++;
					if (i == this.selectmax) break;
				}
			}

			bw.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long calculateDatabaseTotal(int testId) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT timevalue, array_index FROM responses, responses_parts WHERE responses.test_id = ? AND responses_parts.response_id = responses.response_id");
			pst.setInt(1, testId);
			ResultSet rs = pst.executeQuery();
			long total = 0;
			long start = 0;
			int i = 0;
			while (rs.next()) {
				if (rs.getInt(2) == 2) {
					start = rs.getLong(1);
				} else if (rs.getInt(2) == 3) {
					total += rs.getLong(1) - start;
					i++;
					if (i == this.selectmax) break;
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
