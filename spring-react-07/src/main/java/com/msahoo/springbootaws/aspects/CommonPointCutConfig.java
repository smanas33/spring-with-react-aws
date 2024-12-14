package com.msahoo.springbootaws.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {
    @Pointcut("execution(* com.msahoo.springbootaws.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("@annotation(com.msahoo.springbootaws.annotations.TrackTime)")
    public void tractTimeAnnotation() {}
}
