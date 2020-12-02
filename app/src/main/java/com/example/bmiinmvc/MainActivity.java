package com.example.bmiinmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Height, Weight;
    TextView answer;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implementation of BMI calculator

        Height=(EditText) findViewById(R.id.Height);
        Weight=(EditText) findViewById(R.id.Weight);
        answer=(TextView) findViewById(R.id.answer);
        calculate=(Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BMImodel bmImodel = new BMImodel(Height.getText().toString(), Weight.getText().toString());
                float bmi = BMImodel.calculateBMI();

                //Error message if nothing typed
                String str1 = Weight.getText().toString();
                String str2 = Height.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    Weight.setError("You need to enter your weight in order to calculate your BMI");
                    Weight.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    Height.setError("You need to enter your height in order to calculate your BMI");
                    Height.requestFocus();
                    return;
                }

                answer.setText(BMImodel.displayBMI(bmi));


            }
        });


    }
}