package com.rubick.sunflower.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rubick.sunflower.Model.Header;
import com.rubick.sunflower.R;
import com.rubick.sunflower.Service.APIUrls;
import com.rubick.sunflower.Service.RapidApiHeaders;
import com.rubick.sunflower.Service.ServerActions;
import com.rubick.sunflower.Service.buttonPhrases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Home extends AppCompatActivity {
    private Button topButton;
    private Button bottomButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        setItems();
        setButtonsText();
    }

    private void setItems(){
        topButton = findViewById(R.id.topButton);
        bottomButton = findViewById(R.id.bottomButton);

        topButton.setOnClickListener(v -> {
            List<Header> headers = new ArrayList<>();
            headers.add(RapidApiHeaders.RandomQuoteAPI);
            headers.add(RapidApiHeaders.Key);
            ServerActions.GetRequestWithHeaders(APIUrls.RandomQuoteAPI, this, headers);

        });

        bottomButton.setOnClickListener(v -> {
            ServerActions.GetRequest(APIUrls.DogAPI, this);
            Intent inspiration = new Intent(this, Inspiration.class);
            startActivity(inspiration);
        });
    }

    private void setButtonsText(){
        int firstNumber = randomNumber();
        int secondNumber = randomNumber(firstNumber);

        topButton.setText(buttonPhrases.getIndexPhrases(firstNumber));
        bottomButton.setText(buttonPhrases.getIndexPhrases(secondNumber));
    }

    private int randomNumber(){
        Random rand = new Random();
        int max = 10;
        int min = 1;
        return rand.nextInt((max - min) + 1) + min;
    }

    private int randomNumber(int out){
        Random rand = new Random();
        int max = 10;
        int min = 1;
        int random;
        do{
            random = rand.nextInt((max - min) + 1) + min;
        }while(random == out);

        return random;
    }
}