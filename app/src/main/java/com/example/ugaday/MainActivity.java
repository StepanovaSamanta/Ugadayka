package com.example.ugaday;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    protected boolean gameFinished;
    private int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }
    public void onClick(View view)
    {
        System.out.println(guess);
        if(!gameFinished)
        {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > guess)
            {
                tvInfo.setText("Перелет!");
            }
            if (inp < guess)
            {
                tvInfo.setText("Недолет!");
            }
            if (inp == guess)
            {
                tvInfo.setText("В точку!");
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение:");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished=false;
        }
        etInput.setText("");
    }
}