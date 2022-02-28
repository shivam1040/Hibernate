package com.hibernate;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.query.*; //this is necessary if we dont want to use deprecated version of Query used below
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory(); // creates connection
																								// b/w db and hibernate,
																								// give filename in
																								// configure if it is
																								// not found
																								// automatically
		// System.out.println(sessionFactory1.isClosed()); //checks if connection is
		// closed
		CertificateRefrenceInsert certificateRefrenceInsert = new CertificateRefrenceInsert("Comp", "1");
		Student student1 = new Student(103, "SJ4", "DL4", certificateRefrenceInsert);
		// System.out.println(student1);
		byte image[] = null;

		try {// reading an image file
			FileInputStream fileInputStream1 = new FileInputStream("src/main/java/HiberNateArchitec.PNG");
			image = new byte[fileInputStream1.available()];
			fileInputStream1.read(image); // story image bytes into byte var
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Address address1 = new Address("BL", "PAD", true, 99.0, new Date(), image); // no need to add id since it is
																					// auto generated

		AnswerOneToOneMapping answerOneToOneMapping1 = new AnswerOneToOneMapping(4, "PL");
		QuestionOneToOneMapping question1 = new QuestionOneToOneMapping(3, "Java", answerOneToOneMapping1);
		answerOneToOneMapping1.setQuestionOneToOneMapping(question1);

		QuestionOneToManyMapping questionOneToManyMapping = new QuestionOneToManyMapping(0, "A?");
		AnswerOneToManyMapping answerOneToManyMapping2 = new AnswerOneToManyMapping(1, "A1");
		AnswerOneToManyMapping answerOneToManyMapping3 = new AnswerOneToManyMapping(2, "A2");
		answerOneToManyMapping2.setQuestionOneToManyMapping(questionOneToManyMapping);
		answerOneToManyMapping3.setQuestionOneToManyMapping(questionOneToManyMapping);
		List<AnswerOneToManyMapping> answerOneToManyMapping1 = new ArrayList<AnswerOneToManyMapping>();
		answerOneToManyMapping1.add(answerOneToManyMapping2);
		answerOneToManyMapping1.add(answerOneToManyMapping3);
		questionOneToManyMapping.setAnswerOneToManyMapping(answerOneToManyMapping1);

		EmpManyToMany empManyToMany = new EmpManyToMany(0, "SJ");
		EmpManyToMany empManyToMany1 = new EmpManyToMany(1, "SJ1");
		ProjManyToMany projManyToMany = new ProjManyToMany(2, "V");
		ProjManyToMany projManyToMany1 = new ProjManyToMany(3, "J");
		List<EmpManyToMany> listE = new ArrayList<EmpManyToMany>();
		listE.add(empManyToMany);
		listE.add(empManyToMany1);
		List<ProjManyToMany> listP = new ArrayList<ProjManyToMany>();
		listP.add(projManyToMany);
		listP.add(projManyToMany1);
		empManyToMany.setProjManyToMany(listP); // making a part of many to many relation by assigning many projects to
												// one emp
		projManyToMany.setEmpManyToMany(listE); // making a part ofmany to many relation by assigning many emps to one
												// proj

		Session session1 = sessionFactory1.openSession(); // creates session b/w db and hibernate, similar to creatiing
															// statement obj in jdbc, once the session is opened on the
															// new session obj can be created using getcurrentsession
															// method
		session1.beginTransaction(); // step before firing a query

		// session1.save(student1); //fires a query internally and saves passed obj ina
		// table
		// session1.save(address1);

		// session1.save(question1); //doing onetoOne mapping
		// session1.save(answerOneToOneMapping1); //doing onetoOne mapping

		
		  //session1.save(questionOneToManyMapping); //doing one to many mapping
		  //session1.save(answerOneToManyMapping2);
		  //session1.save(answerOneToManyMapping3); QuestionOneToManyMapping
		  //questionOneToManyMapping1=(QuestionOneToManyMapping)session1.get(
		  //QuestionOneToManyMapping.class, 0); //getting data by id 0 of question
		  //for(AnswerOneToManyMapping a:
		  //questionOneToManyMapping1.getAnswerOneToManyMapping())
		  //System.out.println(a.getAnswer()); //retrieving list of answers
		 
		
		 Query query1=session1.createQuery("select q.questionId, q.question, a.answer from QuestionOneToManyMapping q INNER JOIN q.answerOneToManyMapping as a"); //this is hql query for join between tables to display data which are mapped by FK by mentioning var in respective entity classes
		 List<Object[]> list1=query1.getResultList(); //since the data returned is a custom type data  i.e no such entity class has been defined so we need to store the result in objects
		 for(Object[] arr:list1)
			 System.out.println(Arrays.toString(arr));
		 
		// session1.save(empManyToMany); //mapping many to many
		// session1.save(empManyToMany1); //session1.save(projManyToMany);
		// session1.save(projManyToMany1);

		session1.getTransaction().commit(); // commits the changes in db table
		session1.close(); // closes the session, all these steps from begintransaction need to be followed
							// for db operations

	}
}
