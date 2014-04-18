package controllers;

import com.google.gson.Gson;
import models.database.DB4o;
import models.database.Database;
import models.database.Hibernate;
import models.database.MySQL;
import models.datatypes.Airport;
import models.datatypes.Flight;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Insert extends Controller {

    public static Result oneFlight(Long time) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[4];
		times[0] = time;
		times[1] = reqArrTime;

		DynamicForm requestData = Form.form().bindFromRequest();
		String json = requestData.get("data");
		Gson gson = new Gson();
		Flight flight = gson.fromJson(json, Flight.class);

		//Database db = new MySQL();
		//Database db = new DB4o();
		Database db = new Hibernate();

		times[2] = System.currentTimeMillis();
		times[3] = db.insertFlight(flight);

		if(times[3] == -1) return internalServerError();
        return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3] + "]");
    }

	public static Result oneAirport(Long time) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[4];
		times[0] = time;
		times[1] = reqArrTime;

		DynamicForm requestData = Form.form().bindFromRequest();
		String json = requestData.get("data");
		Gson gson = new Gson();
		Airport airport = gson.fromJson(json, Airport.class);

		//Database db = new MySQL();
		//Database db = new DB4o();
		Database db = new Hibernate();

		times[2] = System.currentTimeMillis();
		times[3] = db.insertAirport(airport);

		if (times[3] == -1) return internalServerError();
		return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + ", " + times[3] + "]");
	}

}
