package com.example.song.songapplication.Exception;


import com.example.song.songapplication.Utils.Log;

import java.io.Serializable;

/**
 * Exception for Web API
 * @author Robin
 *
 */
public class WebAPIException extends Exception{
	private static final long serialVersionUID = 1L;
	private static final String TAG = "RssWebServiceException";
	
	public static final int TYPE_SERVER = 1;
	public static final int TYPE_NETWORK_TIMEOUT = 2;
	public static final int TYPE_NETWORK = 3;
	public static final int TYPE_APP_OBSOLETE = 4;
	public static final int TYPE_CUSTOM = 100;
	
	private int type;
	private String code = "";
	private String message = "";
	private transient Exception exception;
	private Serializable data;
	
	protected WebAPIException(int type, String code, String message, Exception exception){
		this.type = type;
		this.code = code;
		this.message = message;
		this.exception = exception;
	}
	
	public int getType(){
		return type;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getMessage(){
		return message;
	}
	
	public Exception getException(){
		return exception;
	}
	
	public boolean isNetworkWeak(){
		return type == TYPE_NETWORK_TIMEOUT || type == TYPE_NETWORK;
	}
	
	public boolean isServerError(){
		return type == TYPE_SERVER;
	}
	
	public boolean isAppObsolete() {
		return type == TYPE_APP_OBSOLETE;
	}
	
	public boolean isCustomError() {
		return type == TYPE_CUSTOM;
	}
	
	public void setData(Serializable data) {
		this.data = data;
	}
	
	public Serializable getData() {
		return data;
	}
	
	@Override
	public void printStackTrace() {
		StringBuilder s = new StringBuilder();
		if(isNetworkWeak()){
			s.append("Network weak error");
		}
		
		if(isServerError()){
			s.append("Server Error\n");
			if(message != null && message.length()>0){
				s.append(message);
			}
		}
		Log.e(TAG, s.toString());
		super.printStackTrace();
	}
	
	public static WebAPIException networkTimeout(Exception e){
		return new WebAPIException(TYPE_NETWORK_TIMEOUT, "", "",null);
	}
	
	public static WebAPIException network(Exception e){
		return new WebAPIException(TYPE_NETWORK, "", "", e);
	}
	
	public static WebAPIException server(String code, String message){
		return new WebAPIException(TYPE_SERVER, code, message,null);
	}
	
	public static WebAPIException appObsolete(String redirectUrl) {
		return new WebAPIException(TYPE_APP_OBSOLETE, "", redirectUrl, null);
	}
	
	public static WebAPIException customError(String code, String message, Exception e) {
		return new WebAPIException(TYPE_CUSTOM, code, message, e);
	}
	
	public static WebAPIException customError(String code) {
		return customError(code, "", null);
	}
	
}
