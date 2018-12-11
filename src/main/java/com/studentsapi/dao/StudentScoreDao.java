package com.studentsapi.dao;

import com.studentsapi.model.Score;

public interface StudentScoreDao {
  
	void insertScore(Score score);
	Object avgScore ();
	int studentScore(int id);
	void insertScore(int id, int studentScore); 
	boolean deleteStudentsScore (int id);
	int studentLastestScore(int Student_id);
	
}
