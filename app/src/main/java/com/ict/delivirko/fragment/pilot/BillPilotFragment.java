package com.ict.delivirko.fragment.pilot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponsePilotBill;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class BillPilotFragment extends Fragment implements OnClickListener {
    private ImageButton btnNewerBillPilot;
    private ImageButton btnOlderBillPilot;
    private int numPage = 0;
    private TextView tvAcceptance;
    private TextView tvCanceledTrips;
    private TextView tvComplete;
    private TextView tvDateOrders;
    private TextView tvEPay;
    private TextView tvEnsure;
    private TextView tvNoOfOrders;
    private TextView tvOfficeFee;
    private TextView tvOrderTimeDialog;
    private TextView tvOrdersIncome;
    private TextView tvPilotNameOrders;
    private TextView tvPointNo;
    private TextView tvRateBill;
    private TextView tvReward;
    private TextView tvTotalMoney;
    private TextView tvWeekBalance;
    private TextView tvWorksHoursBill;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_bill_pilot, viewGroup, false);
        this.btnNewerBillPilot = (ImageButton) layoutInflater.findViewById(C0519R.id.btnNewerBillPilot);
        this.btnOlderBillPilot = (ImageButton) layoutInflater.findViewById(C0519R.id.btnOlderBillPilot);
        this.tvPilotNameOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvPilotNameOrders);
        this.tvPilotNameOrders.setText(ApplicationController.getInstance().getUser().getName());
        this.tvRateBill = (TextView) layoutInflater.findViewById(C0519R.id.tvRateBill);
        this.tvWorksHoursBill = (TextView) layoutInflater.findViewById(C0519R.id.tvWorksHoursBill);
        this.tvPointNo = (TextView) layoutInflater.findViewById(C0519R.id.tvPointNo);
        this.tvNoOfOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvNoOfOrders);
        this.tvComplete = (TextView) layoutInflater.findViewById(C0519R.id.tvComplete);
        this.tvAcceptance = (TextView) layoutInflater.findViewById(C0519R.id.tvAcceptance);
        this.tvOrdersIncome = (TextView) layoutInflater.findViewById(C0519R.id.tvOrdersIncome);
        this.tvReward = (TextView) layoutInflater.findViewById(C0519R.id.tvReward);
        this.tvEnsure = (TextView) layoutInflater.findViewById(C0519R.id.tvEnsure);
        this.tvCanceledTrips = (TextView) layoutInflater.findViewById(C0519R.id.tvCanceledTrips);
        this.tvOfficeFee = (TextView) layoutInflater.findViewById(C0519R.id.tvOfficeFee);
        this.tvOrderTimeDialog = (TextView) layoutInflater.findViewById(C0519R.id.tvOrderTimeDialog);
        this.tvEPay = (TextView) layoutInflater.findViewById(C0519R.id.tvEPay);
        this.tvTotalMoney = (TextView) layoutInflater.findViewById(C0519R.id.tvTotalMoney);
        this.tvWeekBalance = (TextView) layoutInflater.findViewById(C0519R.id.tvWeekBalance);
        this.tvDateOrders = (TextView) layoutInflater.findViewById(C0519R.id.tvDateOrders);
        this.btnNewerBillPilot.setOnClickListener(this);
        this.btnOlderBillPilot.setOnClickListener(this);
        BillDriver(String.valueOf(this.numPage), getActivity());
        return layoutInflater;
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0519R.id.btnNewerBillPilot) {
            view = this.numPage;
            this.numPage = view + 1;
            BillDriver(String.valueOf(view), getActivity());
        } else if (view == C0519R.id.btnOlderBillPilot) {
            view = this.numPage;
            this.numPage = view - 1;
            BillDriver(String.valueOf(view), getActivity());
        }
    }

    public void BillDriver(String str, final Context context) {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().BillDriver(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponsePilotBill responsePilotBill = (ResponsePilotBill) obj;
                if (responsePilotBill.isStatus()) {
                    TextView access$000 = BillPilotFragment.this.tvDateOrders;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getFrom());
                    stringBuilder.append(" - ");
                    stringBuilder.append(responsePilotBill.getPilot_bill().getTo());
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvRateBill;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("5/");
                    stringBuilder.append(responsePilotBill.getPilot_bill().getRating());
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvWorksHoursBill;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getWorkHours());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvPointNo;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getCountPoints());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvNoOfOrders;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getCountOrders());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvComplete;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("%");
                    stringBuilder.append(responsePilotBill.getPilot_bill().getCompletedRate());
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvAcceptance;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("%");
                    stringBuilder.append(responsePilotBill.getPilot_bill().getAcceptanceRate());
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvOrdersIncome;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getRevenue());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvEnsure;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getGuarantee());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvCanceledTrips;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getRejectOrder());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvOfficeFee;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getOfficePayment());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvOrderTimeDialog;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getWallet());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvEPay;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getElectronicPaymentService());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvTotalMoney;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getCountTargetsMoney());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    access$000 = BillPilotFragment.this.tvWeekBalance;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(responsePilotBill.getPilot_bill().getAmount_cash());
                    stringBuilder.append("");
                    access$000.setText(stringBuilder.toString());
                    return;
                }
                Constants.showDialog(BillPilotFragment.this.getActivity(), responsePilotBill.getMessage());
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
