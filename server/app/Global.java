import models.database.DB4o;
import models.database.Hibernate;
import play.*;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		int mb = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();
		System.out.println("##### Heap utilization statistics [MB] #####");
		System.out.println("Used Memory:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);
		System.out.println("Free Memory:"
				+ runtime.freeMemory() / mb);
		System.out.println("Total Memory:" + runtime.totalMemory() / mb);
		System.out.println("Max Memory:" + runtime.maxMemory() / mb);

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