package com.braindatawire.collagemanagement.model;

public class Course implements Comparable<Course>
{
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	//implement method in Comparable interface for sort 
	public int compareTo(Course c)
	{
		return this.cid-c.cid;
	}
	
}
