package net.pixomania.dbtest.client;

import net.pixomania.dbtest.client.datatypes.Airport;
import net.pixomania.dbtest.client.datatypes.Flight;
import net.pixomania.dbtest.client.http.HttpClient;
import net.pixomania.dbtest.client.models.*;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;


public class Main {
	public static int testing_database = 1; // 1 = mysql, 2 = db4o, 3 = hibernate
	public static String url = "http://localhost:9000";

	public static void main(String[] args) {

		try {
			LinkedList<Airport> airports =	Util.loadAirports(new File("C:\\Users\\Victor\\dbtest\\client\\data\\airports.csv"), 3376);
			ConnectionPool.open(5);
			for (int x = 0; x < 5; x++) {
				for (int i = 1; i < 4; i++) {
					testing_database = i;

					InsertAirportTest insertAirportTest = new InsertAirportTest();
					insertAirportTest.run(airports);
					System.out.println("[" + new Date() + "] Insert airports test done, run: " + (x + 1) + ", database: " + testing_database);

					InsertFlightTest insertFlightTest = new InsertFlightTest();
					LinkedList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"), 3000);
					insertFlightTest.run(flights);
					System.out.println("[" + new Date() + "] Insert flights test done, run: " + (x + 1) + ", database: " + testing_database);

					SelectFlightTest selectFlightTest = new SelectFlightTest();
					selectFlightTest.run(flights);
					System.out.println("[" + new Date() + "] Select flights test done, run: " + (x + 1) + ", database: " + testing_database);

					ListFlightTest listFlightTest = new ListFlightTest();
					listFlightTest.run(airports);
					System.out.println("[" + new Date() + "] List fligths test done, run: " + (x + 1) + ", database: " + testing_database);

					HttpClient.sendGET(url + "/purge");
				}
			}

			ConnectionPool.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
