package com.example.booksellersystem.app;

import com.example.booksellersystem.mapper.RecordMapper;
import com.example.booksellersystem.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

/*预留部分*/
@Aspect
@Component
@Slf4j
public class MyAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RecordMapper recordMapper;

   /* @Before("execution(public * com.example.booksellersystem.cont" +
            "roller..*(..))")*/
    @After("@annotation(com.example.booksellersystem.util.MyLog)")
    public void after(JoinPoint joinPoint){

        //获取类型
        String url = request.getRequestURI().toString();
        int jud = url.contains("/user")?1:2;
        //获取账号
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt,jud);
        String contact = (String) claims.get("account");
        String type = (String) claims.get("type");
        String methodName = joinPoint.getSignature().getName();
        String ClassName = joinPoint.getTarget().getClass().getSimpleName();

        LocalDateTime intime = LocalDateTime.now();

        recordMapper.insert(contact,type,methodName,intime,ClassName);
        System.out.println("try to login in");
    }
   /* @After("execution(public * com.example.booksellersystem.cont" +
            "roller.LoginController.*(..))")
    public void after(){
        System.out.println("successes to login in");
    }*/

    public void around(){

    }
    public void afterReturning(){}
}
