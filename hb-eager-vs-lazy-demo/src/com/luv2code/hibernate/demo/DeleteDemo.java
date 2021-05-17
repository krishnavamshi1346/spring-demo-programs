package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
				//start a transaction
			session.beginTransaction();
			
			//get instructor by primary key id
			int theId=1;
			
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Deleting Instructor : "+tempInstructor);
			//delete instructor
			
			if(tempInstructor!=null) {
				
				//it will aslo instructor detail because of CascadeType.ALL
				session.delete(tempInstructor);
			}
						
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		

	}

}
