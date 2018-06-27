package com.zcmx.bit.testbit.ui.fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.zcmx.bit.testbit.R;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MapFragment extends BaseFragment implements GoogleMap.OnMyLocationButtonClickListener, OnMapReadyCallback {

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    private static final float DEFAULT_ZOOM = 14;

    private GoogleMap mMap;

    private Marker myPosition;

    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        MapFragmentPermissionsDispatcher.myLocationListenersWithPermissionCheck(this);

        mMap.setOnMapLoadedCallback(() -> MapFragmentPermissionsDispatcher.getLastLocationWithPermissionCheck(MapFragment.this));
        mMap.setOnCameraMoveCanceledListener(() -> MapFragmentPermissionsDispatcher.getLastLocationWithPermissionCheck(MapFragment.this));

    }

    @Override
    public boolean onMyLocationButtonClick() {
        statusCheck();
        MapFragmentPermissionsDispatcher.getLastLocationWithPermissionCheck(this);
        return true;
    }

    @NeedsPermission(value = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})
    void myLocationListeners() {
        mMap.setMyLocationEnabled(true);
    }

    @NeedsPermission(value = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})
    void getLastLocation() {
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        if (myPosition != null) {
                            myPosition.remove();
                        }

                        LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        myPosition = mMap.addMarker(new MarkerOptions().position(myLocation)
                                .title("lat = " + myLocation.latitude + " lon = " + myLocation.longitude));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, DEFAULT_ZOOM));
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        statusCheck();

        MapFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.gps_disable_notification)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, (dialog, id) -> startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)))
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.cancel());
        final AlertDialog alert = builder.create();
        alert.show();
    }
}
