package com.studentsapi.service;

import com.studentsapi.model.Score;

public interface StudentScoreService {

   void insertScore(Score score); 
   void insertScore(int i, int j);
   boolean deleteStudentScore(int id);
   Object averageScore();
   int studentScore(int student_id);



}
