package com.studentsapi.model;

import java.io.Serializable;

public class Score implements Serializable {
  
	private static final long serialVersionUID = 1L;

	private int score ;
	private int student_id;
	
	public Score() {
		super();

		
	}
	
	public Score(int id,int score) {
		this.student_id = id;
		this.score = score;
	}



	public int getStudent_id() {
		return student_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
}
