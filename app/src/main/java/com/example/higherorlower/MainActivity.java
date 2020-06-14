package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editText;
    private int number;
    private int guess;
    private TextView text,lastGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        lastGuess = findViewById(R.id.textView6);
        lastGuess.setText("---");
        number = new Random().nextInt(20)+1;
        Log.d(TAG, "onCreate: "+number);
        text = findViewById(R.id.textView4);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    guess = Integer.parseInt(editText.getText().toString());
                }catch (Exception e){
                    text.setText("Invalid Entry");
                    text.setTextColor(Color.RED);
                }
                if(guess>20 | guess<1){
                    text.setText("The Number is Between 1 and 20");
                    text.setTextColor(Color.MAGENTA);
                }
                else if(number == guess){
                    text.setText("Congrats Right Guess");
                    text.setTextColor(Color.GREEN);
                }
                else if(number-guess<=2 & number-guess>0 ){
                    text.setText("You are a little behind");
                    text.setTextColor(Color.MAGENTA);
                }
                else if(guess-number<=2 & guess-number>0){
                    text.setText("You are a little ahead");
                    text.setTextColor(Color.MAGENTA);
                }
                else{
                    text.setText("Wrong Guess");
                    text.setTextColor(Color.rgb(230,12,100));
                }
                editText.setText("");
                lastGuess.setText(String.valueOf(guess));
            }
        });
    }
}