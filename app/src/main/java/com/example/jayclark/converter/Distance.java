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

import java.text.DecimalFormat;
import java.text.NumberFormat;


/*Written by: Jonathan Clark */


public class Distance extends AppCompatActivity {

    EditText editTitle;
    EditText editDistance;
    TextView resultDistance;
    Button buttonDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainthree);

        editTitle = (EditText) findViewById(R.id.title_distance);
        editDistance = (EditText) findViewById(R.id.edit_distance);
        resultDistance = (TextView) findViewById(R.id.view_distance);
        buttonDistance = (Button) findViewById(R.id.button_distance);

        buttonDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculation(editDistance,resultDistance,editTitle.getText().toString());
            }
        });
    }
//        buttonDistance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showCalculation(editDistance, resultDistance, editTitle.getText().toString());
//            }
//        });
//
//    }
    public void showCalculation(EditText a, TextView b, String e) {
        String value = a.getText().toString();
        int finalValue=Integer.parseInt(value);
        double total = finalValue * 1.60;
        if(e.equals("Kilometers") && finalValue > 0) {
            total = finalValue * 1.60;
            String finalResult = Double.toString(total);

            b.setText(finalResult);
            b.setText(finalResult + " Kilometer(s) in " + a.getText().toString() + " Mile(s)");
        }else if(e.equals("Miles") && finalValue > 0 ) {
            total = finalValue * 0.62;
            String finalResult = Double.toString(total);
            b.setText(finalResult);
            b.setText(finalResult + " Mile(s) in " + a.getText().toString() + " Kilometer(s)");
        } else {
            alertBox();
        }
    }
    public void alertBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(Distance.this).create();
        alertDialog.setTitle("Alert");

        alertDialog.setMessage("Error, please be sure that the words entered match the Hint and the number is greater than 0");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();
    }


    public void goBack(View view){
        Intent backToHome = new Intent(Distance.this, MainActivity.class);
        startActivity(backToHome);
    }

    }