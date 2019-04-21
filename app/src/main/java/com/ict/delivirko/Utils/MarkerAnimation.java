package com.ict.delivirko.Utils;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class MarkerAnimation {
    public static void animateMarkerToGB(Marker marker, LatLng latLng, LatLngInterpolator latLngInterpolator) {
        final LatLng position = marker.getPosition();
        Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final Interpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        final Marker marker2 = marker;
        final LatLngInterpolator latLngInterpolator2 = latLngInterpolator;
        final LatLng latLng2 = latLng;
        final Handler handler2 = handler;
        handler.post(new Runnable() {
            long elapsed;
            /* renamed from: t */
            float f24t;
            /* renamed from: v */
            float f25v;

            public void run() {
                this.elapsed = SystemClock.uptimeMillis() - uptimeMillis;
                this.f24t = ((float) this.elapsed) / 2000.0f;
                this.f25v = accelerateDecelerateInterpolator.getInterpolation(this.f24t);
                marker2.setPosition(latLngInterpolator2.interpolate(this.f25v, position, latLng2));
                if (this.f24t < 1.0f) {
                    handler2.postDelayed(this, 16);
                }
            }
        });
    }
}
