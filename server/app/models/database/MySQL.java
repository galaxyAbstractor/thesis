package models.database;

import models.datatypes.Flight;
import play.db.DB;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MySQL implements Database {
	Connection conn = null;

	public MySQL() {
		conn = DB.getConnection();
	}

	@Override
	public long insertFlight(Flight flight) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO ontime (Year, Month, DayofMonth, DayOfWeek," +
					"DepTime, CRSDepTime, ArrTime, CRSArrTime, UniqueCarrier, FlightNum, TailNum, ActualElapsedTime, " +
					"CRSElapsedTime, AirTime, ArrDelay, DepDelay, Origin, Dest, Distance, TaxiIn, TaxiOut, Cancelled, " +
					"CancellationCode, Diverted, CarrierDelay, WeatherDelay, NASDelay, SecurityDelay," +
					"LateAircraftDelay) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
					"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setInt(1, flight.getYear());
			pst.setInt(2, flight.getMonth());
			pst.setInt(3, flight.getDayOfMonth());
			pst.setInt(4, flight.getDayOfWeek());
			pst.setInt(5, flight.getDepTime());
			pst.setInt(6, flight.getCRSDepTime());
			pst.setInt(7, flight.getArrTime());
			pst.setInt(8, flight.getCRSArrTime());
			pst.setString(9, flight.getUniqueCarrier());
			pst.setInt(10, flight.getFlightNum());
			pst.setString(11, flight.getTailNum());
			pst.setInt(12, flight.getActualElapsedTime());
			pst.setInt(13, flight.getCRSElapsedTime());
			pst.setInt(14, flight.getAirTime());
			pst.setInt(15, flight.getArrDelay());
			pst.setInt(16, flight.getDepDelay());
			pst.setString(17, flight.getOrigin());
			pst.setString(18, flight.getDest());
			pst.setInt(19, flight.getDistance());
			pst.setInt(20, flight.getTaxiIn());
			pst.setInt(21, flight.getTaxiOut());
			pst.setInt(22, flight.getCancelled());
			pst.setString(23, flight.getCancellationCode());
			pst.setString(24, flight.getDiverted());
			pst.setInt(25, flight.getCarrierDelay());
			pst.setInt(26, flight.getWeatherDelay());
			pst.setInt(27, flight.getNASDelay());
			pst.setInt(28, flight.getSecurityDelay());
			pst.setInt(29, flight.getLateAircraftDelay());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			System.err.println("Could not create statement");
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return System.currentTimeMillis();
	}

	@Override
	public long selectFlightByDepTime(int depTime) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM ontime WHERE DepTime = ?");
			pst.setInt(1, depTime);
			pst.executeQuery();
			pst.close();
		} catch (SQLException e) {
			System.err.println("Could not create statement");
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return System.currentTimeMillis();
	}

}
