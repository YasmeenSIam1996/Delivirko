package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.media.ExifInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObjectStatus;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;

public class SplashActivity extends AppCompatActivity {
    public double LAT;
    public double LNG;
    private FusedLocationProviderClient fusedLocationClient;

    /* renamed from: com.ict.delivirko.Activities.SplashActivity$1 */
    class C05121 implements Runnable {
        C05121() {
        }

        public void run() {
            SplashActivity splashActivity;
            if (!ApplicationController.getInstance().IsDriverUserLoggedIn()) {
                splashActivity = SplashActivity.this;
                splashActivity.checkAndSetCurrentLocation(new Intent(splashActivity.getApplicationContext(), SelectServiceActivity.class));
            } else if (ApplicationController.getInstance().getUser().isDriver()) {
                Context context = SplashActivity.this;
                context.CheckStatus(context);
            } else {
                splashActivity = SplashActivity.this;
                splashActivity.startActivity(new Intent(splashActivity.getApplicationContext(), HomeRestaurantActivity.class));
                SplashActivity.this.finish();
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.SplashActivity$3 */
    class C05133 implements OnClickListener {
        C05133() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            SplashActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            SplashActivity.this.finish();
        }
    }

    /* renamed from: com.ict.delivirko.Activities.SplashActivity$4 */
    class C05144 implements OnClickListener {
        C05144() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            SplashActivity.this.finish();
        }
    }

    /* renamed from: com.ict.delivirko.Activities.SplashActivity$5 */
    class C05155 implements OnCancelListener {
        C05155() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            ActivityCompat.finishAffinity(SplashActivity.this);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_splash);
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient((Activity) this);
        new Handler().postDelayed(new C05121(), 2000);
    }

    public void CheckStatus(final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().CheckStatus(new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObjectStatus responseObjectStatus = (ResponseObjectStatus) obj;
                if (responseObjectStatus.isStatus()) {
                    Intent intent;
                    if (responseObjectStatus.getStatus_().getStatus_id() == 2) {
                        intent = new Intent(SplashActivity.this.getApplicationContext(), PilotTravelActivity.class);
                        intent.putExtra("isEnd", true);
                    } else if (responseObjectStatus.getStatus_().getStatus_id() == 1) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(responseObjectStatus.getStatus_().getStatus_id());
                        stringBuilder.append("");
                        Log.e("CHECK_STATUS3", stringBuilder.toString());
                        intent = new Intent(SplashActivity.this.getApplicationContext(), PilotTravelActivity.class);
                        intent.putExtra("isStart", true);
                    } else {
                        intent = new Intent(SplashActivity.this.getApplicationContext(), HomePilotActivity.class);
                        ApplicationController.getInstance().deleteOrderNotification();
                        ApplicationController.getInstance().deleteTempOrder();
                    }
                    intent.putExtra("OrderStatus", responseObjectStatus.getStatus_());
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
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
                str = new Intent(SplashActivity.this.getApplicationContext(), HomePilotActivity.class);
                ApplicationController.getInstance().deleteOrderNotification();
                ApplicationController.getInstance().deleteTempOrder();
                SplashActivity.this.checkAndSetCurrentLocation(str);
            }
        });
    }

    private void checkAndSetCurrentLocation(Intent intent) {
        if (VERSION.SDK_INT >= 19) {
            int i;
            Log.e("state_", "1");
            Object obj = 1;
            try {
                i = Secure.getInt(getContentResolver(), "location_mode");
            } catch (SettingNotFoundException e) {
                e.printStackTrace();
                i = 1;
            }
            if (i == 0 || i != 3) {
                obj = null;
            }
            if (obj != null) {
                Log.e("state_", ExifInterface.GPS_MEASUREMENT_3D);
                getCurrentLocation(intent);
                return;
            }
            Log.e("state_", "4");
            Toast.makeText(this, "turn on", 0).show();
            showSettingAlert();
            return;
        }
        Log.e("state_", ExifInterface.GPS_MEASUREMENT_2D);
        showSettingAlert();
    }

    public void showSettingAlert() {
        Builder builder = new Builder(this);
        builder.setTitle((CharSequence) "GPS setting!");
        builder.setMessage((CharSequence) "GPS is not enabled, Do you want to go to settings menu? ");
        builder.setPositiveButton((CharSequence) "Setting", new C05133());
        builder.setNegativeButton((CharSequence) "Cancel", new C05144());
        builder.setOnCancelListener(new C05155());
        builder.show();
    }

    private void getCurrentLocation(final Intent intent) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.fusedLocationClient.getLastLocation().addOnSuccessListener((Activity) this, new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        SplashActivity.this.LAT = location.getLatitude();
                        SplashActivity.this.LNG = location.getLongitude();
                        intent.putExtra("LAT", SplashActivity.this.LAT);
                        intent.putExtra("LNG", SplashActivity.this.LNG);
                        SplashActivity.this.startActivity(intent);
                        SplashActivity.this.finish();
                    }
                }
            });
        } else {
            getLocationPermission();
        }
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }
}
