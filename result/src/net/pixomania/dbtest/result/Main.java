package net.pixomania.dbtest.result;

import net.pixomania.dbtest.result.database.Database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		System.out.println(db.calculateRequestTotalAverage(65, 71, 77));
	}
}
