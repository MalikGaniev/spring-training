package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

   Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

 //  @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
 //   public void myPointcut(){}

  //  @Before("myPointcut()")
   // public void log(){
    //   logger.info("Info log........");
 //  }

 //   @Before("execution(* com.cydeo.controller.CourseController.*(..))")
 //   public void log(){
  //      logger.info("Info log........");
    //}

 /*   @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    public void courseRepositoryFindBYIdPC(){}

    @Before("courseRepositoryFindBYIdPC()")
    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
        logger.info("Before -> Method: {},Arguments: {}, Target: {}", joinPoint.getSignature(),joinPoint.getArgs(),joinPoint.getTarget());

    }*/
 @Pointcut("within(com.cydeo.controller..*)")
public void anyControllerOperation(){}
    @Pointcut("@within(org.springframework.stereotype.Service)")
public void anyServiceOperation(){}

    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
     logger.info("Before -> Method: {},Arguments: {}, Target: {}", joinPoint.getSignature(),joinPoint.getArgs(),joinPoint.getTarget());
    }

}
