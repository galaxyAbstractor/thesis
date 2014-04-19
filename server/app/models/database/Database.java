package models.database;

import models.datatypes.Airport;
import models.datatypes.Flight;

public interface Database {

	public long insertAirport(Airport airport);
	public long insertFlight(Flight flight);
	public long selectFlightByDepTime(int depTime);
	public long joinSelectFlightByDest(String dest);
}
