package com.ict.delivirko.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.Activities.SelectServiceActivity;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.tapadoo.alerter.Alerter;
import java.util.Locale;

public class Constants {
    public static final String ACCEPT_ORDER = "http://142.93.203.170/api/driver/approveOrder";
    public static final String BASE_COMPANY_URL = "http://142.93.203.170/api/company/";
    public static final String BASE_DRIVER_URL = "http://142.93.203.170/api/driver/";
    public static final String BASE_URL = "http://142.93.203.170/api/";
    public static final String CANCEL_ORDER = "http://142.93.203.170/api/company/cancelOrder";
    public static final String CANCEL_TRAVEL = "http://142.93.203.170/api/driver/cancelOrder";
    public static final String CHECK_STATUS = "http://142.93.203.170/api/driver/checkStatus";
    public static final String COMPANY_BILL = "http://142.93.203.170/api/company/bill";
    public static final String COMPANY_DATA = "http://142.93.203.170/api/company/data";
    public static final String CONDITION = "http://142.93.203.170/api/conditions";
    public static final String CONTACT = "http://142.93.203.170/api/contacts";
    public static final String CREATE_ORDER = "http://142.93.203.170/api/company/createOrder";
    public static final String DESTINATION = "destinations";
    public static final String DISTANCE = "distance";
    public static final String DRIVER_BILL = "http://142.93.203.170/api/driver/bill";
    public static final String DRIVER_DATA = "http://142.93.203.170/api/driver/data";
    public static final String DRIVER_ORDER = "http://142.93.203.170/api/driver/myOrder";
    public static final String FINISH_ORDER = "http://142.93.203.170/api/driver/finishOrder";
    public static final String FONTS_APP = "sf_pro_text_semibold.otf";
    public static final String FORGET_PASS = "http://142.93.203.170/api/forgot/password";
    public static final String FREE_TRIPS = "http://142.93.203.170/api/company/freeTrips";
    public static final String GET_COMPANY_DATA = "http://142.93.203.170/api/company/getMakeOrderData";
    public static final Object GOOGLE_API_KEY = "AIzaSyCq89vpwa_xekSic9fTX15W2T_08UN0obE";
    public static final String GOOGLE_MATRIX_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?";
    public static final String Image_URL = "http://142.93.203.170/public/uploads/";
    public static final String LANGUAGE = "language";
    public static final String LOGIN_DRIVER = "http://142.93.203.170/api/driver/login";
    public static final String LOGIN_REST = "http://142.93.203.170/api/company/login";
    public static final String LOGOUT = "http://142.93.203.170/api/logout";
    public static final String MAKE_ORDER = "http://142.93.203.170/api/company/makeOrder";
    public static final String MODE = "mode";
    public static final String MY_ORDER = "http://142.93.203.170/api/company/myOrder";
    public static final String ORDER_DETAILS = "http://142.93.203.170/api/company/myOrderDetails";
    public static final String ORDER_ON_THE_WAY = "http://142.93.203.170/api/driver/orderOnTheWay";
    public static final String ORIGINS = "origins";
    public static final String PILOT_ORDER_DETAILS = "http://142.93.203.170/api/driver/myOrderDetails";
    public static final String QUESTIONS = "http://142.93.203.170/api/questions";
    public static final String REJECT_ORDER = "http://142.93.203.170/api/driver/rejectOrder";
    public static final String REPORT_BILL = "http://142.93.203.170/api/company/report";
    public static final String RETURN_ORDER = "http://142.93.203.170/api/driver/returnOrder";
    public static final String SENSOR = "sensor";
    public static final String SET_FCM = "http://142.93.203.170/api/setFcmToken";
    public static final String START_TRAVEL = "http://142.93.203.170/api/driver/startOrder";
    public static final String TIME = "time";
    public static final String TRACKING_ORDER = "http://142.93.203.170/api/company/trackingOrders";
    public static final String TRACKING_ORDER_DATA = "http://142.93.203.170/api/company/trackingOrderData";
    public static final String TRACKING_ORDER_DETAILS = "http://142.93.203.170/api/company/trackingOrderDetails";
    public static final String UPDATE_PROFILE = "http://142.93.203.170/api/driver/updateProfile";
    public static final String UPDATE_PROFILE_RES = "http://142.93.203.170/api/company/updateProfile";
    public static Dialog mProgressDialog;

