package org.closure.course.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.closure.course.dto.ProductDto;
import org.closure.course.entity.Product;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MainAspect {
    @Pointcut("execution(* org.closure.course.service.ProductService.*(..))")
    public void adviceProduct(){}

    @Before("adviceProduct()")  // @After(adviceProduct)  no difference
    public void logData(JoinPoint joinPoint){
        System.out.println("execute : " + joinPoint.getSignature());
        System.out.println("with following params : ");
        for(Object param : joinPoint.getArgs())
        {
            if(param instanceof Product){
                Product value = (Product) param;
                System.out.println(value.toString());
            }else if(param instanceof Integer)
            {
                Integer value = (Integer) param;
                System.out.println(value);
            }
        }
    }

    @AfterReturning(pointcut = "execution(* org.closure.course.service.ProductService.*(..))",returning = "result")
    public void logActualData(JoinPoint joinPoint, Object result)
    {
        System.out.println("execute : " + joinPoint.getSignature());
        System.out.println("with following params : ");
        for(Object param : joinPoint.getArgs())
        {
            if(param instanceof Product){
                Product value = (Product) param;
                System.out.println(value.toString());
            }else if(param instanceof Integer)
            {
                Integer value = (Integer) param;
                System.out.println(value);
            }
        }

        System.out.println("result : ");
        System.out.println(((ProductDto)result).toString());
    }

    @Around("adviceProduct()")
    public Object logDetails(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //before
        System.out.println("before execution");
        Object obj = proceedingJoinPoint.proceed();
        //after
        System.out.println("after execution");
        return obj;
    } 

    @AfterThrowing(pointcut = "execution(* org.closure.course.service.ProductService.*(..))",throwing = "error")
    public void ExceptionAdvice(JoinPoint joinPoint, Throwable error)
    {
        System.out.println("error handled");
        System.out.println(error.getMessage());
    }

}
