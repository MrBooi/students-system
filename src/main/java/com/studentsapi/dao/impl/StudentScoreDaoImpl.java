package com.studentsapi.dao.impl;



import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



import com.studentsapi.dao.StudentScoreDao;
import com.studentsapi.model.Score;
import com.studentsapi.model.Student;



@Repository
public class StudentScoreDaoImpl extends JdbcDaoSupport  implements StudentScoreDao {

	
	@Autowired
	DataSource datasource;
	
	@PostConstruct 
	private void initializ() {
		setDataSource(datasource);
	}
	
	
	@Override
	public void insertScore(Score score) {
      String sql = "INSERT INTO scores"  + "(student_id,score) VALUES (?,?)";
      getJdbcTemplate().update(sql,new Object[] {score.getStudent_id(),score.getScore()});
	}

	@Override
	public Object avgScore() {
	String sql = "SELECT AVG(score) from Scores";
	List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
	
	
	return rows.get(0).values();
	}
	

	@Override
	public int studentScore(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void insertScore(int student_Id, int studentScore) {
		 String sql = "INSERT INTO scores(student_id,score) VALUES (?,?)";
	      getJdbcTemplate().update(sql, new Object[] {student_Id,studentScore});	
	}


	@Override
	public boolean deleteStudentsScore(int id) {
		String sql = "DELETE FROM scores Where student_id=?";
    	int isDeleted= 	getJdbcTemplate().update(sql,id);
    	
    	if(isDeleted==0) {
    		return false;
    	}
		return true;
	}


	@Override
	public int studentLastestScore(int Student_id) {
		try {
			String sql = "SELECT score from scores where student_id= ? ORDER BY id DESC limit 1;";
		    int studentScore = getJdbcTemplate().queryForObject(sql, new Object[] {Student_id},Integer.class); 
		     return studentScore;
		}
		catch (Exception e) {
			return 0;
		}
		
	
	}


}
