package com.example.jayclark.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Distance extends AppCompatActivity {

    EditText editDistance;
    TextView resultDistance;
    Button buttonDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainthree);

        editDistance = (EditText) findViewById(R.id.edit_distance);
        resultDistance = (TextView) findViewById(R.id.view_distance);
         buttonDistance = (Button) findViewById(R.id.button_distance);

        buttonDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showCalculation(editDistance, resultDistance);
            }
        });

    }

    //public void showKeyboard(View v) {
      //  InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
       // mgr.showSoftInput(editDistance, InputMethodManager.SHOW_IMPLICIT);
    //}
    public void showCalculation(EditText a, TextView b) {
        String value = a.getText().toString();

        int finalValue=Integer.parseInt(value);

        double total = finalValue * 1.60;

        String finalResult = Double.toString(total);

        b.setText(finalResult);


    }

}