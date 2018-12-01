package com.example.jayclark.converter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*Written by: Jonathan Clark */

public class Weight extends AppCompatActivity {
    EditText titleView;
    EditText editWeight;
    TextView resultWeight;
    Button buttonWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfour);

        titleView = (EditText) findViewById(R.id.title_weight);
        editWeight = (EditText) findViewById(R.id.edit_weight);
        resultWeight = (TextView) findViewById(R.id.view_weight);
        buttonWeight = (Button) findViewById(R.id.button_weight);





        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculation(editWeight, resultWeight,titleView.getText().toString());
            }
        });
    }



    public void showCalculation (EditText a, TextView b, String e){
        String value = a.getText().toString();

        int finalValue = Integer.parseInt(value);
        if(e.equals("Pounds")  ) {

            double total = finalValue * 0.454;

            String finalResult = Double.toString(total);

            b.setText( finalResult + " Pound(s) in " + a.getText().toString() + " Kilogram(s)");


        }else if(e.equals("Kilograms")){


            double total = finalValue * 2.205;

            String finalResult = Double.toString(total);

            b.setText(finalResult);

            b.setText( finalResult + " Kilogram(s) in " + a.getText().toString() + " Pound(s)");
            } else  {
            alertBox();
        }if(finalValue < 0) {
            alertBoxNumber();
        }


    }
    public void alertBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(Weight.this).create();
        alertDialog.setTitle("Alert");

        alertDialog.setMessage("Sorry, the words in the first text field must be 'Pound' or 'Kilogram'");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();
    }
    public void alertBoxNumber() {
        AlertDialog alertDialog = new AlertDialog.Builder(Weight.this).create();
        alertDialog.setTitle("Alert");

        alertDialog.setMessage("Sorry, the number must be greater than 0");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();
    }


    public void goBack(View view){
        Intent backToHome = new Intent(Weight.this, MainActivity.class);
        startActivity(backToHome);
    }
}