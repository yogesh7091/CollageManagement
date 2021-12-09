package com.braindatawire.collagemanagement.client;

import java.util.Scanner;

import com.braindatawire.collagemanagement.service.Cjc;
import com.braindatawire.collagemanagement.serviceImp.Karvenagar;

public class Test {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("***Complete Java Classes***");
		System.out.println("Enter 1 For Add course");
		System.out.println("Enter 2 For Course Details");
		System.out.println("Enter 3 For Add Faculty");
		System.out.println("Enter 4 For faculty Details");
		System.out.println("Enter 5 For Add Batch");
		System.out.println("Enter 6 For Batch Details");
		System.out.println("Enter 7 For Add Student");
		System.out.println("Enter 8 For Student Details");
		
		
		Cjc cjc = new Karvenagar();
		while(true)
		{
			int caseNo =sc.nextInt();
			
			switch(caseNo)
			{
			case 1: cjc.addCourse();
			break;
		
			case 2: cjc.viewCourse();
			break;
		
			case 3: cjc.addFaculty();
			break;
		
			case 4: cjc.viewFaculty();
			break;
		
			case 5: cjc.addBatch();
			break;
		
			case 6: cjc.viewBatch();
			break;
		
			case 7: cjc.addStudent();
			break;
		
			case 8: cjc.viewStudent();
			break;
			
			case 9: System.exit(0);
			}
		}

	}

}
