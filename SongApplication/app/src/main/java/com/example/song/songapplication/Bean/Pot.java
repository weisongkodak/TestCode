package com.example.song.songapplication.Bean;

/**
 * Created by 10181198 on 4/20/2017.
 */

public class Pot {

    private Flower flower;

    public Pot(Flower flower) {
        this.flower = flower;
    }

    public String show() {
        return flower.whisper();
    }
}