package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sets selected currency abbreviation
        String currency = getIntent().getStringExtra("CurrencyParameter");
        TextView txt = findViewById(R.id.CurrencyText);
        txt.setText(currency);

        String yenOption = getIntent().getStringExtra("YenParameter");
        String cadOption = getIntent().getStringExtra("CadParameter");
        String eurOption = getIntent().getStringExtra("EurParameter");

        //compares user selection to all options to set correct initial value
        if(currency.equals(yenOption)) {
            TextView initialTxt = findViewById(R.id.CurrencyAmountText);
            initialTxt.setText("109.94");
        } else if(currency.equals(cadOption)) {
            TextView initialTxt = findViewById(R.id.CurrencyAmountText);
            initialTxt.setText("1.26");
        } else if(currency.equals(eurOption)) {
            TextView initialTxt = findViewById(R.id.CurrencyAmountText);
            initialTxt.setText("0.85");
        }
    }

    public void OnBack(View v) {
        finish();
    }

    public void fromUSD (View v) {
        //takes input from USD line
        EditText input = findViewById(R.id.UsdAmountText);
        String str = input.getText().toString();
        double num = Double.parseDouble(str);

        String currency = getIntent().getStringExtra("CurrencyParameter");
        String yenOption = getIntent().getStringExtra("YenParameter");
        String cadOption = getIntent().getStringExtra("CadParameter");
        String eurOption = getIntent().getStringExtra("EurParameter");

        if(currency.equals(yenOption)) {
            num *= 109.94;
        } else if(currency.equals(cadOption)) {
            num *= 1.26;
        } else if(currency.equals(eurOption)) {
            num *= 0.85;
        }

        //outputs conversion on currency line
        str = Double.toString(num);
        TextView output = findViewById(R.id.CurrencyAmountText);
        output.setText(str);
    }

    public void toUSD (View v) {
        //takes input from the currency line
        EditText input = findViewById(R.id.CurrencyAmountText);
        String str = input.getText().toString();
        double num = Double.parseDouble(str);

        String currency = getIntent().getStringExtra("CurrencyParameter");
        String yenOption = getIntent().getStringExtra("YenParameter");
        String cadOption = getIntent().getStringExtra("CadParameter");
        String eurOption = getIntent().getStringExtra("EurParameter");

        if(currency.equals(yenOption)) {
            num /= 109.94;
        } else if(currency.equals(cadOption)) {
            num /= 1.26;
        } else if(currency.equals(eurOption)) {
            num /= 0.85;
        }

        //outputs to the USD line
        str = Double.toString(num);
        TextView output = findViewById(R.id.UsdAmountText);
        output.setText(str);
    }
}