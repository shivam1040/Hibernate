package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataUsingGetLoad {
	public static void main(String[] args) {
	SessionFactory sessionFactory1=new Configuration().configure().buildSessionFactory(); //creates connection b/w db and hibernate, give filename in configure if it is not found automatically
	Session session1=sessionFactory1.openSession();
	//Student student1=(Student)session1.get(Student.class, 102); //this fetches the db data from student table by id(102) by using get method
	Student student1=(Student)session1.load(Student.class, 102); //this fetches the db data from student table by id(102) by using load method
	System.out.println(student1);
	}
}
