import models.database.DB4o;
import models.database.Hibernate;
import play.*;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		Logger.info("Application has started");
		DB4o.openDB();
		Hibernate.createSessionFactory();
	}

	@Override
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
		DB4o.closeDB();
		Hibernate.closeSessionFactory();
	}

}