package com.ict.delivirko.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseConditions;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class ConditionsFragment extends Fragment {
    private TextView tvConditions;

    /* renamed from: com.ict.delivirko.fragment.ConditionsFragment$1 */
    class C09211 implements UniversalCallBack {
        C09211() {
        }

        public void onResponse(Object obj) {
            ResponseConditions responseConditions = (ResponseConditions) obj;
            if (responseConditions == null) {
                return;
            }
            if (responseConditions.isStatus()) {
                ConditionsFragment.this.tvConditions.setText(responseConditions.getConditions().getValue());
            } else {
                Constants.showDialog(ConditionsFragment.this.getActivity(), responseConditions.getMessage());
            }
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(ConditionsFragment.this.getActivity(), ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
        }

        public void OnError(String str) {
            Constants.showDialog(ConditionsFragment.this.getActivity(), str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_conditions, viewGroup, false);
        this.tvConditions = (TextView) layoutInflater.findViewById(C0519R.id.tvConditions);
        Conditions();
        return layoutInflater;
    }

    public void Conditions() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().Conditions(new C09211());
    }
}
