package com.spring.core.chap01;

public class Hotel {

    //레스토랑
    private Restaurant resataurant;
    //헤드쉐프
    private Chef chef;

    //생성자
    public Hotel(Restaurant resataurant, Chef chef) {
        this.resataurant = resataurant;
        this.chef = chef;
    }

    //레스토랑 예약 기능
    public void reserve(){
        System.out.println("레스토랑을 예약합니다.");
        System.out.printf("우리 호텔의 레스토랑은 %s입니다. 그리고 헤드셰프는 %s입니다."
                , resataurant.getClass().getSimpleName()
                , chef.getClass().getSimpleName()
        );
        resataurant.order();
    }

}
