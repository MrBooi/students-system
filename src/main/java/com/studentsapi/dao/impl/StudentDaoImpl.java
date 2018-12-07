package com.studentsapi.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.studentsapi.dao.StudentDao;
import com.studentsapi.model.Student;

@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
	
	@Autowired
	DataSource datasource;
	
	@PostConstruct 
	private void initializ() {
		setDataSource(datasource);
	}

	@Override
	public void insert(Student student) {
		String sql = "INSERT INTO students " + "(name,email) VALUES (?,?)";
		getJdbcTemplate().update(sql,new Object[] {student.getName(),student.getEmail()});
		
	}

	@Override
	public void insertBatch(List<Student> students) {
	 String sql = "INSERT INTO students " + "(name,email) VALUES (?,?,?)";
	 getJdbcTemplate().batchUpdate(sql,new BatchPreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
		   Student student = students.get(i);
		   ps.setLong(1, student.getId());
		   ps.setString(2, student.getName());
		   ps.setString(3, student.getEmail());
		}
		
		@Override
		public int getBatchSize() {
			
			return students.size();
		}
	}); 

	}

	@Override
	public List<Student> loadAllStudents() {
		String sql = "SELECT * FROM Students";
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Student> result = new ArrayList<Student>();
		for (Map<String , Object> row : rows) {
			 Student student = new Student();
			  student.setId((int)row.get("id"));
			  student.setName((String)row.get("name"));
			  student.setEmail((String)row.get("email"));
			  result.add(student);
			
		}
				
		return result;
	}

	@Override
	public String findNameByID(long id) {
		  String sql = "SELECT name FROM customer WHERE id = ?";
		     return getJdbcTemplate().queryForObject(sql, new Object[]{id}, String.class);

	}



}
