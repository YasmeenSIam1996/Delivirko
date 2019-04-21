package com.ict.delivirko.fragment.restaurant;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetDialog;
import android.support.media.ExifInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseNearestCompany;
import com.ict.delivirko.API.ResponseNearestDriver;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.ResponseOrderTemp;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.Activities.AddOrderActivity;
import com.ict.delivirko.Activities.HomeRestaurantActivity;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.ObjectClickListener;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Interfaces.UniversalStringCallBack;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.restaurant.Company;
import com.ict.delivirko.Module.restaurant.Driver;
import com.ict.delivirko.Module.restaurant.TrackingOrderDetails;
import com.ict.delivirko.Utils.AddLineToMap;
import com.ict.delivirko.Utils.AlarmReceive;
import com.ict.delivirko.Utils.Constants;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;

public class MapRestaurantFragment extends Fragment implements OnMapReadyCallback, OnMarkerClickListener, OnMapClickListener {
    private boolean IS_ONCE = true;
    private Dialog LoadingPilotsDialog;
    private Button PilotOrder;
    private Dialog RejectPilotsDialog;
    private AddLineToMap addLineToMap;
    private AlarmManager alarmManager;
    private Company companyTemp;
    private Dialog dialog;
    private Marker driverMarker;
    private String duration = "";
    public BroadcastReceiver internetConnectionReciever = new C05528();
    private AlertDialog internetDialog;
    private boolean isNetDialogShowing = false;
    private GoogleMap mMap;
    private PendingIntent pendingIntent;
    private TrackingOrderDetails trackingOrderDetails;

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$2 */
    class C05492 implements OnClickListener {
        C05492() {
        }

