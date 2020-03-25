package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

//	private List<Student> list = new ArrayList<Student>();
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public String insert(Student student) {
		String sqlInsert = "insert into student values(?,?)";
		int result = jdbc.update(sqlInsert, student.getId(), student.getName());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		if (list.add(student)) {
//			return "SUCCESS";
//		} else {
//			return "FAIL";
//		}
	}

	@Override
	public String delete(Student student) {
		String sqlDelete = "delete from student where id = ?";
		int result = jdbc.update(sqlDelete, student.getId());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		for (Student s1 : list) {
//			if (s1.getId().equals(student.getId())) {
//				list.remove(s1);
//				return "SUCCESS";
//			}
//		}
//		return "FAILED";
	}

	@Override
	public String update(Student student) {
		String sqlUpdate = "update student set name = ? where id = ?";
		int result = jdbc.update(sqlUpdate, student.getName(), student.getId());
		if(result == 1) {
			return "SUCCESS";
		}else {
			return "FAILED";
		}
//		for (Student s1 : list) {
//			if (s1.getId().equals(student.getId())) {
//				s1.setName(student.getName());
//				return "SUCCESS";
//			}
//		}
//		return "FAILED";
	}
	@Override
	public List<Student> getAll() {
		String sql = "select * from student";
		List<Student> result = jdbc.query(sql, (rs, RowMapper) ->
									new Student(rs.getString(1), rs.getString(2)));
		return result;
//		System.out.println(list);
//		return list;
	}
}
