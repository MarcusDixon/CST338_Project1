/*
* Title: Student.java
* Abstract: This class holds student info.
* Author: Marcus Dixon
* ID: 0721
* Date: 3/15/2015
*/

public class Student
{
	int studentNumber;
	String name;
	int courseNumber;
	double score;
	String grade;
	
	public Student()
	{
		this.studentNumber = 0000;
		this.name = "Unknown";
		this.courseNumber = 000;
		this.score = 00.00;
		this.grade = "U";
	}
	
	public void setStudentNumber(int studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setCourseNumber(int courseNumber)
	{
		this.courseNumber = courseNumber;
	}
	
	public void setScore(double score)
	{
		this.score = score;
	}
	
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	public int getStudentNumber()
	{
		return this.studentNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCourseNumber()
	{
		return this.courseNumber;
	}
	
	public double getGetScore()
	{
		return this.score;
	}
	
	public String getGrade()
	{
		return this.grade;
	}
	
	
	
	
}