        public void onClick(View view) {
            view = MapRestaurantFragment.this;
            view.createCompanyOrder(view.getActivity());
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$5 */
    class C05505 implements OnClickListener {
        C05505() {
        }

        public void onClick(View view) {
            view = MapRestaurantFragment.this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ApplicationController.getInstance().getOrderTemp().getId());
            stringBuilder.append("");
            view.cancelOrder(stringBuilder.toString(), MapRestaurantFragment.this.getActivity(), false);
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$7 */
    class C05517 implements OnClickListener {
        C05517() {
        }

        public void onClick(View view) {
            MapRestaurantFragment.this.RejectPilotsDialog.dismiss();
            ApplicationController.getInstance().deleteTempOrder();
            ApplicationController.getInstance().deleteOrderNotification();
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$8 */
    class C05528 extends BroadcastReceiver {
        C05528() {
        }

        public void onReceive(Context context, Intent intent) {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context != null) {
                switch (context.getType()) {
                    case null:
                        MapRestaurantFragment.this.removeInternetDialog();
                        break;
                    case 1:
                        MapRestaurantFragment.this.removeInternetDialog();
                        break;
                    default:
                        break;
                }
            } else if (MapRestaurantFragment.this.isNetDialogShowing == null) {
                MapRestaurantFragment.this.showInternetDialog();
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$9 */
    class C05539 implements DialogInterface.OnClickListener {
        C05539() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MapRestaurantFragment.this.removeInternetDialog();
            MapRestaurantFragment.this.getActivity().finish();
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$1 */
    class C09331 implements ObjectClickListener {
        C09331() {
        }

        public void onItemClickListener(OrderNotification orderNotification) {
            if (orderNotification.getStatus_id().equals("1") || orderNotification.getStatus_id().equals("0")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(MapRestaurantFragment.this.getActivity().getIntent().getIntExtra("orderNo", 0));
                stringBuilder.append("");
                Log.e("orderNo_111", stringBuilder.toString());
                Intent intent = new Intent(MapRestaurantFragment.this.getActivity(), HomeRestaurantActivity.class);
                intent.putExtra("Status_id", Integer.valueOf(orderNotification.getStatus_id()));
                intent.putExtra("Order_status_text", orderNotification.getOrder_status_text());
                MapRestaurantFragment.this.startActivity(intent);
                MapRestaurantFragment.this.getActivity().finish();
                MapRestaurantFragment.this.LoadingPilotsDialog.dismiss();
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$3 */
    class C09343 implements UniversalCallBack {
        C09343() {
        }

        public void onResponse(Object obj) {
            C09343 c09343 = this;
            ResponseNearestCompany responseNearestCompany = (ResponseNearestCompany) obj;
            if (responseNearestCompany == null) {
                return;
            }
            if (responseNearestCompany.isStatus()) {
                MapRestaurantFragment.this.moveMap(responseNearestCompany.getDataNearestDriver().getNearestDriver().getLat(), responseNearestCompany.getDataNearestDriver().getNearestDriver().getLng(), 1, responseNearestCompany.getDataNearestDriver().getNearestDriver().getName(), false);
                MapRestaurantFragment.this.moveMap(responseNearestCompany.getDataNearestDriver().getLat(), responseNearestCompany.getDataNearestDriver().getLng(), 2, responseNearestCompany.getDataNearestDriver().getAddress(), true);
                return;
            }
            Constants.showDialog(MapRestaurantFragment.this.getActivity(), responseNearestCompany.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(MapRestaurantFragment.this.getActivity(), ((ResponseNearestDriver) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
            MapRestaurantFragment.this.getActivity().getIntent().removeExtra("orderNo");
        }

        public void OnError(String str) {
            Constants.showDialog(MapRestaurantFragment.this.getActivity(), str);
        }
    }

    public void onMapClick(LatLng latLng) {
    }

    public android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/199449817.run(Unknown Source)
*/
        /*
        r3 = this;
        r6 = 2131492935; // 0x7f0c0047 float:1.8609336E38 double:1.0530974335E-314;
        r0 = 0;
        r4 = r4.inflate(r6, r5, r0);
        r5 = new android.app.Dialog;
        r6 = r3.getActivity();
        r5.<init>(r6);
        r3.LoadingPilotsDialog = r5;
        r5 = new android.app.Dialog;
        r6 = r3.getActivity();
        r5.<init>(r6);
        r3.RejectPilotsDialog = r5;
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "orderNo";	 Catch:{ Exception -> 0x00f4 }
        r0 = -1;	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntExtra(r6, r0);	 Catch:{ Exception -> 0x00f4 }
        if (r5 != r0) goto L_0x0034;	 Catch:{ Exception -> 0x00f4 }
    L_0x002f:
        r3.companyData();	 Catch:{ Exception -> 0x00f4 }
        goto L_0x00f4;	 Catch:{ Exception -> 0x00f4 }
    L_0x0034:
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "Status_id";	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntExtra(r6, r0);	 Catch:{ Exception -> 0x00f4 }
        if (r5 != 0) goto L_0x005a;	 Catch:{ Exception -> 0x00f4 }
    L_0x0044:
        r3.companyData();	 Catch:{ Exception -> 0x00f4 }
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "Order_status_text";	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getStringExtra(r6);	 Catch:{ Exception -> 0x00f4 }
        r3.showRejectPilotsDialog(r5);	 Catch:{ Exception -> 0x00f4 }
        goto L_0x00f4;	 Catch:{ Exception -> 0x00f4 }
    L_0x005a:
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "Status_id";	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntExtra(r6, r0);	 Catch:{ Exception -> 0x00f4 }
        r6 = 1;	 Catch:{ Exception -> 0x00f4 }
        if (r5 != r6) goto L_0x00f4;	 Catch:{ Exception -> 0x00f4 }
    L_0x006b:
        r5 = "orderNo_";	 Catch:{ Exception -> 0x00f4 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f4 }
        r6.<init>();	 Catch:{ Exception -> 0x00f4 }
        r1 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r1 = r1.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r2 = "orderNo";	 Catch:{ Exception -> 0x00f4 }
        r1 = r1.getIntExtra(r2, r0);	 Catch:{ Exception -> 0x00f4 }
        r6.append(r1);	 Catch:{ Exception -> 0x00f4 }
        r1 = "";	 Catch:{ Exception -> 0x00f4 }
        r6.append(r1);	 Catch:{ Exception -> 0x00f4 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00f4 }
        android.util.Log.e(r5, r6);	 Catch:{ Exception -> 0x00f4 }
        r5 = "orderNo_2";	 Catch:{ Exception -> 0x00f4 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f4 }
        r6.<init>();	 Catch:{ Exception -> 0x00f4 }
        r1 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r1 = r1.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r2 = "orderNo";	 Catch:{ Exception -> 0x00f4 }
        r1 = r1.getIntExtra(r2, r0);	 Catch:{ Exception -> 0x00f4 }
        r6.append(r1);	 Catch:{ Exception -> 0x00f4 }
        r1 = "";	 Catch:{ Exception -> 0x00f4 }
        r6.append(r1);	 Catch:{ Exception -> 0x00f4 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00f4 }
        android.util.Log.e(r5, r6);	 Catch:{ Exception -> 0x00f4 }
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "orderNo";	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntExtra(r6, r0);	 Catch:{ Exception -> 0x00f4 }
        if (r5 != r0) goto L_0x00df;	 Catch:{ Exception -> 0x00f4 }
    L_0x00c3:
        r5 = com.ict.delivirko.App.ApplicationController.getInstance();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getOrderNotification();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getOrder_id();	 Catch:{ Exception -> 0x00f4 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x00f4 }
        r6 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r3.trackingOrderDetails(r5, r6);	 Catch:{ Exception -> 0x00f4 }
        goto L_0x00f4;	 Catch:{ Exception -> 0x00f4 }
    L_0x00df:
        r5 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntent();	 Catch:{ Exception -> 0x00f4 }
        r6 = "orderNo";	 Catch:{ Exception -> 0x00f4 }
        r5 = r5.getIntExtra(r6, r0);	 Catch:{ Exception -> 0x00f4 }
        r6 = r3.getActivity();	 Catch:{ Exception -> 0x00f4 }
        r3.trackingOrderDetails(r5, r6);	 Catch:{ Exception -> 0x00f4 }
    L_0x00f4:
        r5 = new com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$1;
        r5.<init>();
        com.ict.delivirko.FirebaseUtils.MyFirebaseMessagingService.setOnItemClickListener(r5);
        r5 = r3.getChildFragmentManager();
        r6 = 2131296481; // 0x7f0900e1 float:1.821088E38 double:1.0530003724E-314;
        r5 = r5.findFragmentById(r6);
        r5 = (com.google.android.gms.maps.SupportMapFragment) r5;
        r5.getMapAsync(r3);
        r5 = 2131296278; // 0x7f090016 float:1.8210468E38 double:1.053000272E-314;
        r5 = r4.findViewById(r5);
        r5 = (android.widget.Button) r5;
        r3.PilotOrder = r5;
        r5 = r3.PilotOrder;
        r6 = new com.ict.delivirko.fragment.restaurant.MapRestaurantFragment$2;
        r6.<init>();
        r5.setOnClickListener(r6);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void companyData() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().companyData(new C09343());
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMarkerClickListener(this);
        this.addLineToMap = new AddLineToMap(this.mMap, getActivity());
        getLocationPermission();
        if (this.alarmManager == null) {
            this.alarmManager = (AlarmManager) getActivity().getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent(getActivity(), AlarmReceive.class), 0);
            this.alarmManager.setRepeating(0, System.currentTimeMillis(), 10000, this.pendingIntent);
        }
    }

    private void moveMap(double d, double d2, int i, String str, boolean z) {
        LatLng latLng = new LatLng(d, d2);
        if (i == 1) {
            this.mMap.addMarker(new MarkerOptions().position(latLng).draggable(true).title(str).icon(BitmapDescriptorFactory.fromResource(1.052935608E-314d)));
        } else if (i == 3) {
            this.mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(this.addLineToMap.getMarkerBitmapFromView(this.duration, ExifInterface.GPS_MEASUREMENT_2D))));
        } else {
            this.mMap.addMarker(new MarkerOptions().position(latLng).draggable(true).title(str).icon(BitmapDescriptorFactory.fromResource(1.052935624E-314d)));
        }
        if (z) {
            this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 7.0f));
        } else {
            this.mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        this.mMap.getUiSettings().setZoomControlsEnabled(false);
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public void createCompanyOrder(final Context context) {
        new UserAPI().createCompanyOrder(new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseOrderTemp responseOrderTemp = (ResponseOrderTemp) obj;
                if (responseOrderTemp.isStatus()) {
                    ApplicationController.getInstance().SetTempOrder(responseOrderTemp.getOrderTemp());
                    MapRestaurantFragment.this.showLoadingPilotsDialog();
                    return;
                }
                Constants.showDialog((Activity) context, responseOrderTemp.getMessage());
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }

    public void showLoadingPilotsDialog() {
        this.LoadingPilotsDialog.setContentView(C0519R.layout.loading_pilots_dialog);
        this.LoadingPilotsDialog.getWindow().setBackgroundDrawableResource(17170445);
        this.LoadingPilotsDialog.setCancelable(false);
        this.LoadingPilotsDialog.show();
        ((Button) this.LoadingPilotsDialog.findViewById(C0519R.id.CancelOrder)).setOnClickListener(new C05505());
    }

    public void cancelOrder(String str, final Context context, final boolean z) {
        new UserAPI().cancelOrder(str, new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    if (MapRestaurantFragment.this.LoadingPilotsDialog != null) {
                        MapRestaurantFragment.this.LoadingPilotsDialog.dismiss();
                    }
                    if (MapRestaurantFragment.this.dialog != null) {
                        MapRestaurantFragment.this.dialog.dismiss();
                    }
                    Constants.showDialog((Activity) context, responseObject.getMessage());
                    if (z != null) {
                        obj = MapRestaurantFragment.this;
                        obj.startActivity(new Intent(obj.getActivity(), HomeRestaurantActivity.class));
                        MapRestaurantFragment.this.getActivity().finish();
                        return;
                    }
                    return;
                }
                Toast.makeText(context, responseObject.getMessage(), 1).show();
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }

    public void showRejectPilotsDialog(String str) {
        this.RejectPilotsDialog.setContentView(C0519R.layout.reject_pilots_dialog);
        this.RejectPilotsDialog.getWindow().setBackgroundDrawableResource(17170445);
        this.RejectPilotsDialog.setCancelable(false);
        ((TextView) this.RejectPilotsDialog.findViewById(C0519R.id.textDialog)).setText(str);
        ((Button) this.RejectPilotsDialog.findViewById(C0519R.id.Done)).setOnClickListener(new C05517());
        this.RejectPilotsDialog.show();
    }

    public void onResume() {
        super.onResume();
        new ContextWrapper(getActivity()).registerReceiver(this.internetConnectionReciever, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void removeInternetDialog() {
        AlertDialog alertDialog = this.internetDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.internetDialog.dismiss();
            this.isNetDialogShowing = false;
            this.internetDialog = null;
        }
    }

    private void showInternetDialog() {
        this.isNetDialogShowing = true;
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(getString(C0519R.string.dialog_no_internet)).setMessage(getString(C0519R.string.dialog_no_inter_message)).setPositiveButton(getString(C0519R.string.dialog_enable_3g), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MapRestaurantFragment.this.startActivity(new Intent("android.settings.SETTINGS"));
                MapRestaurantFragment.this.removeInternetDialog();
            }
        }).setNeutralButton(getString(C0519R.string.dialog_enable_wifi), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MapRestaurantFragment.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                MapRestaurantFragment.this.removeInternetDialog();
            }
        }).setNegativeButton(getString(C0519R.string.dialog_exit), new C05539());
        this.internetDialog = builder.create();
        this.internetDialog.show();
    }

    private void showDialog(final Driver driver, final int i) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), C0519R.style.SheetDialog);
        bottomSheetDialog.setContentView((int) C0519R.layout.bottom_pilot);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.show();
        Button button = (Button) bottomSheetDialog.findViewById(C0519R.id.AddOrder);
        Button button2 = (Button) bottomSheetDialog.findViewById(C0519R.id.CancelOrder);
        TextView textView = (TextView) bottomSheetDialog.findViewById(C0519R.id.motorcycle);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(C0519R.id.telephone);
        TextView textView3 = (TextView) bottomSheetDialog.findViewById(C0519R.id.PilotName);
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(C0519R.id.pilot_image);
        TextView textView4 = (TextView) bottomSheetDialog.findViewById(C0519R.id.num);
        ImageView imageView2 = (ImageView) bottomSheetDialog.findViewById(C0519R.id.call);
        RatingBar ratingBar = (RatingBar) bottomSheetDialog.findViewById(C0519R.id.rateBarRest);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(driver.getCar_number());
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        textView3.setText(driver.getName());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Float.valueOf(driver.getDriver_rating()));
        stringBuilder2.append("");
        ratingBar.setRating(Float.parseFloat(stringBuilder2.toString()));
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(driver.getPhone());
        stringBuilder3.append("");
        textView2.setText(stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(driver.getDriver_rating_count());
        stringBuilder3.append("");
        textView4.setText(stringBuilder3.toString());
        Picasso picasso = Picasso.get();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Constants.Image_URL);
        stringBuilder2.append(driver.getImage());
        picasso.load(stringBuilder2.toString()).fit().into(imageView);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view = MapRestaurantFragment.this;
                view.showCancelDialog(view.getActivity(), i);
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view = new Intent(MapRestaurantFragment.this.getActivity(), AddOrderActivity.class);
                view.putExtra("orderId", i);
                MapRestaurantFragment.this.startActivity(view);
            }
        });
        imageView2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Context activity;
                StringBuilder stringBuilder;
                if (VERSION.SDK_INT < 23) {
                    view = MapRestaurantFragment.this;
                    activity = view.getActivity();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("");
                    stringBuilder.append(driver.getPhone());
                    view.phoneCall(activity, stringBuilder.toString());
                } else if (ContextCompat.checkSelfPermission(MapRestaurantFragment.this.getActivity(), "android.permission.CALL_PHONE") == null) {
                    view = MapRestaurantFragment.this;
                    activity = view.getActivity();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("");
                    stringBuilder.append(driver.getPhone());
                    view.phoneCall(activity, stringBuilder.toString());
                } else {
                    ActivityCompat.requestPermissions(MapRestaurantFragment.this.getActivity(), new String[]{"android.permission.CALL_PHONE"}, 9);
                }
            }
        });
    }

    public void showCancelDialog(Context context, final int i) {
        this.dialog = new Dialog(context);
        this.dialog.setContentView(C0519R.layout.dialog_question);
        this.dialog.getWindow().setBackgroundDrawableResource(17170445);
        TextView textView = (TextView) this.dialog.findViewById(C0519R.id.tvCloseQuestionDialog);
        Button button = (Button) this.dialog.findViewById(C0519R.id.btnDialogReject);
        Button button2 = (Button) this.dialog.findViewById(C0519R.id.btnDialogAgree);
        this.dialog.setCancelable(false);
        this.dialog.show();
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MapRestaurantFragment.this.dialog.dismiss();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MapRestaurantFragment.this.dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                view = MapRestaurantFragment.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("");
                view.cancelOrder(stringBuilder.toString(), MapRestaurantFragment.this.getActivity(), true);
            }
        });
    }

    private void phoneCall(Context context, String str) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.CALL_PHONE") == 0) {
            Intent intent = new Intent("android.intent.action.CALL");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tel:");
            stringBuilder.append(str);
            intent.setData(Uri.parse(stringBuilder.toString()));
            context.startActivity(intent);
            return;
        }
        Constants.showDialog((Activity) context, getActivity().getResources().getString(C0519R.string.permission));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        i = i != 9 ? 0 : iArr[0] == 0 ? 1 : 0;
        if (i != 0) {
            i = getActivity();
            strArr = new StringBuilder();
            strArr.append("");
            strArr.append(ApplicationController.getInstance().getOrderNotification().getDriver_phone());
            phoneCall(i, strArr.toString());
            return;
        }
        Toast.makeText(getActivity(), getActivity().getResources().getString(C0519R.string.permission), 0).show();
    }

    public void trackingOrderDetails(int i, final Context context) {
        UserAPI userAPI = new UserAPI();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        userAPI.trackingOrderDetails(stringBuilder.toString(), new UniversalCallBack() {
            public void onResponse(java.lang.Object r11) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/199449817.run(Unknown Source)
*/
                /*
                r10 = this;
                r11 = (com.ict.delivirko.API.ResponseTrackingOrderDetails) r11;
                r0 = r11.isStatus();
                if (r0 == 0) goto L_0x0171;
            L_0x0008:
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r1 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r0.trackingOrderDetails = r1;	 Catch:{ Exception -> 0x017c }
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r0 = r0.getActivity();	 Catch:{ Exception -> 0x017c }
                r0 = r0.getIntent();	 Catch:{ Exception -> 0x017c }
                r1 = "Status_id";	 Catch:{ Exception -> 0x017c }
                r2 = 1;	 Catch:{ Exception -> 0x017c }
                r0 = r0.getIntExtra(r1, r2);	 Catch:{ Exception -> 0x017c }
                if (r0 != 0) goto L_0x0048;	 Catch:{ Exception -> 0x017c }
            L_0x0024:
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r11 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r11 = r11.getOrder();	 Catch:{ Exception -> 0x017c }
                r11 = r11.getStatus_text();	 Catch:{ Exception -> 0x017c }
                r0.showRejectPilotsDialog(r11);	 Catch:{ Exception -> 0x017c }
                r11 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r11 = r11.getActivity();	 Catch:{ Exception -> 0x017c }
                r0 = "notification";	 Catch:{ Exception -> 0x017c }
                r11 = r11.getSystemService(r0);	 Catch:{ Exception -> 0x017c }
                r11 = (android.app.NotificationManager) r11;	 Catch:{ Exception -> 0x017c }
                r11.cancelAll();	 Catch:{ Exception -> 0x017c }
                goto L_0x017c;	 Catch:{ Exception -> 0x017c }
            L_0x0048:
                if (r0 != r2) goto L_0x017c;	 Catch:{ Exception -> 0x017c }
            L_0x004a:
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r1 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r1 = r1.getDriver();	 Catch:{ Exception -> 0x017c }
                r2 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r2 = r2.getOrder();	 Catch:{ Exception -> 0x017c }
                r2 = r2.getId();	 Catch:{ Exception -> 0x017c }
                r0.showDialog(r1, r2);	 Catch:{ Exception -> 0x017c }
                r0 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x017c }
                r1 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r1 = r1.getDriver();	 Catch:{ Exception -> 0x017c }
                r1 = r1.getLat();	 Catch:{ Exception -> 0x017c }
                r3 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r3 = r3.getDriver();	 Catch:{ Exception -> 0x017c }
                r3 = r3.getLng();	 Catch:{ Exception -> 0x017c }
                r0.<init>(r1, r3);	 Catch:{ Exception -> 0x017c }
                r1 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x017c }
                r2 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r2 = r2.getCompany();	 Catch:{ Exception -> 0x017c }
                r2 = r2.getLat();	 Catch:{ Exception -> 0x017c }
                r4 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r4 = r4.getCompany();	 Catch:{ Exception -> 0x017c }
                r4 = r4.getLng();	 Catch:{ Exception -> 0x017c }
                r1.<init>(r2, r4);	 Catch:{ Exception -> 0x017c }
                r2 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r2 = r2.addLineToMap;	 Catch:{ Exception -> 0x017c }
                r2.addMarker(r1);	 Catch:{ Exception -> 0x017c }
                r2 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r2 = r2.addLineToMap;	 Catch:{ Exception -> 0x017c }
                r2.addMarker(r0);	 Catch:{ Exception -> 0x017c }
                r3 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r2 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r2 = r2.getCompany();	 Catch:{ Exception -> 0x017c }
                r4 = r2.getAddress();	 Catch:{ Exception -> 0x017c }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
                r2.<init>();	 Catch:{ Exception -> 0x017c }
                r5 = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = r1.latitude;	 Catch:{ Exception -> 0x017c }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = ",";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = r1.longitude;	 Catch:{ Exception -> 0x017c }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "&";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "destinations";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "=";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = r0.latitude;	 Catch:{ Exception -> 0x017c }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = ",";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = r0.longitude;	 Catch:{ Exception -> 0x017c }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "&";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "mode";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "=driving&";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "language";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "=en-EN&key=";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = com.ict.delivirko.Utils.Constants.GOOGLE_API_KEY;	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "&";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "sensor";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = "=";	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = 0;	 Catch:{ Exception -> 0x017c }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x017c }
                r2.append(r5);	 Catch:{ Exception -> 0x017c }
                r5 = r2.toString();	 Catch:{ Exception -> 0x017c }
                r2 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r8 = r2.getActivity();	 Catch:{ Exception -> 0x017c }
                r9 = 1;	 Catch:{ Exception -> 0x017c }
                r6 = r1;	 Catch:{ Exception -> 0x017c }
                r7 = r0;	 Catch:{ Exception -> 0x017c }
                r3.TimeTrackingOrder(r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x017c }
                r2 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r2 = r2.addLineToMap;	 Catch:{ Exception -> 0x017c }
                r2.ZoomBetween2Marker(r1, r0);	 Catch:{ Exception -> 0x017c }
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r1 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r1 = r1.getCompany();	 Catch:{ Exception -> 0x017c }
                r0.companyTemp = r1;	 Catch:{ Exception -> 0x017c }
                r0 = com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.this;	 Catch:{ Exception -> 0x017c }
                r11 = r11.getTrackingOrderDetails();	 Catch:{ Exception -> 0x017c }
                r11 = r11.getDriver();	 Catch:{ Exception -> 0x017c }
                r11 = r11.getId();	 Catch:{ Exception -> 0x017c }
                r0.MovementDriverMarker(r11);	 Catch:{ Exception -> 0x017c }
                goto L_0x017c;
            L_0x0171:
                r0 = r4;
                r0 = (android.app.Activity) r0;
                r11 = r11.getMessage();
                com.ict.delivirko.Utils.Constants.showDialog(r0, r11);
            L_0x017c:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.18.onResponse(java.lang.Object):void");
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void onFinish() {
                MapRestaurantFragment.this.getActivity().getIntent().removeExtra("orderNo");
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }

    private void MovementDriverMarker(int i) {
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drivers/");
        stringBuilder.append(i);
        stringBuilder.append("/");
        instance.getReference(stringBuilder.toString()).addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                Double d = (Double) dataSnapshot.child("lat").getValue(Double.TYPE);
                Double d2 = (Double) dataSnapshot.child("lng").getValue(Double.TYPE);
                MapRestaurantFragment mapRestaurantFragment = MapRestaurantFragment.this;
                String address = mapRestaurantFragment.companyTemp.getAddress();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://maps.googleapis.com/maps/api/distancematrix/json?origins=");
                stringBuilder.append(String.valueOf(MapRestaurantFragment.this.companyTemp.getLat()));
                stringBuilder.append(",");
                stringBuilder.append(String.valueOf(MapRestaurantFragment.this.companyTemp.getLng()));
                stringBuilder.append("&");
                stringBuilder.append(Constants.DESTINATION);
                stringBuilder.append("=");
                stringBuilder.append(String.valueOf(d));
                stringBuilder.append(",");
                stringBuilder.append(String.valueOf(d2));
                stringBuilder.append("&");
                stringBuilder.append(Constants.MODE);
                stringBuilder.append("=driving&");
                stringBuilder.append(Constants.LANGUAGE);
                stringBuilder.append("=en-EN&key=");
                stringBuilder.append(Constants.GOOGLE_API_KEY);
                stringBuilder.append("&");
                stringBuilder.append(Constants.SENSOR);
                stringBuilder.append("=");
                stringBuilder.append(String.valueOf(false));
                mapRestaurantFragment.TimeTrackingOrder(address, stringBuilder.toString(), new LatLng(MapRestaurantFragment.this.companyTemp.getLat(), MapRestaurantFragment.this.companyTemp.getLng()), new LatLng(d.doubleValue(), d2.doubleValue()), MapRestaurantFragment.this.getActivity(), false);
                MapRestaurantFragment.this.addLineToMap.addMarker(new LatLng(MapRestaurantFragment.this.companyTemp.getLat(), MapRestaurantFragment.this.companyTemp.getLng()));
                MapRestaurantFragment.this.addLineToMap.addMarker(new LatLng(d.doubleValue(), d2.doubleValue()));
            }

            public void onCancelled(DatabaseError databaseError) {
                Log.w("Failed_", "Failed to read value.", databaseError.toException());
            }
        });
    }

    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/199449817.run(Unknown Source)
*/
        /*
        r1 = this;
        r2 = r1.trackingOrderDetails;	 Catch:{ Exception -> 0x0013 }
        r2 = r2.getDriver();	 Catch:{ Exception -> 0x0013 }
        r0 = r1.trackingOrderDetails;	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getOrder();	 Catch:{ Exception -> 0x0013 }
        r0 = r0.getId();	 Catch:{ Exception -> 0x0013 }
        r1.showDialog(r2, r0);	 Catch:{ Exception -> 0x0013 }
    L_0x0013:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.fragment.restaurant.MapRestaurantFragment.onMarkerClick(com.google.android.gms.maps.model.Marker):boolean");
    }

    public void onPause() {
        super.onPause();
        getActivity().getIntent().removeExtra("orderNo");
    }

    public void TimeTrackingOrder(String str, String str2, LatLng latLng, LatLng latLng2, Context context, boolean z) {
        final boolean z2 = z;
        final LatLng latLng3 = latLng;
        final String str3 = str;
        final LatLng latLng4 = latLng2;
        final Context context2 = context;
        new UserAPI().TimeOrderTracking(str2, new UniversalStringCallBack() {
            public void onFinish() {
            }

            public void onResponse(String str) {
                Log.e("result1_result1", str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getString(NotificationCompat.CATEGORY_STATUS).equals("OK") != null) {
                        MapRestaurantFragment.this.duration = jSONObject.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
                        if (z2 != null) {
                            MapRestaurantFragment.this.mMap.addMarker(new MarkerOptions().position(latLng3).icon(BitmapDescriptorFactory.fromBitmap(MapRestaurantFragment.this.addLineToMap.getMarkerBitmapFromView(str3, "1"))));
                            MapRestaurantFragment.this.driverMarker = MapRestaurantFragment.this.mMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(MapRestaurantFragment.this.addLineToMap.getMarkerBitmapFromView(MapRestaurantFragment.this.duration, ExifInterface.GPS_MEASUREMENT_2D))));
                            return;
                        }
                        if (MapRestaurantFragment.this.IS_ONCE != null) {
                            MapRestaurantFragment.this.addLineToMap.deleteDriverMarker();
                            if (MapRestaurantFragment.this.driverMarker != null) {
                                MapRestaurantFragment.this.driverMarker.remove();
                            }
                            MapRestaurantFragment.this.IS_ONCE = false;
                        }
                        MapRestaurantFragment.this.mMap.addMarker(new MarkerOptions().position(latLng3).icon(BitmapDescriptorFactory.fromBitmap(MapRestaurantFragment.this.addLineToMap.getMarkerBitmapFromView(str3, "1"))));
                        MapRestaurantFragment.this.moveMap(latLng4.latitude, latLng4.longitude, 3, "Driver", false);
                    }
                } catch (String str2) {
                    str2.printStackTrace();
                }
            }

            public void onFailure(String str) {
                if (str != null) {
                    Constants.showDialog((Activity) context2, str);
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context2, str);
            }
        });
    }
}
