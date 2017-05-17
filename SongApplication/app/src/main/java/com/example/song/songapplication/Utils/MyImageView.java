package com.example.song.songapplication.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView 
{
	public MyImageView(Context context)
	{
		super(context);
	}
	
	public MyImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}
	
	public void setImageFileUrl(String url)
	{
	}
	
	protected void onDraw(Canvas canvas) 
	{
		super.onDraw(canvas);
//		if (imageInfo.width > 0) {
//			canvas.drawBitmap (imageInfo.buffer, 0, imageInfo.width, 0, 0, imageInfo.width, imageInfo.height, imageInfo.hasAlphaChannel, null);
//		}
	}
}
