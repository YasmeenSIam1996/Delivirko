package com.ict.delivirko.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.pilot.CanceledOrder;
import java.util.ArrayList;

public class CanceledOrdersAdapter extends Adapter<MyViewHolder> {
    Context context;
    ArrayList<CanceledOrder> objects;

    public class MyViewHolder extends ViewHolder {
        LinearLayout containerOrders;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.containerOrders = (LinearLayout) view.findViewById(C0519R.id.containerOrders);
        }
    }

    public CanceledOrdersAdapter(Context context, ArrayList<CanceledOrder> arrayList) {
        this.context = context;
        this.objects = arrayList;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_canceled_orders, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (i % 2 == 0) {
            myViewHolder.containerOrders.setBackgroundColor(ContextCompat.getColor(this.context, C0519R.color.pilotOrdersGrey));
        }
    }

    public int getItemCount() {
        return this.objects.size();
    }
}
