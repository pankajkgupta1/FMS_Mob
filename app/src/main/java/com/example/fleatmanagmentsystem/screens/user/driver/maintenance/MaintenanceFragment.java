package com.example.fleatmanagmentsystem.screens.user.driver.maintenance;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentMaintenanceBinding;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.ExpensesHistoryActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.ExpensesHistoryAdapter;
import com.example.fleatmanagmentsystem.viewmodel.maintenances.MaintenancesViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MaintenanceFragment extends BaseFragment<FragmentMaintenanceBinding,MaintenancesViewModel> implements AdapterMaintenance.AdapterMaintenanceClickLisner{

    FragmentMaintenanceBinding binding;
    MaintenancesViewModel maintenancesViewModel;
    public static ArrayList<String> workId = new ArrayList<>();
    public static ArrayList<String> vehicleId = new ArrayList<>();
    AdapterMaintenance adapterMaintenance;
    MaintenanceResponseModule maintenanceResponseModuleData = new MaintenanceResponseModule();

    public MaintenanceFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<MaintenancesViewModel> getViewModel() {
        return MaintenancesViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_maintenance;
    }

    @Override
    protected void onCreateView(Bundle instance, MaintenancesViewModel viewModel, FragmentMaintenanceBinding binding, Context context) {
        this.binding = binding;
        this.maintenancesViewModel = viewModel;

        maintenancesViewModel.getMaintenanceAssignedServices(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

        initView();
    }

    @SuppressLint("FragmentLiveDataObserve")
    private void initView() {
        maintenancesViewModel.getMaintenanceAssServ().observe(this, maintenanceResponseModule -> {
            if(maintenanceResponseModule != null){
                if(maintenanceResponseModule.getData() != null){
                    maintenanceResponseModuleData = maintenanceResponseModule;
                    workId.add("Select");
                    vehicleId.add("Select");
                    //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                    for (int i = 0; i < maintenanceResponseModule.getData().getMaintanenceWorkOrders().size(); i++) {
                        workId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getWorkOrderId());
                        vehicleId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getVehicleId());
                    }

                    adapterMaintenance = new AdapterMaintenance(getContext(),MaintenanceFragment.this ,maintenanceResponseModuleData);
                    binding.recyclerMaintenance.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerMaintenance.setAdapter(adapterMaintenance);
                    adapterMaintenance.notifyDataSetChanged();

                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    @Override
    public void onItemClickLisner(int position) {

        binding.depoId.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getDepotName().toString());
        binding.location.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getDepotAddress().toString());
        binding.vehicleId.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getVehicleId());
        binding.responsiblePerson.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getEmployeeName());
        binding.scheduledDateTime.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getScheduleDateTime());
    }
}