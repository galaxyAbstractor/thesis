package net.pixomania.dbtest.client.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {
	private static LinkedList<Connection> pool = new LinkedList<>();

	public synchronized static void open(int connections){
		for(int i = 0; i < connections; i++) {
			try {
				pool.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", ""));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Opened " + connections + " connections");
	}

	public synchronized static Connection getConnection() {
		if(pool.size() == 0) open(1);

		return pool.poll();
	}

	public synchronized static void returnConnection(Connection con) {
		pool.add(con);
	}

	public synchronized static void close() {
		for(Connection con : pool) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
