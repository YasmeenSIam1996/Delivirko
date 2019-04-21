package com.ict.delivirko.FirebaseUtils;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.media.ExifInterface;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.ict.delivirko.Activities.HomeRestaurantActivity;
import com.ict.delivirko.Activities.PilotTravelActivity;
import com.ict.delivirko.Activities.TravelMapsActivity;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.ObjectClickListener;
import com.ict.delivirko.Module.OrderNotification;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final int NOTIFICATION_ID = 1;
    private static final String TAG = "MyFirebaseMsgService";
    static ObjectClickListener objectClickListener;
    Builder builder;
    private String date = "";
    private NotificationManager mNotificationManager;
    OrderNotification orderNotification;

    public static void setOnItemClickListener(ObjectClickListener objectClickListener) {
        objectClickListener = objectClickListener;
    }

    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r5) {
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
        r4 = this;
        r0 = "MyFirebaseIIDService2";
        r1 = r5.getNotification();
        r1 = r1.getTitle();
        android.util.Log.e(r0, r1);
        r0 = r5.getData();	 Catch:{ Exception -> 0x0042 }
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0042 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0042 }
        r0 = new com.google.gson.Gson;	 Catch:{ Exception -> 0x0042 }
        r0.<init>();	 Catch:{ Exception -> 0x0042 }
        r2 = r1.toString();	 Catch:{ Exception -> 0x0042 }
        r3 = com.ict.delivirko.Module.OrderNotification.class;	 Catch:{ Exception -> 0x0042 }
        r0 = r0.fromJson(r2, r3);	 Catch:{ Exception -> 0x0042 }
        r0 = (com.ict.delivirko.Module.OrderNotification) r0;	 Catch:{ Exception -> 0x0042 }
        r4.orderNotification = r0;	 Catch:{ Exception -> 0x0042 }
        r0 = com.ict.delivirko.App.ApplicationController.getInstance();	 Catch:{ Exception -> 0x0042 }
        r2 = r4.orderNotification;	 Catch:{ Exception -> 0x0042 }
        r0.SetOrderNotification(r2);	 Catch:{ Exception -> 0x0042 }
        r0 = "JSON_OBJECT";	 Catch:{ Exception -> 0x0042 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0042 }
        android.util.Log.e(r0, r1);	 Catch:{ Exception -> 0x0042 }
        r0 = objectClickListener;	 Catch:{ Exception -> 0x0042 }
        r1 = r4.orderNotification;	 Catch:{ Exception -> 0x0042 }
        r0.onItemClickListener(r1);	 Catch:{ Exception -> 0x0042 }
    L_0x0042:
        r0 = "";
        r1 = r5.getNotification();
        r1 = r1.getTitle();
        if (r1 == 0) goto L_0x0056;
    L_0x004e:
        r0 = r5.getNotification();
        r0 = r0.getTitle();
    L_0x0056:
        r1 = "";
        r2 = r5.getNotification();
        r2 = r2.getBody();
        if (r2 == 0) goto L_0x006a;
    L_0x0062:
        r5 = r5.getNotification();
        r1 = r5.getBody();
    L_0x006a:
        r5 = "1";
        r4.sendNotification(r0, r1, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.FirebaseUtils.MyFirebaseMessagingService.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    private void sendNotification(String str, String str2, String str3) {
        Bundle bundle;
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        str3 = ApplicationController.getInstance().getOrderNotification().getStatus_id();
        Log.e("JSON_OBJECT3333", ApplicationController.getInstance().getOrderNotification().toString());
        if (!(str3.equals("4") || str3.equals(ExifInterface.GPS_MEASUREMENT_3D) || str3.equals(ExifInterface.GPS_MEASUREMENT_2D))) {
            if (!str3.equals("6")) {
                if (str3.equals("7")) {
                    Log.e("statusOrder_7", "hi");
                    str3 = new Intent(getApplicationContext(), PilotTravelActivity.class);
                    str3.putExtra("isStart", true);
                } else if (str3.equals("5") != null) {
                    str3 = new Intent(getApplicationContext(), HomeRestaurantActivity.class);
                    ApplicationController.getInstance().deleteTempOrder();
                    ApplicationController.getInstance().deleteOrderNotification();
                } else {
                    str3 = new Intent(getApplicationContext(), HomeRestaurantActivity.class);
                }
                str3.setFlags(603979776);
                bundle = new Bundle();
                str3.putExtra("orderNo", Integer.valueOf(this.orderNotification.getOrder_id()));
                str3.putExtra("Status_id", Integer.valueOf(this.orderNotification.getStatus_id()));
                bundle.putSerializable("orderNotification", this.orderNotification);
                str3.putExtras(bundle);
                str3 = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), str3, 0);
                str = new Notification.Builder(this).setSmallIcon(C0519R.mipmap.ic_launcher).setContentTitle(str).setStyle(new BigTextStyle().bigText(str2)).setSound(System.DEFAULT_NOTIFICATION_URI).setAutoCancel(true).setContentText(str2);
                str.setContentIntent(str3);
                this.mNotificationManager.notify(1, str.build());
            }
        }
        str3 = new Intent(getApplicationContext(), TravelMapsActivity.class);
        str3.setFlags(603979776);
        bundle = new Bundle();
        str3.putExtra("orderNo", Integer.valueOf(this.orderNotification.getOrder_id()));
        str3.putExtra("Status_id", Integer.valueOf(this.orderNotification.getStatus_id()));
        bundle.putSerializable("orderNotification", this.orderNotification);
        str3.putExtras(bundle);
        str3 = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), str3, 0);
        str = new Notification.Builder(this).setSmallIcon(C0519R.mipmap.ic_launcher).setContentTitle(str).setStyle(new BigTextStyle().bigText(str2)).setSound(System.DEFAULT_NOTIFICATION_URI).setAutoCancel(true).setContentText(str2);
        str.setContentIntent(str3);
        this.mNotificationManager.notify(1, str.build());
    }
}
