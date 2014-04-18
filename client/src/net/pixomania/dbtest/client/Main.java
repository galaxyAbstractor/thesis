package net.pixomania.dbtest.client;

import com.google.gson.Gson;
import net.pixomania.dbtest.client.datatypes.Airport;
import net.pixomania.dbtest.client.datatypes.Flight;
import net.pixomania.dbtest.client.http.HttpClient;
import net.pixomania.dbtest.client.models.Util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
/*
			LinkedList<Airport> airports = Util.loadAirports(new File("C:\\Users\\Victor\\dbtest\\client\\data\\airports.csv"));
			Gson gson = new Gson();
			DecimalFormat df = new DecimalFormat("#.000");
			for (Airport airport : airports) {
				String json = gson.toJson(airport);
				String url = "http://localhost:9000/insert/airport/one/" + System.currentTimeMillis();
				HttpClient.sendPOST(url, json);
				System.out.println(HttpClient.totaltime + "ms | " + df.format((double)HttpClient.totaltime/(double)1000) +"s " +
						"| average (ms): " + df.format((double) HttpClient.totaltime / (double) HttpClient.requestsmade)  + " | requests made: " + HttpClient.requestsmade +
						" | low: " + HttpClient.low + "ms | high: " + HttpClient.high + "ms");
			}

*/
/*
			LinkedList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));
			Gson gson = new Gson();
			DecimalFormat df = new DecimalFormat("#.000");
			for(Flight flight : flights) {
				String json = gson.toJson(flight);
				String url = "http://localhost:9000/insert/flight/one/" + System.currentTimeMillis();
				HttpClient.sendPOST(url, json);
				System.out.println(HttpClient.totaltime + "ms | " + df.format((double) HttpClient.totaltime / (double) 1000) + "s " +
						"| average (ms): " + df.format((double) HttpClient.totaltime / (double) HttpClient.requestsmade) + " | requests made: " + HttpClient.requestsmade +
						" | low: " + HttpClient.low + "ms | high: " + HttpClient.high + "ms");
			}
*/
/*
			LinkedList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));
			Gson gson = new Gson();
			DecimalFormat df = new DecimalFormat("#.000");
			for (Flight flight : flights) {

				String url = "http://localhost:9000/select/flight/deptime/" + flight.getDepTime() + "/" + System.currentTimeMillis();
				HttpClient.sendGET(url);
				System.out.println(HttpClient.totaltime + "ms | " + df.format((double) HttpClient.totaltime / (double) 1000) + "s " +
						"| average (ms): " + df.format((double) HttpClient.totaltime / (double) HttpClient.requestsmade) + " | requests made: " + HttpClient.requestsmade +
						" | low: " + HttpClient.low + "ms | high: " + HttpClient.high + "ms");
			}
*/

			LinkedList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));
			Gson gson = new Gson();
			DecimalFormat df = new DecimalFormat("#.000");
			for (Flight flight : flights) {

				String url = "http://localhost:9000/select/join/flight/dest/" + flight.getDest().getIata() + "/" + System.currentTimeMillis();
				HttpClient.sendGET(url);
				System.out.println(HttpClient.totaltime + "ms | " + df.format((double) HttpClient.totaltime / (double) 1000) + "s " +
						"| average (ms): " + df.format((double) HttpClient.totaltime / (double) HttpClient.requestsmade) + " | requests made: " + HttpClient.requestsmade +
						" | low: " + HttpClient.low + "ms | high: " + HttpClient.high + "ms");
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
