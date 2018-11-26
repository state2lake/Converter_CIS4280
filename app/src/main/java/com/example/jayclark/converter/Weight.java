package com.example.jayclark.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Weight extends AppCompatActivity {
    TextView titleView;
    EditText editWeight;
    TextView resultWeight;
    Button buttonWeight;
    Spinner spinnerWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfour);

        titleView = (TextView) findViewById(R.id.title_view);
        editWeight = (EditText) findViewById(R.id.edit_weight);
        resultWeight = (TextView) findViewById(R.id.view_weight);
        buttonWeight = (Button) findViewById(R.id.button_weight);
        spinnerWeight = (Spinner) findViewById(R.id.spinner_weight);

        String name= titleView.getText().toString();

        if(spinnerWeight != null && spinnerWeight.getSelectedItem() !=null ) {
            name = (String)spinnerWeight.getSelectedItem();
            titleView.setText(name);
        }

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculation(editWeight, resultWeight);
            }
        });
    }

    public void showKeyboard(View v) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(editWeight, InputMethodManager.SHOW_IMPLICIT);
    }

    public void spinnerChoice(Spinner s, EditText e) {
        String name= e.getText().toString();
        if(s != null && s.getSelectedItem() !=null ) {
            name = (String)s.getSelectedItem();
            e.setText(name);
        }
    }
    public void showCalculation (EditText a, TextView b){
        String value = a.getText().toString();

        int finalValue = Integer.parseInt(value);

        double total = finalValue * 0.454;

        String finalResult = Double.toString(total);

        b.setText(finalResult);


    }
}