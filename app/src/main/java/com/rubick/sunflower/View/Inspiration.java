package com.rubick.sunflower.View;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.rubick.sunflower.Model.Image.CatAPI;
import com.rubick.sunflower.R;
import com.rubick.sunflower.Service.APIParser;
import com.rubick.sunflower.Service.APIUrls;
import com.rubick.sunflower.Service.PreferenceData;

public class Inspiration extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inspiration);

        setItems();
        CatAPI data = APIParser.ConvertToType(PreferenceData.getText(this), CatAPI.class);
        Glide.with(this).load(data.url).into(imageView);
        //textView.setText(data.url);
    }

    private void setItems(){
        textView = findViewById(R.id.inspirationText);
        imageView = findViewById(R.id.inspirationBackground);
    }
}