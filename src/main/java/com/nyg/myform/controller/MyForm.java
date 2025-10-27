package com.nyg.myform.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyg.myform.dto.ArticleRequest;

public class MyForm {
	// 웹주소창에 테스트 가능, Form에 가능
//	http://localhost:8010/article-get?title=제목입니다&content=내용입니다
	@GetMapping("/article-get")
	public String articleGet(@RequestParam String title, @RequestParam String content) {
		String result = "제목: " + title + "\n" + "<br>내용: " + content;
		return result;
	}

//	Form화면 테스트 가능
//	http://localhost:8010/article-post
	@PostMapping("/article-post")
	public String articlePost(@ModelAttribute ArticleRequest request) {
		String result = "제목: " + request.title() + "<br>내용: " + request.content();
		return result;
	}

//	포스트맨으로 테스트하세요
//	http://localhost:8010/article-postman
	@PostMapping("/article-postman")
	public String articlePostman(@RequestBody ArticleRequest request) {
		String result = "제목: " + request.title() + "\n내용: " + request.content();
		return result;
	}

//	Form화면 테스트 가능, 포스트맨 테스트 가능
//	http://localhost:8010/article-auto
	@PostMapping("/article-auto")
	public String articleAuto(ArticleRequest request) {
		String result = "제목: " + request.title() + "\n내용: " + request.content();
		return result;
	}

}
