package com.pluralsight.springaop.example3;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

	@Around("execution(* *.*Passenger(..))")
	public Object log (ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        logger.info("Call method " + methodName + " with arg " + methodArgs[0]);
        Object result = thisJoinPoint.proceed();
        logger.info("Method " + methodName + " returns " + result);
        return result;
	}

}