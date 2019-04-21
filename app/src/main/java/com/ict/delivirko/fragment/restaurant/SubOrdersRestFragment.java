package com.ict.delivirko.fragment.restaurant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseOrders;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.Orders;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.restaurant.MyOrdersRestAdapter;
import java.util.List;
import java.util.Vector;

public class SubOrdersRestFragment extends Fragment implements OnClickListener {
    public static final String ARG_PARAM1 = "Status";
    private int Page = 0;
    private MyOrdersRestAdapter adapter;
    ImageButton btnNewerSubOrders;
    ImageButton btnOlderSubOrders;
    private List<Orders> list;
    private RecyclerView rvMyOrdersRest;
    private int status;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_sub_orders_rest, viewGroup, false);
        setUpAdapter(layoutInflater);
        setActions(layoutInflater);
        this.status = getArguments().getInt(ARG_PARAM1);
        bundle = new StringBuilder();
        bundle.append(this.status);
        bundle.append("");
        Log.e("status_", bundle.toString());
        viewGroup = new StringBuilder();
        viewGroup.append(this.status);
        viewGroup.append("");
        viewGroup = viewGroup.toString();
        bundle = new StringBuilder();
        bundle.append(this.Page);
        bundle.append("");
        myOrders(viewGroup, bundle.toString(), getActivity());
        return layoutInflater;
    }

    private void setActions(View view) {
        this.btnOlderSubOrders = (ImageButton) view.findViewById(C0519R.id.btnOlderSubOrders);
        this.btnNewerSubOrders = (ImageButton) view.findViewById(C0519R.id.btnNewerSubOrders);
        this.btnOlderSubOrders.setOnClickListener(this);
        this.btnNewerSubOrders.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        StringBuilder stringBuilder;
        int i;
        if (view == C0519R.id.btnNewerSubOrders) {
            this.btnNewerSubOrders.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
            view = new StringBuilder();
            view.append(this.status);
            view.append("");
            view = view.toString();
            stringBuilder = new StringBuilder();
            i = this.Page + 1;
            this.Page = i;
            stringBuilder.append(i);
            stringBuilder.append("");
            myOrders(view, stringBuilder.toString(), getActivity());
        } else if (view == C0519R.id.btnOlderSubOrders) {
            this.btnOlderSubOrders.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
            view = new StringBuilder();
            view.append(this.status);
            view.append("");
            view = view.toString();
            stringBuilder = new StringBuilder();
            i = this.Page - 1;
            this.Page = i;
            stringBuilder.append(i);
            stringBuilder.append("");
            myOrders(view, stringBuilder.toString(), getActivity());
        }
    }

    public void myOrders(String str, String str2, final Context context) {
        new UserAPI().myOrders(str, str2, new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                SubOrdersRestFragment.this.list.clear();
                ResponseOrders responseOrders = (ResponseOrders) obj;
                if (responseOrders.isStatus()) {
                    SubOrdersRestFragment.this.list.addAll(responseOrders.getOrderData().getOrders());
                    SubOrdersRestFragment.this.adapter.notifyDataSetChanged();
                    return;
                }
                Toast.makeText((Activity) context, responseOrders.getMessage(), 1).show();
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

    private void setUpAdapter(View view) {
        this.list = new Vector();
        this.rvMyOrdersRest = (RecyclerView) view.findViewById(C0519R.id.rvMyOrdersRest);
        this.adapter = new MyOrdersRestAdapter(getContext(), this.list);
        this.rvMyOrdersRest.setAdapter(this.adapter);
        this.rvMyOrdersRest.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
