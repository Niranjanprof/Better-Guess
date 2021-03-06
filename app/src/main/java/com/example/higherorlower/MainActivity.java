package com.example.higherorlower;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editText;
    private int number;
    private int guess;
    private int choice;
    private TextView text, lastGuess, numberOfGuess;
    private Button reset,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        lastGuess = findViewById(R.id.textView6);
        numberOfGuess = findViewById(R.id.textView7);
        reset = findViewById(R.id.reset);
        text = findViewById(R.id.textView4);
        button =findViewById(R.id.button);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 5;
                numberOfGuess.setText(String.valueOf(choice));
                number = new Random().nextInt(20) + 1;
                lastGuess.setText("---");
                button.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                reset.setVisibility(View.GONE);
                reset.setText("RETRY");
                text.setText("");
                text.setVisibility(View.VISIBLE);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice--;
                numberOfGuess.setText(String.valueOf(choice));
                try {
                    guess = Integer.parseInt(editText.getText().toString());
                } catch (Exception e) {
                    text.setText("Invalid Entry");
                    text.setTextColor(Color.RED);
                }
                if (guess > 20 | guess < 1) {
                    text.setText("The Number is Between 1 and 20");
                    text.setTextColor(Color.MAGENTA);
                } else if (number == guess) {
                    text.setText("Congrats Right Guess");
                    text.setTextColor(Color.GREEN);
                    button.setEnabled(false);
                } else if (number - guess <= 2 & number - guess > 0) {
                    text.setText("You are a little behind");
                    text.setTextColor(Color.MAGENTA);
                } else if (guess - number <= 2 & guess - number > 0) {
                    text.setText("You are a little ahead");
                    text.setTextColor(Color.MAGENTA);
                } else {
                    text.setText("Wrong Guess");
                    text.setTextColor(Color.rgb(230, 12, 100));
                }
                editText.setText("");
                lastGuess.setText(String.valueOf(guess));
                if(!(button.isEnabled())){
                    button.setEnabled(true);
                    button.setVisibility(View.GONE);
                    reset.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.INVISIBLE);
                }
                if (choice == 0 ) {
                    button.setVisibility(View.GONE);
                    reset.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.INVISIBLE);
                    text.setText("");
                }
            }
        });
    }
}