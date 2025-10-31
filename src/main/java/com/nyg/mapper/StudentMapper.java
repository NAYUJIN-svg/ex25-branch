package com.nyg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nyg.domain.Student;

@Mapper
public interface StudentMapper {
	// <select id="findAll" resultType="Student">
	List<Student> findAll();

	Student findById(Long id);

	void insert(Student student);

	void update(Student student);

	void delete(Long id);

}
