package com.nyg.mybatis.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentTest {

	private Long id;
	private String name;
	private String email;
	private Integer age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
