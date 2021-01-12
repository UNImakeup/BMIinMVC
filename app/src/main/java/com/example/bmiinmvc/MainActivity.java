package com.example.bmiinmvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText height, weight;
    TextView answer;
    Button calculate;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implementation of BMI calculator

        height =(EditText) findViewById(R.id.height);
        weight =(EditText) findViewById(R.id.weight);
        answer=(TextView) findViewById(R.id.answer);
        calculate=(Button) findViewById(R.id.calculate);
        next = findViewById(R.id.button);

        final MainActivityViewModel viewModel =  new ViewModelProvider(this).get(MainActivityViewModel.class); //Skal sætte dependencies. Gjort og tror et er sådan.
        answer.setText(viewModel.getBmi()); //Skal sættes lig BMI

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kan så fjerne udkommentering på nedenstående og nederste settext og udkommentere de fire linjer med viewmodel,
                // for at vise at den ikke beholder det når man vender skærmen.
                //BMImodel bmImodel = BMImodel.getInstance(height.getText().toString(), weight.getText().toString());

                //Error message if nothing typed
                String str1 = weight.getText().toString();
                String str2 = height.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    weight.setError("You need to enter your weight in order to calculate your BMI");
                    weight.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    height.setError("You need to enter your height in order to calculate your BMI");
                    height.requestFocus();
                    return;
                }

                viewModel.setBmi(str2, str1);
                answer.setText(viewModel.getBmi());

                //answer.setText(bmImodel.displayBMI());



            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextpage = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(nextpage);
            }
        });


    }
}