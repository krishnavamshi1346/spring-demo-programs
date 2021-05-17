package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
			
			//create a course
			int studentId=2;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("Loading courses for student "+tempStudent+ "is");
			System.out.println(tempStudent.getCourses());
			
			
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
