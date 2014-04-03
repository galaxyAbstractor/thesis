package models.database;

import models.datatypes.Flight;

public interface Database {

    public long insertFlight(Flight flight);
    public long select();
}
