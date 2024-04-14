package com.shiva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder> {

    private List<String> smsList;

    public SmsAdapter(List<String> smsList) {
        this.smsList = smsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(smsList.get(position));
    }

    @Override
    public int getItemCount() {
        return smsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSms;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSms = itemView.findViewById(android.R.id.text1);
        }

        void bind(String sms) {
            textViewSms.setText(sms);
        }
    }
}
