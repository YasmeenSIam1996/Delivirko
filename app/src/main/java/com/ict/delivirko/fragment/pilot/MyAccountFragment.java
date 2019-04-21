package com.ict.delivirko.fragment.pilot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class MyAccountFragment extends Fragment {
    private Button btnUpdatePilot;
    private EditText txtConfirmPilot;
    private EditText txtEmailUpdatePilot;
    private EditText txtMobileUpdatePilot;
    private EditText txtNewPassPilot;
    private EditText txtOldPassUpdate;

    /* renamed from: com.ict.delivirko.fragment.pilot.MyAccountFragment$1 */
    class C05391 implements OnClickListener {
        C05391() {
        }

        public void onClick(View view) {
            if (MyAccountFragment.this.validateData() != null) {
                MyAccountFragment myAccountFragment = MyAccountFragment.this;
                myAccountFragment.UpdateProfile(myAccountFragment.txtMobileUpdatePilot.getText().toString().trim(), MyAccountFragment.this.txtEmailUpdatePilot.getText().toString().trim(), MyAccountFragment.this.txtNewPassPilot.getText().toString().trim(), MyAccountFragment.this.txtConfirmPilot.getText().toString().trim(), MyAccountFragment.this.getActivity());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_my_account_pilot, viewGroup, false);
        findViews(layoutInflater);
        return layoutInflater;
    }

    private void findViews(View view) {
        this.txtMobileUpdatePilot = (EditText) view.findViewById(C0519R.id.txtMobileUpdatePilot);
        this.txtEmailUpdatePilot = (EditText) view.findViewById(C0519R.id.txtEmailUpdatePilot);
        this.txtNewPassPilot = (EditText) view.findViewById(C0519R.id.txtNewPass);
        this.txtOldPassUpdate = (EditText) view.findViewById(C0519R.id.txtOldPass);
        this.txtConfirmPilot = (EditText) view.findViewById(C0519R.id.txtConfirm);
        this.btnUpdatePilot = (Button) view.findViewById(C0519R.id.btnUpdatePilot);
        setData();
        this.btnUpdatePilot.setOnClickListener(new C05391());
    }

    private void setData() {
        this.txtMobileUpdatePilot.setText(ApplicationController.getInstance().getUser().getPhone());
        this.txtEmailUpdatePilot.setText(ApplicationController.getInstance().getUser().getEmail());
    }

    private boolean validateData() {
        if (!Constants.ValidationEmptyInput(this.txtMobileUpdatePilot)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EpityMobile));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtEmailUpdatePilot)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EpityEmail));
            return false;
        } else if (!isValidEmail(this.txtEmailUpdatePilot.getText().toString().trim())) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmailNotValidate));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtNewPassPilot)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityNewPass));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtOldPassUpdate)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityOldPass));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtConfirmPilot)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityComfirmPass));
            return false;
        } else if (this.txtConfirmPilot.getText().toString().equals(this.txtNewPassPilot.getText().toString())) {
            return true;
        } else {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.NotMatchPass));
            return false;
        }
    }

    public static boolean isValidEmail(CharSequence charSequence) {
        return (TextUtils.isEmpty(charSequence) || Patterns.EMAIL_ADDRESS.matcher(charSequence).matches() == null) ? null : true;
    }

    public void UpdateProfile(final String str, final String str2, String str3, String str4, final Context context) {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().UpdateProfile(Constants.UPDATE_PROFILE, str, str2, str3, str4, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Constants.showDialog(MyAccountFragment.this.getActivity(), responseObject.getMessage());
                    ApplicationController.getInstance().getUser().setPhone(str);
                    ApplicationController.getInstance().getUser().setEmail(str2);
                    MyAccountFragment.this.setData();
                    return;
                }
                Constants.showDialog(MyAccountFragment.this.getActivity(), responseObject.getMessage());
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
