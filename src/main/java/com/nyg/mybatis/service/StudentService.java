package com.nyg.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nyg.mybatis.domain.Student;
import com.nyg.mybatis.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	// MyBatis가 SELECT * FROM students 결과를 List<Student> 형태로 만들어줌.
	public List<Student> getAllStudents() {

		return studentMapper.findAll();
	}

	public Student getStudent(Long id) {
		return studentMapper.findById(id);
	}

	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		studentMapper.update(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
	}
}