    public static String getLanguage() {
        return Locale.getDefault().getLanguage().equalsIgnoreCase("en") ? "en" : "ar";
    }

    public static void showDialog(Activity activity, String str) {
        Alerter.create(activity).setText(str).hideIcon().setIcon(ContextCompat.getDrawable(activity, C0519R.drawable.pilot_logo)).setBackgroundColorRes(C0519R.color.colorAccent).show();
    }

    public static void showForgetPasswordDialog(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(C0519R.layout.dialog_forget_password);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        TextView textView = (TextView) dialog.findViewById(C0519R.id.tvCloseFDialog);
        final EditText editText = (EditText) dialog.findViewById(C0519R.id.txtForget1);
        Button button = (Button) dialog.findViewById(C0519R.id.rest_btn);
        dialog.setCancelable(false);
        dialog.show();
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (Constants.ValidationEmptyInput(editText) == null) {
                    view = context;
                    Toast.makeText(view, view.getResources().getString(C0519R.string.EpityEmail), 1).show();
                } else if (Constants.isValidEmail(editText) == null) {
                    view = context;
                    Toast.makeText(view, view.getResources().getString(C0519R.string.EmailValid), 1).show();
                } else {
                    Constants.ForgetPass(editText.getText().toString(), context);
                }
            }
        });
    }

    public static boolean ValidationEmptyInput(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString()) != null ? null : true;
    }

    public static boolean isValidEmail(EditText editText) {
        editText = editText.getText().toString();
        return (TextUtils.isEmpty(editText) || Patterns.EMAIL_ADDRESS.matcher(editText).matches() == null) ? null : true;
    }

    public static void showSimpleProgressDialog(Context context, String str) {
        if (context != null) {
            mProgressDialog = new Dialog(context, C0519R.style.DialogSlideAnim_leftright);
            mProgressDialog.requestWindowFeature(1);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            mProgressDialog.setCancelable(false);
            mProgressDialog.setContentView(C0519R.layout.animation_loading);
            ((TextView) mProgressDialog.findViewById(C0519R.id.tv_title)).setText(str);
            mProgressDialog.show();
        }
    }

    public static void removeProgressDialog() {
        Dialog dialog = mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void showCustomDialog(final Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(false);
        dialog.setContentView(C0519R.layout.custom_dialog);
        Button button = (Button) dialog.findViewById(C0519R.id.yes);
        Button button2 = (Button) dialog.findViewById(C0519R.id.no);
        ((TextView) dialog.findViewById(C0519R.id.text)).setText(context.getResources().getString(C0519R.string.logo_out));
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ApplicationController.getInstance().IsDriverUserLoggedIn() != null) {
                    Constants.logout(context);
                    return;
                }
                view = context;
                view.startActivity(new Intent(view, SelectServiceActivity.class));
                ((Activity) context).finish();
            }
        });
        dialog.show();
    }

    public static void logout(final Context context) {
        showSimpleProgressDialog(context, context.getResources().getString(C0519R.string.Loading));
        new UserAPI().logout(new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    ApplicationController.getInstance().deleteUser();
                    obj = context;
                    obj.startActivity(new Intent(obj, SelectServiceActivity.class));
                    ((Activity) context).finish();
                    return;
                }
                Constants.removeProgressDialog();
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

    public static void ForgetPass(String str, final Context context) {
        showSimpleProgressDialog(context, context.getResources().getString(C0519R.string.Loading));
        new UserAPI().ForgetPass(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject == null) {
                    return;
                }
                if (responseObject.isStatus()) {
                    Constants.showDialog((Activity) context, responseObject.getMessage());
                } else {
                    Constants.showDialog((Activity) context, responseObject.getMessage());
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
