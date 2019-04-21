package com.ict.delivirko.Utils;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.ict.delivirko.Interfaces.LocationClickListener;
import java.util.Timer;
import java.util.TimerTask;

public class BookingTrackingService extends Service implements LocationListener {
    private static final String TAG = "BookingTrackingService";
    static LocationClickListener objectClickListener = null;
    public static String str_receiver = "servicetutorial.service.receiver";
    private Context context;
    Intent intent;
    boolean isGPSEnable = false;
    boolean isNetworkEnable = false;
    double latitude;
    Location location;
    LocationManager locationManager;
    double longitude;
    private Handler mHandler = new Handler();
    private Timer mTimer = null;
    long notify_interval = 100;
    public double track_lat = 0.0d;
    public double track_lng = 0.0d;

    private class TimerTaskToGetLocation extends TimerTask {

        /* renamed from: com.ict.delivirko.Utils.BookingTrackingService$TimerTaskToGetLocation$1 */
        class C05211 implements Runnable {
            C05211() {
            }

            public void run() {
                BookingTrackingService.this.fn_getlocation();
            }
        }

        private TimerTaskToGetLocation() {
        }

        public void run() {
            BookingTrackingService.this.mHandler.post(new C05211());
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public static void setOnItemClickListener(LocationClickListener locationClickListener) {
        objectClickListener = locationClickListener;
    }

    public void onCreate() {
        super.onCreate();
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTaskToGetLocation(), 5, this.notify_interval);
        this.intent = new Intent(str_receiver);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.context = this;
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy <<");
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void trackLocation() {
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
        r8 = this;
        r0 = "BookingTrackingService";
        r1 = "trackLocation";
        android.util.Log.e(r0, r1);
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "latitude";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "";
        r2.append(r3);
        r3 = r8.track_lat;
        r2.append(r3);
        r2 = r2.toString();
        r0.put(r1, r2);
        r1 = "longitude";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "";
        r2.append(r3);
        r3 = r8.track_lng;
        r2.append(r3);
        r2 = r2.toString();
        r0.put(r1, r2);
        r1 = objectClickListener;	 Catch:{ Exception -> 0x0045 }
        r2 = r8.track_lat;	 Catch:{ Exception -> 0x0045 }
        r4 = r8.track_lng;	 Catch:{ Exception -> 0x0045 }
        r1.onItemClickListener(r2, r4);	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        r1 = com.ict.delivirko.App.ApplicationController.getInstance();
        r1 = r1.getUser();
        r1 = r1.getId();
        r2 = com.google.firebase.database.FirebaseDatabase.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "drivers/";
        r3.append(r4);
        r3.append(r1);
        r4 = "/lat";
        r3.append(r4);
        r3 = r3.toString();
        r3 = r2.getReference(r3);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "drivers/";
        r4.append(r5);
        r4.append(r1);
        r1 = "/lng";
        r4.append(r1);
        r1 = r4.toString();
        r1 = r2.getReference(r1);
        r4 = r8.track_lng;
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x0097;
    L_0x0091:
        r4 = r8.track_lat;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00a9;
    L_0x0097:
        r4 = r8.track_lng;
        r2 = java.lang.Double.valueOf(r4);
        r1.setValue(r2);
        r1 = r8.track_lat;
        r1 = java.lang.Double.valueOf(r1);
        r3.setValue(r1);
    L_0x00a9:
        r1 = "BookingTrackingService";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "param_track_location >> ";
        r2.append(r3);
        r0 = r0.toString();
        r2.append(r0);
        r0 = r2.toString();
        android.util.Log.e(r1, r0);
        r8.stopSelf();
        r0 = r8.mTimer;
        r0.cancel();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Utils.BookingTrackingService.trackLocation():void");
    }

    private void fn_getlocation() {
        this.locationManager = (LocationManager) getApplicationContext().getSystemService(Param.LOCATION);
        this.isGPSEnable = this.locationManager.isProviderEnabled("gps");
        this.isNetworkEnable = this.locationManager.isProviderEnabled("network");
        if (this.isGPSEnable || this.isNetworkEnable) {
            LocationManager locationManager;
            String str;
            if (this.isNetworkEnable) {
                this.location = null;
                this.locationManager.requestLocationUpdates("network", 1000, 0.0f, this);
                locationManager = this.locationManager;
                if (locationManager != null) {
                    this.location = locationManager.getLastKnownLocation("network");
                    if (this.location != null) {
                        str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("isNetworkEnable latitude");
                        stringBuilder.append(this.location.getLatitude());
                        stringBuilder.append("\nlongitude");
                        stringBuilder.append(this.location.getLongitude());
                        stringBuilder.append("");
                        Log.e(str, stringBuilder.toString());
                        this.latitude = this.location.getLatitude();
                        this.longitude = this.location.getLongitude();
                        this.track_lat = this.latitude;
                        this.track_lng = this.longitude;
                    }
                }
            }
            if (this.isGPSEnable) {
                this.location = null;
                this.locationManager.requestLocationUpdates("gps", 1000, 0.0f, this);
                locationManager = this.locationManager;
                if (locationManager != null) {
                    this.location = locationManager.getLastKnownLocation("gps");
                    if (this.location != null) {
                        str = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("isGPSEnable latitude");
                        stringBuilder2.append(this.location.getLatitude());
                        stringBuilder2.append("\nlongitude");
                        stringBuilder2.append(this.location.getLongitude());
                        stringBuilder2.append("");
                        Log.e(str, stringBuilder2.toString());
                        this.latitude = this.location.getLatitude();
                        this.longitude = this.location.getLongitude();
                        this.track_lat = this.latitude;
                        this.track_lng = this.longitude;
                    }
                }
            }
            Log.e(TAG, "START SERVICE");
            trackLocation();
            return;
        }
        Log.e(TAG, "CAN'T GET LOCATION");
        stopSelf();
    }
}
