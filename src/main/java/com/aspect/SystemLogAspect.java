package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by carlwang on 5/14/16.
 */

@Aspect
@Component
public class SystemLogAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.aspect.annotation.LogAnnotation)")
    public void logAspect() {

    }

    @Before(value = "logAspect()")
    public void deBefore(JoinPoint joinPoint) {
        LOGGER.debug("Begin to before method.");
        LOGGER.debug("The target name {}.", joinPoint.getTarget().getClass().getName());
        LOGGER.debug("The target signature is {}.", joinPoint.getSignature().getName());
        LOGGER.debug("End to before method.");
        joinPoint.getTarget();
    }
}
