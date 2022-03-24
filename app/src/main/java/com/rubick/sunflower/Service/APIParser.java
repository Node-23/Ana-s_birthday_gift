package com.rubick.sunflower.Service;

import android.os.AsyncTask;

import com.google.gson.Gson;

public class APIParser {
    public static <T> T ConvertToType(String data, Class<T> apiType){
        Gson gson = new Gson();
        data = RemoveObjectMark(data);
        return gson.fromJson(data, apiType);
    }
    private static String RemoveObjectMark(String data){
        if(!data.startsWith("[")){
            return data;
        }
        StringBuilder sb = new StringBuilder(data);
        sb.deleteCharAt(data.length() - 1);
        sb.deleteCharAt(0);
        return data = sb.toString();
    }
}
