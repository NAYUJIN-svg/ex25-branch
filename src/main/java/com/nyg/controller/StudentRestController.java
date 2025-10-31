package com.nyg.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.nyg.dao.MyStudent;
import com.nyg.domain.Student;
import com.nyg.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {
	// 객체주입 (롬복적용)
	private final StudentService studentService;

	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();
	}

// http://localhost:8085/api/students/29
	@GetMapping("/{id}")
	public ResponseEntity<Student> detail(@PathVariable Long id) {
		Student student = studentService.getStudent(id);

		return ResponseEntity.ok(student);
	}

	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {
		// TODO: process POST request
		studentService.createStudent(student);
		return ResponseEntity.ok(student);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		// 꼭 set id를 하고 값을 찾아온다.
		student.setId(id);
		studentService.updateStudent(student);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
	}

//	@GetMapping
//	public String list() {
//
//		return studentService.getMyString();
//	}

//	@GetMapping
//	public String list() {
//
//		return studentService.getIntgerString();

//	@GetMapping
//	public String myStudent() {
//		return studentService.getStudentName();
//	}

	// list 전체 조회

}
