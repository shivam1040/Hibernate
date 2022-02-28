package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbedObj {
	public static void main(String[] args) {
	SessionFactory sessionFactory1=new Configuration().configure().buildSessionFactory(); //creates connection b/w db and hibernate, give filename in configure if it is not found automatically
    CertificateRefrenceInsert certificateRefrenceInsert=new CertificateRefrenceInsert("Comp", "1"); //defining default constructor is necessary fo embedding objects
	Student student1=new Student(123, "SJ5", "DL4", certificateRefrenceInsert);
	Session session1=sessionFactory1.openSession();
	session1.beginTransaction(); //step before firing a query
    session1.save(student1); //fires a query internally and saves passed obj ina table
    session1.getTransaction().commit(); //commits the changes in db table
    session1.close(); //closes the session, all these steps from begintransaction need to be followed for db operations

	}
	
}
