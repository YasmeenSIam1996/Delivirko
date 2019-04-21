package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.media.ExifInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.FirebaseUtils.MyFirebaseMessagingService;
import com.ict.delivirko.Interfaces.ObjectClickListener;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Interfaces.UniversalStringCallBack;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.restaurant.Order;
import com.ict.delivirko.Module.restaurant.TrackingOrderDetails;
import com.ict.delivirko.Utils.AddLineToMap;
import com.ict.delivirko.Utils.Constants;
import org.json.JSONObject;

public class TravelMapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private Button Done;
    private Order OrderTemp;
    private TextView PilotName;
    private AddLineToMap addLineToMap;
    private RelativeLayout bottomLayId;
    private ImageView call;
    private LinearLayout lay;
    private GoogleMap mMap;
    private TextView motorcycle;
    private TextView num;
    private ImageView pilot_image;
    private RatingBar rateBarRest;
    private TextView statusText;
    private TextView telephone;
    private TrackingOrderDetails trackingOrderDetails;

    /* renamed from: com.ict.delivirko.Activities.TravelMapsActivity$4 */
    class C05184 implements OnClickListener {
        C05184() {
        }

        public void onClick(View view) {
            ApplicationController.getInstance().deleteTempOrder();
            ApplicationController.getInstance().deleteOrderNotification();
            view = TravelMapsActivity.this;
            view.startActivity(new Intent(view, HomeRestaurantActivity.class));
            TravelMapsActivity.this.finish();
        }
    }

    /* renamed from: com.ict.delivirko.Activities.TravelMapsActivity$1 */
    class C09101 implements ObjectClickListener {
        C09101() {
        }

        public void onItemClickListener(OrderNotification orderNotification) {
            if (!orderNotification.getStatus_id().equals("0")) {
                Intent intent = new Intent(TravelMapsActivity.this, TravelMapsActivity.class);
                intent.putExtra("orderNo", Integer.valueOf(orderNotification.getOrder_id()));
                intent.putExtra("Status_id", Integer.valueOf(orderNotification.getStatus_id()));
                TravelMapsActivity.this.startActivity(intent);
                TravelMapsActivity.this.finish();
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.TravelMapsActivity$6 */
    class C09136 implements ValueEventListener {
        C09136() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            Double d = (Double) dataSnapshot.child("lat").getValue(Double.TYPE);
            Double d2 = (Double) dataSnapshot.child("lng").getValue(Double.TYPE);
            TravelMapsActivity travelMapsActivity = TravelMapsActivity.this;
            String address = travelMapsActivity.OrderTemp.getAddress();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://maps.googleapis.com/maps/api/distancematrix/json?origins=");
            stringBuilder.append(String.valueOf(TravelMapsActivity.this.OrderTemp.getD_lat()));
            stringBuilder.append(",");
            stringBuilder.append(String.valueOf(TravelMapsActivity.this.OrderTemp.getD_lng()));
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
            travelMapsActivity.TimeTrackingOrder(address, stringBuilder.toString(), new LatLng(TravelMapsActivity.this.OrderTemp.getD_lat(), TravelMapsActivity.this.OrderTemp.getD_lng()), new LatLng(d.doubleValue(), d2.doubleValue()), TravelMapsActivity.this);
            TravelMapsActivity.this.addLineToMap.addMarker(new LatLng(TravelMapsActivity.this.OrderTemp.getD_lat(), TravelMapsActivity.this.OrderTemp.getD_lng()));
            TravelMapsActivity.this.addLineToMap.addMarker(new LatLng(d.doubleValue(), d2.doubleValue()));
        }

        public void onCancelled(DatabaseError databaseError) {
            Log.w("Failed_", "Failed to read value.", databaseError.toException());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0519R.layout.travel_map_activity);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.map)).getMapAsync(this);
        this.motorcycle = (TextView) findViewById(C0519R.id.motorcycle);
        this.telephone = (TextView) findViewById(C0519R.id.telephone);
        this.PilotName = (TextView) findViewById(C0519R.id.PilotName);
        this.pilot_image = (ImageView) findViewById(C0519R.id.pilot_image);
        this.num = (TextView) findViewById(C0519R.id.num);
        this.call = (ImageView) findViewById(C0519R.id.call);
        this.rateBarRest = (RatingBar) findViewById(C0519R.id.rateBarRest);
        this.bottomLayId = (RelativeLayout) findViewById(C0519R.id.bottom_pilot);
        this.statusText = (TextView) findViewById(C0519R.id.statusText);
        this.lay = (LinearLayout) findViewById(C0519R.id.lay);
        this.Done = (Button) findViewById(C0519R.id.Done);
        MyFirebaseMessagingService.setOnItemClickListener(new C09101());
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.addLineToMap = new AddLineToMap(this.mMap, this);
        trackingOrderDetails(getIntent().getIntExtra("orderNo", 0), this);
    }

    public void TimeTrackingOrder(String str, String str2, LatLng latLng, LatLng latLng2, Context context) {
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
                        str = jSONObject.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text");
                        TravelMapsActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                TravelMapsActivity.this.mMap.addMarker(new MarkerOptions().position(latLng3).icon(BitmapDescriptorFactory.fromBitmap(TravelMapsActivity.this.addLineToMap.getMarkerBitmapFromView(str3, "1"))));
                                TravelMapsActivity.this.mMap.addMarker(new MarkerOptions().position(latLng4).icon(BitmapDescriptorFactory.fromBitmap(TravelMapsActivity.this.addLineToMap.getMarkerBitmapFromView(str, ExifInterface.GPS_MEASUREMENT_2D))));
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

    private void showDialog(final com.ict.delivirko.Module.restaurant.Driver r6, java.lang.String r7) {
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
        r5 = this;
        r0 = r5.bottomLayId;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r5.lay;
        r2 = 8;
        r0.setVisibility(r2);
        r0 = r5.getIntent();
        r2 = "Status_id";
        r0 = r0.getIntExtra(r2, r1);
        r2 = "statusIdstatusId";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r4 = "";
        r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
        r2 = 4;
        if (r0 == r2) goto L_0x0036;
    L_0x0030:
        r2 = 6;
        if (r0 == r2) goto L_0x0036;
    L_0x0033:
        r2 = 7;
        if (r0 != r2) goto L_0x003b;
    L_0x0036:
        r0 = r5.Done;
        r0.setVisibility(r1);
    L_0x003b:
        r0 = r5.statusText;
        r0.setVisibility(r1);
        r0 = r5.motorcycle;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r6.getCar_number();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        r0.setText(r1);
        r0 = r5.PilotName;
        r1 = r6.getName();
        r0.setText(r1);
        r0 = r5.rateBarRest;	 Catch:{ Exception -> 0x0086 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0086 }
        r1.<init>();	 Catch:{ Exception -> 0x0086 }
        r2 = r6.getDriver_rating();	 Catch:{ Exception -> 0x0086 }
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x0086 }
        r1.append(r2);	 Catch:{ Exception -> 0x0086 }
        r2 = "";	 Catch:{ Exception -> 0x0086 }
        r1.append(r2);	 Catch:{ Exception -> 0x0086 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0086 }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Exception -> 0x0086 }
        r0.setRating(r1);	 Catch:{ Exception -> 0x0086 }
        goto L_0x008c;
    L_0x0086:
        r0 = r5.rateBarRest;
        r1 = 0;
        r0.setRating(r1);
    L_0x008c:
        r0 = r5.telephone;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r6.getPhone();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        r0.setText(r1);
        r0 = r5.num;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r6.getDriver_rating_count();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        r0.setText(r1);
        r0 = r5.statusText;
        r0.setText(r7);
        r7 = com.squareup.picasso.Picasso.get();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "http://142.93.203.170/public/uploads/";
        r0.append(r1);
        r1 = r6.getImage();
        r0.append(r1);
        r0 = r0.toString();
        r7 = r7.load(r0);
        r7 = r7.fit();
        r0 = r5.pilot_image;
        r7.into(r0);
        r7 = r5.call;
        r0 = new com.ict.delivirko.Activities.TravelMapsActivity$3;
        r0.<init>(r6);
        r7.setOnClickListener(r0);
        r6 = r5.Done;
        r7 = new com.ict.delivirko.Activities.TravelMapsActivity$4;
        r7.<init>();
        r6.setOnClickListener(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Activities.TravelMapsActivity.showDialog(com.ict.delivirko.Module.restaurant.Driver, java.lang.String):void");
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

    public void trackingOrderDetails(int i, final Context context) {
        UserAPI userAPI = new UserAPI();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        userAPI.trackingOrderDetails(stringBuilder.toString(), new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(java.lang.Object r12) {
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
                r11 = this;
                r12 = (com.ict.delivirko.API.ResponseTrackingOrderDetails) r12;
                r0 = r12.isStatus();
                if (r0 == 0) goto L_0x0286;
            L_0x0008:
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r1 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r0.trackingOrderDetails = r1;	 Catch:{ Exception -> 0x0291 }
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r1 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r1 = r1.trackingOrderDetails;	 Catch:{ Exception -> 0x0291 }
                r1 = r1.getDriver();	 Catch:{ Exception -> 0x0291 }
                r2 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r2 = r2.trackingOrderDetails;	 Catch:{ Exception -> 0x0291 }
                r2 = r2.getOrder();	 Catch:{ Exception -> 0x0291 }
                r2 = r2.getStatus_text();	 Catch:{ Exception -> 0x0291 }
                r0.showDialog(r1, r2);	 Catch:{ Exception -> 0x0291 }
                r0 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x0291 }
                r1 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r1 = r1.getCompany();	 Catch:{ Exception -> 0x0291 }
                r1 = r1.getLat();	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getCompany();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getLng();	 Catch:{ Exception -> 0x0291 }
                r0.<init>(r1, r3);	 Catch:{ Exception -> 0x0291 }
                r1 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x0291 }
                r2 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r2 = r2.getDriver();	 Catch:{ Exception -> 0x0291 }
                r2 = r2.getLat();	 Catch:{ Exception -> 0x0291 }
                r4 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r4 = r4.getDriver();	 Catch:{ Exception -> 0x0291 }
                r4 = r4.getLng();	 Catch:{ Exception -> 0x0291 }
                r1.<init>(r2, r4);	 Catch:{ Exception -> 0x0291 }
                r2 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getOrder();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getD_lat();	 Catch:{ Exception -> 0x0291 }
                r5 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getOrder();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getD_lng();	 Catch:{ Exception -> 0x0291 }
                r2.<init>(r3, r5);	 Catch:{ Exception -> 0x0291 }
                r3 = "Status_id";	 Catch:{ Exception -> 0x0291 }
                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0291 }
                r4.<init>();	 Catch:{ Exception -> 0x0291 }
                r5 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getIntent();	 Catch:{ Exception -> 0x0291 }
                r6 = "Status_id";	 Catch:{ Exception -> 0x0291 }
                r7 = 0;	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getIntExtra(r6, r7);	 Catch:{ Exception -> 0x0291 }
                r4.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = "";	 Catch:{ Exception -> 0x0291 }
                r4.append(r5);	 Catch:{ Exception -> 0x0291 }
                r4 = r4.toString();	 Catch:{ Exception -> 0x0291 }
                android.util.Log.e(r3, r4);	 Catch:{ Exception -> 0x0291 }
                r3 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getIntent();	 Catch:{ Exception -> 0x0291 }
                r4 = "Status_id";	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getIntExtra(r4, r7);	 Catch:{ Exception -> 0x0291 }
                r4 = 3;	 Catch:{ Exception -> 0x0291 }
                if (r3 != r4) goto L_0x0190;	 Catch:{ Exception -> 0x0291 }
            L_0x00b7:
                r3 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r2 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r2 = r2.getCompany();	 Catch:{ Exception -> 0x0291 }
                r4 = r2.getAddress();	 Catch:{ Exception -> 0x0291 }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0291 }
                r2.<init>();	 Catch:{ Exception -> 0x0291 }
                r5 = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getCompany();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getLat();	 Catch:{ Exception -> 0x0291 }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = ",";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getCompany();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getLng();	 Catch:{ Exception -> 0x0291 }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = "&";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = "destinations";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = "=";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getDriver();	 Catch:{ Exception -> 0x0291 }
                r5 = r5.getLat();	 Catch:{ Exception -> 0x0291 }
                r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r5 = ",";	 Catch:{ Exception -> 0x0291 }
                r2.append(r5);	 Catch:{ Exception -> 0x0291 }
                r12 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r12 = r12.getDriver();	 Catch:{ Exception -> 0x0291 }
                r5 = r12.getLng();	 Catch:{ Exception -> 0x0291 }
                r12 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "&";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "mode";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "=driving&";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "language";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "=en-EN&key=";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = com.ict.delivirko.Utils.Constants.GOOGLE_API_KEY;	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "&";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "sensor";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = "=";	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r12 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0291 }
                r2.append(r12);	 Catch:{ Exception -> 0x0291 }
                r5 = r2.toString();	 Catch:{ Exception -> 0x0291 }
                r8 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r6 = r0;	 Catch:{ Exception -> 0x0291 }
                r7 = r1;	 Catch:{ Exception -> 0x0291 }
                r3.TimeTrackingOrder(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0291 }
                r12 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r12 = r12.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r12.addMarker(r0);	 Catch:{ Exception -> 0x0291 }
                r12 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r12 = r12.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r12.addMarker(r1);	 Catch:{ Exception -> 0x0291 }
                r12 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r12 = r12.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r12.ZoomBetween2Marker(r0, r1);	 Catch:{ Exception -> 0x0291 }
                goto L_0x0291;	 Catch:{ Exception -> 0x0291 }
            L_0x0190:
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getOrder();	 Catch:{ Exception -> 0x0291 }
                r0.OrderTemp = r3;	 Catch:{ Exception -> 0x0291 }
                r5 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r0 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r0 = r0.getOrder();	 Catch:{ Exception -> 0x0291 }
                r6 = r0.getAddress();	 Catch:{ Exception -> 0x0291 }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0291 }
                r0.<init>();	 Catch:{ Exception -> 0x0291 }
                r3 = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getOrder();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getD_lat();	 Catch:{ Exception -> 0x0291 }
                r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = ",";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getOrder();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getD_lng();	 Catch:{ Exception -> 0x0291 }
                r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "&";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "destinations";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "=";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getDriver();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getLat();	 Catch:{ Exception -> 0x0291 }
                r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = ",";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getDriver();	 Catch:{ Exception -> 0x0291 }
                r3 = r3.getLng();	 Catch:{ Exception -> 0x0291 }
                r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "&";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "mode";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "=driving&";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "language";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "=en-EN&key=";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = com.ict.delivirko.Utils.Constants.GOOGLE_API_KEY;	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "&";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "sensor";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = "=";	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r3 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0291 }
                r0.append(r3);	 Catch:{ Exception -> 0x0291 }
                r7 = r0.toString();	 Catch:{ Exception -> 0x0291 }
                r10 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r8 = r2;	 Catch:{ Exception -> 0x0291 }
                r9 = r1;	 Catch:{ Exception -> 0x0291 }
                r5.TimeTrackingOrder(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x0291 }
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r0 = r0.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r0.addMarker(r2);	 Catch:{ Exception -> 0x0291 }
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r0 = r0.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r0.addMarker(r1);	 Catch:{ Exception -> 0x0291 }
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r0 = r0.addLineToMap;	 Catch:{ Exception -> 0x0291 }
                r0.ZoomBetween2Marker(r2, r1);	 Catch:{ Exception -> 0x0291 }
                r0 = com.ict.delivirko.Activities.TravelMapsActivity.this;	 Catch:{ Exception -> 0x0291 }
                r12 = r12.getTrackingOrderDetails();	 Catch:{ Exception -> 0x0291 }
                r12 = r12.getDriver();	 Catch:{ Exception -> 0x0291 }
                r12 = r12.getId();	 Catch:{ Exception -> 0x0291 }
                r0.MovementDriverMarker(r12);	 Catch:{ Exception -> 0x0291 }
                goto L_0x0291;
            L_0x0286:
                r0 = r4;
                r0 = (android.app.Activity) r0;
                r12 = r12.getMessage();
                com.ict.delivirko.Utils.Constants.showDialog(r0, r12);
            L_0x0291:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Activities.TravelMapsActivity.5.onResponse(java.lang.Object):void");
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

    private void MovementDriverMarker(int i) {
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("drivers/");
        stringBuilder.append(i);
        stringBuilder.append("/");
        instance.getReference(stringBuilder.toString()).addValueEventListener(new C09136());
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomeRestaurantActivity.class));
    }
}
