package com.ict.delivirko.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds.Builder;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.ict.delivirko.C0519R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class AddLineToMap {
    public static final PatternItem DASH = new Dash(20.0f);
    public static final PatternItem GAP = new Gap(20.0f);
    public static final int PATTERN_DASH_LENGTH_PX = 20;
    public static final int PATTERN_GAP_LENGTH_PX = 20;
    public static final List<PatternItem> PATTERN_POLYGON_ALPHA = Arrays.asList(new PatternItem[]{GAP, DASH});
    private Context context;
    private Marker driverMarker;
    private GoogleMap mMap;
    private ArrayList markerPoints = new ArrayList();

    private class DownloadTask extends AsyncTask<String, Void, String> {
        private DownloadTask() {
        }

        protected String doInBackground(String... strArr) {
            String str = "";
            try {
                str = AddLineToMap.this.downloadUrl(strArr[0]);
            } catch (String[] strArr2) {
                Log.d("Background Task", strArr2.toString());
            }
            return str;
        }

        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            new ParserTask().execute(new String[]{str});
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
        protected void onPostExecute(java.util.List<java.util.List<java.util.HashMap<java.lang.String, java.lang.String>>> r13) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:28:0x0141 in {2, 9, 10, 12, 20, 24, 25, 27} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
            r12 = this;
            r0 = 0;
            r1 = "lnglng";	 Catch:{ Exception -> 0x0035 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
            r2.<init>();	 Catch:{ Exception -> 0x0035 }
            r3 = r13.get(r0);	 Catch:{ Exception -> 0x0035 }
            r2.append(r3);	 Catch:{ Exception -> 0x0035 }
            r3 = "";	 Catch:{ Exception -> 0x0035 }
            r2.append(r3);	 Catch:{ Exception -> 0x0035 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x0035 }
            android.util.Log.e(r1, r2);	 Catch:{ Exception -> 0x0035 }
            r1 = "lnglng";	 Catch:{ Exception -> 0x0035 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
            r2.<init>();	 Catch:{ Exception -> 0x0035 }
            r3 = r13.size();	 Catch:{ Exception -> 0x0035 }
            r2.append(r3);	 Catch:{ Exception -> 0x0035 }
            r3 = "";	 Catch:{ Exception -> 0x0035 }
            r2.append(r3);	 Catch:{ Exception -> 0x0035 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x0035 }
            android.util.Log.e(r1, r2);	 Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r1 = 0;
            r2 = new com.google.android.gms.maps.model.MarkerOptions;
            r2.<init>();
            r2 = r1;
            r1 = 0;
        L_0x003d:
            r3 = r13.size();
            r4 = 1;
            if (r1 >= r3) goto L_0x009e;
        L_0x0044:
            r2 = new java.util.ArrayList;
            r2.<init>();
            r3 = new com.google.android.gms.maps.model.PolylineOptions;
            r3.<init>();
            r5 = r13.get(r1);
            r5 = (java.util.List) r5;
            r6 = 0;
        L_0x0055:
            r7 = r5.size();
            if (r6 >= r7) goto L_0x0084;
        L_0x005b:
            r7 = r5.get(r6);
            r7 = (java.util.HashMap) r7;
            r8 = "lat";
            r8 = r7.get(r8);
            r8 = (java.lang.String) r8;
            r8 = java.lang.Double.parseDouble(r8);
            r10 = "lng";
            r7 = r7.get(r10);
            r7 = (java.lang.String) r7;
            r10 = java.lang.Double.parseDouble(r7);
            r7 = new com.google.android.gms.maps.model.LatLng;
            r7.<init>(r8, r10);
            r2.add(r7);
            r6 = r6 + 1;
            goto L_0x0055;
        L_0x0084:
            r3.addAll(r2);
            r2 = 1099431936; // 0x41880000 float:17.0 double:5.431915495E-315;
            r3.width(r2);
            r2 = com.ict.delivirko.Utils.AddLineToMap.PATTERN_POLYGON_ALPHA;
            r3.pattern(r2);
            r2 = 2131034161; // 0x7f050031 float:1.7678832E38 double:1.052870769E-314;
            r3.color(r2);
            r3.geodesic(r4);
            r1 = r1 + 1;
            r2 = r3;
            goto L_0x003d;
        L_0x009e:
            r13 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ Exception -> 0x00ba }
            r13 = r13.mMap;	 Catch:{ Exception -> 0x00ba }
            r13.addPolyline(r2);	 Catch:{ Exception -> 0x00ba }
            r13 = "statusOrder_";	 Catch:{ Exception -> 0x00ba }
            r1 = "hhhhhhhhhhhhh11111111";	 Catch:{ Exception -> 0x00ba }
            android.util.Log.e(r13, r1);	 Catch:{ Exception -> 0x00ba }
        L_0x00ae:
            r13 = "statusOrder_";
            r0 = "hhhhhhhhhhhh";
            android.util.Log.e(r13, r0);
            goto L_0x0138;
        L_0x00b7:
            r13 = move-exception;
            goto L_0x0139;
        L_0x00ba:
            r13 = move-exception;
            r1 = "statusOrder_";	 Catch:{ all -> 0x00b7 }
            r13 = r13.getMessage();	 Catch:{ all -> 0x00b7 }
            android.util.Log.e(r1, r13);	 Catch:{ all -> 0x00b7 }
            r13 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r13 = r13.markerPoints;	 Catch:{ all -> 0x00b7 }
            r13 = r13.size();	 Catch:{ all -> 0x00b7 }
            if (r13 != r4) goto L_0x00fa;	 Catch:{ all -> 0x00b7 }
        L_0x00d0:
            r13 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r13 = r13.mMap;	 Catch:{ all -> 0x00b7 }
            r1 = new com.google.android.gms.maps.model.MarkerOptions;	 Catch:{ all -> 0x00b7 }
            r1.<init>();	 Catch:{ all -> 0x00b7 }
            r2 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r2 = r2.markerPoints;	 Catch:{ all -> 0x00b7 }
            r0 = r2.get(r0);	 Catch:{ all -> 0x00b7 }
            r0 = (com.google.android.gms.maps.model.LatLng) r0;	 Catch:{ all -> 0x00b7 }
            r0 = r1.position(r0);	 Catch:{ all -> 0x00b7 }
            r1 = 2131165429; // 0x7f0700f5 float:1.7945075E38 double:1.052935624E-314;	 Catch:{ all -> 0x00b7 }
            r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(r1);	 Catch:{ all -> 0x00b7 }
            r0 = r0.icon(r1);	 Catch:{ all -> 0x00b7 }
            r13.addMarker(r0);	 Catch:{ all -> 0x00b7 }
            goto L_0x00ae;	 Catch:{ all -> 0x00b7 }
        L_0x00fa:
            r13 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r13 = r13.markerPoints;	 Catch:{ all -> 0x00b7 }
            r13 = r13.size();	 Catch:{ all -> 0x00b7 }
            r0 = 2;	 Catch:{ all -> 0x00b7 }
            if (r13 != r0) goto L_0x00ae;	 Catch:{ all -> 0x00b7 }
        L_0x0107:
            r13 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r0 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r0 = r0.mMap;	 Catch:{ all -> 0x00b7 }
            r1 = new com.google.android.gms.maps.model.MarkerOptions;	 Catch:{ all -> 0x00b7 }
            r1.<init>();	 Catch:{ all -> 0x00b7 }
            r2 = com.ict.delivirko.Utils.AddLineToMap.this;	 Catch:{ all -> 0x00b7 }
            r2 = r2.markerPoints;	 Catch:{ all -> 0x00b7 }
            r2 = r2.get(r4);	 Catch:{ all -> 0x00b7 }
            r2 = (com.google.android.gms.maps.model.LatLng) r2;	 Catch:{ all -> 0x00b7 }
            r1 = r1.position(r2);	 Catch:{ all -> 0x00b7 }
            r2 = 2131165396; // 0x7f0700d4 float:1.7945008E38 double:1.052935608E-314;	 Catch:{ all -> 0x00b7 }
            r2 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(r2);	 Catch:{ all -> 0x00b7 }
            r1 = r1.icon(r2);	 Catch:{ all -> 0x00b7 }
            r0 = r0.addMarker(r1);	 Catch:{ all -> 0x00b7 }
            r13.driverMarker = r0;	 Catch:{ all -> 0x00b7 }
            goto L_0x00ae;
        L_0x0138:
            return;
        L_0x0139:
            r0 = "statusOrder_";
            r1 = "hhhhhhhhhhhh";
            android.util.Log.e(r0, r1);
            throw r13;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Utils.AddLineToMap.ParserTask.onPostExecute(java.util.List):void");
        }

        private ParserTask() {
        }

        protected List<List<HashMap<String, String>>> doInBackground(String... strArr) {
            try {
                return new DirectionsJSONParser().parse(new JSONObject(strArr[0]));
            } catch (String[] strArr2) {
                strArr2.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: com.ict.delivirko.Utils.AddLineToMap$1 */
    class C09141 implements CancelableCallback {
        public void onCancel() {
        }

        C09141() {
        }

        public void onFinish() {
            AddLineToMap.this.mMap.animateCamera(CameraUpdateFactory.zoomBy(-2.0f));
        }
    }

    private java.lang.String downloadUrl(java.lang.String r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:23:0x0055 in {7, 9, 11, 13, 15, 17, 19, 20, 22} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
        r0 = "";
        r1 = 0;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        r6 = r2.openConnection();	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        r6 = (java.net.HttpURLConnection) r6;	 Catch:{ Exception -> 0x003b, all -> 0x0038 }
        r6.connect();	 Catch:{ Exception -> 0x0036 }
        r1 = r6.getInputStream();	 Catch:{ Exception -> 0x0036 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0036 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0036 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0036 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0036 }
        r3.<init>();	 Catch:{ Exception -> 0x0036 }
    L_0x0024:
        r4 = r2.readLine();	 Catch:{ Exception -> 0x0036 }
        if (r4 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x0036 }
    L_0x002a:
        r3.append(r4);	 Catch:{ Exception -> 0x0036 }
        goto L_0x0024;	 Catch:{ Exception -> 0x0036 }
    L_0x002e:
        r0 = r3.toString();	 Catch:{ Exception -> 0x0036 }
        r2.close();	 Catch:{ Exception -> 0x0036 }
        goto L_0x0046;
    L_0x0036:
        r2 = move-exception;
        goto L_0x003d;
    L_0x0038:
        r0 = move-exception;
        r6 = r1;
        goto L_0x004e;
    L_0x003b:
        r2 = move-exception;
        r6 = r1;
    L_0x003d:
        r3 = "Exception";	 Catch:{ all -> 0x004d }
        r2 = r2.toString();	 Catch:{ all -> 0x004d }
        android.util.Log.d(r3, r2);	 Catch:{ all -> 0x004d }
    L_0x0046:
        r1.close();
        r6.disconnect();
        return r0;
    L_0x004d:
        r0 = move-exception;
    L_0x004e:
        r1.close();
        r6.disconnect();
        throw r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Utils.AddLineToMap.downloadUrl(java.lang.String):java.lang.String");
    }

    public AddLineToMap(GoogleMap googleMap, Context context) {
        this.mMap = googleMap;
        this.context = context;
    }

    public void addMarker(LatLng latLng) {
        if (this.markerPoints.size() > 1) {
            this.markerPoints.clear();
            this.mMap.clear();
        }
        this.markerPoints.add(latLng);
        new MarkerOptions().position(latLng);
        if (this.markerPoints.size() >= 2) {
            latLng = getDirectionsUrl((LatLng) this.markerPoints.get(0), (LatLng) this.markerPoints.get(1));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(latLng);
            stringBuilder.append("");
            Log.e("lnglng", stringBuilder.toString());
            new DownloadTask().execute(new String[]{latLng});
        }
    }

    private String getDirectionsUrl(LatLng latLng, LatLng latLng2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(latLng.latitude);
        stringBuilder.append(",");
        stringBuilder.append(latLng.longitude);
        latLng = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("destination=");
        stringBuilder.append(latLng2.latitude);
        stringBuilder.append(",");
        stringBuilder.append(latLng2.longitude);
        latLng2 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("key=");
        stringBuilder2.append(Constants.GOOGLE_API_KEY);
        String stringBuilder3 = stringBuilder2.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(latLng);
        stringBuilder4.append("&");
        stringBuilder4.append(latLng2);
        stringBuilder4.append("&");
        stringBuilder4.append("mode=driving");
        stringBuilder4.append("&");
        stringBuilder4.append("language=en-EN");
        stringBuilder4.append("&");
        stringBuilder4.append(stringBuilder3);
        stringBuilder4.append("&");
        stringBuilder4.append("sensor=false");
        latLng = stringBuilder4.toString();
        latLng2 = new StringBuilder();
        latLng2.append("https://maps.googleapis.com/maps/api/directions/json?");
        latLng2.append(latLng);
        return latLng2.toString();
    }

    public Bitmap getMarkerBitmapFromView(String str, String str2) {
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0519R.layout.marker_info_window, null);
        TextView textView = (TextView) inflate.findViewById(C0519R.id.txt_eta);
        ImageView imageView = (ImageView) inflate.findViewById(C0519R.id.eta_iv);
        if (str2.equals("1") != null) {
            imageView.setImageResource(C0519R.drawable.rest_icon);
        } else {
            imageView.setImageResource(C0519R.drawable.my_location);
        }
        if (str.equals("") != null) {
            textView.setVisibility(8);
        }
        textView.setText(str);
        inflate.measure(0, 0);
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        inflate.buildDrawingCache();
        str = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Config.ARGB_8888);
        str2 = new Canvas(str);
        str2.drawColor(-1, Mode.SRC_IN);
        Drawable background = inflate.getBackground();
        if (background != null) {
            background.draw(str2);
        }
        inflate.draw(str2);
        return str;
    }

    public void ZoomBetween2Marker(LatLng latLng, LatLng latLng2) {
        Builder builder = new Builder();
        builder.include(latLng);
        builder.include(latLng2);
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 70), new C09141());
    }

    public void deleteDriverMarker() {
        Marker marker = this.driverMarker;
        if (marker != null) {
            marker.remove();
        }
    }
}
