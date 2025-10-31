package com.nyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyg.domain.Student;
import com.nyg.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	// 객체주입
	private final StudentService studentService;

	// 학생전체리스트 조회
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		// 화면의 경로와 이름
		return "student/list";
	}

	// form화면[새학생등록] : 한명의 학생을 등록하기 위한 빈입력화면
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}

	// form[학생등록->저장] : 한명의 학생을 등록 처리하기
	@PostMapping
	public String create(@ModelAttribute Student student) {
		studentService.createStudent(student);

		return "redirect:/students";
	}

	// list화면[수정버튼] -> form화면: 한명의 학생의 정보를 보여준다.
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "student/form";
	}

	// 수정처리
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		// TODO: process POST request
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		// TODO: process POST request
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
