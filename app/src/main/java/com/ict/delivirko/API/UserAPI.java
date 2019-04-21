package com.ict.delivirko.API;

import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.gson.Gson;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Interfaces.UniversalStringCallBack;
import com.ict.delivirko.Module.restaurant.MakeOrder;
import com.ict.delivirko.Utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class UserAPI {
    public void Login(String str, String str2, String str3, String str4, String str5, UniversalCallBack universalCallBack) {
        UserAPI userAPI = this;
        final UniversalCallBack universalCallBack2 = universalCallBack;
        final String str6 = str;
        Log.d("LOGIN_DRIVER: ", str);
        final String str7 = str2;
        final String str8 = str5;
        final String str9 = str3;
        final String str10 = str4;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "LOGIN_DRIVER: ";
                android.util.Log.d(r0, r3);
                r0 = r0;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseSign.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseSign) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r0;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r0;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.1.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack2.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack2);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ApplicationController.langNum);
                stringBuilder.append("");
                hashMap.put("lang", stringBuilder.toString());
                hashMap.put("phone", str7);
                hashMap.put("password", str8);
                if (str6.equals(Constants.LOGIN_DRIVER)) {
                    hashMap.put("lat", str9);
                    hashMap.put("lng", str10);
                }
                return hashMap;
            }
        }, "");
    }

    public void ForgetPass(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.FORGET_PASS;
        Log.d("FORGET_PASS: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "FORGET_PASS: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.4.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.putAll(headers);
                return hashMap;
            }

            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("email", str3);
                return hashMap;
            }
        }, "");
    }

    public void setFcm(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.SET_FCM;
        Log.d("fcm_token: ", str2);
        Log.d("fcm_token: ", str);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "fcm_token: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.7.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }

            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("fcm_token", str3);
                return hashMap;
            }
        }, "");
    }

    public void logout(final UniversalCallBack universalCallBack) {
        String str = Constants.LOGOUT;
        Log.d("LOGOUT: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "SET_FCM_TOKEN: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.10.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void companyData(final UniversalCallBack universalCallBack) {
        String str = Constants.COMPANY_DATA;
        Log.d("COMPANY_DATA: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "COMPANY_DATA: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseNearestCompany.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseNearestCompany) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.13.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer1", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void driverData(final UniversalCallBack universalCallBack) {
        String str = Constants.DRIVER_DATA;
        Log.d("DRIVER_DATA: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "DRIVER_DATA: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseNearestDriver.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseNearestDriver) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.16.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                Log.d("DRIVER_DATA", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void createCompanyOrder(final UniversalCallBack universalCallBack) {
        String str = Constants.CREATE_ORDER;
        Log.d("CREATE_ORDER: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CREATE_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOrderTemp.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOrderTemp) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.19.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void cancelOrder(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.CANCEL_ORDER;
        Log.d("CANCEL_ORDER: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CANCEL_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.22.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void myOrders(String str, String str2, final UniversalCallBack universalCallBack) {
        String str3 = Constants.MY_ORDER;
        Log.d("MY_ORDER: ", str3);
        final String str4 = str2;
        final String str5 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str3, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "MY_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r12;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOrders.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOrders) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r12;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r12;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.25.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("week", str4);
                hashMap.put(NotificationCompat.CATEGORY_STATUS, str5);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void orderDetails(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.ORDER_DETAILS;
        Log.d("ORDER_DETAILS: ", str2);
        Log.d("ORDER_DETAILS: ", str);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "ORDER_DETAILS: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOrderDetails.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOrderDetails) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.28.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void Contact(final UniversalCallBack universalCallBack) {
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, Constants.CONTACT, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CONTACT: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseContact.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseContact) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.31.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void Questions(final UniversalCallBack universalCallBack) {
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, Constants.QUESTIONS, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "QUESTIONS: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseQuestions.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseQuestions) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.34.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void FreeTrips(final UniversalCallBack universalCallBack) {
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, Constants.FREE_TRIPS, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "FREE_TRIPS: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseFreeTrips.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseFreeTrips) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.37.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void getOrderData(final UniversalCallBack universalCallBack) {
        String str = Constants.GET_COMPANY_DATA;
        Log.d("GET_COMPANY_DATA: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(String str) {
                Log.d("GET_COMPANY_DATA: ", str);
                try {
                    universalCallBack.onFinish();
                    universalCallBack.onResponse((ResponseMakeOrder) new Gson().fromJson(str.toString(), ResponseMakeOrder.class));
                } catch (String str2) {
                    Log.e("GET_COMPANY_DATA", str2.getMessage());
                    universalCallBack.OnError("Server Connection error try again later");
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void makeOrder(MakeOrder makeOrder, final UniversalCallBack universalCallBack) {
        String str = Constants.MAKE_ORDER;
        Log.d("MAKE_ORDER: ", str);
        final MakeOrder makeOrder2 = makeOrder;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "MAKE_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOrderId.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOrderId) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.43.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", makeOrder2.getOrder_id());
                hashMap.put("name", makeOrder2.getName());
                hashMap.put("phone", makeOrder2.getPhone());
                hashMap.put("place", makeOrder2.getPlace());
                hashMap.put("street", makeOrder2.getStreet());
                hashMap.put("building_no", makeOrder2.getBuilding_no());
                hashMap.put("apartment_no", makeOrder2.getApartment_no());
                hashMap.put("floor_no", makeOrder2.getFloor_no());
                hashMap.put("to_lat", makeOrder2.getTo_lat());
                hashMap.put("to_lng", makeOrder2.getTo_lng());
                hashMap.put(Param.PRICE, makeOrder2.getPrice());
                hashMap.put(Param.SHIPPING, makeOrder2.getShipping());
                hashMap.put("payment", makeOrder2.getPayment());
                hashMap.put("free_trip", makeOrder2.getFree_trip());
                hashMap.put("place_id", makeOrder2.getPlace_id());
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void trackingOrders(final UniversalCallBack universalCallBack) {
        String str = Constants.TRACKING_ORDER;
        Log.d("TRACKING_ORDER: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "TRACKING_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseTrackingOrders.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseTrackingOrders) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.46.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void trackingOrderData(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.TRACKING_ORDER_DATA;
        Log.d("TRACKING_ORDER_DATA: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "TRACKING_ORDER_DATA: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseTrackingOrderData.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseTrackingOrderData) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.49.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void trackingOrderDetails(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.TRACKING_ORDER_DETAILS;
        Log.d("TRACKING_ORDER_DETAILS", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "TRACKING_ORDER_DETAILS";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseTrackingOrderDetails.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseTrackingOrderDetails) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.52.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                String concat = "Bearer ".concat(ApplicationController.getAppContext().getSharedPreferences("access_token", 0).getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void TimeOrderTracking(String str, final UniversalStringCallBack universalStringCallBack) {
        Log.d("TimeOrderTracking: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(null, str, new Listener<String>() {
            public void onResponse(java.lang.String r2) {
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
                r1 = this;
                r0 = "TimeOrderTracking: ";
                android.util.Log.d(r0, r2);
                r0 = r5;	 Catch:{ JsonSyntaxException -> 0x0010 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0010 }
                r0 = r5;	 Catch:{ JsonSyntaxException -> 0x0010 }
                r0.onResponse(r2);	 Catch:{ JsonSyntaxException -> 0x0010 }
                goto L_0x0017;
            L_0x0010:
                r2 = r5;
                r0 = "Server Connection error try again later";
                r2.OnError(r0);
            L_0x0017:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.55.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalStringCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalStringCallBack);
            }
        }), "");
    }

    public void AcceptOrder(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.ACCEPT_ORDER;
        Log.d("DRIVER_DATA: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "DRIVER_DATA: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.57.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void RejectOrder(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.REJECT_ORDER;
        Log.d("DRIVER_DATA: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "DRIVER_DATA: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.60.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void StartTravel(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.START_TRAVEL;
        Log.d("START_TRAVEL: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "START_TRAVEL: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.63.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void FinishOrder(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.FINISH_ORDER;
        Log.d("FINISH_ORDER: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "FINISH_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.66.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void ReturnOrder(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.RETURN_ORDER;
        Log.d("RETURN_ORDER: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "RETURN_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.69.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void CancelTravel(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.CANCEL_TRAVEL;
        Log.d("CANCEL_TRAVEL: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CANCEL_TRAVEL: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.72.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void OrderOnTheWay(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.ORDER_ON_THE_WAY;
        Log.d("ORDER_ON_THE_WAY: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "ORDER_ON_THE_WAY: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOnTheWay.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOnTheWay) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.75.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void CheckStatus(final UniversalCallBack universalCallBack) {
        String str = Constants.CHECK_STATUS;
        Log.d("CHECK_STATUS: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CHECK_STATUS: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObjectStatus.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObjectStatus) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.78.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void UpdateProfile(String str, String str2, String str3, String str4, String str5, UniversalCallBack universalCallBack) {
        UserAPI userAPI = this;
        final UniversalCallBack universalCallBack2 = universalCallBack;
        String str6 = str;
        Log.d("CANCEL_TRAVEL: ", str);
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str5;
        final String str10 = str4;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str6, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "UPDATE_PROFILE: ";
                android.util.Log.d(r0, r3);
                r0 = r0;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseObject.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseObject) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r0;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r0;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.81.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack2.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack2);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("phone", str7);
                hashMap.put("email", str8);
                hashMap.put("old_password", str9);
                hashMap.put("new_password", str10);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void Conditions(final UniversalCallBack universalCallBack) {
        String str = Constants.CONDITION;
        Log.d("CONDITION: ", str);
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "CONDITION: ";
                android.util.Log.d(r0, r3);
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseConditions.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseConditions) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r8;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r8;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.84.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void PilotOrderDetails(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.PILOT_ORDER_DETAILS;
        Log.d("PILOT_ORDER_DETAILS: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(String str) {
                Log.d("PILOT_ORDER_DETAILS: ", str);
                try {
                    universalCallBack.onFinish();
                    universalCallBack.onResponse((ResponseMyOrderDetails) new Gson().fromJson(str.toString(), ResponseMyOrderDetails.class));
                } catch (String str2) {
                    Log.e("PILOT_ORDER_DETAILS", str2.getMessage());
                    universalCallBack.OnError("Server Connection error try again later");
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("order_id", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void BillDriver(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.DRIVER_BILL;
        Log.d("DRIVER_BILL: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "DRIVER_BILL: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponsePilotBill.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponsePilotBill) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.90.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("week", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void BillRest(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.COMPANY_BILL;
        Log.d("COMPANY_BILL: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "COMPANY_BILL: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseBillResData.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseBillResData) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.93.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("week", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void ReportBillRest(String str, final UniversalCallBack universalCallBack) {
        String str2 = Constants.REPORT_BILL;
        Log.d("REPORT_BILL: ", str2);
        final String str3 = str;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str2, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "REPORT_BILL: ";
                android.util.Log.d(r0, r3);
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseReportOrder.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseReportOrder) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r10;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r10;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.96.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("date", str3);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    public void PilotOrder(String str, String str2, final UniversalCallBack universalCallBack) {
        String str3 = Constants.DRIVER_ORDER;
        Log.d("DRIVER_ORDER: ", str3);
        final String str4 = str;
        final String str5 = str2;
        VolleySingleton.getInstance().addToRequestQueue(new VolleyStringRequest(1, str3, new Listener<String>() {
            public void onResponse(java.lang.String r3) {
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
                r2 = this;
                r0 = "DRIVER_ORDER: ";
                android.util.Log.d(r0, r3);
                r0 = r12;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onFinish();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r3.toString();	 Catch:{ JsonSyntaxException -> 0x0021 }
                r1 = com.ict.delivirko.API.ResponseOrderPilot.class;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = r0.fromJson(r3, r1);	 Catch:{ JsonSyntaxException -> 0x0021 }
                r3 = (com.ict.delivirko.API.ResponseOrderPilot) r3;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0 = r12;	 Catch:{ JsonSyntaxException -> 0x0021 }
                r0.onResponse(r3);	 Catch:{ JsonSyntaxException -> 0x0021 }
                goto L_0x0028;
            L_0x0021:
                r3 = r12;
                r0 = "Server Connection error try again later";
                r3.OnError(r0);
            L_0x0028:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.99.onResponse(java.lang.String):void");
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                universalCallBack.onFinish();
                UserAPI.this.showMessage(volleyError, universalCallBack);
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("week", str4);
                hashMap.put(NotificationCompat.CATEGORY_STATUS, str5);
                return hashMap;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                SharedPreferences sharedPreferences = ApplicationController.getAppContext().getSharedPreferences("access_token", 0);
                Log.e("Bearer", sharedPreferences.getString("UserToken", ""));
                String concat = "Bearer ".concat(sharedPreferences.getString("UserToken", ""));
                Map headers = super.getHeaders();
                Map<String, String> hashMap = new HashMap();
                headers.remove("Authorization");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", concat);
                hashMap.putAll(headers);
                return hashMap;
            }
        }, "");
    }

    private void showMessage(com.android.volley.VolleyError r4, com.ict.delivirko.Interfaces.UniversalCallBack r5) {
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
        r0 = "onErrorResponse";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r4.toString();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
        r0 = "error.getMessage()";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r4.getMessage();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
        r0 = r4 instanceof com.android.volley.NetworkError;
        if (r0 == 0) goto L_0x003e;
    L_0x0038:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x003e:
        r0 = r4 instanceof com.android.volley.ServerError;
        if (r0 == 0) goto L_0x0048;
    L_0x0042:
        r4 = "The server could not be found. Please try again after some time!!";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x0048:
        r0 = r4 instanceof com.android.volley.AuthFailureError;
        if (r0 == 0) goto L_0x0052;
    L_0x004c:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x0052:
        r0 = r4 instanceof com.android.volley.ParseError;
        if (r0 == 0) goto L_0x005c;
    L_0x0056:
        r4 = "Parsing error! Please try again after some time!!";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x005c:
        r0 = r4 instanceof com.android.volley.NoConnectionError;
        if (r0 == 0) goto L_0x0066;
    L_0x0060:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x0066:
        r0 = r4 instanceof com.android.volley.TimeoutError;
        if (r0 == 0) goto L_0x0070;
    L_0x006a:
        r4 = "Connection TimeOut! Please check your internet connection.";
        r5.OnError(r4);
        goto L_0x008a;
    L_0x0070:
        r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0085 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0085 }
        r4 = r4.getMessage();	 Catch:{ JsonSyntaxException -> 0x0085 }
        r1 = com.ict.delivirko.API.ResponseError.class;	 Catch:{ JsonSyntaxException -> 0x0085 }
        r4 = r0.fromJson(r4, r1);	 Catch:{ JsonSyntaxException -> 0x0085 }
        r4 = (com.ict.delivirko.API.ResponseError) r4;	 Catch:{ JsonSyntaxException -> 0x0085 }
        r5.onFailure(r4);	 Catch:{ JsonSyntaxException -> 0x0085 }
        goto L_0x008a;
    L_0x0085:
        r4 = "Server Connection error try again later";
        r5.OnError(r4);
    L_0x008a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.showMessage(com.android.volley.VolleyError, com.ict.delivirko.Interfaces.UniversalCallBack):void");
    }

    private void showMessage(com.android.volley.VolleyError r4, com.ict.delivirko.Interfaces.UniversalStringCallBack r5) {
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
        r0 = "onErrorResponse";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r4.toString();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
        r0 = "error.getMessage()";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r4.getMessage();
        r1.append(r2);
        r2 = "";
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
        r0 = r4 instanceof com.android.volley.NetworkError;
        if (r0 == 0) goto L_0x003e;
    L_0x0038:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x003e:
        r0 = r4 instanceof com.android.volley.ServerError;
        if (r0 == 0) goto L_0x0048;
    L_0x0042:
        r4 = "The server could not be found. Please try again after some time!!";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x0048:
        r0 = r4 instanceof com.android.volley.AuthFailureError;
        if (r0 == 0) goto L_0x0052;
    L_0x004c:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x0052:
        r0 = r4 instanceof com.android.volley.ParseError;
        if (r0 == 0) goto L_0x005c;
    L_0x0056:
        r4 = "Parsing error! Please try again after some time!!";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x005c:
        r0 = r4 instanceof com.android.volley.NoConnectionError;
        if (r0 == 0) goto L_0x0066;
    L_0x0060:
        r4 = "Cannot connect to Internet...Please check your connection!";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x0066:
        r0 = r4 instanceof com.android.volley.TimeoutError;
        if (r0 == 0) goto L_0x0070;
    L_0x006a:
        r4 = "Connection TimeOut! Please check your internet connection.";
        r5.OnError(r4);
        goto L_0x008e;
    L_0x0070:
        r0 = new com.google.gson.Gson;	 Catch:{ JsonSyntaxException -> 0x0089 }
        r0.<init>();	 Catch:{ JsonSyntaxException -> 0x0089 }
        r4 = r4.getMessage();	 Catch:{ JsonSyntaxException -> 0x0089 }
        r1 = com.ict.delivirko.API.ResponseError.class;	 Catch:{ JsonSyntaxException -> 0x0089 }
        r4 = r0.fromJson(r4, r1);	 Catch:{ JsonSyntaxException -> 0x0089 }
        r4 = (com.ict.delivirko.API.ResponseError) r4;	 Catch:{ JsonSyntaxException -> 0x0089 }
        r4 = r4.getMessage();	 Catch:{ JsonSyntaxException -> 0x0089 }
        r5.onFailure(r4);	 Catch:{ JsonSyntaxException -> 0x0089 }
        goto L_0x008e;
    L_0x0089:
        r4 = "Server Connection error try again later";
        r5.OnError(r4);
    L_0x008e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.API.UserAPI.showMessage(com.android.volley.VolleyError, com.ict.delivirko.Interfaces.UniversalStringCallBack):void");
    }
}
