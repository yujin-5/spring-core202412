package com.spring.core.chap02_2.practice.q2;

import lombok.Setter;

@Setter
public class MusicPlayer {
    private Speaker speaker;

//    public void setSpeaker(speaker speaker) {
//        this.speaker = speaker;
//    }

    public void playMusic(){
        if(speaker == null){
            System.out.println("스피커가 세팅되지 않았습니다.");
            return;
        }
        speaker.playSound();
        System.out.println("음악플레이어에서 음악이 재생됩니다.");
    }


}
