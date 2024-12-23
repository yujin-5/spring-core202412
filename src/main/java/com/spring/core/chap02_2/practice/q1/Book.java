package com.spring.core.chap02_2.practice.q1;

import lombok.*;

//@Data //편리하지만 세밀한 제어 불가능 -> 실무에선 사용 안 함
@Setter @Getter
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 초기화 생성자
@ToString
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;



}
