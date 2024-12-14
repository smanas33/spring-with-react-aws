package com.msahoo.springbootaws.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.msahoo.springbootaws.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.msahoo.springbootaws.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - Method is called - {}", joinPoint);
    }

    @AfterThrowing(pointcut = "com.msahoo.springbootaws.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
        throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(pointcut = "com.msahoo.springbootaws.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
            returning = "result")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Aspect - {} has returned {}", joinPoint, result);
    }

}
