package com.example.song.songapplication.dagger2;

import com.example.song.songapplication.Bean.Flower;
import com.example.song.songapplication.Module.FlowerModule;
import com.example.song.songapplication.dagger2.qualifier.FlowerForLily;
import com.example.song.songapplication.dagger2.qualifier.FlowerForRose;

import dagger.Component;

/**
 * Created by 10181198 on 4/18/2017.
 */
/*@Component(modules = {FlowerModule.class})  // 作为桥梁，沟通调用者和依赖对象库
public interface FlowerComponent {

    PotComponent plus(PotModule potModule);
}*/

@Component(modules = FlowerModule.class)
public interface FlowerComponent {
    @FlowerForRose
    Flower getRoseFlower();

    @FlowerForLily
    Flower getLilyFlower();
}