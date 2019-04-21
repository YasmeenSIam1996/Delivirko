package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.ResponseObjectStatus;
import com.ict.delivirko.API.ResponseSign;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class LoginPilotActivity extends AppCompatActivity implements OnClickListener {
    private Button btnLoginPilot;
    private EditText edt_mobile;
    private EditText edt_password;
    private TextView tvForgetPilot;

    /* renamed from: com.ict.delivirko.Activities.LoginPilotActivity$1 */
    class C09001 implements UniversalCallBack {
        C09001() {
        }

        public void onResponse(Object obj) {
            ResponseSign responseSign = (ResponseSign) obj;
            if (responseSign == null) {
                return;
            }
            if (responseSign.isStatus()) {
                obj = responseSign.getUser();
                obj.setDriver(true);
                ApplicationController.getInstance().loginUser(obj);
                LoginPilotActivity.this.setFcm(FirebaseInstanceId.getInstance().getToken(), LoginPilotActivity.this);
                return;
            }
            Constants.showDialog(LoginPilotActivity.this, responseSign.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(LoginPilotActivity.this, ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
            LoginPilotActivity.this.btnLoginPilot.setEnabled(true);
        }

        public void OnError(String str) {
            Constants.showDialog(LoginPilotActivity.this, str);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_login_pilot);
        this.tvForgetPilot = (TextView) findViewById(C0519R.id.tvForgetPilot);
        this.btnLoginPilot = (Button) findViewById(C0519R.id.btnLoginPilot);
        this.edt_password = (EditText) findViewById(C0519R.id.edt_password);
        this.edt_mobile = (EditText) findViewById(C0519R.id.edt_mobile);
        this.tvForgetPilot.setOnClickListener(this);
        this.btnLoginPilot.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != C0519R.id.btnLoginPilot) {
            if (view == C0519R.id.tvForgetPilot) {
                Constants.showForgetPasswordDialog(this);
            }
        } else if (Constants.ValidationEmptyInput(this.edt_mobile) == null) {
            Constants.showDialog(this, getResources().getString(C0519R.string.EpityMobile));
        } else if (Constants.ValidationEmptyInput(this.edt_password) == null) {
            Constants.showDialog(this, getResources().getString(C0519R.string.EpityPassword));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getIntent().getDoubleExtra("LAT", -1.0d));
            stringBuilder.append("");
            Log.e("LAT", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(getIntent().getDoubleExtra("LNG", -1.0d));
            stringBuilder.append("");
            Log.e("LNG", stringBuilder.toString());
            view = this.edt_mobile.getText().toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(getIntent().getDoubleExtra("LAT", -1.0d));
            stringBuilder.append("");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(getIntent().getDoubleExtra("LNG", -1.0d));
            stringBuilder3.append("");
            PilotLogin(view, stringBuilder2, stringBuilder3.toString(), this.edt_password.getText().toString());
        }
    }

    public void PilotLogin(String str, String str2, String str3, String str4) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        this.btnLoginPilot.setEnabled(false);
        new UserAPI().Login(Constants.LOGIN_DRIVER, str, str2, str3, str4, new C09001());
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
                    obj = LoginPilotActivity.this;
                    obj.CheckStatus(obj);
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

    public void CheckStatus(final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().CheckStatus(new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObjectStatus responseObjectStatus = (ResponseObjectStatus) obj;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(responseObjectStatus.isStatus());
                stringBuilder.append("");
                Log.e("CHECK_STATUS", stringBuilder.toString());
                if (!responseObjectStatus.isStatus()) {
                    return;
                }
                if (responseObjectStatus.getStatus_().getStatus_id() == 2) {
                    new Intent(LoginPilotActivity.this.getApplicationContext(), PilotTravelActivity.class).putExtra("isEnd", true);
                } else if (responseObjectStatus.getStatus_().getStatus_id() == 1) {
                    new Intent(LoginPilotActivity.this.getApplicationContext(), PilotTravelActivity.class).putExtra("isStart", true);
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
                Log.e("CHECK_STATUS", str);
                str = new Intent(LoginPilotActivity.this.getApplicationContext(), HomePilotActivity.class);
                ApplicationController.getInstance().deleteOrderNotification();
                ApplicationController.getInstance().deleteTempOrder();
                LoginPilotActivity.this.startActivity(str);
                LoginPilotActivity.this.finish();
            }
        });
    }
}
