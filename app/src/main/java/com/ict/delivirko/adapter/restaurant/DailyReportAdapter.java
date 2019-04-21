package com.ict.delivirko.adapter.restaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.BillRest;
import java.util.List;

public class DailyReportAdapter extends Adapter<MyViewHolder> {
    Context context;
    List<BillRest> objects;

    public class MyViewHolder extends ViewHolder {
        public MyViewHolder(@NonNull View view) {
            super(view);
        }
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
    }

    public DailyReportAdapter(Context context, List<BillRest> list) {
        this.context = context;
        this.objects = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_follow_orders, viewGroup, false));
    }

    public int getItemCount() {
        return this.objects.size();
    }
}
