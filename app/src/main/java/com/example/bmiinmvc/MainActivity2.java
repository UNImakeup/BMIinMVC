package com.example.bmiinmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BMImodel sameModel = BMImodel.getInstance("same", "model"); //Måske burde man ikke gøre sådan, fordi man skal skrive parametre hver gang.

        TextView displayBMI = findViewById(R.id.textView);
        TextView randomInt = findViewById(R.id.textView2);

        displayBMI.setText(sameModel.displayBMI());

        Random a = new Random();
        int b = a.nextInt(1000);

        randomInt.setText("" + b);

    }
}