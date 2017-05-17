package com.example.song.songapplication.Api;

import com.example.song.songapplication.Exception.WebAPIException;
import com.example.song.songapplication.OkHttpBaseAPI;

public class CollageAPI extends OkHttpBaseAPI {

    public String getDataTestTask() throws WebAPIException {
        String url = "http://192.168.1.105:8765/";
        url = "http://192.168.1.118:8765/";
        //String result = httpGetTask(url, "getDataTestTask");

        //String result = httpPostImageTask(url, "postDataTestTask");
        return null;
    }

    public String uploadImage(String filePath) throws WebAPIException{
        //the url is test can not connect
        String url = "http://192.168.1.105:8765/";
        url = "http://192.168.1.118:8765/";
        //String result = httpGetTask(url, "getDataTestTask");

        String result = httpPostImageTask(url, "postDataTestTask", filePath);
        return result;
    }
}
