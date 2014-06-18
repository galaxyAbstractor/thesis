package net.pixomania.dbtest.result;

import net.pixomania.dbtest.result.database.Database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database(100000);
		int x = 301;
		int i = x;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 12) + "\t" + db.calculateRequestTotal(i + 24));
		i += 4;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 12) + "\t" + db.calculateRequestTotal(i + 24));
		i += 4;
		System.out.println(db.calculateRequestTotal(i) + "\t" + db.calculateRequestTotal(i + 12) + "\t" + db.calculateRequestTotal(i + 24));
		System.out.println();
		i = x;
		System.out.println(db.calculateDatabaseTotal(i) + "\t" + db.calculateDatabaseTotal(i + 12) + "\t" + db.calculateDatabaseTotal(i + 24));
		i += 4;
		System.out.println(db.calculateDatabaseTotal(i) + "\t" + db.calculateDatabaseTotal(i + 12) + "\t" + db.calculateDatabaseTotal(i + 24));
		i += 4;
		System.out.println(db.calculateDatabaseTotal(i) + "\t" + db.calculateDatabaseTotal(i + 12) + "\t" + db.calculateDatabaseTotal(i + 24));

		//db.scatter(412);

	}
}
