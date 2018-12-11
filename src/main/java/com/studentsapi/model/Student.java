package com.studentsapi.model;

import java.io.Serializable;

public class Student implements Serializable  {
	
	private static final long serialVersionUID =1L;

	private int id ;
	private String name;
	private String surname;
	private int age;
	private String email;
	private int score;
	
	public Student () {
		
	}
	
	
	public Student(String name, String surname, int age, String email,int score) {
		super();
	
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.score = score;
	}

	

	

	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
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


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

   
	


	
}
