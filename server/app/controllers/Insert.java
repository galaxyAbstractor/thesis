package controllers;

import com.google.gson.Gson;
import models.database.Database;
import models.database.MySQL;
import models.datatypes.Flight;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Insert extends Controller {

    public static Result oneFlight(Long time) {
		Long reqArrTime = System.currentTimeMillis();
		Long[] times = new Long[3];
		times[0] = time;
		times[1] = reqArrTime;

		DynamicForm requestData = Form.form().bindFromRequest();
		String json = requestData.get("data");
		Gson gson = new Gson();
		Flight flight = gson.fromJson(json, Flight.class);

		Database db = new MySQL();

		times[2] = db.insertFlight(flight);
        return ok("[" + times[0] + ", " + times[1] + ", " + times[2] + "]");
    }

}
