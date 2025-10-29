package com.nyg.mybatis.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component

public class LoggingAspect {

	@Before("execution(* com.nyg.mybatis.service.*.*(..))")
	public void logBefore(JoinPoint jp) {
		log.info("MMMMMMMMMMMMMMMM 메서드 실행전: {} MMMMMM", jp.getSignature());
	}

	@AfterReturning(pointcut = "execution(* com.nyg.mybatis.service.*.*(..))", returning = "result")
	public void logAfter(JoinPoint jp, Object result) {
		log.info("WWWWW 메서드 실행 성공 : {} WWWW \n WWWW {} WWWWW", jp.getSignature(), result);
	}

}
