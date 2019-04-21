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
import android.view.ViewGroup;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseTrackingOrders;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.DriverTracking;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.restaurant.FollowOrdersAdapter;
import java.util.ArrayList;
import java.util.List;

public class FollowOrdersFragment extends Fragment {
    private FollowOrdersAdapter followOrdersAdapter;
    private List<DriverTracking> objects;
    private RecyclerView rvFollowOrders;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_follow_orders, viewGroup, false);
        setUpAdapter(layoutInflater);
        trackingOrders(getActivity());
        return layoutInflater;
    }

    private void setUpAdapter(View view) {
        this.rvFollowOrders = (RecyclerView) view.findViewById(C0519R.id.rvFollowOrders);
        this.objects = new ArrayList();
        this.followOrdersAdapter = new FollowOrdersAdapter(getContext(), this.objects);
        this.rvFollowOrders.setAdapter(this.followOrdersAdapter);
        this.rvFollowOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void trackingOrders(final Context context) {
        new UserAPI().trackingOrders(new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseTrackingOrders responseTrackingOrders = (ResponseTrackingOrders) obj;
                if (responseTrackingOrders.isStatus()) {
                    FollowOrdersFragment.this.objects.clear();
                    FollowOrdersFragment.this.objects.addAll(responseTrackingOrders.getDriverTracking());
                    FollowOrdersFragment.this.followOrdersAdapter.notifyDataSetChanged();
                    return;
                }
                Constants.showDialog((Activity) context, responseTrackingOrders.getMessage());
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    ResponseError responseError = (ResponseError) obj;
                    Constants.showDialog((Activity) context, responseError.getMessage());
                    Log.e("TRACKING_ORDER", responseError.getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }
}
