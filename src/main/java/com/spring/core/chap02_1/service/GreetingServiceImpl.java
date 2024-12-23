package com.spring.core.chap02_1.service;

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
//        return "Hello, " + name + "!";
//        return String.format("Hello, %s!", name);
        return "Hello, %s!".formatted(name); //자바 15이후
    }
}
