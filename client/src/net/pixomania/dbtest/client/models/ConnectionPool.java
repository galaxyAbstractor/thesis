package net.pixomania.dbtest.client.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> pool = new LinkedList<Connection>();

	public static void open(int connections){
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
		return pool.remove(0);
	}

	public synchronized static void returnConnection(Connection con) {
		pool.add(con);
		//System.out.println("Returned connection!! " + pool.size()+" HASH"+ Integer.toHexString(con.hashCode()));
	}

	public  static void close() {
		for(Connection con : pool) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
