package net.pixomania.dbtest.result;

import net.pixomania.dbtest.result.database.Database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database(20000);
		int i = 232;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 6) + "\t" + db.calculateRequestTotal(i + 12));
		i += 2;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 6) + "\t" + db.calculateRequestTotal(i + 12));
		i += 2;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 6) + "\t" + db.calculateRequestTotal(i + 12));
	}
}
