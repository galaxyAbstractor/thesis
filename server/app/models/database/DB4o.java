package models.database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.reflect.generic.GenericClass;
import com.db4o.reflect.generic.GenericObject;
import com.db4o.reflect.generic.GenericReflector;
import models.datatypes.Flight;
import play.Logger;

public class DB4o implements Database {
	private static ObjectContainer db;

	public static void openDB() {
		db = Db4oEmbedded.openFile(Db4oEmbedded
				.newConfiguration(), "db4o.db");
		Logger.info("DB4o opened");
	}

	public static void closeDB() {
		db.close();
		Logger.info("DB4o closed");
	}

	@Override
	public long insertFlight(Flight flight) {
		try {
			db.store(flight);
			db.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return System.currentTimeMillis();
	}

	@Override
	public long selectFlightByDepTime(int depTime) {

		try {
			Flight flightExample = new Flight();
			flightExample.setDepTime(depTime);
			ObjectSet result = db.queryByExample(flightExample);
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return System.currentTimeMillis();
	}
}
