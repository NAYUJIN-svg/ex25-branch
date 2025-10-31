package com.nyg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.nyg.dao.MyStudent;
import com.nyg.domain.Student;
import com.nyg.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	// 전체 조회
	public List<Student> getAllStudents() {
		// 매퍼 오브젝트에게 값을 요청
		return studentMapper.findAll();
	}

	// id 단건 조회
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return studentMapper.findById(id);
	}

	// 안전성 annotation
	@Transactional
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
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

//	public String getMyString() {
//		// TODO Auto-generated method stub
//		return "test";
//	}
//
//	public Integer getIntger() {
//		// TODO Auto-generated method stub
//		return 99;
//	}
//
//	// 자바 방식
//	public MyStudent getStudent() {
//
//		MyStudent myStudent = new MyStudent();
//		myStudent.setName("홍길동");
//		myStudent.setAge(10);
//		return myStudent;
//	}
//
//	public String getStudentName() {
//		// spring 방식
//		MyStudent myStudent2 = new MyStudent();
//		myStudent2.setName("일지매222");
//		myStudent2.setAge(20);
//
//		return myStudent2.getName();
//	}

}
