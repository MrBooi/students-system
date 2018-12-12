package com.studentsapi.dao.impl;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		String sql = "INSERT INTO students " + "(name,surname,age,email) VALUES (?,?,?,?)";
		getJdbcTemplate().update(sql,new Object[] {student.getName(),student.getSurname(),student.getAge(),student.getEmail()});
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
			  student.setSurname((String)row.get("Surname"));
			  student.setAge((int)row.get("age"));
			  student.setEmail((String)row.get("email"));
			  result.add(student);
			
		}
				
		return result;
	}


	@Override
	public Student findByName(String name) {
	  String sql = "SELECT * FROM students WHERE name= ?";
	  Object[] params = new Object[] {name};
	  Student found = null;
	  try {
		  found = (Student) getJdbcTemplate().queryForObject(sql, params,
                  new BeanPropertyRowMapper<Student>(Student.class));
	} catch (EmptyResultDataAccessException  e) {
		return found;
	} 
	 return found;



	}

	@Override
	public boolean isNameExists(String name) {
		String sql = "SELECT COUNT(name) FROM students Where name= ?";
		int found = getJdbcTemplate().queryForObject(sql, new Object[] {name},Integer.class);
		 if (found ==0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudent(int id) {
		String sql = "DELETE FROM Students Where id=?";
    	int isDeleted= 	getJdbcTemplate().update(sql,id);
    	if(isDeleted==0) {
    		return false;
    	}
    	
    	return true;
		
	}

	@Override
	public void editStudent(Student student) {
		String sql = "Update students SET surname =?, age = ? , email = ? Where name=? ";
		getJdbcTemplate().update(sql,new Object[] {student.getSurname(),student.getAge(),student.getEmail(),student.getName()});
	}

	@Override
	public Student findbyStudentId(int studentId) {
		 Student found = null;
		try {
			 String sql = "SELECT * FROM students WHERE id= ?";
			  Object[] params = new Object[] {studentId};
			 
			  try {
				  found = (Student) getJdbcTemplate().queryForObject(sql, params,
		                  new BeanPropertyRowMapper<Student>(Student.class));
			} catch (EmptyResultDataAccessException  e) {
				return found;
			} 
			 return found;
		} catch (Exception e) {
			System.out.println(e);
		}
		return found;
		
		
		
	}


}
