package com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentShipmentLoadingBinding;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecution.ShipmentExecutionResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.LoadSequenceHelper;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetail;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetailsDocumentsInfo;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.viewmodel.shipmentexception.ShipmentExceptionViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ShipmentLoadingFragment extends BaseFragment<FragmentShipmentLoadingBinding, ShipmentExceptionViewModel> {

    FragmentShipmentLoadingBinding binding;
    ShipmentExceptionViewModel shipmentExceptionViewModel;
    private ArrayAdapter<String> tripTypeList;
    private ArrayAdapter<String> loadTypeList;
    public ArrayList<String> tripIdListShipment = new ArrayList<>();
    public ArrayList<String> loadIdListShipment = new ArrayList<>();
    public LoadSequenceHelper loadSequenceHelper = new LoadSequenceHelper();
    public ShipmentDetail shipmentDetail = new ShipmentDetail();

    private ShipmentDetailsDocumentsInfo shipmentDetailsDocumentsInfo = new ShipmentDetailsDocumentsInfo();

    ShipmentLoadedResponseModule shipmentLoadedResponseModuleData = new ShipmentLoadedResponseModule();
    private ShipmentExecutionResponseModule shipmentExecutionResponseModuleData = new ShipmentExecutionResponseModule();
    private ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule = new ShipmentExecutionUpdateRequestModule();
    AdvanceExpensesResponseModule advanceExpensesResponseModuleData = new AdvanceExpensesResponseModule();
    String tripId = "";
    public static int position ;
    String dateTime;

    String atGate=null,loadingEnd=null,placeLoading=null,documentRecived=null,loadingStart=null,gateout=null;
    int kmGateout1;

    boolean atGateBol=false,loadingEndBol=false,placeLoadingBol=false,documentRecivedBol=false,loadingStartBol=false,gateoutBol=false,kmGateout1Bol=false;

    Double kmUnloading;//1
    String unloadingEnd=null;//2
    Double kmGateout;//3
    String unloadingGate=null;//4
    String dopReceived=null;//5
    String settlement=null;//6
    String unloadingStarts=null;//7
    String unloadingGateOut=null;

    DriverTripIdListResponseModule driverTripIdListResponseModuleData = new DriverTripIdListResponseModule();

    public ShipmentLoadingFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<ShipmentExceptionViewModel> getViewModel() {
        return ShipmentExceptionViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shipment_loading;
    }

    @Override
    protected void onCreateView(Bundle instance, ShipmentExceptionViewModel viewModel, FragmentShipmentLoadingBinding binding, Context context) {
        this.binding = binding;
        this.shipmentExceptionViewModel = viewModel;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        shipmentExceptionViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

        binding.atGate.setOnClickListener(v ->{
            popup("atGate");
        });

        binding.loadingEnd.setOnClickListener(v ->{
            popup("loadingEnd");
        });

        binding.kmGateout.setOnClickListener(v ->{
            popup("kmGateout");
        });

        binding.placeLoading.setOnClickListener(v ->{
            popup("placeLoading");
        });

        binding.atDocument.setOnClickListener(v ->{
            popup("documentRecived");
        });

        binding.loadingStart.setOnClickListener(v ->{
            popup("loadingStart");
        });

        binding.gateout.setOnClickListener(v ->{
            popup("gateout");
        });

        binding.takeover.setOnClickListener(v -> {

        });



        binding.spinnerTripsIds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    tripId = binding.spinnerTripsIds.getSelectedItem().toString();
                    shipmentExceptionViewModel.getAdvanceExpenses(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken, LoginActivity.tenantId);
                    shipmentExceptionViewModel.getShipmentExceptionLoadId(tripId, LoginActivity.accessToken, LoginActivity.tenantId);
                    //shipmentExceptionViewModel.getShipmentExceptionStartDetails(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.spinnerTripsLoads.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    tripId = binding.spinnerTripsIds.getSelectedItem().toString();
                    //shipmentExceptionViewModel.getShipmentExceptionLoadId(tripId, LoginActivity.accessToken);
                    shipmentExceptionViewModel.getShipmentExceptionStartDetails(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken, LoginActivity.tenantId);
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

        shipmentExceptionViewModel.getDriverTripId().observe(this, driverTripIdListResponseModule -> {
            if (driverTripIdListResponseModule != null) {
                tripIdListShipment.clear();
                tripIdListShipment.add("Select");
                //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                for (int i = 0; i < driverTripIdListResponseModule.getData().getConfirmationList().size(); i++) {
                    tripIdListShipment.add(driverTripIdListResponseModule.getData().getConfirmationList().get(i).getTripId());
                    //position = i;
                }
                selectTrip(tripIdListShipment);
            }
        });

        shipmentExceptionViewModel.getLoadId().observe(this, shipmentLoadedResponseModule -> {
            if(shipmentLoadedResponseModule != null){
                if(shipmentLoadedResponseModule.getData() != null){
                    shipmentLoadedResponseModuleData = shipmentLoadedResponseModule;
                    loadIdListShipment.clear();
                    loadIdListShipment.add("Select");
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

        shipmentExceptionViewModel.getAdvanceExpensesStartData().observe(this, advanceExpensesResponseModule -> {
            if(advanceExpensesResponseModule != null){
                if(advanceExpensesResponseModule.getData() != null){
                    advanceExpensesResponseModuleData = advanceExpensesResponseModule;
                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getShipmentExceptionStartData().observe(this, shipmentExecutionResponseModule -> {
            if(shipmentExecutionResponseModule != null){
                if(shipmentExecutionResponseModule.getData() != null){
                    if(shipmentExecutionResponseModule.getData().getShipmentExecution() != null){



                        for(int i=0; i<shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().size();i++){
                            //shipmentDetailList.add(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate());
                            if(binding.spinnerTripsLoads.getSelectedItem().toString().equals(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadSequenceHelper().getLoadId())){

                                atGate = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate();
                                loadingEnd = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingEndedTime();
                                kmGateout1 = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromLoading();
                                placeLoading = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading();
                                documentRecived = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime();
                                loadingStart = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime();
                                gateout = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();

                                kmUnloading = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsAtThePointOfUnloading();
                                unloadingEnd = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingEndedTime();
                                Double km = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromUnloading();
                                kmGateout = km;
                                //kmGateout = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromUnloading();
                                unloadingGate = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading();
                                dopReceived = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime();
                                settlement = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime();
                                unloadingStarts = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();
                                unloadingGateOut = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate() != null){
                                    atGateBol = true;
                                    binding.atGate.setEnabled(false);
                                    binding.atGate.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.atGate.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading() != null){
                                    placeLoadingBol = true;
                                    binding.placeLoading.setEnabled(false);
                                    binding.placeLoading.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.placeLoading.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingEndedTime() != null){
                                    loadingEndBol = true;
                                    binding.loadingEnd.setEnabled(false);
                                    binding.loadingEnd.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.loadingEnd.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromLoading() > 0){
                                    kmGateout1Bol = true;
                                    binding.kmGateout.setEnabled(false);
                                    binding.kmGateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.kmGateout.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime() != null){
                                    documentRecivedBol = true;
                                    binding.atDocument.setEnabled(false);
                                    binding.atDocument.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.atDocument.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime() != null){
                                    loadingStartBol = true;
                                    binding.loadingStart.setEnabled(false);
                                    binding.loadingStart.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.loadingStart.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut() != null){
                                    gateoutBol = true;
                                    binding.gateout.setEnabled(false);
                                    binding.gateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.gateout.setTextColor(getResources().getColor(R.color.white));
                                }
                            }
                        }

                        /*if(atGateBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(loadingEndBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(true);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(kmGateout1Bol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(true);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(placeLoadingBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(true);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(documentRecivedBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(true);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(loadingStartBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(true);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }

                        if(gateoutBol){
                            binding.atGate.setEnabled(false);
                            binding.loadingEnd.setEnabled(false);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }else {
                            binding.atGate.setEnabled(true);
                            binding.loadingEnd.setEnabled(true);
                            binding.kmGateout.setEnabled(false);
                            binding.placeLoading.setEnabled(false);
                            binding.atDocument.setEnabled(false);
                            binding.loadingStart.setEnabled(false);
                            binding.gateout.setEnabled(false);
                        }*/

                    }else{

                    }

                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getShipmentExecutionUpdateSavaData().observe(this,shipmentExecutionUpdateResponseModule -> {
            if (shipmentExecutionUpdateResponseModule != null) {
                if(shipmentExecutionUpdateResponseModule.getData() != null){

                    showToast(shipmentExecutionUpdateResponseModule.getStatusMsg());

                    /*atGate = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getTimeOfPlacementAtGate();*/
                    loadingEnd = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getLoadingEndedTime();
                    /*kmGateout1 = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsOfGateOutFromLoading();
                    placeLoading = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getPlacedTimeForLoading();
                    documentRecived = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getDocumentsReceivedTime();*/
                    loadingStart = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getLoadingStartedTime();
                    /*gateout = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getTimeOfGateOut();*/

                    for(int i=0; i<shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().size();i++){
                        //shipmentDetailList.add(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate());
                        if(binding.spinnerTripsLoads.getSelectedItem().toString().equals(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadSequenceHelper().getLoadId())){
                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate() != null){
                                atGateBol = true;
                                binding.atGate.setEnabled(false);
                                binding.atGate.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.atGate.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading() != null){
                                placeLoadingBol = true;
                                binding.placeLoading.setEnabled(false);
                                binding.placeLoading.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.placeLoading.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingEndedTime() != null){
                                placeLoadingBol = true;
                                binding.loadingEnd.setEnabled(false);
                                binding.loadingEnd.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.loadingEnd.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromLoading() > 0){
                                kmGateout1Bol = true;
                                binding.kmGateout.setEnabled(false);
                                binding.kmGateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.kmGateout.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime() != null){
                                documentRecivedBol = true;
                                binding.atDocument.setEnabled(false);
                                binding.atDocument.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.atDocument.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime() != null){
                                loadingStartBol = true;
                                binding.loadingStart.setEnabled(false);
                                binding.loadingStart.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.loadingStart.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut() != null){
                                gateoutBol = true;
                                binding.gateout.setEnabled(false);
                                binding.gateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.gateout.setTextColor(getResources().getColor(R.color.white));
                            }
                        }
                    }

                   /* if(atGateBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(loadingEndBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(true);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(kmGateout1Bol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(true);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(placeLoadingBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(true);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(documentRecivedBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(true);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(loadingStartBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(true);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }
                    if(gateoutBol){
                        binding.atGate.setEnabled(false);
                        binding.loadingEnd.setEnabled(false);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }else {
                        binding.atGate.setEnabled(true);
                        binding.loadingEnd.setEnabled(true);
                        binding.kmGateout.setEnabled(false);
                        binding.placeLoading.setEnabled(false);
                        binding.atDocument.setEnabled(false);
                        binding.loadingStart.setEnabled(false);
                        binding.gateout.setEnabled(false);
                    }*/


                }else{
                    getResources().getString(R.string.no_data);
                }

            }else {
                getResources().getString(R.string.something_wrong);
            }
        });
    }

    private void selectTrip(ArrayList<String> tripIdListShipment) {

        tripTypeList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, tripIdListShipment) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                return v;
            }
        };
        binding.spinnerTripsIds.setAdapter(tripTypeList);
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

    private void popup(String type) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.accept_trip_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;

        TextView acceptTrip = (TextView) dialogView.findViewById(R.id.accept_trip);
        TextView tripYes = (TextView) dialogView.findViewById(R.id.tripYes);
        TextView tripNo = (TextView) dialogView.findViewById(R.id.tripNo);
        EditText kilometerGate = (EditText) dialogView.findViewById(R.id.kilometerGate);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        if(type.equals("kmGateout")){
            kilometerGate.setVisibility(View.VISIBLE);
        }else {
            kilometerGate.setVisibility(View.GONE);
        }

        alertDialog.show();

        //acceptTrip.setText(R.string.placed_gate);

        tripYes.setOnClickListener(v1 -> {
            alertDialog.dismiss();
            dateAndTime();
            Toast.makeText(getContext(), "Yes", Toast.LENGTH_SHORT).show();

            //LoadSequenceHelper loadSequenceHelpers = new LoadSequenceHelper();
            ArrayList<ShipmentDetail> shipmentDetails = new ArrayList<>();
            ArrayList<ShipmentDetailsDocumentsInfo> shipmentDetailsDocumentsInfos = new ArrayList<>();


            loadSequenceHelper.setLoadId(binding.spinnerTripsLoads.getSelectedItem().toString());
            loadSequenceHelper.setSourceLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getSourceLocation());
            loadSequenceHelper.setDestinationLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getDestinationLocation());
            loadSequenceHelper.setShipperPickupDateAndTime(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getShipperPickupDateAndTime());
            loadSequenceHelper.setCustomerDeliveryDateAndTime(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getCustomerDeliveryDateAndTime());
            loadSequenceHelper.setTripSequence(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getTripSequence());
            loadSequenceHelper.setPurchaseOrderId(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getPurchaseOrderId());
            loadSequenceHelper.setDistance(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getDistance());
            loadSequenceHelper.setInvoiceStatus(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getInvoiceStatus());

            shipmentDetail.setLoadSequenceHelper(loadSequenceHelper);



            //shipmentDetail.setStops(shipmentExecutionResponseModuleData.getData().getShipmentExecution().getShipmentDetails().get(position).getStops());

            //shipmentDetail.setStops(advanceExpensesResponseModuleData.getData().getTrip().getTripSequenceNumber());
            shipmentDetail.setStops(shipmentLoadedResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getTripSequence());
            shipmentDetail.setCurrentDateAndTime(dateTime);
            shipmentDetail.setVehicleId(advanceExpensesResponseModuleData.getData().getTrip().getVehicleId());
            shipmentDetail.setEquipmentId(advanceExpensesResponseModuleData.getData().getTrip().getEquipmentId());
            shipmentDetail.setDriverId(DriverDetailsActivity.DriverId);
            shipmentDetail.setCleanerId(advanceExpensesResponseModuleData.getData().getTrip().getCleanerId());
            shipmentDetail.setSourceLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getSourceLocation());
            shipmentDetail.setDestinationLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(position).getDestinationLocation());


            if(type.equals("atGate")){
                acceptTrip.setText(R.string.placed_gate);
            }else if (type.equals("loadingEnd")){
                acceptTrip.setText(R.string.loading_end);
            }if(type.equals("kmGateout")){
                acceptTrip.setText(R.string.km_gate_out);
            }else if(type.equals("placeLoading")){
                acceptTrip.setText(R.string.place_loading);
            }else if(type.equals("documentRecived")){
                acceptTrip.setText(R.string.doc_received);
            }else if(type.equals("loadingStart")){
                acceptTrip.setText(R.string.loading_start_time);
            }else if(type.equals("gateout")){
                acceptTrip.setText(R.string.gate_out);
            }

            if(type.equals("atGate")){
                shipmentDetail.setTimeOfPlacementAtGate(dateTime);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            else if (type.equals("loadingEnd")){
                shipmentDetail.setLoadingEndedTime(dateTime);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            if(type.equals("kmGateout")){
                int km = Integer.parseInt(kilometerGate.getText().toString());
                shipmentDetail.setKmsOfGateOutFromLoading(km);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
            }/*else{
                shipmentDetail.setKmsOfGateOutFromLoading(null);
            }*/

            else if(type.equals("placeLoading")){
                shipmentDetail.setPlacedTimeForLoading(dateTime);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            else if(type.equals("documentRecived")){
                shipmentDetail.setDocumentsReceivedTime(dateTime);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            else if(type.equals("loadingStart")){
                shipmentDetail.setLoadingStartedTime(dateTime);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            else if(type.equals("gateout")){
                shipmentDetail.setTimeOfGateOut(dateTime);
                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);
            }/*else{
                shipmentDetail.setTimeOfGateOut(null);
                shipmentDetail.setTimeOfPlacementAtGate(null);
                shipmentDetail.setLoadingEndedTime(null);
                shipmentDetail.setPlacedTimeForLoading(null);
                shipmentDetail.setDocumentsReceivedTime(null);
                shipmentDetail.setLoadingStartedTime(null);
            }*/

            shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
            shipmentDetail.setUnloadingEndedTime(unloadingEnd);
            shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
            shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
            shipmentDetail.setPodReceivedTime(dopReceived);
            shipmentDetail.setTimeOfSettlement(settlement);
            shipmentDetail.setUnloadingStartedTime(unloadingStarts);
            shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);


            //shipmentDetail.setPodReceivedTime(null);
            //shipmentDetail.setTimeAtUnloadingDock(null);
            //shipmentDetail.setUnloadingTimeOfGateOut(null);
            //shipmentDetail.setUnloadingStartedTime(null);
            //shipmentDetail.setUnloadingEndedTime(null);
            //shipmentDetail.setKmsAtThePointOfUnloading(null);
            //shipmentDetail.setKmsOfGateOutFromUnloading(null);
            //shipmentDetail.setTimeOfSettlement(null);

            shipmentDetail.setTypeOfOperation(null);
            shipmentDetail.setTripStatus(null);
            shipmentDetail.setShipmentDetailsDocumentsInfo(new ArrayList<>());
            shipmentDetails.add(shipmentDetail);

            shipmentExecutionUpdateRequestModule.setCountry(LoginActivity.country);
            shipmentExecutionUpdateRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
            shipmentExecutionUpdateRequestModule.setTripId(tripId);
            shipmentExecutionUpdateRequestModule.setPhysicalDocumentsHandover(null);
            shipmentExecutionUpdateRequestModule.setOdoMeterEnd(null);
            shipmentExecutionUpdateRequestModule.setOdoMeterStart(null);
            shipmentExecutionUpdateRequestModule.setHandOver(null);
            shipmentExecutionUpdateRequestModule.setTakeOver(null);

            shipmentExecutionUpdateRequestModule.setShipmentDetails(shipmentDetails);


            shipmentExceptionViewModel.getShipmentExceptionUpdate(shipmentExecutionUpdateRequestModule,LoginActivity.accessToken,LoginActivity.tenantId );
        });

        tripNo.setOnClickListener(v1 -> {
            alertDialog.dismiss();
        });
    }

    private void dateAndTime() {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        String calDate = currentDay + "/" + (currentMonth + 1) + "/" + currentYear;


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = df.format(c);


        SimpleDateFormat spf=new SimpleDateFormat("dd/MM/yyyy");
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        Date newDate= null;
        try {
            newDate = spf.parse(calDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf= new SimpleDateFormat("MM");
        String month_no = spf.format(newDate);
        dateTime = String.valueOf(formattedDate+" "+ currentTime);
    }

}