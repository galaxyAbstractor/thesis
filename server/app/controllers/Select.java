package controllers;

import com.google.gson.Gson;
import models.database.DB4o;
import models.database.Database;
import models.database.MySQL;
import models.datatypes.Flight;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Select extends Controller {

	public static Result flightByDepTime(int depTime, Long time) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[3];
		times[0] = time;
		times[1] = reqArrTime;

		//Database db = new MySQL();
		Database db = new DB4o();

		times[2] = db.selectFlightByDepTime(depTime);
		if (times[2] == -1) return internalServerError();
		return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + "]");
	}

}
