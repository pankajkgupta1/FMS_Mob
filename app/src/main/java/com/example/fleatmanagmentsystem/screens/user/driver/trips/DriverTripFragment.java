package com.example.fleatmanagmentsystem.screens.user.driver.trips;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;


import androidx.recyclerview.widget.DefaultItemAnimator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentDriverTripBinding;
import com.example.fleatmanagmentsystem.models.login.tripdetail.TripDetailResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.viewmodel.tripdetails.TripDetailsViewModel;

public class DriverTripFragment extends BaseFragment<FragmentDriverTripBinding, TripDetailsViewModel> {

    FragmentDriverTripBinding binding;
    private ArrayAdapter<String> tripTypeList;
    private TripDetailsViewModel tripDetailsViewModel;

    DriverTripsAdapter driverTripsAdapter;

    TripDetailResponseModule tripDetailResponseModuleData = new TripDetailResponseModule();

    public DriverTripFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<TripDetailsViewModel> getViewModel() {
        return TripDetailsViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_driver_trip;
    }

    @Override
    protected void onCreateView(Bundle instance, TripDetailsViewModel viewModel, FragmentDriverTripBinding binding, Context context) {
        this.binding = binding;
        this.tripDetailsViewModel = viewModel;

        selectTrip();

        tripDetailsViewModel.getUserTripDetails("Assigned", LoginActivity.accessToken, LoginActivity.tenantId);

        binding.spinnerTripsType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    tripDetailsViewModel.getUserTripDetails("Assigned", LoginActivity.accessToken, LoginActivity.tenantId);
                }else if(position == 1){
                    tripDetailsViewModel.getUserTripDetails("Assigned", LoginActivity.accessToken, LoginActivity.tenantId);
                }else if(position == 2){
                    tripDetailsViewModel.getUserTripDetails("Accepted", LoginActivity.accessToken, LoginActivity.tenantId);
                }else if(position == 3){
                    tripDetailsViewModel.getUserTripDetails("Rejected", LoginActivity.accessToken, LoginActivity.tenantId);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initView();

    }

    @SuppressLint("FragmentLiveDataObserve")
    private void initView() {
        tripDetailsViewModel.getTripInfo().observe(this,tripDetailResponseModule -> {
            if(tripDetailResponseModule != null){
                if(tripDetailResponseModule.getData() != null){
                    tripDetailResponseModuleData = tripDetailResponseModule;

                    driverTripsAdapter = new DriverTripsAdapter(getContext(), tripDetailResponseModuleData);
                    binding.recyclerTripList.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerTripList.setAdapter(driverTripsAdapter);
                    driverTripsAdapter.notifyDataSetChanged();
                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    private void selectTrip() {
        String[] countryNames={"Select","Assigned","Accepted","Rejected"};

        tripTypeList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, countryNames) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,  parent);

                return v;
            }
        };
        binding.spinnerTripsType.setAdapter(tripTypeList);
    }
}