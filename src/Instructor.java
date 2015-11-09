/*
* Title: Instructor.java
* Abstract: This class holds Instructor data.
* Author: Marcus Dixon
* ID: 0721
* Date: 3/15/2015
*/

public class Instructor
{
	int instructorNumber;
	String name;
	String email;
	String phoneNumber;
	
	public Instructor()
	{
		this.instructorNumber = 000;
		this.name = "Unknown";
		this.email = "Unknown";
		this.phoneNumber = "Unknown";
	}
	
	public void setInstructorNumber(int instructorNumber)
	{
		this.instructorNumber = instructorNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public int getInstructorNumber()
	{
		return this.instructorNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
}
