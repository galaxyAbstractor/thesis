package net.pixomania.dbtest.client;

import com.google.gson.Gson;
import net.pixomania.dbtest.client.datatypes.Flight;
import net.pixomania.dbtest.client.http.HttpClient;
import net.pixomania.dbtest.client.models.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {

			ArrayList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));
			Gson gson = new Gson();
			Long time = System.currentTimeMillis();
			for(Flight flight : flights) {
				String json = gson.toJson(flight);
				String url = "http://localhost:9000/insert/flight/one/" + System.currentTimeMillis();
				HttpClient.sendPOST(url, json);
				System.out.println((System.currentTimeMillis() - time) / 1000 + " SECONDS");
			}
			System.out.println((System.currentTimeMillis() - time)/1000 + " SECONDS");

/*
			ArrayList<Flight> flights = Util.loadFlights(new File("C:\\Users\\Victor\\dbtest\\client\\data\\1987.csv"));
			Gson gson = new Gson();
			Long time = System.currentTimeMillis();
			for (Flight flight : flights) {

				String url = "http://localhost:9000/select/flight/deptime/" + flight.getDepTime() + "/" + System.currentTimeMillis();
				HttpClient.sendGET(url);
				System.out.println((System.currentTimeMillis() - time) / 1000 + " SECONDS");
			}
			System.out.println((System.currentTimeMillis() - time) / 1000 + " SECONDS");
*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
