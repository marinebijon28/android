package com.marine.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Intent srcIntent = getIntent();
        User user = srcIntent.getParcelableExtra("author");
        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText(user.version);
        TextView authorTextView = findViewById(R.id.authorTextView);
        authorTextView.setText(user.name);
    }
}