package com.studentsapi.model;

import java.io.Serializable;

public class Student implements Serializable  {
	
	private static final long serialVersionUID =1L;

	private long id ;
	private String name;
	private String email;
	
	public Student() {
	
	}
	
	public Student(String name, String email) {
		
		this.name = name;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

    @Override
	public String toString() {
	return"Student [id= "+ id +", name="+ name +" ,email="+email
			+"]";
	}
	


	
}
