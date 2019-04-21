package com.ict.delivirko.fragment.pilot;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.annotation.NonNull;
import android.support.media.ExifInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ict.delivirko.API.ResponseNearestCompany;
import com.ict.delivirko.API.ResponseNearestDriver;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.Activities.PilotTravelActivity;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.FirebaseUtils.MyFirebaseMessagingService;
import com.ict.delivirko.Interfaces.ObjectClickListener;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.pilot.NearestCompany;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.Utils.LatLngInterpolator.Spherical;
import com.ict.delivirko.Utils.MarkerAnimation;

public class PilotMapFragment extends Fragment implements OnMapReadyCallback {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 5445;
    private Location currentLocation;
    private ImageButton currentLocationImageButton;
    private Marker currentLocationMarker;
    private boolean firstTimeFlag = true;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private final LocationCallback mLocationCallback = new C09241();
    private GoogleMap mMap;

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$2 */
    class C05402 implements OnClickListener {
        C05402() {
        }

        public void onClick(View view) {
            if (view.getId() == C0519R.id.currentLocationImageButton && PilotMapFragment.this.mMap != null && PilotMapFragment.this.currentLocation != null) {
                view = PilotMapFragment.this;
                view.animateCamera(view.currentLocation);
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$4 */
    class C05414 implements DialogInterface.OnClickListener {
        C05414() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PilotMapFragment.this.getActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            PilotMapFragment.this.getActivity().finish();
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$5 */
    class C05425 implements DialogInterface.OnClickListener {
        C05425() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            PilotMapFragment.this.getActivity().finish();
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$6 */
    class C05436 implements OnCancelListener {
        C05436() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            ActivityCompat.finishAffinity(PilotMapFragment.this.getActivity());
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$1 */
    class C09241 extends LocationCallback {
        C09241() {
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            if (locationResult.getLastLocation() != null) {
                PilotMapFragment.this.currentLocation = locationResult.getLastLocation();
                if (!(PilotMapFragment.this.firstTimeFlag == null || PilotMapFragment.this.mMap == null)) {
                    locationResult = PilotMapFragment.this;
                    locationResult.animateCamera(locationResult.currentLocation);
                    PilotMapFragment.this.firstTimeFlag = false;
                }
                locationResult = PilotMapFragment.this;
                locationResult.showMarker(locationResult.currentLocation);
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$3 */
    class C09253 implements ObjectClickListener {
        C09253() {
        }

        public void onItemClickListener(OrderNotification orderNotification) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(orderNotification.getStatus_id());
            stringBuilder.append("");
            Log.e("Status_id", stringBuilder.toString());
            if (orderNotification.getStatus_id().equals("7")) {
                Intent intent = new Intent(PilotMapFragment.this.getActivity(), PilotTravelActivity.class);
                intent.putExtra("orderNo", Integer.valueOf(orderNotification.getOrder_id()));
                intent.putExtra("Status_id", Integer.valueOf(orderNotification.getStatus_id()));
                PilotMapFragment.this.startActivity(intent);
                PilotMapFragment.this.getActivity().finish();
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotMapFragment$7 */
    class C09267 implements UniversalCallBack {
        C09267() {
        }

        public void onResponse(Object obj) {
            ResponseNearestDriver responseNearestDriver = (ResponseNearestDriver) obj;
            if (responseNearestDriver != null && responseNearestDriver.isStatus()) {
                for (NearestCompany nearestCompany : responseNearestDriver.getDataNearestCompany().getNearestCompanies()) {
                    PilotMapFragment.this.mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(PilotMapFragment.this.getMarkerBitmapFromView(nearestCompany.getName(), false))).position(new LatLng(nearestCompany.getLat(), nearestCompany.getLng())));
                }
            }
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(PilotMapFragment.this.getActivity(), ((ResponseNearestCompany) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
        }

        public void OnError(String str) {
            Constants.showDialog(PilotMapFragment.this.getActivity(), str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_map_pilot, viewGroup, false);
        this.currentLocationImageButton = (ImageButton) layoutInflater.findViewById(C0519R.id.currentLocationImageButton);
        this.currentLocationImageButton.setOnClickListener(new C05402());
        driverData();
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(C0519R.id.mapHomePilot)).getMapAsync(this);
        MyFirebaseMessagingService.setOnItemClickListener(new C09253());
        return layoutInflater;
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        googleMap.clear();
        if (VERSION.SDK_INT >= 19) {
            int i;
            Log.e("state_", "1");
            googleMap = true;
            try {
                i = Secure.getInt(getActivity().getContentResolver(), "location_mode");
            } catch (SettingNotFoundException e) {
                e.printStackTrace();
                i = 1;
            }
            if (i == 0 || i != 3) {
                googleMap = null;
            }
            if (googleMap != null) {
                Log.e("state_", ExifInterface.GPS_MEASUREMENT_3D);
                return;
            }
            Log.e("state_", "4");
            Toast.makeText(getActivity(), "turn on", 0).show();
            showSettingAlert();
            return;
        }
        Log.e("state_", ExifInterface.GPS_MEASUREMENT_2D);
        showSettingAlert();
    }

    public void showSettingAlert() {
        Builder builder = new Builder(getContext());
        builder.setTitle((CharSequence) "GPS setting!");
        builder.setMessage((CharSequence) "GPS is not enabled, Do you want to go to settings menu? ");
        builder.setPositiveButton((CharSequence) "Setting", new C05414());
        builder.setNegativeButton((CharSequence) "Cancel", new C05425());
        builder.setOnCancelListener(new C05436());
        builder.show();
    }

    public void driverData() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().driverData(new C09267());
    }

    private Bitmap getMarkerBitmapFromView(String str, boolean z) {
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(C0519R.layout.marker_info_window, null);
        TextView textView = (TextView) inflate.findViewById(C0519R.id.txt_eta);
        ImageView imageView = (ImageView) inflate.findViewById(C0519R.id.eta_iv);
        if (z) {
            imageView.setImageResource(true);
        } else {
            imageView.setImageResource(true);
        }
        if (str.equals("")) {
            textView.setVisibility(true);
        }
        textView.setText(str);
        inflate.measure(0, 0);
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        inflate.buildLayer();
        str = Bitmap.createBitmap(inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), Config.ARGB_8888);
        z = new Canvas(str);
        z.drawColor(-1, Mode.SRC_IN);
        Drawable background = inflate.getBackground();
        if (background != null) {
            background.draw(z);
        }
        inflate.draw(z);
        return str;
    }

    private void animateCamera(@NonNull Location location) {
        this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(getCameraPositionWithBearing(new LatLng(location.getLatitude(), location.getLongitude()))));
    }

    @NonNull
    private CameraPosition getCameraPositionWithBearing(LatLng latLng) {
        return new CameraPosition.Builder().target(latLng).zoom(16.0f).build();
    }

    private void showMarker(@NonNull Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        location = this.currentLocationMarker;
        if (location == null) {
            this.currentLocationMarker = this.mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(getResources().getString(C0519R.string.myLocation), true))).position(latLng));
        } else {
            MarkerAnimation.animateMarkerToGB(location, latLng, new Spherical());
        }
    }

    public void onStop() {
        super.onStop();
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationProviderClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.mLocationCallback);
        }
    }

    public void onResume() {
        super.onResume();
        if (isGooglePlayServicesAvailable()) {
            this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
            startCurrentLocationUpdates();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.fusedLocationProviderClient = null;
        this.mMap = null;
    }

    private void startCurrentLocationUpdates() {
        LocationRequest create = LocationRequest.create();
        create.setPriority(100);
        create.setInterval(3000);
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.fusedLocationProviderClient.requestLocationUpdates(create, this.mLocationCallback, Looper.myLooper());
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(getActivity());
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (instance.isUserResolvableError(isGooglePlayServicesAvailable)) {
            Toast.makeText(getActivity(), "Please Install google play services to use this application", 1).show();
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 5445) {
            return;
        }
        if (iArr[0] == -1) {
            Toast.makeText(getActivity(), "Permission denied by uses", 0).show();
        } else if (iArr[0] == 0) {
            startCurrentLocationUpdates();
        }
    }
}
