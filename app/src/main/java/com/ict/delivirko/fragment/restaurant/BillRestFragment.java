package com.ict.delivirko.fragment.restaurant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseBillResData;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.BillOrders;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.restaurant.BillRestAdapter;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Vector;

public class BillRestFragment extends Fragment implements OnClickListener {
    private ImageView ResImage;
    private List<BillOrders> billOrders;
    private BillRestAdapter billRestAdapter;
    private ImageButton btnNewerBillRest;
    private ImageButton btnOlderBillRest;
    private int page = 0;
    private RecyclerView rvBillRest;
    private TextView totalPrice;
    private TextView tvRestNameBill;
    private TextView tvWeekBillRest;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_bill_rest, viewGroup, false);
        intiViews(layoutInflater);
        return layoutInflater;
    }

    private void intiViews(View view) {
        this.billOrders = new Vector();
        this.rvBillRest = (RecyclerView) view.findViewById(C0519R.id.rvBillRest);
        this.ResImage = (ImageView) view.findViewById(C0519R.id.ResImage);
        this.billRestAdapter = new BillRestAdapter(getContext(), this.billOrders, false);
        this.rvBillRest.setAdapter(this.billRestAdapter);
        this.rvBillRest.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.btnOlderBillRest = (ImageButton) view.findViewById(C0519R.id.btnOlderBillRest);
        this.btnNewerBillRest = (ImageButton) view.findViewById(C0519R.id.btnNewerBillRest);
        this.tvWeekBillRest = (TextView) view.findViewById(C0519R.id.tvWeekBillRest);
        this.tvRestNameBill = (TextView) view.findViewById(C0519R.id.tvRestNameBill);
        this.totalPrice = (TextView) view.findViewById(C0519R.id.totalPrice);
        this.btnNewerBillRest.setOnClickListener(this);
        this.btnOlderBillRest.setOnClickListener(this);
        view = new StringBuilder();
        view.append(this.page);
        view.append("");
        BillCompany(view.toString(), getActivity());
        this.tvRestNameBill.setText(ApplicationController.getInstance().getUser().getName());
        view = Picasso.get();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Image_URL);
        stringBuilder.append(ApplicationController.getInstance().getUser().getImage());
        view.load(stringBuilder.toString()).fit().into(this.ResImage);
    }

    public void onClick(View view) {
        view = view.getId();
        int i;
        if (view == C0519R.id.btnNewerBillRest) {
            view = new StringBuilder();
            i = this.page + 1;
            this.page = i;
            view.append(i);
            view.append("");
            BillCompany(view.toString(), getActivity());
            this.btnNewerBillRest.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        } else if (view == C0519R.id.btnOlderBillRest) {
            view = new StringBuilder();
            i = this.page - 1;
            this.page = i;
            view.append(i);
            view.append("");
            BillCompany(view.toString(), getActivity());
            this.btnOlderBillRest.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        }
    }

    public void BillCompany(String str, final Context context) {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().BillRest(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseBillResData responseBillResData = (ResponseBillResData) obj;
                if (responseBillResData.isStatus()) {
                    BillRestFragment.this.billOrders.clear();
                    BillRestFragment.this.billOrders.addAll(responseBillResData.getBillData().getOrders());
                    BillRestFragment.this.billRestAdapter.notifyDataSetChanged();
                    TextView access$200 = BillRestFragment.this.tvWeekBillRest;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(responseBillResData.getBillData().getStart_date());
                    stringBuilder.append(" - ");
                    stringBuilder.append(responseBillResData.getBillData().getEnd_date());
                    access$200.setText(stringBuilder.toString());
                    access$200 = BillRestFragment.this.totalPrice;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responseBillResData.getBillData().getTotal_price());
                    stringBuilder.append("");
                    access$200.setText(stringBuilder.toString());
                    return;
                }
                Constants.showDialog(BillRestFragment.this.getActivity(), responseBillResData.getMessage());
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
