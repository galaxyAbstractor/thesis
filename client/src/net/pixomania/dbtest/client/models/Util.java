package net.pixomania.dbtest.client.models;

import net.pixomania.dbtest.client.datatypes.Flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	public static ArrayList<Flight> loadFlights(File csv) throws FileNotFoundException {
		ArrayList<Flight> flights = new ArrayList<>();
		Scanner scanner = new Scanner(csv);
		scanner.useDelimiter(",");
		scanner.nextLine();
		while(scanner.hasNextLine()) {
			Flight flight = new Flight();

			Scanner scanner1 = new Scanner(scanner.nextLine());
			scanner1.useDelimiter(",");
			flight.setYear(checkInt(scanner1.next()));
			flight.setMonth(checkInt(scanner1.next()));
			flight.setDayOfMonth(checkInt(scanner1.next()));
			flight.setDayOfWeek(checkInt(scanner1.next()));
			flight.setDepTime(checkInt(scanner1.next()));
			flight.setCRSDepTime(checkInt(scanner1.next()));
			flight.setArrTime(checkInt(scanner1.next()));
			flight.setCRSArrTime(checkInt(scanner1.next()));
			flight.setUniqueCarrier(checkString(scanner1.next()));
			flight.setFlightNum(checkInt(scanner1.next()));
			flight.setTailNum(checkString(scanner1.next()));
			flight.setActualElapsedTime(checkInt(scanner1.next()));
			flight.setCRSElapsedTime(checkInt(scanner1.next()));
			flight.setAirTime(checkInt(scanner1.next()));
			flight.setArrDelay(checkInt(scanner1.next()));
			flight.setDepDelay(checkInt(scanner1.next()));
			flight.setOrigin(checkString(scanner1.next()));
			flight.setDest(checkString(scanner1.next()));
			flight.setDistance(checkInt(scanner1.next()));
			flight.setTaxiIn(checkInt(scanner1.next()));
			flight.setTaxiOut(checkInt(scanner1.next()));
			flight.setCancelled(checkInt(scanner1.next()));
			flight.setCancellationCode(checkString(scanner1.next()));
			flight.setDiverted(checkString(scanner1.next()));
			flight.setCarrierDelay(checkInt(scanner1.next()));
			flight.setWeatherDelay(checkInt(scanner1.next()));
			flight.setNASDelay(checkInt(scanner1.next()));
			flight.setSecurityDelay(checkInt(scanner1.next()));
			flight.setLateAircraftDelay(checkInt(scanner1.next()));

			flights.add(flight);
			if(flights.size() == 80000) break;
		}

		return flights;
	}

	private static int checkInt(String input){
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException ex){
			return -1;
		}
	}

	private static String checkString(String input) {
		if(input.equals("NA")) return "";
		return input;
	}
}
