package com.example.fleatmanagmentsystem.screens.user.driver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.ActivityDriverfeaturesBinding;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.AdvanceExpensesFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.maintenance.MaintenanceClosureFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.maintenance.MaintenanceFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentExecutionFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.trips.DriverTripFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.vehicle.VehicleTakeoverHandoverFragment;

public class DriverFeaturesActivity extends AppCompatActivity {

    String from,type="";
    ActivityDriverfeaturesBinding binding;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_driverfeatures);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_driverfeatures);

        if(getIntent() != null){
            from = getIntent().getStringExtra("from");
            type = getIntent().getStringExtra("type");
        }

        if(from.equals("trip")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.driver_trip));
            DriverTripFragment driverTripFragment = new DriverTripFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, driverTripFragment).commit();
        }else if(from.equals("advanceExpenses")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.advance_and_expenses));
            AdvanceExpensesFragment advanceExpensesFragment = new AdvanceExpensesFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, advanceExpensesFragment).commit();
        }else if(from.equals("shipment")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.shipment_execution));
            ShipmentExecutionFragment shipmentExecutionFragment = new ShipmentExecutionFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, shipmentExecutionFragment).commit();
        }else if(from.equals("maintenance")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.maintenance));
            MaintenanceFragment maintenanceFragment = new MaintenanceFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, maintenanceFragment).commit();
        }else if(from.equals("takeover")){
            Bundle bundle = new Bundle();
            bundle.putString("type", type);

            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.takeover));
            VehicleTakeoverHandoverFragment vehicleTakeoverFragment = new VehicleTakeoverHandoverFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            vehicleTakeoverFragment.setArguments(bundle);
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, vehicleTakeoverFragment).commit();
        }else if(from.equals("handover")){
            Bundle bundle = new Bundle();
            bundle.putString("type", type);

            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.handover));
            VehicleTakeoverHandoverFragment vehicleHandoverFragment = new VehicleTakeoverHandoverFragment();
            vehicleHandoverFragment.setArguments(bundle);
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, vehicleHandoverFragment).commit();
        }else if(from.equals("maintenanceClosure")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.maintenance_closure));
            MaintenanceClosureFragment maintenanceClosureFragment = new MaintenanceClosureFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, maintenanceClosureFragment).commit();
        }else if(from.equals("lrpod")){
            binding.titleBar.textViewBarTitle.setText(getResources().getString(R.string.lr_pod));
            VehicleTakeoverHandoverFragment vehicleHandoverFragment = new VehicleTakeoverHandoverFragment();
            FragmentManager firstFragmentManager = getSupportFragmentManager();
            FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
            firstFragmentTransaction.replace(R.id.loadFragmentLayout, vehicleHandoverFragment).commit();
        }
    }
}