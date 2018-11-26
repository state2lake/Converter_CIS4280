package com.example.jayclark.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Volume extends AppCompatActivity {
    EditText editVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfive);

        editVolume = (EditText) findViewById(R.id.edit_volume);
    }

    public void showKeyboard(View v) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(editVolume, InputMethodManager.SHOW_IMPLICIT);
    }
}