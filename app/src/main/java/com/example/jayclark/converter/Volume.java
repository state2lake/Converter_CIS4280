package com.example.jayclark.converter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Volume extends AppCompatActivity {
    EditText titleVolume;
    EditText editVolume;
    TextView resultVolume;
    Button buttonVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfive);

        titleVolume = (EditText) findViewById(R.id.title_volume);
        editVolume = (EditText) findViewById(R.id.edit_volume);
        resultVolume = (TextView) findViewById(R.id.view_volume);
        buttonVolume = (Button) findViewById(R.id.button_volume);

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculation(editVolume, resultVolume,titleVolume.getText().toString());
            }
        });
    }

    public void showCalculation(EditText a, TextView b, String e) {
        String value = a.getText().toString();

        int finalValue=Integer.parseInt(value);

        if(e.equals("Liters") && finalValue > 0 ) {

            double total = 0.26 ;

            String finalResult = Double.toString(total);


            b.setText(finalResult + " Liter(s) in" + a.getText().toString() + " Gallon(s)");
        }else if(e.equals("Gallons")  && finalValue > 0 ) {

            double total = 3.79;

            String finalResult = Double.toString(total);

            b.setText(finalResult);

            b.setText(finalResult + " Gallon(s) in" + a.getText().toString() + " Liter(s)");
        } else {
            alertBox();
        }

    }
    public void alertBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(Volume.this).create();
        alertDialog.setTitle("Alert");

        alertDialog.setMessage("Sorry, the words in the first text field must be 'Liters' or 'Gallons' and the volume number must be greater than 0");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        alertDialog.show();
    }
}