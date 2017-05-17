package com.example.song.songapplication.Utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Base64URL {
	public static String encode(String val) {
		if(val == null || val.length() == 0){
			return null;
		}
		try {
			byte[] encode = val.getBytes("UTF-8");
			return encode(encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encode(byte[] bytes){
		if(bytes == null || bytes.length == 0){
			return null;
		}
		
		try {
			String newVal = new String(Base64.encode(bytes, 0, bytes.length, Base64.DEFAULT), "UTF-8");
			int lastEqualIndex = newVal.lastIndexOf("=");
			while(lastEqualIndex != -1){
				newVal = newVal.substring(0, newVal.length()-2);
				lastEqualIndex = newVal.lastIndexOf("=");
			}
			return newVal.replace('+', '-').replace('/', '_');
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
		return null;
	}
	
	public static String decode(String val){
		if (val == null || val.length() == 0) { 
            return null; 
        } 
		val = addBase64Padding(val.replace('-', '+').replace('_', '/'));
        try { 
            byte[] encode = val.getBytes("UTF-8"); 
            return decode(encode); 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        } 
        return null;
	}
	
	public static String decode(byte[] bytes){
		try {
			return new String(Base64.decode(bytes, 0, bytes.length, Base64.DEFAULT), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	// add pad bytes to the end of an unpadded Base64 string
	private static String addBase64Padding(String val){
		// if val is really an unpadded Base64 string, then (val.Length % 4) should be 0, 2, or 3 (never 1).
		switch (val.length() % 4) {
		case 2:
			return val + "==";
		case 3: 
			return val + "=";
		default:
			return val;
		}
	}
}
