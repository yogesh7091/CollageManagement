package com.braindatawire.collagemanagement.model;

public class Student implements Comparable<Student>
{
	private int sid;
	private String sname;
	private Batch batch;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.sid-o.sid;
	}
}
