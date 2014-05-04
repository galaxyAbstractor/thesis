package controllers;

import models.database.DB4o;
import models.database.MySQL;
import play.mvc.Controller;
import play.mvc.Result;

public class Purge extends Controller {

	public static Result purge() {
		MySQL mySQL = new MySQL();
		mySQL.purge();

		DB4o db4o = new DB4o();
		db4o.purge();
		return ok("[1]");
	}

}