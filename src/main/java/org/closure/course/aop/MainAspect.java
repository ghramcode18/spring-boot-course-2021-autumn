package org.closure.course.aop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

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

    FileReader fr;
    FileWriter fw;

    @PostConstruct
    public void init(){
        Path path = Paths.get("logs/ProductLog.log");
        try {
          fr = new FileReader(path.toFile());
            fw = new FileWriter(path.toFile(),true);
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }

    }
    @Before("adviceProduct()")  // @After(adviceProduct)  no difference
    public void logData(JoinPoint joinPoint) throws IOException{
        fw.write("execute : " + joinPoint.getSignature());
        fw.write("with following params : ");
        for(Object param : joinPoint.getArgs())
        {
            if(param instanceof Product){
                Product value = (Product) param;
                fw.write(value.toString());
            }else if(param instanceof Integer)
            {
                Integer value = (Integer) param;
                fw.write(value);
            }
        }
        fw.flush();
        int c = -1;
        String resultLog = "";
        while ((c = fr.read())!= -1) {
            resultLog = resultLog+((char)c);
        }
        System.out.println(resultLog);
    }

    @AfterReturning(pointcut = "execution(* org.closure.course.service.ProductService.*(..))",returning = "result")
    public void logActualData(JoinPoint joinPoint, Object result) throws IOException
    {
        fw.write("execute : " + joinPoint.getSignature());
        fw.write("with following params : ");
        for(Object param : joinPoint.getArgs())
        {
            if(param instanceof Product){
                Product value = (Product) param;
                fw.write(value.toString());
            }else if(param instanceof Integer)
            {
                Integer value = (Integer) param;
                fw.write(value);
            }
        }

        fw.write("result : ");
        fw.write(((ProductDto)result).toString());
        fw.flush();
    }

    @Around("adviceProduct()")
    public Object logDetails(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //before
        fw.write("before execution");
        Object obj = proceedingJoinPoint.proceed();
        //after
        fw.write("after execution");
        fw.flush();
        return obj;
    } 

    @AfterThrowing(pointcut = "execution(* org.closure.course.service.ProductService.*(..))",throwing = "error")
    public void ExceptionAdvice(JoinPoint joinPoint, Throwable error) throws IOException
    {
        fw.write("error handled");
        fw.write(error.getMessage());
        fw.flush();

    }

}
