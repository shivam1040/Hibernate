package MappingByXML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

public static void main(String[] args) {
	SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory(); // creates connection
	// b/w db and hibernate,
	// give filename in
	// configure if it is
	// not found
	// automatically

	
	
	Session session1 = sessionFactory1.openSession(); // creates session b/w db and hibernate, similar to creatiing
	// statement obj in jdbc, once the session is opened on the
	// new session obj can be created using getcurrentsession
	// method
session1.beginTransaction(); // step before firing a query


session1.getTransaction().commit(); // commits the changes in db table
session1.close();
}	
	
}
