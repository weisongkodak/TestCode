package com.example.song.songapplication.Module;

import com.example.song.songapplication.Bean.Flower;
import com.example.song.songapplication.Bean.Lily;
import com.example.song.songapplication.Bean.Rose;
import com.example.song.songapplication.dagger2.qualifier.FlowerForLily;
import com.example.song.songapplication.dagger2.qualifier.FlowerForRose;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 10181198 on 4/18/2017.
 */
@Module   //提供依赖对象的实例
public class FlowerModule {

    @Provides
    @FlowerForRose
    Flower providePersonRose() {

        return new Rose();
    }

    @Provides
    @FlowerForLily
    Flower providePersonLisy() {

        return new Lily();
    }
}
