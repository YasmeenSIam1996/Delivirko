package com.ict.delivirko.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseObject;
import com.ict.delivirko.API.ResponseOnTheWay;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Interfaces.UniversalStringCallBack;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.pilot.Status;
import com.ict.delivirko.Utils.AddLineToMap;
import com.ict.delivirko.Utils.Constants;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;

public class PilotTravelActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 5445;
    private TextView ClintName;
    private String CompanyTel = "";
    private TextView Company_name;
    private Button EndTravel;
    private TextView LocationFrom;
    private RelativeLayout LocationLay;
    private TextView LocationTo;
    private String OrderTel = "";
    private TextView Price;
    private Button ReturnOrder;
    private AddLineToMap addLineToMap;
    private Button agree;
    private ImageView call;
    private RelativeLayout company_bottom_sheet_layout;
    private ImageView company_image;
    private Location currentLocation;
    private ImageButton currentLocationImageButton;
    private Marker currentLocationMarker;
    private boolean firstTimeFlag = true;
    private TextView fromLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private boolean isEnd = false;
    private boolean isStart = false;
    private final LocationCallback mLocationCallback = new C09068();
    private GoogleMap mMap;
    private OrderNotification orderNotification;
    private Button reject;
    private int second = 0;
    private Status statusOrder;
    private TextView telephone;
    private TextView text_timer;
    private TextView toLocation;

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$1 */
    class C05041 implements OnClickListener {
        C05041() {
        }

        public void onClick(View view) {
            view = PilotTravelActivity.this;
            view.animateCamera(view.currentLocation);
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$2 */
    class C05062 implements OnClickListener {
        C05062() {
        }

        public void onClick(View view) {
            StringBuilder stringBuilder;
            if (PilotTravelActivity.this.isStart != null) {
                if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                    view = PilotTravelActivity.this;
                    view.CancelTravel(view.orderNotification.getOrder_id(), PilotTravelActivity.this);
                    return;
                }
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.CancelTravel(stringBuilder.toString(), PilotTravelActivity.this);
            } else if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                view = PilotTravelActivity.this;
                view.RejectOrder(view.orderNotification.getOrder_id(), PilotTravelActivity.this);
            } else {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.RejectOrder(stringBuilder.toString(), PilotTravelActivity.this);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$3 */
    class C05073 implements OnClickListener {
        C05073() {
        }

        public void onClick(View view) {
            StringBuilder stringBuilder;
            if (PilotTravelActivity.this.isStart != null) {
                if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                    view = PilotTravelActivity.this;
                    view.StartTravel(view.orderNotification.getOrder_id(), PilotTravelActivity.this);
                    return;
                }
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.StartTravel(stringBuilder.toString(), PilotTravelActivity.this);
            } else if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                view = PilotTravelActivity.this;
                view.AcceptOrder(view.orderNotification.getOrder_id(), PilotTravelActivity.this);
            } else {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.AcceptOrder(stringBuilder.toString(), PilotTravelActivity.this);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$4 */
    class C05084 implements OnClickListener {
        C05084() {
        }

        public void onClick(View view) {
            view = PilotTravelActivity.this;
            view.showReturnDialog(view);
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$5 */
    class C05095 implements OnClickListener {
        C05095() {
        }

        public void onClick(View view) {
            view = PilotTravelActivity.this;
            view.showEndDialog(view);
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$6 */
    class C05106 implements OnClickListener {
        C05106() {
        }

        public void onClick(View view) {
            StringBuilder stringBuilder;
            if (VERSION.SDK_INT < 23) {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(PilotTravelActivity.this.CompanyTel);
                view.phoneCall(view, stringBuilder.toString());
            } else if (ContextCompat.checkSelfPermission(PilotTravelActivity.this, "android.permission.CALL_PHONE") == null) {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(PilotTravelActivity.this.CompanyTel);
                view.phoneCall(view, stringBuilder.toString());
            } else {
                ActivityCompat.requestPermissions(PilotTravelActivity.this, new String[]{"android.permission.CALL_PHONE"}, 9);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$7 */
    class C05117 implements OnClickListener {
        C05117() {
        }

        public void onClick(View view) {
            StringBuilder stringBuilder;
            if (VERSION.SDK_INT < 23) {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(PilotTravelActivity.this.OrderTel);
                view.phoneCall(view, stringBuilder.toString());
            } else if (ContextCompat.checkSelfPermission(PilotTravelActivity.this, "android.permission.CALL_PHONE") == null) {
                view = PilotTravelActivity.this;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(PilotTravelActivity.this.OrderTel);
                view.phoneCall(view, stringBuilder.toString());
            } else {
                ActivityCompat.requestPermissions(PilotTravelActivity.this, new String[]{"android.permission.CALL_PHONE"}, 9);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.PilotTravelActivity$8 */
    class C09068 extends LocationCallback {
        C09068() {
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PilotTravelActivity.this.second);
            stringBuilder.append("");
            Log.e("_second_", stringBuilder.toString());
            if (PilotTravelActivity.this.second == 0 || PilotTravelActivity.this.second == 7) {
                if (locationResult.getLastLocation() != null) {
                    PilotTravelActivity.this.currentLocation = locationResult.getLastLocation();
                    locationResult = PilotTravelActivity.this;
                    locationResult.changeLocationFirebase(new LatLng(locationResult.currentLocation.getLatitude(), PilotTravelActivity.this.currentLocation.getLongitude()));
                    if (!(PilotTravelActivity.this.firstTimeFlag == null || PilotTravelActivity.this.mMap == null)) {
                        locationResult = PilotTravelActivity.this;
                        locationResult.animateCamera(locationResult.currentLocation);
                        PilotTravelActivity.this.firstTimeFlag = false;
                    }
                    locationResult = PilotTravelActivity.this;
                    locationResult.showMarker(locationResult.currentLocation);
                } else {
                    return;
                }
            }
            PilotTravelActivity.this.second = PilotTravelActivity.this.second + 1;
            if (PilotTravelActivity.this.second == 7) {
                PilotTravelActivity.this.second = 0;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0519R.layout.activity_pilot_travel);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.map)).getMapAsync(this);
        intiViews();
        intiActions();
        this.currentLocationImageButton = (ImageButton) findViewById(C0519R.id.currentLocationImageButton);
        this.currentLocationImageButton.setOnClickListener(new C05041());
    }

    private void intiActions() {
        OrderNotification orderNotification = this.orderNotification;
        if (orderNotification != null) {
            orderNotification.getWaiting_time();
        } else {
            this.statusOrder.getOrder().getWaiting_time();
        }
        this.reject.setOnClickListener(new C05062());
        this.agree.setOnClickListener(new C05073());
        this.ReturnOrder.setOnClickListener(new C05084());
        this.EndTravel.setOnClickListener(new C05095());
        this.call.setOnClickListener(new C05106());
        this.telephone.setOnClickListener(new C05117());
    }

    private void intiViews() {
        this.statusOrder = (Status) getIntent().getSerializableExtra("OrderStatus");
        this.orderNotification = ApplicationController.getInstance().getOrderNotification();
        this.text_timer = (TextView) findViewById(C0519R.id.text_timer);
        this.LocationFrom = (TextView) findViewById(C0519R.id.LocationFrom);
        this.LocationTo = (TextView) findViewById(C0519R.id.LocationTo);
        this.reject = (Button) findViewById(C0519R.id.reject);
        this.agree = (Button) findViewById(C0519R.id.agree);
        this.company_bottom_sheet_layout = (RelativeLayout) findViewById(C0519R.id.company_bottom_sheet_layout);
        this.LocationLay = (RelativeLayout) findViewById(C0519R.id.place_back_map_layout);
        this.ReturnOrder = (Button) findViewById(C0519R.id.ReturnOrder);
        this.EndTravel = (Button) findViewById(C0519R.id.EndTravel);
        this.call = (ImageView) findViewById(C0519R.id.call);
        this.company_image = (ImageView) findViewById(C0519R.id.company_image);
        this.ClintName = (TextView) findViewById(C0519R.id.ClintName);
        this.Company_name = (TextView) findViewById(C0519R.id.Company_name);
        this.telephone = (TextView) findViewById(C0519R.id.telephone);
        this.fromLocation = (TextView) findViewById(C0519R.id.fromLocation);
        this.toLocation = (TextView) findViewById(C0519R.id.toLocation);
        this.Price = (TextView) findViewById(C0519R.id.TxtPrice);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.map)).getMapAsync(this);
        this.isStart = getIntent().getBooleanExtra("isStart", false);
        this.isEnd = getIntent().getBooleanExtra("isEnd", false);
        if (this.isStart) {
            this.text_timer.setVisibility(8);
            this.reject.setText(getResources().getString(C0519R.string.CancelTravel));
            this.agree.setText(getResources().getString(C0519R.string.StartTravel));
        }
        if (this.isEnd) {
            this.company_bottom_sheet_layout.setVisibility(0);
            this.text_timer.setVisibility(8);
            this.LocationLay.setVisibility(8);
            this.text_timer.setVisibility(8);
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.addLineToMap = new AddLineToMap(this.mMap, this);
    }

    private void startCurrentLocationUpdates() {
        LocationRequest create = LocationRequest.create();
        create.setPriority(100);
        create.setInterval(3000);
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.fusedLocationProviderClient.requestLocationUpdates(create, this.mLocationCallback, Looper.myLooper());
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (instance.isUserResolvableError(isGooglePlayServicesAvailable)) {
            Toast.makeText(this, "Please Install google play services to use this application", 1).show();
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 5445) {
            return;
        }
        if (iArr[0] == -1) {
            Toast.makeText(this, "Permission denied by uses", 0).show();
        } else if (iArr[0] == 0) {
            startCurrentLocationUpdates();
        }
    }

    private void animateCamera(@NonNull Location location) {
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(getCameraPositionWithBearing(new LatLng(location.getLatitude(), location.getLongitude()))));
    }

    @NonNull
    private CameraPosition getCameraPositionWithBearing(LatLng latLng) {
        return new Builder().target(latLng).zoom(16.0f).build();
    }

    private void showMarker(@android.support.annotation.NonNull android.location.Location r3) {
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
        r2 = this;
        r0 = r2.currentLocationMarker;	 Catch:{ Exception -> 0x0047 }
        if (r0 != 0) goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0004:
        r0 = r2.isEnd;	 Catch:{ Exception -> 0x0047 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0047 }
    L_0x0008:
        r0 = r2.orderNotification;	 Catch:{ Exception -> 0x0047 }
        r0 = r0.getOrder_id();	 Catch:{ Exception -> 0x0047 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0047 }
        r1 = "";	 Catch:{ Exception -> 0x0047 }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0047 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ Exception -> 0x0047 }
    L_0x001a:
        r0 = r2.orderNotification;	 Catch:{ Exception -> 0x0047 }
        r0 = r0.getOrder_id();	 Catch:{ Exception -> 0x0047 }
        r2.OrderOnTheWay(r0, r2, r3);	 Catch:{ Exception -> 0x0047 }
        goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0024:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0047 }
        r0.<init>();	 Catch:{ Exception -> 0x0047 }
        r1 = r2.statusOrder;	 Catch:{ Exception -> 0x0047 }
        r1 = r1.getOrder();	 Catch:{ Exception -> 0x0047 }
        r1 = r1.getId();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0047 }
        r2.OrderOnTheWay(r0, r2, r3);	 Catch:{ Exception -> 0x0047 }
        goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0043:
        r0 = 1;	 Catch:{ Exception -> 0x0047 }
        r2.drawStatus2(r3, r0);	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Activities.PilotTravelActivity.showMarker(android.location.Location):void");
    }

    protected void onStop() {
        super.onStop();
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationProviderClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.mLocationCallback);
        }
    }

    protected void onResume() {
        super.onResume();
        if (isGooglePlayServicesAvailable()) {
            this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
            startCurrentLocationUpdates();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.fusedLocationProviderClient = null;
        this.mMap = null;
    }

    public void AcceptOrder(String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().AcceptOrder(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Intent intent = new Intent(PilotTravelActivity.this, PilotTravelActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    intent.putExtra("isStart", true);
                    PilotTravelActivity.this.startActivity(intent);
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

    public void RejectOrder(String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().RejectOrder(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Intent intent = new Intent(PilotTravelActivity.this, HomePilotActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    PilotTravelActivity.this.startActivity(intent);
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

    public void StartTravel(String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().StartTravel(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Intent intent = new Intent(PilotTravelActivity.this, PilotTravelActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    intent.putExtra("isEnd", true);
                    Constants.showDialog((Activity) context, responseObject.getMessage());
                    PilotTravelActivity.this.startActivity(intent);
                    PilotTravelActivity.this.finish();
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

    public void CancelTravel(String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().CancelTravel(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    Intent intent = new Intent(PilotTravelActivity.this, HomePilotActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    Constants.showDialog((Activity) context, responseObject.getMessage());
                    PilotTravelActivity.this.startActivity(intent);
                    PilotTravelActivity.this.finish();
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

    public void FinishOrder(final Dialog dialog, String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().FinishOrder(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    dialog.dismiss();
                    Intent intent = new Intent(PilotTravelActivity.this, HomePilotActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    PilotTravelActivity.this.startActivity(intent);
                    PilotTravelActivity.this.finish();
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

    public void ReturnOrder(final Dialog dialog, String str, final Context context) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().ReturnOrder(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseObject responseObject = (ResponseObject) obj;
                if (responseObject.isStatus()) {
                    dialog.dismiss();
                    Intent intent = new Intent(PilotTravelActivity.this, HomePilotActivity.class);
                    intent.putExtra("Message", responseObject.getMessage());
                    PilotTravelActivity.this.startActivity(intent);
                    PilotTravelActivity.this.finish();
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
        Constants.showDialog((Activity) context, getResources().getString(C0519R.string.permission));
    }

    public void showReturnDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(null);
        dialog.setContentView(C0519R.layout.dialog_question);
        Button button = (Button) dialog.findViewById(C0519R.id.btnDialogAgree);
        TextView textView = (TextView) dialog.findViewById(C0519R.id.tvCloseQuestionDialog);
        ((Button) dialog.findViewById(C0519R.id.btnDialogReject)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                    view = PilotTravelActivity.this;
                    view.ReturnOrder(dialog, view.orderNotification.getOrder_id(), PilotTravelActivity.this);
                    return;
                }
                view = PilotTravelActivity.this;
                Dialog dialog = dialog;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.ReturnOrder(dialog, stringBuilder.toString(), PilotTravelActivity.this);
            }
        });
        dialog.show();
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void showEndDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(null);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        dialog.setContentView(C0519R.layout.dialog_question_end);
        Button button = (Button) dialog.findViewById(C0519R.id.btnDialogAgree);
        TextView textView = (TextView) dialog.findViewById(C0519R.id.tvCloseQuestionDialog);
        ((Button) dialog.findViewById(C0519R.id.btnDialogReject)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (PilotTravelActivity.this.orderNotification.getOrder_id().trim().equals("") == null) {
                    view = PilotTravelActivity.this;
                    view.FinishOrder(dialog, view.orderNotification.getOrder_id(), PilotTravelActivity.this);
                    return;
                }
                view = PilotTravelActivity.this;
                Dialog dialog = dialog;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PilotTravelActivity.this.statusOrder.getOrder().getId());
                stringBuilder.append("");
                view.FinishOrder(dialog, stringBuilder.toString(), PilotTravelActivity.this);
            }
        });
        dialog.show();
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void drawStatus2(Location location, boolean z) {
        String company_address;
        LatLng latLng;
        Double valueOf = Double.valueOf(location.getLatitude());
        location = Double.valueOf(location.getLongitude());
        LatLng latLng2 = new LatLng(valueOf.doubleValue(), location.doubleValue());
        Status status = this.statusOrder;
        LatLng latLng3;
        if (status == null) {
            Log.e("statusOrder_", this.orderNotification.getCompany_name());
            latLng3 = new LatLng(Double.valueOf(this.orderNotification.getCompany_lng()).doubleValue(), Double.valueOf(this.orderNotification.getCompany_lat()).doubleValue());
            company_address = this.orderNotification.getCompany_address();
            this.LocationFrom.setText(this.orderNotification.getCompany_name());
            this.LocationTo.setText(this.orderNotification.getCompany_address());
            this.text_timer.setText(this.orderNotification.getWaiting_time());
            latLng = latLng3;
        } else {
            Log.e("statusOrder_2", status.getCompany().toString());
            latLng3 = new LatLng(this.statusOrder.getCompany().getLat(), this.statusOrder.getCompany().getLng());
            company_address = this.statusOrder.getCompany().getAddress();
            this.LocationFrom.setText(this.statusOrder.getCompany().getName());
            this.LocationTo.setText(this.statusOrder.getCompany().getAddress());
            this.text_timer.setText(this.statusOrder.getOrder().getWaiting_time());
            latLng = latLng3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://maps.googleapis.com/maps/api/distancematrix/json?origins=");
        stringBuilder.append(String.valueOf(latLng.latitude));
        stringBuilder.append(",");
        stringBuilder.append(String.valueOf(latLng.longitude));
        stringBuilder.append("&");
        stringBuilder.append(Constants.DESTINATION);
        stringBuilder.append("=");
        stringBuilder.append(String.valueOf(valueOf));
        stringBuilder.append(",");
        stringBuilder.append(String.valueOf(location));
        stringBuilder.append("&");
        stringBuilder.append(Constants.MODE);
        stringBuilder.append("=driving&");
        stringBuilder.append(Constants.LANGUAGE);
        stringBuilder.append("=en-EN&key=");
        stringBuilder.append(Constants.GOOGLE_API_KEY);
        stringBuilder.append("&");
        stringBuilder.append(Constants.SENSOR);
        stringBuilder.append("=");
        stringBuilder.append(String.valueOf(null));
        TimeTrackingOrder(company_address, stringBuilder.toString(), latLng, latLng2, this);
        this.addLineToMap.addMarker(latLng);
        this.addLineToMap.addMarker(latLng2);
        if (z) {
            this.addLineToMap.ZoomBetween2Marker(latLng, latLng2);
        }
    }

    public void TimeTrackingOrder(String str, String str2, LatLng latLng, LatLng latLng2, Context context) {
        Log.e("statusOrder_", str2);
        final LatLng latLng3 = latLng;
        final String str3 = str;
        final LatLng latLng4 = latLng2;
        final Context context2 = context;
        new UserAPI().TimeOrderTracking(str2, new UniversalStringCallBack() {
            public void onFinish() {
            }

            public void onResponse(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getString(NotificationCompat.CATEGORY_STATUS).equals("OK") != null) {
                        str = jSONObject.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
                        PilotTravelActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                PilotTravelActivity.this.mMap.addMarker(new MarkerOptions().position(latLng3).icon(BitmapDescriptorFactory.fromBitmap(PilotTravelActivity.this.addLineToMap.getMarkerBitmapFromView(str3, "1"))));
                                PilotTravelActivity.this.currentLocationMarker = PilotTravelActivity.this.mMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(PilotTravelActivity.this.addLineToMap.getMarkerBitmapFromView(str, ExifInterface.GPS_MEASUREMENT_2D))));
                            }
                        });
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

    public void OrderOnTheWay(String str, final Context context, final Location location) {
        Constants.showSimpleProgressDialog(this, getResources().getString(C0519R.string.Loading));
        new UserAPI().OrderOnTheWay(str, new UniversalCallBack() {
            public void onResponse(Object obj) {
                ResponseOnTheWay responseOnTheWay = (ResponseOnTheWay) obj;
                if (responseOnTheWay.isStatus()) {
                    PilotTravelActivity.this.ClintName.setText(responseOnTheWay.getOnTheWay().getOrder().getName());
                    PilotTravelActivity.this.telephone.setText(responseOnTheWay.getOnTheWay().getOrder().getPhone());
                    PilotTravelActivity.this.fromLocation.setText(responseOnTheWay.getOnTheWay().getCompany().getName());
                    PilotTravelActivity.this.toLocation.setText(responseOnTheWay.getOnTheWay().getOrder().getPlace());
                    TextView access$1900 = PilotTravelActivity.this.Price;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(responseOnTheWay.getOnTheWay().getOrder().getPrice());
                    stringBuilder.append("");
                    access$1900.setText(stringBuilder.toString());
                    Picasso picasso = Picasso.get();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Constants.Image_URL);
                    stringBuilder.append(responseOnTheWay.getOnTheWay().getCompany().getImage());
                    picasso.load(stringBuilder.toString()).fit().into(PilotTravelActivity.this.company_image);
                    PilotTravelActivity.this.CompanyTel = responseOnTheWay.getOnTheWay().getCompany().getPhone();
                    PilotTravelActivity.this.OrderTel = responseOnTheWay.getOnTheWay().getOrder().getPhone();
                    PilotTravelActivity.this.Company_name.setText(responseOnTheWay.getOnTheWay().getCompany().getName());
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    LatLng latLng2 = new LatLng(responseOnTheWay.getOnTheWay().getOrder().getLat(), responseOnTheWay.getOnTheWay().getOrder().getLng());
                    PilotTravelActivity.this.addLineToMap.addMarker(latLng2);
                    PilotTravelActivity.this.addLineToMap.addMarker(latLng);
                    PilotTravelActivity pilotTravelActivity = PilotTravelActivity.this;
                    String place = responseOnTheWay.getOnTheWay().getOrder().getPlace();
                    obj = new StringBuilder();
                    obj.append("https://maps.googleapis.com/maps/api/distancematrix/json?origins=");
                    obj.append(String.valueOf(latLng2.latitude));
                    obj.append(",");
                    obj.append(String.valueOf(latLng2.longitude));
                    obj.append("&");
                    obj.append(Constants.DESTINATION);
                    obj.append("=");
                    obj.append(String.valueOf(latLng.latitude));
                    obj.append(",");
                    obj.append(String.valueOf(latLng.longitude));
                    obj.append("&");
                    obj.append(Constants.MODE);
                    obj.append("=driving&");
                    obj.append(Constants.LANGUAGE);
                    obj.append("=en-EN&key=");
                    obj.append(Constants.GOOGLE_API_KEY);
                    obj.append("&");
                    obj.append(Constants.SENSOR);
                    obj.append("=");
                    obj.append(String.valueOf(false));
                    pilotTravelActivity.TimeTrackingOrder(place, obj.toString(), latLng2, latLng, PilotTravelActivity.this);
                    return;
                }
                Constants.showDialog((Activity) context, responseOnTheWay.getMessage());
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

    private void changeLocationFirebase(LatLng latLng) {
        int id = ApplicationController.getInstance().getUser().getId();
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drivers/");
        stringBuilder.append(id);
        stringBuilder.append("/lat");
        DatabaseReference reference = instance.getReference(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("drivers/");
        stringBuilder2.append(id);
        stringBuilder2.append("/lng");
        DatabaseReference reference2 = instance.getReference(stringBuilder2.toString());
        if (latLng.latitude != 0.0d || latLng.longitude != 0.0d) {
            reference2.setValue(Double.valueOf(latLng.longitude));
            reference.setValue(Double.valueOf(latLng.latitude));
        }
    }
}
