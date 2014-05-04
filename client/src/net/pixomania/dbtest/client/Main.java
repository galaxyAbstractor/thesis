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
	public static String url = "http://192.168.1.3:9000";

	public static void main(String[] args) {

		try {
			//LinkedList<Airport> airports =	Util.loadAirports(new File("C:\\Users\\Victor\\dbtest\\client\\data\\airports.csv"), 3376);
			ConnectionPool.open(5);
			for(int dataamount = 0; dataamount < 3; dataamount++) {
				for (int repetitions = 0; repetitions < 3; repetitions++) {
					for (int database = 1; database < 4; database++) {
						testing_database = database;
	/*
						InsertAirportTest insertAirportTest = new InsertAirportTest();
						insertAirportTest.run(airports);
						System.out.println("[" + new Date() + "] Insert airports test done, run: " + (repetitions + 1) + ", database: " + testing_database);
	*/
						InsertFlightTest insertFlightTest = new InsertFlightTest();
						int toload = 0;

						switch (dataamount) {
							case 0:
								toload = 1000;
								break;
							case 1:
								toload = 10000;
								break;
							case 2:
								toload = 20000;
								break;
							case 3:
								toload = 80000;
								break;
						}
						LinkedList<Flight> flights = Util.loadFlights(new File("1987.csv"), toload);
						insertFlightTest.run(flights);
						System.out.println("[" + new Date() + "] Insert flights test done, run: " + (repetitions + 1) + ", database: " + testing_database);

						SelectFlightTest selectFlightTest = new SelectFlightTest();
						selectFlightTest.run(flights);
						System.out.println("[" + new Date() + "] Select flights test done, run: " + (repetitions + 1) + ", database: " + testing_database);
	/*
						ListFlightTest listFlightTest = new ListFlightTest();
						listFlightTest.run(airports);
						System.out.println("[" + new Date() + "] List fligths test done, run: " + (repetitions + 1) + ", database: " + testing_database);
	*/
						HttpClient.sendGET(url + "/purge");
					}
				}
			}

			ConnectionPool.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
