package com.example.calculus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numbersIds = new int[]{
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine,
        };

        int[] actionsIds = new int[]{
                R.id.plus,
                R.id.minus,
                R.id.times,
                R.id.divide,
                R.id.equal,
                R.id.backspace,
                R.id.clear,
        };

        text = findViewById(R.id.text);
        calculator = new CalculatorModel();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbersIds.length; i++){
            findViewById(numbersIds[i]).setOnClickListener(numberButtonClickListener);
        }
        for (int i = 0; i < actionsIds.length; i++){
            findViewById(actionsIds[i]).setOnClickListener(actionButtonClickListener);
        }
    }
}