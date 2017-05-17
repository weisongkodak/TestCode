package com.example.song.songapplication.okHttp.builder;


import com.example.song.songapplication.okHttp.OkHttpUtils;
import com.example.song.songapplication.okHttp.request.OtherRequest;
import com.example.song.songapplication.okHttp.request.RequestCall;

/**
 * Created by song on 4/8/2016.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
