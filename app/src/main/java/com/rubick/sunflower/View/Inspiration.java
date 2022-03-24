package com.rubick.sunflower.View;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rubick.sunflower.Model.Image.DogAndCatAPI;
import com.rubick.sunflower.Model.Text.LoveQuoteAPI;
import com.rubick.sunflower.Model.Text.RandomQuotesAPI;
import com.rubick.sunflower.R;
import com.rubick.sunflower.Service.APIParser;
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

//        DogAndCatAPI data = APIParser.ConvertToType(PreferenceData.getText(this), DogAndCatAPI.class);
//        Glide.with(this)
//                .load(data.url)
//                .placeholder(R.drawable.load_anim)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .centerCrop()
//                .into(imageView);
        RandomQuotesAPI data = APIParser.ConvertToType(PreferenceData.getText(this), RandomQuotesAPI.class);
        textView.setText(data.Quote);
    }

    private void setItems(){
        textView = findViewById(R.id.inspirationText);
        imageView = findViewById(R.id.inspirationBackground);
    }
}