package com.example.fleatmanagmentsystem.screens.user.driver.trips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseActivity;
import com.example.fleatmanagmentsystem.databinding.ActivityTripDetailsBinding;
import com.example.fleatmanagmentsystem.map.FetchURL;
import com.example.fleatmanagmentsystem.map.TaskLoadedCallback;
import com.example.fleatmanagmentsystem.models.login.tripdetail.LoadInfo;
import com.example.fleatmanagmentsystem.models.login.tripdetail.TripDetailResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.viewmodel.tripdetails.TripDetailsViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

public class TripDetailsActivity extends BaseActivity<ActivityTripDetailsBinding, TripDetailsViewModel> implements OnMapReadyCallback, TaskLoadedCallback {

    ActivityTripDetailsBinding binding;

    private int position;
    Location currentLocation;
    MarkerOptions markerOptions,markerOptions1;
    private GoogleMap mMap;
    private Polyline currentPolyline;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    private TripDetailResponseModule tripDetailResponseModule;

    private TripsDetailsAdapter tripsDetailsAdapter;
    private TripDetailsViewModel tripDetailsViewModel;

    public static String tripId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Class<TripDetailsViewModel> getViewModel() {
        return TripDetailsViewModel.class;
    }

    @Override
    protected void onCreate(Bundle instance, TripDetailsViewModel viewModel, ActivityTripDetailsBinding binding) {

        this.binding = binding;
        this.tripDetailsViewModel = viewModel;

        binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.trip_details));

        if(getIntent() != null){
            tripDetailResponseModule = getIntent().getParcelableExtra("tripDetailResponseModule");
            position = getIntent().getIntExtra("position",0);
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();

        String lodeId="",s2="",s3="",s4="",s5="";
        List<LoadInfo> loadInfoList = tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo();

        binding.tripId.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getTripId());
        tripId = tripDetailResponseModule.getData().getTripInfoList().get(position).getTripId();

        for (LoadInfo l : loadInfoList){
            lodeId = l.getLoadId();
            s2 = l.getSourceLocation();
            s3 = l.getDestinationLocation();
            s4 = l.getShipperPickupDateAndTime();
            s5 = l.getCustomerDeliveryDateAndTime();
        }


        binding.vehicleId.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getVehicleId());
        binding.vehicleName.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getVehicleName());
        binding.vehicleRegNo.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getVehicleRegNo());
        //binding.vehicleCoDriver.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getC());
        binding.loadId.setText(lodeId);


        tripsDetailsAdapter = new TripsDetailsAdapter(this, tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo());
        binding.loadDetailsRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.loadDetailsRecycler.setAdapter(tripsDetailsAdapter);
        tripsDetailsAdapter.notifyDataSetChanged();

        binding.rejectTrip.setOnClickListener(view -> {
            confirmTrip("Rejected");
        });


        binding.acceptTrip.setOnClickListener(v -> {

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.accept_trip_popup, null);
            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.setView(dialogView);

            TextView tripYes = (TextView) dialogView.findViewById(R.id.tripYes);
            TextView tripNo = (TextView) dialogView.findViewById(R.id.tripNo);

            alertDialog.show();

            tripYes.setOnClickListener(v1 -> {
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show();
                confirmTrip("Accepted");
                alertDialog.dismiss();

            });

            tripNo.setOnClickListener(v1 -> {
                alertDialog.dismiss();
                confirmTrip("Rejected");
            });

        });

        binding.back.setOnClickListener(view -> {
            finish();
        });

        initModule();
    }

    private void initModule() {
        tripDetailsViewModel.getTripStatusActorRej().observe(this,tripStatusResponseModule -> {
            if(tripStatusResponseModule != null){
                if(tripStatusResponseModule.getStatus().equals("0")){
                    showToast(tripStatusResponseModule.getStatusMsg());
                    finish();
                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_trip_details;
    }

    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.myMap);
                    mapFragment.getMapAsync(TripDetailsActivity.this);

                    //assert supportMapFragment != null;
                    //mapFragment.getMapAsync((OnMapReadyCallback) TripDetailsActivity.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //LatLng latLng = new LatLng(branchLocationData.get(position).getLatitude()/*currentLocation.getLatitude()*/, branchLocationData.get(position).getLongitude()/*currentLocation.getLongitude()*/);
        Double src1Lat = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getSourceLocationLatitude());
        Double src1Lon = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getSourceLocationLongitude());
        String srcName = tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getSourceLocation();

        Double des1Lat = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getDestinationLocationLatitude());
        Double des1Lon = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getDestinationLocationLongitude());
        String desName = tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(0).getDestinationLocation();

        LatLng latLng1 = new LatLng(src1Lat, src1Lon);
        markerOptions = new MarkerOptions().position(latLng1).title(srcName);
        LatLng latLng2 = new LatLng(des1Lat, des1Lon);
        markerOptions1 = new MarkerOptions().position(latLng2).title(desName);

        //LatLngBounds latLngBounds = new LatLngBounds(latLng1,latLng2);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng1);
        builder.include(latLng2);
        LatLngBounds bounds = builder.build();
        int padding = 50; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.moveCamera(cu);

        //if(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(position).getWaypointsInfo().get(0) == null){

        //}else{
            /*Double way1Lat = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(position).getWaypointsInfo().get(position).getWaypointLatitude());
            Double way1Lon = Double.valueOf(tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(position).getWaypointsInfo().get(position).getWaypointLongitude());
            String wayName = tripDetailResponseModule.getData().getTripInfoList().get(position).getItineraryDirections().get(position).getWaypointsInfo().get(position).getWaypointLocationState();

            LatLng latLng3 = new LatLng(way1Lat, way1Lon);
            markerOptions2 = new MarkerOptions().position(latLng3).title(wayName);*/

        //}
        //new MarkerOptions().position(new LatLng(27.667491, 85.3208583)).title("Location 2");
        //MarkerOptions markerOptions1 = new MarkerOptions().position(latLng1).title("I am here!");

        //googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng1));
        //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 5));

        /*googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng2));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 5));*/
        googleMap.addMarker(markerOptions);
        googleMap.addMarker(markerOptions1);
        //googleMap.addMarker(markerOptions2);
        new FetchURL(TripDetailsActivity.this).execute(getUrl(markerOptions.getPosition(), markerOptions1.getPosition(), "driving"), "driving");
        //googleMap.addMarker(markerOptions1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }

    private void confirmTrip(String status){
        String role = LoginActivity.role.get(0);
        //String role = LoginActivity.role;
        tripDetailsViewModel.getTripAcceptOrReject(role,tripDetailResponseModule.getData().getTripInfoList().get(position).getTripId(),status,
                tripDetailResponseModule.getData().getTripInfoList().get(position).getOrganizationIdName(),
                LoginActivity.accessToken, LoginActivity.tenantId);
    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + "AIzaSyANxMD9ZdyllJZazLNW0-KnNo5Fkiq6ZTs"/*getString(R.string.map_key)*/;
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }
}