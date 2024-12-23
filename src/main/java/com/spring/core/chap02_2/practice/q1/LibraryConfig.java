package com.spring.core.chap02_2.practice.q1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LibraryConfig {
    //스프링아, 책 목록을 나 대신 만들어줘라
    @Bean
    public List<Book> books(){
        return List.of(
                new Book("이펙티브 자바","kim"),
                new Book("반지의 제왕","abc"),
                new Book("뽀롱뽀롱 뽀로로","뽈롤로")
        );
    }

    //도서관도 나대신 만들어주고 거기다가 책 좀 넣어줘라
    @Bean
    public Library library(){
        return new Library(books());
    }
}
