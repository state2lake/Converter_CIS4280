package com.example.jayclark.converter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Temperature extends AppCompatActivity {
    EditText titleTemperature;
    EditText editTemperature;
    TextView resultTemperature;
    Button   buttonTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);

        titleTemperature = (EditText) findViewById(R.id.title_temperature);
        editTemperature = (EditText) findViewById(R.id.edit_temperature);
        resultTemperature = (TextView) findViewById(R.id.view_temperature);
        buttonTemperature = (Button) findViewById(R.id.button_temperature);


        buttonTemperature.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayResults(editTemperature, resultTemperature,titleTemperature.getText().toString());
            }
        });
    }

    public void displayResults(EditText editTemperature, TextView resultTemperature, String titleTemperature) {

        String value = editTemperature.getText().toString();
        int finalValue = Integer.parseInt(value);



        if(titleTemperature.equals("F") ) {

            double total = (finalValue-32)* 5/9 ;

            String finalResult = Double.toString(total);


            resultTemperature.setText(String.format("When it is " + editTemperature.getText().toString() + "F degrees outside, it is " + finalResult  + "C "));
        }else if(titleTemperature.equals("C")  ) {

            double total = (finalValue * 9/5) + 32;

            String finalResult = Double.toString(total);

            resultTemperature.setText(finalResult);

            resultTemperature.setText("When it is " + editTemperature.getText().toString() + "C degrees outside, it is" + finalResult  + "F ");
        } else {
            alertBox();
        }

    }
    public void alertBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(Temperature.this).create();
        alertDialog.setTitle("Alert");

        alertDialog.setMessage("Sorry, the words in the first text field must be 'F' or 'C' and you must enter a value");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();
    }

    public void goBack(View view){
        Intent backToHome = new Intent(Temperature.this, MainActivity.class);
        startActivity(backToHome);
    }
}