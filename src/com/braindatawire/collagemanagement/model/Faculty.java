package com.braindatawire.collagemanagement.model;

public class Faculty implements Comparable<Faculty>
{
	private int fid;
	private String fname;
	private Course course;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	// in this method compare course id 
	@Override
	public int compareTo(Faculty o) {
		// TODO Auto-generated method stub
		return this.course.getCid()-o.course.getCid();
	}
	
}
