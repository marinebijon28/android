package com.marine.money;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoneyAdapter extends RecyclerView.Adapter<MoneyAdapter.ViewHolder> implements View.OnClickListener {
    private List<Money> money;

    public MoneyAdapter(List<Money> money) {
        this.money = money;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_money, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Money monei = money.get(position);
        holder.flag.setImageResource(monei.image);
        holder.symbole.setText(monei.symbole);
        holder.change.setText(monei.change + "");

        holder.itemView.setTag(monei);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return money.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item1:
                Context view = v.getContext();
                Money item = (Money)v.getTag();
                Intent mainActivity = new Intent(view, MainActivity.class);
                mainActivity.putExtra("money", item);
                view.startActivity(mainActivity);
                break;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flag;
        final TextView change;
        final TextView symbole;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Récupération du composant graphique
            // qui se trouve dans itemView. itemView = item_money.xml
            flag = itemView.findViewById(R.id.flagImageView);
            symbole = itemView.findViewById(R.id.SymbolTextView);
            change = itemView.findViewById(R.id.rateTextView);

        }
    }
}
