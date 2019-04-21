package com.ict.delivirko.fragment.pilot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseOrderPilot;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.ExpandableOrdersAdapter;

public class SubOrdersPilotFragment extends Fragment implements OnClickListener {
    private static int Status;
    private int PagerNum = 0;
    private ExpandableOrdersAdapter adapter;
    private ImageButton btnNewerSubOrdersPilot;
    private ImageButton btnOlderSubOrdersPilot;
    private ExpandableListView orders;
    private TextView tvNoOrders;
    private TextView tvPilotNameOrders;
    private TextView tvWeekPilotOrders;

    /* renamed from: com.ict.delivirko.fragment.pilot.SubOrdersPilotFragment$1 */
    class C05451 implements OnGroupClickListener {
        C05451() {
        }

        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            ImageView imageView = (ImageView) view.findViewById(C0519R.id.indicatorOrders);
            if (SubOrdersPilotFragment.this.orders.isGroupExpanded(i) != null) {
                imageView.setImageResource(C0519R.drawable.ic_expandable_closed);
            } else {
                imageView.setImageResource(C0519R.drawable.ic_expandable_open);
            }
            return null;
        }
    }

    public static SubOrdersPilotFragment newInstance(int i) {
        SubOrdersPilotFragment subOrdersPilotFragment = new SubOrdersPilotFragment();
        Status = i;
        return subOrdersPilotFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_sub_orders_pilot, viewGroup, false);
        this.tvPilotNameOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvPilotNameOrders);
        this.tvWeekPilotOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvWeekPilotOrders);
        this.tvNoOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvNoOrders);
        this.btnNewerSubOrdersPilot = (ImageButton) layoutInflater.findViewById(C0519R.id.btnNewerSubOrdersPilot);
        this.btnOlderSubOrdersPilot = (ImageButton) layoutInflater.findViewById(C0519R.id.btnOlderSubOrdersPilot);
        this.orders = (ExpandableListView) layoutInflater.findViewById(C0519R.id.listOrders);
        this.btnNewerSubOrdersPilot.setOnClickListener(this);
        this.btnOlderSubOrdersPilot.setOnClickListener(this);
        setUpAdapter();
        bundle = new StringBuilder();
        bundle.append(this.PagerNum);
        bundle.append("   ");
        bundle.append(Status);
        Log.e("btnOlderSubOrdersPilot", bundle.toString());
        viewGroup = new StringBuilder();
        viewGroup.append(this.PagerNum);
        viewGroup.append("");
        viewGroup = viewGroup.toString();
        bundle = new StringBuilder();
        bundle.append(Status);
        bundle.append("");
        PilotOrder(viewGroup, bundle.toString(), getActivity());
        return layoutInflater;
    }

    public void onClick(View view) {
        view = view.getId();
        int i;
        StringBuilder stringBuilder;
        if (view == C0519R.id.btnNewerSubOrdersPilot) {
            view = new StringBuilder();
            i = this.PagerNum + 1;
            this.PagerNum = i;
            view.append(i);
            view.append("");
            view = view.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(Status);
            stringBuilder.append("");
            PilotOrder(view, stringBuilder.toString(), getActivity());
            this.btnNewerSubOrdersPilot.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        } else if (view == C0519R.id.btnOlderSubOrdersPilot) {
            view = new StringBuilder();
            i = this.PagerNum - 1;
            this.PagerNum = i;
            view.append(i);
            view.append("");
            view = view.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(Status);
            stringBuilder.append("");
            PilotOrder(view, stringBuilder.toString(), getActivity());
            this.btnOlderSubOrdersPilot.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        }
    }

    private void setUpAdapter() {
        this.orders.setOnGroupClickListener(new C05451());
    }

    public void PilotOrder(String str, String str2, final Context context) {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().PilotOrder(str, str2, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseOrderPilot responseOrderPilot = (ResponseOrderPilot) obj;
                if (responseOrderPilot.isStatus()) {
                    SubOrdersPilotFragment subOrdersPilotFragment = SubOrdersPilotFragment.this;
                    subOrdersPilotFragment.adapter = new ExpandableOrdersAdapter(subOrdersPilotFragment.getActivity(), responseOrderPilot.getMyOrder());
                    SubOrdersPilotFragment.this.orders.setAdapter(SubOrdersPilotFragment.this.adapter);
                    SubOrdersPilotFragment.this.tvPilotNameOrders.setText(ApplicationController.getInstance().getUser().getName());
                    TextView access$300 = SubOrdersPilotFragment.this.tvWeekPilotOrders;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(responseOrderPilot.getMyOrder().getStart_date());
                    stringBuilder.append("-");
                    stringBuilder.append(responseOrderPilot.getMyOrder().getEnd_date());
                    access$300.setText(stringBuilder.toString());
                    access$300 = SubOrdersPilotFragment.this.tvNoOrders;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responseOrderPilot.getMyOrder().getRate());
                    stringBuilder.append("");
                    access$300.setText(stringBuilder.toString());
                    return;
                }
                Constants.showDialog(SubOrdersPilotFragment.this.getActivity(), responseOrderPilot.getMessage());
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
