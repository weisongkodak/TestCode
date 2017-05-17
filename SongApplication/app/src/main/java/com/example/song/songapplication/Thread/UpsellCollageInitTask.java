package com.example.song.songapplication.Thread;

import android.content.Context;
import android.os.AsyncTask;

import com.example.song.songapplication.Api.CollageAPI;
import com.example.song.songapplication.Exception.WebAPIException;
import com.example.song.songapplication.Interfaces.TaskComplatedListener;

/**
 * test class.
 */
public class UpsellCollageInitTask extends AsyncTask<Void, Void, Object> {
    private String jobId;
    private Context context;
    private boolean cancel = false;//if cancel the task;
    private String filePath;
    private TaskComplatedListener listener;

    public UpsellCollageInitTask(Context context, String filePath, TaskComplatedListener listener) {
        this.context = context;
        this.filePath = filePath;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Void... params) {
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CollageAPI collageAPI = new CollageAPI();
            collageAPI.uploadImage(filePath);

        } catch (WebAPIException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        listener.onCompleted(result);
    }


    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }


}
