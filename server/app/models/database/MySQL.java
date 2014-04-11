package models.database;

import models.datatypes.Airport;
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
	public long insertAirport(Airport airport) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO airports (iata, airport, city, state," +
					"country, lat, longitude) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, airport.getIata());
			pst.setString(2, airport.getAirport());
			pst.setString(3, airport.getCity());
			pst.setString(4, airport.getState());
			pst.setString(5, airport.getCountry());
			pst.setDouble(6, airport.getLat());
			pst.setDouble(7, airport.getLongitude());

			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			System.err.println("Could not create statement");
			e.printStackTrace();
			return -1;

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
	public long insertFlight(Flight flight) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO ontime (Year, Month, DayOfMonth, DayOfWeek," +
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

			PreparedStatement originPst = conn.prepareStatement("SELECT id FROM airports WHERE iata = ?");
			originPst.setString(1, flight.getOrigin().getIata());
			ResultSet originResult = originPst.executeQuery();
			originResult.next();
			pst.setInt(17, originResult.getInt("id"));
			originResult.close();
			originPst.close();

			PreparedStatement destPst = conn.prepareStatement("SELECT id FROM airports WHERE iata = ?");
			destPst.setString(1, flight.getDest().getIata());
			ResultSet destResult = destPst.executeQuery();
			destResult.next();
			pst.setInt(18, destResult.getInt("id"));
			destResult.close();
			destPst.close();

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
			return -1;
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

	@Override
	public long joinSelectFlightByDest(String dest) {
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM airports INNER JOIN ontime ON " +
					"(airports.id = ontime.Dest) WHERE airports.iata = ?");
			pst.setString(1, dest);
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
