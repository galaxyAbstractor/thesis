package models.database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.reflect.generic.GenericClass;
import com.db4o.reflect.generic.GenericObject;
import com.db4o.reflect.generic.GenericReflector;
import models.datatypes.Airport;
import models.datatypes.Flight;
import play.Logger;

import java.util.LinkedList;

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
	public long insertAirport(Airport airport) {
		try {
			db.store(airport);
			db.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return System.currentTimeMillis();
	}

	@Override
	public long insertFlight(Flight flight) {
		try {
			ObjectSet result = db.queryByExample(flight.getDest());
			Airport destAirport = (Airport) result.next();
			destAirport.getFlyingIn().add(flight);
			flight.setDest(destAirport);

			result = db.queryByExample(flight.getOrigin());
			Airport originAirport = (Airport) result.next();
			originAirport.getFlyingOut().add(flight);

			flight.setOrigin(originAirport);

			db.store(flight);
			db.store(destAirport);
			db.store(originAirport);
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

	@Override
	public long joinSelectFlightByDest(String dest) {
		Airport destAirport = new Airport();
		destAirport.setIata(dest);
		ObjectSet result = db.queryByExample(destAirport);
		destAirport = (Airport) result.next();
		return System.currentTimeMillis();
	}
}
