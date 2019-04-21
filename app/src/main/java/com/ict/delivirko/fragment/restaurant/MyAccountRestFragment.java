package com.ict.delivirko.fragment.restaurant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.ict.delivirko.fragment.pilot.MyAccountFragment;

public class MyAccountRestFragment extends Fragment {
    private Button btnUpdateRest;
    private EditText txtConfirm;
    private EditText txtEmailUpdateRest;
    private EditText txtMobileUpdateRest;
    private EditText txtNewPass;
    private EditText txtOldPassUpdate;

    /* renamed from: com.ict.delivirko.fragment.restaurant.MyAccountRestFragment$1 */
    class C05541 implements OnClickListener {
        C05541() {
        }

        public void onClick(View view) {
            if (MyAccountRestFragment.this.validateData() != null) {
                MyAccountRestFragment myAccountRestFragment = MyAccountRestFragment.this;
                myAccountRestFragment.UpdateProfile(myAccountRestFragment.txtMobileUpdateRest.getText().toString().trim(), MyAccountRestFragment.this.txtEmailUpdateRest.getText().toString().trim(), MyAccountRestFragment.this.txtNewPass.getText().toString().trim(), MyAccountRestFragment.this.txtConfirm.getText().toString().trim(), MyAccountRestFragment.this.getActivity());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_my_account_rest, viewGroup, false);
        intiView(layoutInflater);
        return layoutInflater;
    }

    private void intiView(View view) {
        this.txtMobileUpdateRest = (EditText) view.findViewById(C0519R.id.txtMobileUpdateRest);
        this.txtEmailUpdateRest = (EditText) view.findViewById(C0519R.id.txtEmailUpdateRest);
        this.txtOldPassUpdate = (EditText) view.findViewById(C0519R.id.txtOldPassUpdate);
        this.txtNewPass = (EditText) view.findViewById(C0519R.id.txtNewPass);
        this.txtConfirm = (EditText) view.findViewById(C0519R.id.txtConfirm);
        this.btnUpdateRest = (Button) view.findViewById(C0519R.id.btnUpdateRest);
        setData();
        this.btnUpdateRest.setOnClickListener(new C05541());
    }

    private void setData() {
        this.txtMobileUpdateRest.setText(ApplicationController.getInstance().getUser().getPhone());
        this.txtEmailUpdateRest.setText(ApplicationController.getInstance().getUser().getEmail());
    }

    private boolean validateData() {
        if (!Constants.ValidationEmptyInput(this.txtMobileUpdateRest)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EpityMobile));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtEmailUpdateRest)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EpityEmail));
            return false;
        } else if (!MyAccountFragment.isValidEmail(this.txtEmailUpdateRest.getText().toString().trim())) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmailNotValidate));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtNewPass)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityNewPass));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtOldPassUpdate)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityOldPass));
            return false;
        } else if (!Constants.ValidationEmptyInput(this.txtConfirm)) {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.EmpityComfirmPass));
            return false;
        } else if (this.txtConfirm.getText().toString().equals(this.txtNewPass.getText().toString())) {
            return true;
        } else {
            Constants.showDialog(getActivity(), getResources().getString(C0519R.string.NotMatchPass));
            return false;
        }
    }

    public void UpdateProfile(final String str, final String str2, String str3, String str4, final Context context) {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().UpdateProfile(Constants.UPDATE_PROFILE_RES, str, str2, str3, str4, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Constants.showDialog(MyAccountRestFragment.this.getActivity(), responseObject.getMessage());
                    ApplicationController.getInstance().getUser().setPhone(str);
                    ApplicationController.getInstance().getUser().setEmail(str2);
                    MyAccountRestFragment.this.setData();
                    return;
                }
                Constants.showDialog(MyAccountRestFragment.this.getActivity(), responseObject.getMessage());
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
