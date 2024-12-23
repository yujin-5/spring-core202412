package com.spring.core.chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void hotel(){
//        Hotel hotel = new Hotel();

        HotelManager manager = new HotelManager(); //매니저 만들기
        Hotel hotel = manager.hotel(); //매니저에게 호텔달라고 하기

        hotel.reserve();

    }
}