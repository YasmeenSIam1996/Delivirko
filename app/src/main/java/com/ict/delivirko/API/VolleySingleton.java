package com.ict.delivirko.API;

import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.ict.delivirko.App.ApplicationController;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

public class VolleySingleton {
    public static final String TAG = "VolleySingleton";
    private static VolleySingleton mInstance;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;

    private VolleySingleton() {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    }

    public static synchronized VolleySingleton getInstance() {
        VolleySingleton volleySingleton;
        synchronized (VolleySingleton.class) {
            if (mInstance == null) {
                mInstance = new VolleySingleton();
            }
            volleySingleton = mInstance;
        }
        return volleySingleton;
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(ApplicationController.getAppContext());
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String str) {
        if (TextUtils.isEmpty(str)) {
            str = TAG;
        }
        request.setTag(str);
        request.setShouldCache(false);
        request.setRetryPolicy(new DefaultRetryPolicy(30000000, 0, 1.0f));
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        addToRequestQueue(request, "");
    }

    public void cancelPendingRequests(Object obj) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.cancelAll(obj);
        }
    }
}
