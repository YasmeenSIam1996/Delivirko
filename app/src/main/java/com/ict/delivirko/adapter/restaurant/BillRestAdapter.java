package com.ict.delivirko.adapter.restaurant;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseReportOrder;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.BillOrders;
import com.ict.delivirko.Utils.Constants;
import java.util.List;
import java.util.Vector;

public class BillRestAdapter extends Adapter<MyViewHolder> {
    List<BillOrders> billOrders;
    Context context;
    boolean isSheet;

    public class MyViewHolder extends ViewHolder {
        ImageView imgIsPayedBillRest;
        ImageView imgIsTransferred;
        TextView tvDateBillRest;
        TextView tvTotalOrderBill;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.tvDateBillRest = (TextView) view.findViewById(C0519R.id.tvDateBillRest);
            this.tvTotalOrderBill = (TextView) view.findViewById(C0519R.id.tvTotalOrderBill);
            this.imgIsPayedBillRest = (ImageView) view.findViewById(C0519R.id.imgIsPayedBillRest);
            this.imgIsTransferred = (ImageView) view.findViewById(C0519R.id.imgIsTransferred);
        }
    }

    public BillRestAdapter(Context context, List<BillOrders> list, boolean z) {
        this.context = context;
        this.billOrders = list;
        this.isSheet = z;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_bill_rest, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final BillOrders billOrders = (BillOrders) this.billOrders.get(i);
        myViewHolder.tvDateBillRest.setText(billOrders.getDate());
        TextView textView = myViewHolder.tvTotalOrderBill;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(billOrders.getPrice());
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        myViewHolder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (BillRestAdapter.this.isSheet == null) {
                    BillRestAdapter.this.showDialog(billOrders.getDate());
                }
            }
        });
    }

    public int getItemCount() {
        return this.billOrders.size();
    }

    private void showDialog(String str) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C0519R.style.SheetDialog);
        bottomSheetDialog.setContentView((int) C0519R.layout.sheet_daily_report_rest);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
        ((ImageView) bottomSheetDialog.findViewById(C0519R.id.imgCancelDailyReport)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        List vector = new Vector();
        RecyclerView recyclerView = (RecyclerView) bottomSheetDialog.findViewById(C0519R.id.rvDailyReport);
        Adapter billRestSheetAdapter = new BillRestSheetAdapter(this.context, vector);
        recyclerView.setAdapter(billRestSheetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        ReportBillCompany(vector, billRestSheetAdapter, str, this.context);
    }

    public void ReportBillCompany(final List<BillOrders> list, final BillRestSheetAdapter billRestSheetAdapter, String str, final Context context) {
        Constants.showSimpleProgressDialog(context, context.getResources().getString(C0519R.string.Loading));
        new UserAPI().ReportBillRest(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseReportOrder responseReportOrder = (ResponseReportOrder) obj;
                list.clear();
                if (responseReportOrder.isStatus()) {
                    list.addAll(responseReportOrder.getReportData().getOrders());
                    billRestSheetAdapter.notifyDataSetChanged();
                    return;
                }
                Constants.showDialog((Activity) context, responseReportOrder.getMessage());
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void onFinish() {
                Constants.removeProgressDialog();
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }
}
