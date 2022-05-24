package com.example.fleatmanagmentsystem.screens.user.lrpod;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentLrpodDriverBinding;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.viewmodel.lrpod.LrPodViewModel;

import java.util.ArrayList;

public class LrpodDriverFragment extends BaseFragment<FragmentLrpodDriverBinding, LrPodViewModel> {

    FragmentLrpodDriverBinding binding;
    LrPodViewModel lrPodViewModel;
    public ArrayList<String> lrpodTripIdList = new ArrayList<>();
    public ArrayAdapter<String> lrpodTripTypeList ;
    public ArrayList<String> loadIdListShipment = new ArrayList<>();
    ShipmentLoadedResponseModule shipmentLoadedResponseModuleData = new ShipmentLoadedResponseModule();

    String tripId;
    private int position;
    private ArrayAdapter<String> loadTypeList;

    public LrpodDriverFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<LrPodViewModel> getViewModel() {
        return LrPodViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_lrpod_driver;
    }

    @Override
    protected void onCreateView(Bundle instance, LrPodViewModel viewModel, FragmentLrpodDriverBinding binding, Context context) {

        this.binding = binding;
        this.lrPodViewModel = viewModel;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        lrPodViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

        binding.signature.setOnClickListener(view -> {

        });

        binding.clear.setOnClickListener(view -> {
            binding.signature.clearCanvas();
        });

        binding.spinnerTripsIds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    tripId = binding.spinnerTripsIds.getSelectedItem().toString();
                    //shipmentExceptionViewModel.getAdvanceExpenses(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken);
                    lrPodViewModel.getShipmentExceptionLoadId(tripId, LoginActivity.accessToken, LoginActivity.tenantId);
                    //shipmentExceptionViewModel.getShipmentExceptionStartDetails(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken);
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

        lrPodViewModel.getDriverTripId().observe(this, driverTripIdListResponseModule -> {
            if (driverTripIdListResponseModule != null) {
                lrpodTripIdList.clear();
                lrpodTripIdList.add("Select");
                //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                for (int i = 0; i < driverTripIdListResponseModule.getData().getConfirmationList().size(); i++) {
                    lrpodTripIdList.add(driverTripIdListResponseModule.getData().getConfirmationList().get(i).getTripId());
                    //position = i;
                }
                selectTrip(lrpodTripIdList);
            }
        });

        lrPodViewModel.getLoadId().observe(this, shipmentLoadedResponseModule -> {
            if(shipmentLoadedResponseModule != null){
                if(shipmentLoadedResponseModule.getData() != null){
                    shipmentLoadedResponseModuleData = shipmentLoadedResponseModule;
                    loadIdListShipment.clear();
                    loadIdListShipment.add("Selected");
                    for(int i=0 ; i<shipmentLoadedResponseModule.getData().getTrip().getLoadSequenceHelper().size();i++){
                        loadIdListShipment.add(shipmentLoadedResponseModule.getData().getTrip().getLoadSequenceHelper().get(i).getLoadId());
                        position = i;
                    }
                    selectLoadId(loadIdListShipment);
                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    private void selectTrip(ArrayList<String> lrpodTripIdList) {

        lrpodTripTypeList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, lrpodTripIdList) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        binding.spinnerTripsIds.setAdapter(lrpodTripTypeList);
    }

    private void selectLoadId(ArrayList<String> loadIdListShipment) {

        loadTypeList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, loadIdListShipment) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        binding.spinnerTripsLoads.setAdapter(loadTypeList);
    }


}