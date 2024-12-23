package com.spring.core.chap02_2.vehicle;

public class Car {

    //의존 객체 설정
    private Engine engine;


    //생성자 주입 - 생성자를 통해 의존객체를 전달받음
//    public Car(Engine engine) {
//        this.engine = engine;
//    }


    //setter 주입 - setter를 통해 의존객체를 전달받음
    //자동차가 만들어질 때 엔진이 세팅되지 않고
    //나중에 setEngine을 통해 엔진 세팅됨
    public Car() {
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine(){
        engine.start();
        System.out.println("자동차가 달릴 준비가 완료되었습니다.");
    }
}
