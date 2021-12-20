package com.braindatawire.collagemanagement.serviceImp;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.hibernate.Session;

import com.braindatawire.collagemanagement.Configuration.HibernateUtil;
import com.braindatawire.collagemanagement.model.Batch;
import com.braindatawire.collagemanagement.model.Course;
import com.braindatawire.collagemanagement.model.Faculty;
import com.braindatawire.collagemanagement.model.Student;
import com.braindatawire.collagemanagement.service.Cjc;

public class Karvenagar implements Cjc 
{
	Scanner sc = new Scanner(System.in);
	Course c = new  Course();
	Faculty faculty = new Faculty();
	Batch batch = new Batch();
	
	
	
	//implemented method in cjc for add course
	public void addCourse()
	{
		System.out.println("Enter Course ID");
		c.setCid(inputIntValidation());
		System.out.println("Enter Course Name");
		c.setCname(inputStringValidation());
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.save(c);
		session.beginTransaction().commit();
		
	}
	//implemented method in cjc for view course
	public void viewCourse()
	{
			
		
	}
	public void addFaculty()
	{
		System.out.println("Enter Faculty Id");
		faculty.setFid(inputIntValidation());
		System.out.println("Enter Faculty Name");
		faculty.setFname(inputStringValidation());
		System.out.println("Enter Course Id ");
		Session session= HibernateUtil.getSessionFactory().openSession();
		Course course=session.get(Course.class, inputIntValidation());
		//this condition check course is present in db or no if not then add course first
		if(course==null)
		{
			System.out.println("You Enter Invalid Course");
			addCourse();
			//if new course added then that course directly allocated to Faculty 
			if(c.getCid()>0)
			{
				faculty.setCourse(c);
				session.save(faculty);
				session.beginTransaction().commit();
			}
		}
		else
		{
			faculty.setCourse(course);
			session.save(faculty);
			session.beginTransaction().commit();
		}
		
	}
	public void viewFaculty()
	{
	}
	public void addBatch()
	{
		System.out.println("Enter Batch Id");
		batch.setBid(inputIntValidation());
		System.out.println("Enter Batch Name");
		batch.setBname(inputStringValidation());
		Session session= HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter Faculty Id");
		Faculty faculty1=session.get(Faculty.class, inputIntValidation());
		if(faculty1==null)
		{
			System.out.println("You Enter Invalid FAculty ID");
			addFaculty();
			if(faculty.getFid()>0)
			{
				batch.setFaculty(faculty);
				session.save(batch);
				session.beginTransaction().commit();
			}
		}
		else 
		{
			batch.setFaculty(faculty1);
			session.save(batch);
			session.beginTransaction().commit();
		}
		
		
	}
	
	public void viewBatch()
	{
		
	}
	
	public void addStudent()
	{
		
		
	}
	public void viewStudent()
	{
		
	}
	
	
	// this method for user  integer input validation
	public int inputIntValidation()
	{
		String input;
		while(true)
		{
			
			input=sc.next();
			boolean inputValid=	Pattern.matches("[0-9]{1,3}", input);
			if(inputValid)
			{
				break;
			}
			else
			{
				System.out.println("You Enter Wrong Input Plz Try Agian");
			}
		}
		//parse int is used to convert String to int for set ID, BatchId, FAcultyId
		int validinput = Integer.parseInt(input);
		return validinput;
	}
	
	
	public String inputStringValidation()
	{
		String input;
		while(true)
		{
			input=sc.next();
			boolean inputValid=	Pattern.matches("[A-Z]{0,1}[a-z]{2,10}", input);
			if(inputValid)
			{
				break;
			}
			else
			{
				System.out.println("You Enter Wrong Input Plz Try Agian");
			}
		}
		
		return input;
	}
	
}
