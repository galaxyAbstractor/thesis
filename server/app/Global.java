import models.database.DB4o;
import play.*;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		Logger.info("Application has started");
		DB4o.openDB();
	}

	@Override
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
		DB4o.closeDB();
	}

}