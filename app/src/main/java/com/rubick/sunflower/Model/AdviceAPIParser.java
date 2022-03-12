package com.rubick.sunflower.Model;

import com.google.gson.Gson;

public class AdviceAPIParser {
    //Object data = gson.fromJson(dataString, Object.class);
    public static String ConvertToAdvice(String data){
        Gson gson = new Gson();
        Root json = gson.fromJson(data, Root.class);
        String text = json.slip.advice;
        return text;
    }
}

class Slip{
    public int id;
    public String advice;
}

class Root{
    public Slip slip;
}

