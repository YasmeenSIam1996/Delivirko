package com.ict.delivirko.adapter.restaurant;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseOrderDetails;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.OrderDetails;
import com.ict.delivirko.Module.restaurant.Orders;
import com.ict.delivirko.Utils.Constants;
import java.util.List;

public class MyOrdersRestAdapter extends Adapter<MyViewHolder> {
    Context context;
    List<Orders> objects;

    public class MyViewHolder extends ViewHolder {
        TextView tvOrderDateRest;
        TextView tvOrderIdRest;
        TextView tvOrderTimeRest;
        TextView tvPilotNameRest;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.tvOrderIdRest = (TextView) view.findViewById(C0519R.id.tvOrderIdRest);
            this.tvOrderTimeRest = (TextView) view.findViewById(C0519R.id.tvOrderTimeRest);
            this.tvOrderDateRest = (TextView) view.findViewById(C0519R.id.tvOrderDateRest);
            this.tvPilotNameRest = (TextView) view.findViewById(C0519R.id.tvPilotNameRest);
        }
    }

    public MyOrdersRestAdapter(Context context, List<Orders> list) {
        this.context = context;
        this.objects = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_my_orders_rest, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Orders orders = (Orders) this.objects.get(i);
        TextView textView = myViewHolder.tvOrderIdRest;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orders.getId());
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        myViewHolder.tvOrderTimeRest.setText(orders.getTime());
        myViewHolder.tvOrderDateRest.setText(orders.getDate());
        myViewHolder.tvPilotNameRest.setText(orders.getDriver().getName());
        myViewHolder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view = MyOrdersRestAdapter.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(orders.getId());
                stringBuilder.append("");
                view.orderDetails(stringBuilder.toString(), MyOrdersRestAdapter.this.context);
            }
        });
    }

    public int getItemCount() {
        return this.objects.size();
    }

    private void showDialog(OrderDetails orderDetails) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C0519R.style.SheetDialog);
        bottomSheetDialog.setContentView((int) C0519R.layout.sheet_orders_details_rest);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(C0519R.id.imgCancelDetailsRest);
        TextView textView = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderIdRestValue);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvRestTimeValue);
        TextView textView3 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderDateRestValue);
        TextView textView4 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvPilotNameValue);
        TextView textView5 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvPilotCodeValue);
        TextView textView6 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvAddressRestValue);
        TextView textView7 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvRestPriceValue);
        TextView textView8 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvDeliveryPriceValue);
        TextView textView9 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvRestPointsValue);
        TextView textView10 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderTypeValue);
        RatingBar ratingBar = (RatingBar) bottomSheetDialog.findViewById(C0519R.id.rateBarRest);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orderDetails.getId());
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        textView2.setText(orderDetails.getTime());
        textView3.setText(orderDetails.getDate());
        textView4.setText(orderDetails.getDriver().getName());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(orderDetails.getDriver().getId());
        stringBuilder2.append("");
        textView5.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(orderDetails.getStreet());
        stringBuilder2.append(" ");
        stringBuilder2.append(orderDetails.getBuilding_no());
        stringBuilder2.append(" ");
        stringBuilder2.append(orderDetails.getFloor_no());
        textView6.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(orderDetails.getPrice());
        stringBuilder2.append("");
        textView7.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(orderDetails.getShipping());
        stringBuilder2.append("");
        textView8.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(orderDetails.getPoints());
        stringBuilder2.append("");
        textView9.setText(stringBuilder2.toString());
        textView10.setText(orderDetails.getOrder_type());
        ratingBar.setRating((float) orderDetails.getCompany_rating());
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
    }

    public void orderDetails(String str, final Context context) {
        new UserAPI().orderDetails(str, new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseOrderDetails responseOrderDetails = (ResponseOrderDetails) obj;
                if (responseOrderDetails.isStatus()) {
                    MyOrdersRestAdapter.this.showDialog(responseOrderDetails.getOrderDetails());
                } else {
                    Toast.makeText((Activity) context, responseOrderDetails.getMessage(), 1).show();
                }
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }
}
