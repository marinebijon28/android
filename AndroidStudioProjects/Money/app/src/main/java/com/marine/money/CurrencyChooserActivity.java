package com.marine.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

public class CurrencyChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_chooser);


        findViewById(R.id.DollarButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Money money;
                money = new Money(R.drawable.flag_usa, 1.21F, "$");
                sendMainActivity(money);
            }
        });
        findViewById(R.id.yenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Money money;
                money = new Money(R.drawable.flag_japan, 127.89F, "Y");
                sendMainActivity(money);
            }
        });
        findViewById(R.id.PoundButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Money money;
                money = new Money(R.drawable.flag_england, 0.86F, "£");
                sendMainActivity(money);
            }
        });

    }

    private void sendMainActivity(Money money) {
        Intent mainActivity = new Intent(CurrencyChooserActivity.this, MainActivity.class);
        mainActivity.putExtra("money", (Parcelable) money);
        startActivity(mainActivity);
    }

}