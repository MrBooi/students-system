package com.studentsapi.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsapi.dao.StudentScoreDao;
import com.studentsapi.model.Score;
import com.studentsapi.service.StudentScoreService;

@Service
public class StudentScoreServiceImpl implements StudentScoreService{

	@Autowired StudentScoreDao studentScoreDao ;
	
	@Override
	public void insertScore(int id, int studentScore)  {
		studentScoreDao.insertScore(id,studentScore);
	}
	

	@Override
	public void insertScore(Score score) {
		studentScoreDao.insertScore(score);
	}

	@Override
	public Object averageScore() {
		return  studentScoreDao.avgScore();
	}

	@Override
	public boolean deleteStudentScore(int id) {
		return studentScoreDao.deleteStudentsScore(id);
	}

	@Override
	public int studentScore(int student_id) {
		
		return studentScoreDao.studentLastestScore(student_id);
	}

}
