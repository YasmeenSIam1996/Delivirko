package com.ict.delivirko.fragment.restaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseFreeTrips;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class FreeOrdersFragment extends Fragment {
    private TextView TxtDate;
    private TextView TxtNum;
    private TextView tvDiscountAmount;
    private TextView tvDiscountInEgp;

    /* renamed from: com.ict.delivirko.fragment.restaurant.FreeOrdersFragment$1 */
    class C09321 implements UniversalCallBack {
        C09321() {
        }

        public void onResponse(Object obj) {
            ResponseFreeTrips responseFreeTrips = (ResponseFreeTrips) obj;
            if (responseFreeTrips == null) {
                return;
            }
            if (responseFreeTrips.isStatus()) {
                TextView access$000 = FreeOrdersFragment.this.TxtNum;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(responseFreeTrips.getFreeTrips().getOrder_num() - responseFreeTrips.getFreeTrips().getOrder_num_used());
                access$000.setText(stringBuilder.toString());
                FreeOrdersFragment.this.TxtDate.setText(responseFreeTrips.getFreeTrips().getEnd_at());
                access$000 = FreeOrdersFragment.this.tvDiscountAmount;
                stringBuilder = new StringBuilder();
                stringBuilder.append(responseFreeTrips.getFreeTrips().getDiscount_rate());
                stringBuilder.append("");
                access$000.setText(stringBuilder.toString());
                access$000 = FreeOrdersFragment.this.tvDiscountInEgp;
                stringBuilder = new StringBuilder();
                stringBuilder.append(responseFreeTrips.getFreeTrips().getDiscount_max_value());
                stringBuilder.append("");
                access$000.setText(stringBuilder.toString());
                return;
            }
            Constants.showDialog(FreeOrdersFragment.this.getActivity(), responseFreeTrips.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(FreeOrdersFragment.this.getActivity(), ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
        }

        public void OnError(String str) {
            Constants.showDialog(FreeOrdersFragment.this.getActivity(), str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_free_orders, viewGroup, false);
        this.TxtNum = (TextView) layoutInflater.findViewById(C0519R.id.TxtNum);
        this.TxtDate = (TextView) layoutInflater.findViewById(C0519R.id.TxtDate);
        this.tvDiscountAmount = (TextView) layoutInflater.findViewById(C0519R.id.tvDiscountAmount);
        this.tvDiscountInEgp = (TextView) layoutInflater.findViewById(C0519R.id.tvDiscountInEgp);
        FreeTrips();
        return layoutInflater;
    }

    public void FreeTrips() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().FreeTrips(new C09321());
    }
}
