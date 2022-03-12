package com.rubick.sunflower.View;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rubick.sunflower.R;
import com.rubick.sunflower.Model.AdviceAPIParser;
import com.rubick.sunflower.Service.PreferenceData;

public class Inspiration extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inspiration);

        textView = findViewById(R.id.inspirationText);
        String text = AdviceAPIParser.ConvertToAdvice(PreferenceData.getText(this));
        textView.setText(text);
    }
}