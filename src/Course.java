/*
* Title: Course.java
* Abstract: This class holds the courses.
* Author: Marcus Dixon
* ID: 0721
* Date: 3/15/2015
*/

public class Course
{
	int courseNumber;
	String courseTitle;
	int instructorNumber;
	String location;
	
	public Course()
	{
		this.courseNumber = 000;
		this.courseTitle = "Unknown";
		this.location = "Unknown";
	}
	
	public void setCourseNumber(int courseNumber)
	{
		this.courseNumber = courseNumber;
	}
	
	public void setCourseTitle(String courseTitle)
	{
		this.courseTitle = courseTitle;
	}
	
	public void setinstructorNumber(int instructorNumber)
	{
		this.instructorNumber = instructorNumber;
	}
	
	public void setCourseLocation(String location)
	{
		this.location = location;
	}
	
	public void updateLocation(String location)
	{
		this.location = location;
	}
	
	public int getCourseNumber()
	{
		return this.courseNumber;
	}
	
	public String getCourseTitle()
	{
		return this.courseTitle;
	}
	
	public int getinstructorNumber()
	{
		return this.instructorNumber;
	}
	
	public String getCourseLocation()
	{
		return this.location;
	}
	
}
