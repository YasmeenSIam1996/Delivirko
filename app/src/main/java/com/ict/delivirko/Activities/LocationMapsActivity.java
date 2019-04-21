package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.support.media.ExifInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Utils.Constants;
import java.util.Locale;

public class LocationMapsActivity extends AppCompatActivity implements OnMapReadyCallback, OnMarkerClickListener, OnMapClickListener {
    private Marker MyMarker;
    private TextView address;
    private Button btnSave;
    private FusedLocationProviderClient fusedLocationClient;
    private double latitude;
    private double longitude;
    private GoogleMap mMap;
    private String nameLocation;

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$1 */
    class C05001 implements OnClickListener {
        C05001() {
        }

        public void onClick(View view) {
            if (LocationMapsActivity.this.nameLocation != null) {
                view = new Intent();
                view.putExtra("name", LocationMapsActivity.this.nameLocation);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(LocationMapsActivity.this.latitude);
                stringBuilder.append("");
                view.putExtra("lat", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(LocationMapsActivity.this.longitude);
                stringBuilder.append("");
                view.putExtra("lng", stringBuilder.toString());
                LocationMapsActivity.this.setResult(-1, view);
                LocationMapsActivity.this.finish();
                return;
            }
            view = LocationMapsActivity.this;
            Constants.showDialog(view, view.getResources().getString(C0519R.string.choose_location));
        }
    }

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$3 */
    class C05013 implements DialogInterface.OnClickListener {
        C05013() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            LocationMapsActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            LocationMapsActivity.this.finish();
        }
    }

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$4 */
    class C05024 implements DialogInterface.OnClickListener {
        C05024() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            LocationMapsActivity.this.finish();
        }
    }

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$5 */
    class C05035 implements OnCancelListener {
        C05035() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            ActivityCompat.finishAffinity(LocationMapsActivity.this);
        }
    }

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$2 */
    class C08982 implements PlaceSelectionListener {
        public void onError(Status status) {
        }

        C08982() {
        }

        public void onPlaceSelected(Place place) {
            LocationMapsActivity.this.mMap.clear();
            LocationMapsActivity.this.latitude = place.getLatLng().latitude;
            LocationMapsActivity.this.longitude = place.getLatLng().longitude;
            place = LocationMapsActivity.this;
            place.moveMap(place.latitude, LocationMapsActivity.this.longitude);
        }
    }

    /* renamed from: com.ict.delivirko.Activities.LocationMapsActivity$6 */
    class C08996 implements OnSuccessListener<Location> {
        C08996() {
        }

        public void onSuccess(Location location) {
            if (location != null) {
                LocationMapsActivity.this.longitude = location.getLongitude();
                LocationMapsActivity.this.latitude = location.getLatitude();
                location = LocationMapsActivity.this;
                location.moveMap(location.latitude, LocationMapsActivity.this.longitude);
            }
        }
    }

    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_location_maps);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.map)).getMapAsync(this);
        this.btnSave = (Button) findViewById(C0519R.id.save);
        this.address = (TextView) findViewById(C0519R.id.address);
        this.btnSave.setOnClickListener(new C05001());
        ((PlaceAutocompleteFragment) getFragmentManager().findFragmentById(C0519R.id.place_autocomplete_fragment)).setOnPlaceSelectedListener(new C08982());
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        googleMap.clear();
        if (VERSION.SDK_INT >= 19) {
            int i;
            Log.e("state_", "1");
            googleMap = true;
            try {
                i = Secure.getInt(getContentResolver(), "location_mode");
            } catch (SettingNotFoundException e) {
                e.printStackTrace();
                i = 1;
            }
            if (i == 0 || i != 3) {
                googleMap = null;
            }
            if (googleMap != null) {
                Log.e("state_", ExifInterface.GPS_MEASUREMENT_3D);
                getCurrentLocation();
                return;
            }
            Log.e("state_", "4");
            showSettingAlert();
            return;
        }
        Log.e("state_", ExifInterface.GPS_MEASUREMENT_2D);
        showSettingAlert();
    }

    private void moveMap(double d, double d2) {
        setAddress(d, d2);
        Marker marker = this.MyMarker;
        if (marker != null) {
            marker.remove();
        }
        LatLng latLng = new LatLng(d, d2);
        this.MyMarker = this.mMap.addMarker(new MarkerOptions().position(latLng).draggable(Double.MIN_VALUE).icon(BitmapDescriptorFactory.fromResource(1.052935608E-314d)).title("My Location"));
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude, latLng.longitude), 5.424144515E-315d));
        this.mMap.getUiSettings().setZoomControlsEnabled(false);
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public void showSettingAlert() {
        Builder builder = new Builder(this);
        builder.setTitle((CharSequence) "GPS setting!");
        builder.setMessage((CharSequence) "GPS is not enabled, Do you want to go to settings menu? ");
        builder.setPositiveButton((CharSequence) "Setting", new C05013());
        builder.setNegativeButton((CharSequence) "Cancel", new C05024());
        builder.setOnCancelListener(new C05035());
        builder.show();
    }

    private void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            Log.e("latitude", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.latitude);
            stringBuilder.append("");
            Log.e("latitude1", stringBuilder.toString());
            this.fusedLocationClient.getLastLocation().addOnSuccessListener((Activity) this, new C08996());
            return;
        }
        getLocationPermission();
    }

    private void setAddress(double d, double d2) {
        try {
            d = new Geocoder(getApplicationContext(), Locale.getDefault()).getFromLocation(d, d2, 1);
            if (d.isEmpty()) {
                this.address.setText("Waiting for Location");
            } else if (d.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((Address) d.get(0)).getFeatureName());
                stringBuilder.append(", ");
                stringBuilder.append(((Address) d.get(0)).getLocality());
                stringBuilder.append(", ");
                stringBuilder.append(((Address) d.get(0)).getAdminArea());
                stringBuilder.append(", ");
                stringBuilder.append(((Address) d.get(0)).getCountryName());
                this.nameLocation = stringBuilder.toString();
                TextView textView = this.address;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(((Address) d.get(0)).getFeatureName());
                stringBuilder2.append(", ");
                stringBuilder2.append(((Address) d.get(0)).getLocality());
                stringBuilder2.append(", ");
                stringBuilder2.append(((Address) d.get(0)).getAdminArea());
                stringBuilder2.append(", ");
                stringBuilder2.append(((Address) d.get(0)).getCountryName());
                textView.setText(stringBuilder2.toString());
            }
        } catch (double d3) {
            d3.printStackTrace();
        }
    }

    public void onMapClick(LatLng latLng) {
        this.mMap.clear();
        this.latitude = latLng.latitude;
        this.longitude = latLng.longitude;
        moveMap(this.latitude, this.longitude);
    }
}
