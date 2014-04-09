package net.pixomania.dbtest.client.datatypes;

import java.util.LinkedList;

public class Airport {
	private int id;
	private String iata;
	private String airport;
	private String city;
	private String state;
	private String country;
	private Double lat;
	private Double longitude;
	private LinkedList<Flight> flyingIn = new LinkedList<>();
	private LinkedList<Flight> flyingOut = new LinkedList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public LinkedList<Flight> getFlyingIn() {
		return flyingIn;
	}

	public void setFlyingIn(LinkedList<Flight> flyingIn) {
		this.flyingIn = flyingIn;
	}

	public LinkedList<Flight> getFlyingOut() {
		return flyingOut;
	}

	public void setFlyingOut(LinkedList<Flight> flyingOut) {
		this.flyingOut = flyingOut;
	}
}

