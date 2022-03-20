package com.rubick.sunflower.View;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        CatAPI data = APIParser.ConvertToType(PreferenceData.getText(this), CatAPI.class);
        Glide.with(this)
                .load(data.url)
                .placeholder(R.drawable.load_anim)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(imageView);
        //textView.setText(data.url);

        //android:adjustViewBounds="true"
        //        android:scaleType="fitXY"
    }

    private void setItems(){
        textView = findViewById(R.id.inspirationText);
        imageView = findViewById(R.id.inspirationBackground);
    }
}