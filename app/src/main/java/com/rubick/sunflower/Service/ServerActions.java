package com.rubick.sunflower.Service;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.rubick.sunflower.Model.Header;
import com.rubick.sunflower.View.Inspiration;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerActions extends AsyncTask<Objects[],Void, String>{
    public static void GetRequest(String url, Context context) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, IOException e) {
                e.printStackTrace();
                String mMessage = e.getMessage();
                Log.w("FAILURE_DATA", mMessage);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String data = Objects.requireNonNull(response.body()).string();
                if(response.isSuccessful()){
                    PreferenceData.saveText(context, data);
                }
                Log.d("RESPONSE_DATA", data);
            }
        });
    }

    public static void GetRequestWithHeaders(String url, Context context, List<Header> headers) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(headers.get(0).getName(), headers.get(0).getValue())
                .addHeader(headers.get(1).getName(), headers.get(1).getValue())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, IOException e) {
                e.printStackTrace();
                String mMessage = e.getMessage();
                Log.w("FAILURE_DATA", mMessage);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String data = Objects.requireNonNull(response.body()).string();
                if(response.isSuccessful()){
                    PreferenceData.saveText(context, data);
                    Intent inspiration = new Intent(context, Inspiration.class);
                    context.startActivity(inspiration);
                }
                Log.d("RESPONSE_DATA", data);
            }

        });
    }

    @Override
    protected String doInBackground(Objects[]... objects) {
        return null;
    }
}
