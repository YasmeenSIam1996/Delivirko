package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.ResponseSign;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class LoginRestActivity extends AppCompatActivity implements OnClickListener {
    private Button btnLoginRest;
    private EditText edt_mobile;
    private EditText edt_password;
    private TextView tvForgetRest;

    /* renamed from: com.ict.delivirko.Activities.LoginRestActivity$1 */
    class C09041 implements UniversalCallBack {

        /* renamed from: com.ict.delivirko.Activities.LoginRestActivity$1$1 */
        class C09031 implements OnSuccessListener<InstanceIdResult> {
            C09031() {
            }

            public void onSuccess(InstanceIdResult instanceIdResult) {
                LoginRestActivity.this.setFcm(instanceIdResult.getToken(), LoginRestActivity.this);
            }
        }

        C09041() {
        }

        public void onResponse(Object obj) {
            ResponseSign responseSign = (ResponseSign) obj;
            if (responseSign == null) {
                return;
            }
            if (responseSign.isStatus()) {
                obj = responseSign.getUser();
                obj.setDriver(false);
                ApplicationController.getInstance().loginUser(obj);
                FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new C09031());
                return;
            }
            Constants.showDialog(LoginRestActivity.this, responseSign.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(LoginRestActivity.this, ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
            LoginRestActivity.this.btnLoginRest.setEnabled(true);
        }

        public void OnError(String str) {
            Constants.showDialog(LoginRestActivity.this, str);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_login_rest);
        this.btnLoginRest = (Button) findViewById(C0519R.id.btnLoginRest);
        this.tvForgetRest = (TextView) findViewById(C0519R.id.tvForgetRest);
        this.edt_password = (EditText) findViewById(C0519R.id.edt_password);
        this.edt_mobile = (EditText) findViewById(C0519R.id.edt_mobile);
        this.btnLoginRest.setOnClickListener(this);
        this.tvForgetRest.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != C0519R.id.btnLoginRest) {
            if (view == C0519R.id.tvForgetRest) {
                Constants.showForgetPasswordDialog(this);
            }
        } else if (Constants.ValidationEmptyInput(this.edt_mobile) == null) {
            Constants.showDialog(this, getResources().getString(C0519R.string.EpityMobile));
        } else if (Constants.ValidationEmptyInput(this.edt_password) == null) {
            Constants.showDialog(this, getResources().getString(C0519R.string.EpityPassword));
        } else {
            RestLogin(this.edt_mobile.getText().toString(), this.edt_password.getText().toString());
        }
    }

    public void RestLogin(String str, String str2) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        this.btnLoginRest.setEnabled(false);
        new UserAPI().Login(Constants.LOGIN_REST, str, "", "", str2, new C09041());
    }

    public void setFcm(String str, final Context context) {
        Constants.showSimpleProgressDialog(context, context.getResources().getString(C0519R.string.Loading));
        new UserAPI().setFcm(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject == null) {
                    return;
                }
                if (responseObject.isStatus()) {
                    obj = LoginRestActivity.this;
                    obj.startActivity(new Intent(obj, HomeRestaurantActivity.class));
                    LoginRestActivity.this.finish();
                    return;
                }
                Constants.showDialog((Activity) context, responseObject.getMessage());
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
