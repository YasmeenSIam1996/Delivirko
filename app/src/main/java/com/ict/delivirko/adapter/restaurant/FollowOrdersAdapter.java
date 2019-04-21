package com.ict.delivirko.adapter.restaurant;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ict.delivirko.Activities.HomeRestaurantActivity;
import com.ict.delivirko.Activities.TravelMapsActivity;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.restaurant.DriverTracking;
import com.ict.delivirko.Utils.Constants;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FollowOrdersAdapter extends Adapter<MyViewHolder> {
    Context context;
    List<DriverTracking> objects;

    public class MyViewHolder extends ViewHolder {
        ImageView imgBelow;
        ImageView imgDotsAbove;
        ImageView pilotImage;
        private TextView textDriverName;
        private TextView txtOrderId;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.imgDotsAbove = (ImageView) view.findViewById(C0519R.id.imgAbove);
            this.imgBelow = (ImageView) view.findViewById(C0519R.id.imgBelow);
            this.pilotImage = (ImageView) view.findViewById(C0519R.id.pilotImage);
            this.txtOrderId = (TextView) view.findViewById(C0519R.id.txtOrderId);
            this.textDriverName = (TextView) view.findViewById(C0519R.id.textDriverName);
        }
    }

    public FollowOrdersAdapter(Context context, List<DriverTracking> list) {
        this.context = context;
        this.objects = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_follow_orders, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final DriverTracking driverTracking = (DriverTracking) this.objects.get(i);
        myViewHolder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (driverTracking.getStatus_id() != 3) {
                    if (driverTracking.getStatus_id() != 2) {
                        view = new Intent(FollowOrdersAdapter.this.context, HomeRestaurantActivity.class);
                        view.putExtra("orderNo", driverTracking.getId());
                        view.putExtra("Status_id", driverTracking.getStatus_id());
                        FollowOrdersAdapter.this.context.startActivity(view);
                    }
                }
                view = new Intent(FollowOrdersAdapter.this.context, TravelMapsActivity.class);
                view.putExtra("orderNo", driverTracking.getId());
                view.putExtra("Status_id", driverTracking.getStatus_id());
                FollowOrdersAdapter.this.context.startActivity(view);
            }
        });
        if (i == 0) {
            myViewHolder.imgDotsAbove.setVisibility(4);
        }
        if (i == this.objects.size() - 1) {
            myViewHolder.imgBelow.setVisibility(4);
        }
        myViewHolder.textDriverName.setText(driverTracking.getDriver().getName());
        i = myViewHolder.txtOrderId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(driverTracking.getId());
        stringBuilder.append("");
        i.setText(stringBuilder.toString());
        i = Picasso.get();
        stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Image_URL);
        stringBuilder.append(driverTracking.getDriver().getImage());
        i.load(stringBuilder.toString()).fit().into(myViewHolder.pilotImage);
    }

    public int getItemCount() {
        return this.objects.size();
    }
}
