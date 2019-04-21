package com.ict.delivirko.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseMyOrderDetails;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.pilot.MyOrder;
import com.ict.delivirko.Module.pilot.MyOrderDetails;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.fragment.pilot.MyOrderData;

public class ExpandableOrdersAdapter extends BaseExpandableListAdapter {
    private Context context;
    private MyOrderData myOrderData;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public ExpandableOrdersAdapter(Context context, MyOrderData myOrderData) {
        this.context = context;
        this.myOrderData = myOrderData;
    }

    public Object getChild(int i, int i2) {
        return ((MyOrder) this.myOrderData.getMyOrder().get(i)).getMyOrderDetails().get(i2);
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        final MyOrderDetails myOrderDetails = (MyOrderDetails) ((MyOrder) this.myOrderData.getMyOrder().get(i)).getMyOrderDetails().get(i2);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(true, null);
            TextView textView = (TextView) view.findViewById(true);
            ImageView imageView = (ImageView) view.findViewById(C0519R.id.imgIsPayed);
            ((TextView) view.findViewById(C0519R.id.tvOrderTime)).setText(myOrderDetails.getTime());
            textView.setText(myOrderDetails.getDate());
        }
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view = ExpandableOrdersAdapter.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(myOrderDetails.getId());
                stringBuilder.append("");
                view.PilotOrderDetails(stringBuilder.toString(), ExpandableOrdersAdapter.this.context);
            }
        });
        return view;
    }

    private void showDialog(com.ict.delivirko.Module.MyOrderDetails myOrderDetails) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C0519R.style.SheetDialog);
        bottomSheetDialog.setContentView((int) C0519R.layout.sheet_orders_details_pilot);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.show();
        ((ImageView) bottomSheetDialog.findViewById(C0519R.id.imgCancelDetailsPilot)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        TextView textView = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderIdValue);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvTimeZonePilotSheet);
        TextView textView3 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderDateValue);
        TextView textView4 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderClientValue);
        TextView textView5 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderAddressValue);
        TextView textView6 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderPriceValue);
        TextView textView7 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvDeliveryPriceValue);
        TextView textView8 = (TextView) bottomSheetDialog.findViewById(C0519R.id.tvOrderPointsValue);
        RatingBar ratingBar = (RatingBar) bottomSheetDialog.findViewById(C0519R.id.rateBarPilot);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(myOrderDetails.getId());
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        textView2.setText(myOrderDetails.getTime());
        textView3.setText(myOrderDetails.getDate());
        textView4.setText(myOrderDetails.getName());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(myOrderDetails.getPlace());
        stringBuilder2.append(" ");
        stringBuilder2.append(myOrderDetails.getStreet());
        stringBuilder2.append(" ");
        stringBuilder2.append(myOrderDetails.getBuilding_no());
        stringBuilder2.append(" ");
        stringBuilder2.append(myOrderDetails.getFloor_no());
        stringBuilder2.append(" ");
        stringBuilder2.append(myOrderDetails.getApartment_no());
        textView5.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(myOrderDetails.getPrice());
        stringBuilder2.append("");
        textView6.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(myOrderDetails.getShipping());
        stringBuilder2.append("");
        textView7.setText(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(myOrderDetails.getPoints());
        stringBuilder2.append("");
        textView8.setText(stringBuilder2.toString());
        ratingBar.setRating(myOrderDetails.getCompany_rating());
    }

    public int getChildrenCount(int i) {
        return ((MyOrder) this.myOrderData.getMyOrder().get(i)).getMyOrderDetails().size();
    }

    public Object getGroup(int i) {
        return this.myOrderData.getMyOrder().get(i);
    }

    public int getGroupCount() {
        return this.myOrderData.getMyOrder().size();
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        MyOrder myOrder = (MyOrder) this.myOrderData.getMyOrder().get(i);
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0519R.layout.item_order_pilot, null);
            TextView textView = (TextView) view.findViewById(C0519R.id.tvOrderId);
            TextView textView2 = (TextView) view.findViewById(C0519R.id.tvOrderTime);
            TextView textView3 = (TextView) view.findViewById(C0519R.id.tvOrderDate);
            ImageView imageView = (ImageView) view.findViewById(C0519R.id.imgIsPayed);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(myOrder.getId());
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            viewGroup = new StringBuilder();
            viewGroup.append(myOrder.getTime());
            viewGroup.append("");
            textView2.setText(viewGroup.toString());
            viewGroup = new StringBuilder();
            viewGroup.append(myOrder.getDate());
            viewGroup.append("");
            textView3.setText(viewGroup.toString());
        }
        if (i % 2 == 0) {
            ((LinearLayout) view.findViewById(C0519R.id.containerOrders)).setBackgroundColor(ContextCompat.getColor(this.context, C0519R.color.pilotOrdersGrey));
        }
        return view;
    }

    public void PilotOrderDetails(String str, final Context context) {
        Constants.showSimpleProgressDialog(context, context.getResources().getString(C0519R.string.Loading));
        new UserAPI().PilotOrderDetails(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseMyOrderDetails responseMyOrderDetails = (ResponseMyOrderDetails) obj;
                if (responseMyOrderDetails.isStatus()) {
                    ExpandableOrdersAdapter.this.showDialog(responseMyOrderDetails.getMyOrderDetails());
                } else {
                    Constants.showDialog((Activity) context, responseMyOrderDetails.getMessage());
                }
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
