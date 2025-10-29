package com.nyg.mybatis.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ExceptionAspect {

	@AfterThrowing(pointcut = "execution(* com.nyg.mybatis.service.*.*(..))", throwing = "excep")
	public void logError(JoinPoint jp, Exception excep) {
		log.info("rrrrr 메서중 오류 발생: {} rrrr \n rrrrr {} rrrrr", jp.getSignature(), excep.getMessage());
	}

}
