package com.marine.money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "start project");
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
                resultTextView.setText((String) String.valueOf(1.21F * Float.parseFloat(number)) + "$");
            }
        });
    }
}