package com.example;

import sun.misc.BASE64Decoder;

public class MyClass {
    public static void main(String[] args) {
        String tempStr = "eyJleHAiOjE0ODc3NDcyODMsIm5iZiI6MTQ4NzY2MDg4MywiaXNzIjoiaHR0cDovL2tvZGFrYWxhcmlzLmNvbS9LQVVzZXJBY2NvdW50IiwiYXVkIjoiTU9CSUxFX0FORFJPSUQiLCJpYXQiOjE0ODc2NjA4ODMsImF1dGhfdGltZSI6MTQ4NzY2MDg4Mywib2lkIjoiZDkwNWI5NWEtYThmZi00ZWE4LWExZjctMjY4YmE2NTc4ZTk3IiwiY291bnRyeSI6IlVTIiwiZW1haWxzIjpbIndlaXNvbmdAa29kYWsuY29tIl0sInZlcmlmaWVkIjoiZmFsc2UiLCJjcm1pZCI6IndlaXNvbmdAa29kYWsuY29tIn0";
        String tempStrNew = "";
        int stringSize = tempStr.length();
        if (stringSize % 4 != 0) {
            int padlen = 4 - stringSize % 4;
            tempStrNew = tempStr;
            for (int i =0 ; i < padlen; i++){
                tempStrNew += "=";
            }
        }
        System.out.println(tempStr);
        System.out.println(tempStrNew);

        System.out.println(getFromBase64(tempStr));
        System.out.println(getFromBase64(tempStrNew));
    }

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
