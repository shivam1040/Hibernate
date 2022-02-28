package com.hibernate2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;

import com.hibernate.AnswerOneToManyMapping;
import com.hibernate.QuestionOneToManyMapping;
import com.hibernate.Student;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class AppCheckStudentComments {
	public static void main(String[] args) {
		SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory(); // creates connection
																								// b/w db and hibernate,
																								// give filename in
																								// configure if it is
																								// not found
																								// automatically

		CertificateRefrenceInsert certificateRefrenceInsert1 = new CertificateRefrenceInsert("J", "2"); // these two
																										// lines mean
																										// transient
																										// state
		Student1 student1 = new Student1(19, "SS", "DL", certificateRefrenceInsert1);

		String hql = "from Student1"; // gets all records of Student1 table via hql query
		hql = "from Student1 where city='DL'";
		hql = "from Student1 as s where s.city=:x and s.name=:y"; // notice setparameter method after begin transaction
																	// whic sets value for x, way to pass dynamic value
		String hql1 = "delete from Student1 where city='DL'"; // hql for deleting
		hql1 = "update Student1 set city='DL' where name='SS'"; // hql for update, executeupdate of session obj work for
																// query obj created by passing this string
		String sql1 = "select * from Student1";

		QuestionOneToManyMapping questionOneToManyMapping1=new QuestionOneToManyMapping(2, "Q2");
		AnswerOneToManyMapping answerOneToManyMapping1=new AnswerOneToManyMapping(3, "A21");
		AnswerOneToManyMapping answerOneToManyMapping2=new AnswerOneToManyMapping(4, "A22");
		List<AnswerOneToManyMapping> list4=new ArrayList<AnswerOneToManyMapping>();
		list4.add(answerOneToManyMapping1);
		list4.add(answerOneToManyMapping2);
		questionOneToManyMapping1.setAnswerOneToManyMapping(list4);
		answerOneToManyMapping1.setQuestionOneToManyMapping(questionOneToManyMapping1);
		answerOneToManyMapping2.setQuestionOneToManyMapping(questionOneToManyMapping1);
		
		Session session1 = sessionFactory1.openSession(); // creates session b/w db and hibernate, similar to creatiing
															// statement obj in jdbc, once the session is opened on the
															// new session obj can be created using getcurrentsession
															// method
		
		
		session1.beginTransaction(); // step before firing a query

		// session1.save(student1); //this and commit statement shows persistent state

		Query query1 = session1.createQuery(hql);// converts string to hql query
		query1.setParameter("x", "DL");
		query1.setParameter("y", "SS");
		List<Student1> list1 = query1.list(); // gets all matching records
		for (Student1 s : list1)
			System.out.println(s);

		
		  //session1.beginTransaction(); //for delete/update statement new transaction is needed 
		  //Query query2=session1.createQuery(hql1); //
		  //query2.executeUpdate();//this is usede for updating/deleting record
		 

		// pagination means getting the records from table by specified position such as
		// record no 10 or 11 etc.
		// Query<Student1> query3=session1.createQuery("from Student1", Student1.class);
		// query3.setFirstResult(1); query3.setMaxResults(4); //this will only get
		// result from row 1 to row 4
		// list1=query3.list();

		// NativeQuery<Object[]> nativeQuery1=session1.createSQLQuery(sql1); //way to
		// fire native sql queries
		// List<Object[]> list2=nativeQuery1.list(); //way to store datat recieved from
		// db
		// for(Object[] arr:list2)
		// System.out.println(Arrays.toString(arr));
		
		//session1.save(questionOneToManyMapping1); //cascading is done here, needed not to save answeronetomany objects, do refer to questiononetomany class for clarity
		
		Student1 student11=session1.get(Student1.class, 19);
		Student1 student12=session1.get(Student1.class, 19); //notice no query is executed when same query is fired for the second time, since this query result is already present in first level cache so hibernate returns result from cache
		
		
		
		session1.getTransaction().commit(); // commits the changes in db table
		session1.close(); // closes the session, all these steps from begintransaction need to be followed for db operations

		// at close object moves to detached state
		/*
		 * session1.get(entity, id); //get an obj from database for a given entity
		 * session1.delete(session1); //this acts as removed state(removed from db but
		 * still in session) for object
		 *
		 */
		
		Session session2 = sessionFactory1.openSession();
		session2.beginTransaction();
		Student1 student13=session2.get(Student1.class, 19); //since similar typeof query has been executed in  session 1 block so no query would be executed for this rather data will be retrieved from second level cache for which config has been defined in cfg file and student 1 class
		session2.getTransaction().commit(); // commits the changes in db table
		session2.close(); 
		
	}
}
