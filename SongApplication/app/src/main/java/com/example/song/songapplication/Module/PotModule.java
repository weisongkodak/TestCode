package com.example.song.songapplication.Module;

import com.example.song.songapplication.Bean.Flower;
import com.example.song.songapplication.Bean.Pot;
import com.example.song.songapplication.dagger2.qualifier.FlowerForLily;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 10181198 on 4/18/2017.
 */
@Module   //提供依赖对象的实例
public class PotModule {

    @Provides
    @Singleton
    //@PotForLily
    Pot providesPotForLily(@FlowerForLily Flower flower) {
        // 提供上下文对象
        return new Pot(flower);
    }

//    @Provides
//    @PotForRose
//    Pot providesPotForRose(@FlowerForRose Flower flower) {
//        // 提供上下文对象
//        return new Pot(flower);
//    }
}
