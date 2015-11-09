/*
* Title: School.java
* Abstract: This program plays is a school information system: add, delete, and see info on students teachers and classes.
* Author: Marcus Dixon
* ID: 0721
* Date: 3/15/2015
*/

import java.io.*;
import java.util.*;

public class School
{
	private ArrayList<Course> courses = new ArrayList(10);
	private ArrayList<Instructor> instructors = new ArrayList(10);
	private String name;
	private ArrayList<Student> students = new ArrayList(10);
	
	public School(String name)
	{
		this.name = name;
	}
	
	public void readData(String data)
	{
		Integer charc = 0;
		String line = "";
		int var = 4;
		
		try
		{
			FileReader fFile = new FileReader(data);
			BufferedReader bFile = new BufferedReader(fFile);
			
			
			line = bFile.readLine();
			charc = charc.valueOf(line);
				
			for(int j = 0; j < charc; j++)
			{
				Integer num = 0;
				line = bFile.readLine();
							
				StringTokenizer st = new StringTokenizer(line, ",");
				String instructorNumber = st.nextToken();
				num = num.valueOf(instructorNumber);
				String name = st.nextToken();
				String email = st.nextToken();
				String phoneNumber = st.nextToken();
				addInstructor(num, name, email, phoneNumber);						
			}	
						
			line = bFile.readLine();
			charc = charc.valueOf(line);
				
			for(int j = 0; j < charc; j++)
			{
				Integer num1 = 0;
				Integer num2 = 0;
				line = bFile.readLine();
							
				StringTokenizer st = new StringTokenizer(line, ",");
				String courseNumber = st.nextToken();
				num1 = num1.valueOf(courseNumber);
				String name = st.nextToken();
				String instructorNumber = st.nextToken();
				num2 = num2.valueOf(instructorNumber);
				String location = st.nextToken();
				addCourse(num1, name, num2, location);						
			}			
						
			line = bFile.readLine();
			charc = charc.valueOf(line);
				
			for(int j = 0; j < charc; j++)
			{
				Integer num1 = 0;
				Integer num2 = 0;
				Double num3 = 0.0;
				line = bFile.readLine();
							
				StringTokenizer st = new StringTokenizer(line, ",");
				String studentNumber = st.nextToken();
				num1 = num1.valueOf(studentNumber);
				String name = st.nextToken();
				String courseNumber = st.nextToken();
				num2 = num2.valueOf(courseNumber);
				String score = st.nextToken();
				num3 = num3.valueOf(score);
				String grade = st.nextToken();
				addStudent(num1, name, num2, num3, grade);						
			}		
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void addCourse(int courseNumber, String courseTitle, int instructorNumber, String location)
	{
		boolean course = true;
		boolean teacher = false;
		
		for (Course element: courses)
		{
			if (element.getCourseNumber() == courseNumber)
			{
				System.out.println("Course addition failed - Course number already used.");
				course = false;
			}
		}
		
		for (Instructor element: instructors)
		{
			if (element.getInstructorNumber() == instructorNumber)
			{
				teacher = true;
			}
		}
		
		if (!teacher)
		{
			System.out.println("course addition failed - Non-existing instructor.");
		}
		
		if (course && teacher)
		{
			Course cours = new Course();
		
			cours.setCourseNumber(courseNumber);
			cours.setCourseTitle(courseTitle);
			cours.setinstructorNumber(instructorNumber);
			cours.setCourseLocation(location);
		
			courses.add(cours);
		}
	}
	
	public void addInstructor(int instructorNumber, String name, String email, String phoneNumber)
	{
		
		Instructor teacher = new Instructor();

		teacher.setInstructorNumber(instructorNumber);
		teacher.setName(name);
		teacher.setEmail(email);
		teacher.setPhoneNumber(phoneNumber);
		
		instructors.add(teacher);
	}
	
	public void courseInfo(int courseNumber)
	{
		boolean found = false;
		double average = 0;
		int count = 0;
		
		for(Course element: courses)
		{
			if (element.getCourseNumber() == courseNumber)
			{
				System.out.println("Course Number: " + element.getCourseNumber());
				System.out.print("Instructor: " );
				for (Instructor e: instructors)
				{
					if (element.getinstructorNumber() == e.getInstructorNumber())
					{
						System.out.println(e.getName());
					}
					
				}
				System.out.println("Course Title: " + element.getCourseTitle());
				System.out.println("Room: " + element.getCourseLocation());
				System.out.println("Enrolled Students: ");
			
				for (Student e: students)
				{
					if (element.getCourseNumber() == e.getCourseNumber())
					{
						System.out.print("       " + e.getName() + ": ");
						System.out.format("%.2f", e.getGetScore()); 
						System.out.println(" (" + e.getGrade() + ")");
						average += e.getGetScore();
						count++;
					}
				}
				found = true;
			}
		}
		if (found)
		{
			System.out.print("Course Average: " );
			System.out.format("%.2f", average / count);
			System.out.println();
		}
		else
			System.out.println("No class info!");
	}
	
	public void courseInfo()
	{
		int count;
		System.out.println("Number of Courses: " + courses.size());
		for(Course element: courses)
		{
			count = 0;
			for(Student e: students)
			{
				if (element.getCourseNumber() == e.getCourseNumber())
				{
					count++;
				}
			}
			System.out.println("       " + element.getCourseNumber() + ": " + count + " enrolled");
		}
	}
	
	public Course getCourse(int courseNumber)
	{
		int index = 0;
		
		for(Course element: courses)
		{
			if (element.getCourseNumber() == courseNumber)
			{
				index = courses.indexOf(element);
			}
		}
		return courses.get(index);
	}
	
	public void deleteCourse(int courseNumber)
	{
		boolean delete = true;
		
		for (Student element: students)
		{
			if (element.getCourseNumber() == courseNumber)
			{
				delete = false;
			}
		}
		
		if (delete)
		{
			for (int i = 0; i < courses.size(); i++)
			{
				if (courses.get(i).getCourseNumber() == courseNumber)
				{
					courses.remove(i);
					i--;
				}
			}
		}
		else
			System.out.println("Course deletion failed - Enrolled student(s) in the class");
	}
	
	public void addStudent(int studentNumber, String name, int courseNumber, double score, String grade)
	{
		Student person = new Student();
		
		person.setStudentNumber(studentNumber);
		person.setName(name);
		person.setCourseNumber(courseNumber);
		person.setScore(score);
		person.setGrade(grade);
		
		students.add(person);
	}
	
	public void graduateStudent(int studentNumber)
	{	
		boolean found = false;
		
		for (int i = 0; i < students.size(); i++)
		{
			if (students.get(i).getStudentNumber() == studentNumber)
			{
				students.remove(i);
				i--;
				found = true;
			}
		}
		if (!found)
		{
			System.out.println("Student graduation failed - Non-existing student.");
		}
	}
	
	public void schoolInfo()
	{
		System.out.println("School Name: " + name);
		System.out.println("Instructor Information");
		for(Instructor element: instructors)
		{
			System.out.println("       " + element.getName());
		}
		
		System.out.println("Course Information");
		for(Course element: courses)
		{
			System.out.println("       " + element.getCourseTitle());
		}
		
		System.out.println("Student Information");
		for(Student element: students)
		{
			System.out.print("       " + element.getName() + ": ");
			
			for(Course e: courses)
			{
				if (element.getCourseNumber() == e.getCourseNumber())
				{
					System.out.println(e.getCourseTitle());
				}
			}
		}
	}
	
	public void studentInfo(int studentNumber)
	{
		boolean found = false;
		boolean name = false;
		double average = 0;
		int count = 0;
		
		System.out.println("Student Number: " + studentNumber);
		
		for(Student element: students)
		{
			if (element.getStudentNumber() == studentNumber)
			{
				found = true;
				if (!name)
				{
					System.out.println("Name: " + element.getName());
					System.out.println("Courses Enrolled: ");
					name = true;
				}
					System.out.print("       " + element.getCourseNumber() + ": ");
					System.out.format("%.2f", element.getGetScore()); 
					System.out.println(" (" + element.getGrade() + ")");
					average += element.getGetScore();
					count++;
			}
		}
		if (found)
		{
			System.out.print("Course Average: ");
			System.out.format("%.2f", average / count);
			System.out.println();
		}
		else
			System.out.println("No student info!");
	}
}
