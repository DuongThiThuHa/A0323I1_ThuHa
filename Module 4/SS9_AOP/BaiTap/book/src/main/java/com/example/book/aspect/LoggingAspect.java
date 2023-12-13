package com.example.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static long visitors = 0;
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution (* com.example.book.service.IBookService.*(..))")
    public void IBookService() {
    }

    ;

    @Before("IBookService()")
    public void writeLogBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("======== Before call method: " + methodName);
    }

    @Around("execution (* com.example.book.service.IBookService.*(..))")
    public Object writeLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("======== Around call method: before " + methodName);
        Object result = joinPoint.proceed();
        logger.info("======== Around call method: after " + methodName);
        return result;
    }
}
