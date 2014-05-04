package controllers;

import models.database.DB4o;
import models.database.Database;
import models.database.Hibernate;
import models.database.MySQL;
import play.mvc.Controller;
import play.mvc.Result;

public class Select extends Controller {

	public static Result flightByDepTime(int depTime, Long time, int database) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[4];
		times[0] = time;
		times[1] = reqArrTime;

		Database db = null;
		switch (database) {
			case 1:
				db = new MySQL();
				break;
			case 2:
				db = new DB4o();
				break;
			case 3:
				db = new Hibernate();
				break;
		}

		times[2] = System.currentTimeMillis();
		times[3] = db.selectFlightByDepTime(depTime);
		if (times[3] == -1) return internalServerError();
		return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3] + "]");
	}

	public static Result joinFlightByDest(String dest, Long time, int database) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[4];
		times[0] = time;
		times[1] = reqArrTime;

		Database db = null;
		switch (database) {
			case 1:
				db = new MySQL();
				break;
			case 2:
				db = new DB4o();
				break;
			case 3:
				db = new Hibernate();
				break;
		}

		times[2] = System.currentTimeMillis();
		times[3] = db.joinSelectFlightByDest(dest);
		if (times[3] == -1) return internalServerError();
		return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3] + "]");
	}

}
