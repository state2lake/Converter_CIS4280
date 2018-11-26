package com.example.jayclark.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Temperature extends AppCompatActivity {
    EditText editTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);

        editTemperature = (EditText) findViewById(R.id.edit_temperature);
    }

    public void showKeyboard(View v) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(editTemperature, InputMethodManager.SHOW_IMPLICIT);
    }
}