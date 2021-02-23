package com.marine.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "start project");

        Intent srcIntent = getIntent();
        Money money = srcIntent.getParcelableExtra("money");

        User user = new User("Marine BIJON",  "version 1.0");
        Log.i("MainActivity", String.valueOf(user.name));

        ImageView image = findViewById(R.id.flag_usaImageView);
        image.setImageResource(money.image);

        final Button ConvertButton = findViewById(R.id.ConvertButton);
        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View w){
                EditText editTextNumber = findViewById(R.id.editTextNumber);
                Log.i("MainActivity", "click !");
                String number = editTextNumber.getText().toString();
                if (number.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                                    "Veuillez rentrer un nombre !",
                                        Toast.LENGTH_SHORT).show();
                    return;
                }
                TextView resultTextView = findViewById(R.id.resultTextView);
                Log.i("MainActivity", String.valueOf(resultTextView));
                resultTextView.setText((String) String.valueOf(money.change * Float.parseFloat(number)) + money.symbole);
            }
        });

        final Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View w){
               Intent aboutActivity = new Intent(MainActivity.this, AboutActivity.class);

               aboutActivity.putExtra("author", (Parcelable) user);
               startActivity(aboutActivity);
            }
        });
    }
}