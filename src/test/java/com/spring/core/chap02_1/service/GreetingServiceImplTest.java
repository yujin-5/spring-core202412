package com.spring.core.chap02_1.service;

import com.spring.core.chap02_1.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceImplTest {

    @Test
    void test(){
        //기존 방식(스프링 사용 전)
//        GreetingServiceImpl greetingService = new GreetingServiceImpl();
//        String greet = greetingService.greet("말포이");
//        System.out.println("greet = " + greet);

        //스프링 사용
        //스프링의 관리 컨테이너인 ApplicationContext를 사용
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = context.getBean(GreetingService.class);
        String greet = greetingService.greet("말포이");
        System.out.println("greet = " + greet);

    }

}