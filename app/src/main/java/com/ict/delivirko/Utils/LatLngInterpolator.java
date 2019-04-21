package com.ict.delivirko.Utils;

import com.google.android.gms.maps.model.LatLng;

public interface LatLngInterpolator {

    public static class Spherical implements LatLngInterpolator {
        public LatLng interpolate(float f, LatLng latLng, LatLng latLng2) {
            float f2 = f;
            LatLng latLng3 = latLng;
            LatLng latLng4 = latLng2;
            double toRadians = Math.toRadians(latLng3.latitude);
            double toRadians2 = Math.toRadians(latLng3.longitude);
            double toRadians3 = Math.toRadians(latLng4.latitude);
            double toRadians4 = Math.toRadians(latLng4.longitude);
            double cos = Math.cos(toRadians);
            double cos2 = Math.cos(toRadians3);
            double computeAngleBetween = computeAngleBetween(toRadians, toRadians2, toRadians3, toRadians4);
            double sin = Math.sin(computeAngleBetween);
            if (sin < 1.0E-6d) {
                return latLng3;
            }
            double d = (double) (1.0f - f2);
            Double.isNaN(d);
            d = Math.sin(d * computeAngleBetween) / sin;
            double d2 = (double) f2;
            Double.isNaN(d2);
            computeAngleBetween = Math.sin(d2 * computeAngleBetween) / sin;
            cos *= d;
            cos2 *= computeAngleBetween;
            sin = (Math.cos(toRadians2) * cos) + (Math.cos(toRadians4) * cos2);
            d2 = (cos * Math.sin(toRadians2)) + (cos2 * Math.sin(toRadians4));
            return new LatLng(Math.toDegrees(Math.atan2((d * Math.sin(toRadians)) + (computeAngleBetween * Math.sin(toRadians3)), Math.sqrt((sin * sin) + (d2 * d2)))), Math.toDegrees(Math.atan2(d2, sin)));
        }

        private double computeAngleBetween(double d, double d2, double d3, double d4) {
            return Math.asin(Math.sqrt(Math.pow(Math.sin((d - d3) / 2.0d), 2.0d) + ((Math.cos(d) * Math.cos(d3)) * Math.pow(Math.sin((d2 - d4) / 2.0d), 2.0d)))) * 2.0d;
        }
    }

    LatLng interpolate(float f, LatLng latLng, LatLng latLng2);
}
