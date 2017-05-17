package com.example.song.songapplication.dagger2;

import com.example.song.songapplication.Bean.Pot;
import com.example.song.songapplication.Module.PotModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 10181198 on 4/18/2017.
 */
/*@Singleton
@Subcomponent(modules = PotModule.class)
public interface PotComponent {
    MainComponent plus();
}*/
@Singleton
@Component(modules = PotModule.class, dependencies = FlowerComponent.class)
public interface PotComponent {
    Pot getPot();
}