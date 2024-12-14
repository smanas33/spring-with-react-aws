package com.msahoo.springbootaws.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("execution(* com.msahoo.springbootaws.*.*.*(..))")
    @Around("com.msahoo.springbootaws.aspects.CommonPointCutConfig.tractTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;
        logger.info("Around Aspect - {} method executed in {}", joinPoint, executionDuration);
        return returnValue;
    }
}
