package com.marine.money;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListActivity extends AppCompatActivity {
    private List<Money> moneyList;
    private MoneyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        moneyList = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            moneyList.add(new Money(R.drawable.flag_usa, 1.21F, "$"));
            moneyList.add(new Money(R.drawable.flag_japan, 127.89F, "Y"));
            moneyList.add(new Money(R.drawable.flag_england, 0.86F, "£"));
        }
        adapter = new MoneyAdapter(moneyList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}