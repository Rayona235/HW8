package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button open;
    private Integer first, second;
    private Boolean isOperationClick;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        open = findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("result",textView.getText().toString());
                startActivity(intent);
            }
        });

        // 12 + 21 = 33
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                open.setVisibility(View.INVISIBLE);
                //нажал на единицу
                if (textView.getText().toString().equals("0") || isOperationClick){
                    textView.setText("1");
                }else {
                    textView.append("1");
                }
                break;
            case R.id.btn_two:
                open.setVisibility(View.INVISIBLE);
                //нажал на двойку
                if (textView.getText().toString().equals("0") || isOperationClick){
                    textView.setText("2");
                }else {
                    textView.append("2");
                }
                break;
            case R.id.btn_clear:
                open.setVisibility(View.INVISIBLE);
                //нажал на очищение
                textView.setText("0");
                first = 0;
                second = 0;
                break;
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                open.setVisibility(View.INVISIBLE);
                //нажал на плюс
                //12
                first = Integer.valueOf(textView.getText().toString());
                break;
            case R.id.btn_equal:
                open.setVisibility(View.VISIBLE);
                //нажал на равно
                //21
                second = Integer.valueOf(textView.getText().toString());
                //       33    =   12  +  21
                Integer result = first + second;
                textView.setText(result.toString());
                break;
        }
        isOperationClick = true;
    }
}