package models.database;

import models.datatypes.Airport;
import models.datatypes.Flight;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import play.Logger;

import java.util.List;

public class Hibernate implements Database {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static void createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Logger.info("Hibernate sessionfactory created");
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
		Logger.info("Hibernate sessionfactory closed");
	}

	@Override
	public long insertAirport(Airport airport) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(airport);
		session.getTransaction().commit();
		session.close();
		return System.currentTimeMillis();
	}

	@Override
	public long insertFlight(Flight flight) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Airport where iata = :iata ");
		query.setParameter("iata", flight.getDest().getIata());
		List list = query.list();

		Airport destAirport = (Airport) list.get(0);
		flight.setDest(destAirport);

		query = session.createQuery("from Airport where iata = :iata ");
		query.setParameter("iata", flight.getOrigin().getIata());
		list = query.list();

		Airport origAirport = (Airport) list.get(0);
		flight.setOrigin(origAirport);

		session.beginTransaction();
		session.save(flight);

		session.getTransaction().commit();
		session.close();
		return System.currentTimeMillis();
	}

	@Override
	public long selectFlightByDepTime(int depTime) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Flight where depTime = :depTime ");
		query.setParameter("depTime", depTime);
		List list = query.list();
		session.close();
		return System.currentTimeMillis();
	}

	@Override
	public long joinSelectFlightByDest(String dest) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Airport where iata = :iata ");
		query.setParameter("iata", dest);
		List list = query.list();
		Airport airport = (Airport) list.get(0);

		session.close();
		return System.currentTimeMillis();
	}
}
