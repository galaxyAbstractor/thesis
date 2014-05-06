package net.pixomania.dbtest.client.models;

import com.google.gson.Gson;
import net.pixomania.dbtest.client.Main;
import net.pixomania.dbtest.client.datatypes.Flight;
import net.pixomania.dbtest.client.http.HttpClient;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InsertFlightTest extends Test {

	public InsertFlightTest() {
		super(2);
	}

	public void run(LinkedList<Flight> flights) {
		ExecutorService pool = Executors.newFixedThreadPool(50);
		Gson gson = new Gson();
		for (Flight flight : flights) {
			String json = gson.toJson(flight);
			String url = Main.url + "/insert/flight/one/" + System.currentTimeMillis() + "/" + Main.testing_database;
			try {
				final long[] response = HttpClient.sendPOST(url, json);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						Connection conn = ConnectionPool.getConnection();
						PreparedStatement pst = null;
						try {
							pst = conn.prepareStatement("INSERT INTO responses (test_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
							pst.setInt(1, testid);
							pst.executeUpdate();
							ResultSet rs = pst.getGeneratedKeys();
							int responseid = -1;
							if (rs.next()) responseid = rs.getInt(1);
							pst.close();

							for (int i = 0; i < response.length; i++) {
								pst = conn.prepareStatement("INSERT INTO responses_parts (response_id, array_index, timevalue) VALUES (?, ?, ?)");
								pst.setInt(1, responseid);
								pst.setInt(2, i);
								pst.setLong(3, response[i]);
								pst.executeUpdate();
								pst.close();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							ConnectionPool.returnConnection(conn);
						}

					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
