package net.pixomania.dbtest.client.http;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

public class HttpClient {

	public static long totaltime = 0;
	public static long requestsmade = 0;
	public static long high = 0;
	public static long low = 50000;

	public static long[] sendPOST(String url, String params) throws IOException {
		java.net.URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes("data=" + params);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		long timeTaken = System.currentTimeMillis();
		in.close();

		Gson gson = new Gson();

		long[] longArr = gson.fromJson(response.toString(), long[].class);
		long[] newArr = Arrays.copyOf(longArr, longArr.length+1);
		newArr[newArr.length-1] = timeTaken;

		return newArr;
	}

	public static long[] sendGET(String url) throws IOException {
		java.net.URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		long timeTaken = System.currentTimeMillis();
		in.close();

		Gson gson = new Gson();

		long[] longArr = gson.fromJson(response.toString(), long[].class);
		long[] newArr = Arrays.copyOf(longArr, longArr.length + 1);
		newArr[newArr.length - 1] = timeTaken;

		return newArr;

	}
}
