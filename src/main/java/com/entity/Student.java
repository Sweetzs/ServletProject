
package com.entity;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private int age;
	private String emailID;
	private String course;
	public Student(int id,String name,int age,String emailID,String course){
		this.id=id;
		this.name=name;
		this.age=age;
		this.emailID=emailID;
		this.course=course;
	}
	public Student() {
	}
	public int getId() {
		return id;
	}
	public void setId() {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName() {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge() {
		this.age=age;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID() {
		this.emailID=emailID;
	}
	public String getCourse() {
		return course;
	}
	public void setcourse() {
		this.course=course;
	}
	
}
