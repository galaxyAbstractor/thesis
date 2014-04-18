package models.datatypes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Airport {
	private int id;
	private String iata;
	private String airport;
	private String city;
	private String state;
	private String country;
	private Double lat;
	private Double longitude;
	private List<Flight> flyingIn = new LinkedList<>();
	private List<Flight> flyingOut = new LinkedList<>();

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

	public List<Flight> getFlyingIn() {
		return flyingIn;
	}

	public void setFlyingIn(List<Flight> flyingIn) {
		this.flyingIn = flyingIn;
	}

	public List<Flight> getFlyingOut() {
		return flyingOut;
	}

	public void setFlyingOut(List<Flight> flyingOut) {
		this.flyingOut = flyingOut;
	}
}
