package models.datatypes;

public class Flight {
	private int year;
	private int month;
	private int dayOfMonth;
	private int dayOfWeek;
	private int depTime;
	private int CRSDepTime;
	private int arrTime;
	private int CRSArrTime;
	private String uniqueCarrier;
	private int flightNum;
	private String tailNum;
	private int actualElapsedTime;
	private int CRSElapsedTime;
	private int airTime;
	private int arrDelay;
	private int depDelay;
	private String origin;
	private String dest;
	private int distance;
	private int taxiIn;
	private int taxiOut;
	private int cancelled;
	private String cancellationCode;
	private String diverted;
	private int carrierDelay;
	private int weatherDelay;
	private int NASDelay;
	private int securityDelay;
	private int lateAircraftDelay;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getDepTime() {
		return depTime;
	}

	public void setDepTime(int depTime) {
		this.depTime = depTime;
	}

	public int getCRSDepTime() {
		return CRSDepTime;
	}

	public void setCRSDepTime(int CRSDepTime) {
		this.CRSDepTime = CRSDepTime;
	}

	public int getArrTime() {
		return arrTime;
	}

	public void setArrTime(int arrTime) {
		this.arrTime = arrTime;
	}

	public int getCRSArrTime() {
		return CRSArrTime;
	}

	public void setCRSArrTime(int CRSArrTime) {
		this.CRSArrTime = CRSArrTime;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}

	public void setUniqueCarrier(String uniqueCarrier) {
		this.uniqueCarrier = uniqueCarrier;
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getTailNum() {
		return tailNum;
	}

	public void setTailNum(String tailNum) {
		this.tailNum = tailNum;
	}

	public int getActualElapsedTime() {
		return actualElapsedTime;
	}

	public void setActualElapsedTime(int actualElapsedTime) {
		this.actualElapsedTime = actualElapsedTime;
	}

	public int getCRSElapsedTime() {
		return CRSElapsedTime;
	}

	public void setCRSElapsedTime(int CRSElapsedTime) {
		this.CRSElapsedTime = CRSElapsedTime;
	}

	public int getAirTime() {
		return airTime;
	}

	public void setAirTime(int airTime) {
		this.airTime = airTime;
	}

	public int getArrDelay() {
		return arrDelay;
	}

	public void setArrDelay(int arrDelay) {
		this.arrDelay = arrDelay;
	}

	public int getDepDelay() {
		return depDelay;
	}

	public void setDepDelay(int depDelay) {
		this.depDelay = depDelay;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTaxiIn() {
		return taxiIn;
	}

	public void setTaxiIn(int taxiIn) {
		this.taxiIn = taxiIn;
	}

	public int getTaxiOut() {
		return taxiOut;
	}

	public void setTaxiOut(int taxiOut) {
		this.taxiOut = taxiOut;
	}

	public int getCancelled() {
		return cancelled;
	}

	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}

	public String getCancellationCode() {
		return cancellationCode;
	}

	public void setCancellationCode(String cancellationCode) {
		this.cancellationCode = cancellationCode;
	}

	public String getDiverted() {
		return diverted;
	}

	public void setDiverted(String diverted) {
		this.diverted = diverted;
	}

	public int getCarrierDelay() {
		return carrierDelay;
	}

	public void setCarrierDelay(int carrierDelay) {
		this.carrierDelay = carrierDelay;
	}

	public int getWeatherDelay() {
		return weatherDelay;
	}

	public void setWeatherDelay(int weatherDelay) {
		this.weatherDelay = weatherDelay;
	}

	public int getNASDelay() {
		return NASDelay;
	}

	public void setNASDelay(int NASDelay) {
		this.NASDelay = NASDelay;
	}

	public int getSecurityDelay() {
		return securityDelay;
	}

	public void setSecurityDelay(int securityDelay) {
		this.securityDelay = securityDelay;
	}

	public int getLateAircraftDelay() {
		return lateAircraftDelay;
	}

	public void setLateAircraftDelay(int lateAircraftDelay) {
		this.lateAircraftDelay = lateAircraftDelay;
	}
}
