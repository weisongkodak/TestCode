package com.example.song.songapplication.okHttp.builder;


import com.example.song.songapplication.okHttp.request.PostStringRequest;
import com.example.song.songapplication.okHttp.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by song on 4/8/2016.
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>
{
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }


}
