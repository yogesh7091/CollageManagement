package com.braindatawire.collagemanagement.serviceImp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.braindatawire.collagemanagement.model.Batch;
import com.braindatawire.collagemanagement.model.Course;
import com.braindatawire.collagemanagement.model.Faculty;
import com.braindatawire.collagemanagement.model.Student;
import com.braindatawire.collagemanagement.service.Cjc;

public class Karvenagar implements Cjc 
{
	Scanner sc = new Scanner(System.in);
	
	List<Course> clist = new ArrayList<>();
	List<Faculty> flist = new ArrayList<>();
	List<Batch> blist = new ArrayList<>();
	List<Student> slist = new ArrayList<>();
	
	int count1 =0;
	int count2 =0;
	int count3 = 0;
	int count4 =0;
	//implemented method in cjc for add course
	public void addCourse()
	{
		Course c1 = new  Course();
		System.out.println("Enter Course ID");
		c1.setCid(inputValidation());
		//c1.setCid(sc.nextInt());
		System.out.println("Enter Course Name");
		c1.setCname(sc.next());
		clist.add(c1);
		count1++;
	}
	//implemented method in cjc for view course
	public void viewCourse()
	{
		//if else condition for first add course after that view course otherwise it directly call addCourse Method
		if(count1>0)
		{
			// Sort on the bacis of course ID using Comparable
			Collections.sort(clist);
			Iterator< Course> itr = clist.iterator();
			//while loop for iteration course list like {c1, c2,c3}
			while(itr.hasNext())
			{
				Course c = itr.next();
				System.out.println("Course Id: "+c.getCid());
				System.out.println("Course Name: "+c.getCname());
			}
		}
		else
		{
			addCourse();
		}
	}
	public void addFaculty()
	{
		//if else condition for first add course after that add Faculty method call otherwise it directly call addCourse Method
		if(count1>0)
		{
			Faculty f = new Faculty();
			System.out.println("Enter Faculty Id");
			f.setFid(inputValidation());
			System.out.println("Enter Faculty Name");
			f.setFname(sc.next());
			Iterator<Course> itr1 = clist.iterator();
			System.out.println("Enter Course Id");
			int eid = inputValidation();
			while(itr1.hasNext())
			{
				Course c = itr1.next();
				int cid = c.getCid();
				// if condition for assign course to faculty
				if(cid==eid)
				{
					f.setCourse(c);
					flist.add(f);
					count2++;
				}
				else
				{
					System.out.println("Course Is Not Found");
					break;
				}
					
			}
			
		}
		else
		{
			addCourse();
		}
		
	}
	public void viewFaculty()
	{
		//if condition for view faculty after Add faculty
		if(count2>0)
		{
			Collections.sort(flist);
			Iterator< Faculty> itr = flist.iterator();
			System.out.println("              ***Faculty Details***");
			System.out.println(" Course Id | Course Name | Faculty Id | Faculty Name");
			while(itr.hasNext())
			{
				Faculty f = itr.next();
				
				System.out.print("    "+f.getCourse().getCid());
				System.out.print("          "+f.getCourse().getCname());
				System.out.print("          "+f.getFid());
				System.out.print("          "+f.getFname()+"\n");
				
			}
		}
		else
		{
			addFaculty();
		}
	}
	public void addBatch()
	{
		if(count2>0)
		{
			Batch b = new Batch();
			System.out.println("Enter Batch Id");
			b.setBid(inputValidation());
			System.out.println("Enter Batch Name");
			b.setBname(sc.next());
			Iterator<Faculty> itr1 = flist.iterator();
			System.out.println("Enter Faculty Id");
			int eid = inputValidation();
			while(itr1.hasNext())
			{
				Faculty f = itr1.next();
				int fid = f.getFid();
				
				if(fid==eid)
				{
					b.setFaculty(f);
					blist.add(b);
					count3++;
				}
				else
				{
					System.out.println("Faculty Id Is Invalid");
					break;
				}
			}
			
		}
		else
		{
			addFaculty();
		}
	}
	
	public void viewBatch()
	{
		if(count3>0)
		{
			Collections.sort(blist);
			System.out.println("                           ***Batch Details***");
			System.out.println("Batch Id | Batch Name | FAculty Id | Faculty Name | Course ID | Course Name");
			Iterator<Batch> itr = blist.iterator();
			while(itr.hasNext())
			{
				Batch b = itr.next();
				System.out.print("  "+b.getBid());
				System.out.print("       "+b.getBname());
				System.out.print("       "+b.getFaculty().getFid());
				System.out.print("          "+b.getFaculty().getFname());
				System.out.print("           "+b.getFaculty().getCourse().getCid());
				System.out.print("         "+b.getFaculty().getCourse().getCname()+"\n");
			}
		}
		else
		{
			addBatch();
		}
	}
	
	public void addStudent()
	{
		if(count3>0)
		{
			Student s = new Student();
			System.out.println("Enter Student Id");
			s.setSid(inputValidation());
			System.out.println("Enter Student Name");
			s.setSname(sc.next());
			Iterator<Batch> itr1 = blist.iterator();
			System.out.println("Enter Batch Id");
			int ebid = inputValidation();
			while(itr1.hasNext())
			{
				Batch b = itr1.next();
				int bid = b.getBid();
				if(bid==ebid)
				{
					s.setBatch(b);
					slist.add(s);
					count4++;
				}
				else
				{
					System.out.println("Batch Not Availabale");
				}
			}
			
		}
		else
		{
			addBatch();
		}
		
	}
	public void viewStudent()
	{
		if(count4>0)
		{
			Collections.sort(slist);
			System.out.println("                        ***Student Details***");
			System.out.println("Student Id | Student Name | Course Id | Course Name | Batch Id | Batch Name");
			Iterator<Student> itr = slist.iterator();
			while(itr.hasNext())
			{
				Student s = itr.next();
				System.out.print("   "+s.getSid());
				System.out.print("          "+s.getSname());
				System.out.print("          "+s.getBatch().getFaculty().getCourse().getCid());
				System.out.print("          "+s.getBatch().getFaculty().getCourse().getCname());
				System.out.print("          "+s.getBatch().getBid());
				System.out.print("        "+s.getBatch().getBname()+"\n");
			}
		}
		else
		{
			addStudent();
		}
	}
	
	
	// this method for user input validation
	public int inputValidation()
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
}
