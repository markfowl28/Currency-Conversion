package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickNext(View v) {

        //stores checked option
        RadioGroup rg = findViewById(R.id.radioGroup);
        int buttonID = rg.getCheckedRadioButtonId();
        RadioButton selection = findViewById(buttonID);

        RadioButton yen = findViewById(R.id.YenButton);
        RadioButton cad = findViewById(R.id.CadButton);
        RadioButton eur = findViewById(R.id.EurButton);

        //sends over option selected and all option values to second activity
        Intent myIntent = new Intent(this, SecondActivity.class);
        myIntent.putExtra("CurrencyParameter", selection.getText().toString());
        myIntent.putExtra("YenParameter", yen.getText().toString());
        myIntent.putExtra("CadParameter", cad.getText().toString());
        myIntent.putExtra("EurParameter", eur.getText().toString());

        startActivity(myIntent);
    }
}