package com.example.song.songapplication.okHttp.callback;

/**
 * Created by song on 4/8/2016.
 */
public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
