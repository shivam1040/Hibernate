package com.CriteriaExample;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Student;

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
		System.out.println("a");
		Criteria c=session1.createCriteria(Student.class); //criterias is used to filter results according to our requirements
		c.add(Restrictions.eq("name", "SS")); //this criteria will filter out all results which dont contain have ss for name
		c.add(Restrictions.gt("id", 24));//filter in all results whose id field is greater than 24
		
		List<Student> list1=c.list(); //returns all records after applying filters
		for(Student s: list1)
			System.out.println(s+"a");
		System.out.println(list1);
		session1.beginTransaction(); // step before firing a query


	session1.getTransaction().commit(); // commits the changes in db table
	session1.close();
	}
}
