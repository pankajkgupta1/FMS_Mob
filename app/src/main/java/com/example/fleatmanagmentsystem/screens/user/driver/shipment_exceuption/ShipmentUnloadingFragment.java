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
import com.example.fleatmanagmentsystem.databinding.FragmentShipmentUnloadingBinding;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
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

public class ShipmentUnloadingFragment extends BaseFragment<FragmentShipmentUnloadingBinding, ShipmentExceptionViewModel> {

    FragmentShipmentUnloadingBinding binding;
    ShipmentExceptionViewModel shipmentExceptionViewModel;

    private ArrayAdapter<String> tripTypeList;
    private ArrayAdapter<String> loadTypeList;
    public ArrayList<String> tripIdListShipment = new ArrayList<>();
    public ArrayList<String> loadIdListShipment = new ArrayList<>();

    public ShipmentDetail shipmentDetail = new ShipmentDetail();
    public LoadSequenceHelper loadSequenceHelper = new LoadSequenceHelper();
    private ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule = new ShipmentExecutionUpdateRequestModule();
    ShipmentLoadedResponseModule shipmentLoadedResponseModuleData = new ShipmentLoadedResponseModule();
    AdvanceExpensesResponseModule advanceExpensesResponseModuleData = new AdvanceExpensesResponseModule();

    public static int position;

    String tripId = "";
    String dateTime;

    Double kmUnloading;//1
    String unloadingEnd=null;//2
    Double kmGateout;//3
    String unloadingGate=null;//4
    String dopReceived=null;//5
    String settlement=null;//6
    String unloadingStarts=null;//7
    String unloadingGateOut=null;

    String atGate=null,loadingEnd=null,placeLoading=null,documentRecived=null,loadingStart=null,gateout=null;
    int kmGateout1;

    public ShipmentUnloadingFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<ShipmentExceptionViewModel> getViewModel() {
        return ShipmentExceptionViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shipment_unloading;
    }

    @Override
    protected void onCreateView(Bundle instance, ShipmentExceptionViewModel viewModel, FragmentShipmentUnloadingBinding binding, Context context) {
        this.binding = binding;
        this.shipmentExceptionViewModel = viewModel;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        shipmentExceptionViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

        binding.kmUnloading.setOnClickListener(v ->{
            popup("kmUnloading");
        });

        binding.unloadingEnd.setOnClickListener(v ->{
            popup("unloadingEnd");
        });

        binding.kmGateout.setOnClickListener(v ->{
            popup("kmGateout");
        });

        binding.unloadingGate.setOnClickListener(v ->{
            popup("unloadingGate");
        });

        binding.dopReceived.setOnClickListener(v ->{
            popup("dopReceived");
        });

        binding.settlement.setOnClickListener(v ->{
            popup("settlement");
        });

        binding.unloadingStarts.setOnClickListener(v ->{
            popup("unloadingStarts");
        });

        binding.unloadingGateOut.setOnClickListener(v ->{
            popup("unloadingGateOut");
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

                                atGate = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate();
                                loadingEnd = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingEndedTime();
                                kmGateout1 = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromLoading();
                                placeLoading = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading();
                                documentRecived = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime();
                                loadingStart = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime();
                                gateout = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();


                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsAtThePointOfUnloading() != null){
                                    binding.kmUnloading.setEnabled(false);
                                    binding.kmUnloading.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.kmUnloading.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingEndedTime() != null){
                                    binding.unloadingEnd.setEnabled(false);
                                    binding.unloadingEnd.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.unloadingEnd.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromUnloading() != null){
                                    binding.kmGateout.setEnabled(false);
                                    binding.kmGateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.kmGateout.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeAtUnloadingDock() != null){
                                    binding.unloadingGate.setEnabled(false);
                                    binding.unloadingGate.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.unloadingGate.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPodReceivedTime() != null){
                                    binding.dopReceived.setEnabled(false);
                                    binding.dopReceived.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.dopReceived.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfSettlement() != null){
                                    binding.settlement.setEnabled(false);
                                    binding.settlement.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.settlement.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingStartedTime() != null){
                                    binding.unloadingStarts.setEnabled(false);
                                    binding.unloadingStarts.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.unloadingStarts.setTextColor(getResources().getColor(R.color.white));
                                }

                                if(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingTimeOfGateOut() != null){
                                    binding.unloadingGateOut.setEnabled(false);
                                    binding.unloadingGateOut.setBackground(getResources().getDrawable(R.color.dark_green));
                                    binding.unloadingGateOut.setTextColor(getResources().getColor(R.color.white));
                                }
                            }
                        }

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

                    /*kmUnloading = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsAtThePointOfUnloading();
                    unloadingEnd = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getUnloadingEndedTime();
                    Double km = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsOfGateOutFromUnloading();
                    kmGateout = km;
                    //kmGateout = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsOfGateOutFromUnloading();
                    unloadingGate = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getPlacedTimeForLoading();
                    dopReceived = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getDocumentsReceivedTime();
                    settlement = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getLoadingStartedTime();
                    unloadingStarts = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getTimeOfGateOut();
                    unloadingGateOut = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getTimeOfGateOut();*/

                    for(int i=0; i<shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().size();i++){
                        //shipmentDetailList.add(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate());
                        if(binding.spinnerTripsLoads.getSelectedItem().toString().equals(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadSequenceHelper().getLoadId())){

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsAtThePointOfUnloading() != null){
                                binding.kmUnloading.setEnabled(false);
                                binding.kmUnloading.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.kmUnloading.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingEndedTime() != null){
                                binding.unloadingEnd.setEnabled(false);
                                binding.unloadingEnd.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.unloadingEnd.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getKmsOfGateOutFromUnloading() != null){
                                binding.kmGateout.setEnabled(false);
                                binding.kmGateout.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.kmGateout.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeAtUnloadingDock() != null){
                                binding.unloadingGate.setEnabled(false);
                                binding.unloadingGate.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.unloadingGate.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPodReceivedTime() != null){
                                binding.dopReceived.setEnabled(false);
                                binding.dopReceived.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.dopReceived.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfSettlement() != null){
                                binding.settlement.setEnabled(false);
                                binding.settlement.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.settlement.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingStartedTime() != null){
                                binding.unloadingStarts.setEnabled(false);
                                binding.unloadingStarts.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.unloadingStarts.setTextColor(getResources().getColor(R.color.white));
                            }

                            if(shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getUnloadingTimeOfGateOut() != null){
                                binding.unloadingGateOut.setEnabled(false);
                                binding.unloadingGateOut.setBackground(getResources().getDrawable(R.color.dark_green));
                                binding.unloadingGateOut.setTextColor(getResources().getColor(R.color.white));
                            }
                        }
                    }


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
        EditText kilometerGate =  dialogView.findViewById(R.id.kilometerGate);
        EditText kilometerUnload =  dialogView.findViewById(R.id.kilometerUnload);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);

        alertDialog.show();

        if(type.equals("kmGateout")){
            kilometerGate.setVisibility(View.VISIBLE);
        }else {
            kilometerGate.setVisibility(View.GONE);
        }

        if(type.equals("kmUnloading")){
            kilometerGate.setVisibility(View.VISIBLE);
        }else{
            kilometerGate.setVisibility(View.GONE);
        }

        //acceptTrip.setText(R.string.placed_gate);

        tripYes.setOnClickListener(v1 -> {
            alertDialog.dismiss();
            dateAndTime();
            Toast.makeText(getContext(), "Yes", Toast.LENGTH_SHORT).show();

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

            if(type.equals("kmUnloading")){
                acceptTrip.setText(R.string.km_unloading);
                String unload = kilometerUnload.getText().toString();
                Double kmUnload = Double.valueOf(unload);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnload);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if (type.equals("unloadingEnd")){
                acceptTrip.setText(R.string.unloading_end);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(dateTime);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("kmGateout")){
                acceptTrip.setText(R.string.km_gate_out);
                Double km = Double.valueOf(kilometerGate.getText().toString());
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(km);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("unloadingGate")){
                acceptTrip.setText(R.string.unloading_gate);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(dateTime);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("dopReceived")){
                acceptTrip.setText(R.string.pod_received);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dateTime);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("settlement")){
                acceptTrip.setText(R.string.settlement_time);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(dateTime);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("unloadingStarts")){
                acceptTrip.setText(R.string.unloading_start);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(dateTime);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);
            }

            else if(type.equals("unloadingGateOut")){
                acceptTrip.setText(R.string.unloading_gate);
                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(dateTime);
            }


            shipmentDetail.setTimeOfPlacementAtGate(atGate);
            shipmentDetail.setLoadingEndedTime(loadingEnd);
            shipmentDetail.setPlacedTimeForLoading(placeLoading);
            shipmentDetail.setDocumentsReceivedTime(documentRecived);
            shipmentDetail.setLoadingStartedTime(loadingStart);
            shipmentDetail.setTimeOfGateOut(gateout);
            shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);


            //shipmentDetail.setTimeOfPlacementAtGate(null);
            //shipmentDetail.setLoadingEndedTime(null);
            //shipmentDetail.setPlacedTimeForLoading(null);
            //shipmentDetail.setDocumentsReceivedTime(null);
            //shipmentDetail.setLoadingStartedTime(null);
            //shipmentDetail.setTimeOfGateOut(null);
            //shipmentDetail.setKmsOfGateOutFromLoading(null);

            shipmentDetail.setTypeOfOperation(null);

            //shipmentDetail.setPodReceivedTime(null);
            //shipmentDetail.setTimeAtUnloadingDock(null);
            //shipmentDetail.setUnloadingTimeOfGateOut(null);
            //shipmentDetail.setUnloadingStartedTime(null);
            //shipmentDetail.setUnloadingEndedTime(null);
            //shipmentDetail.setKmsAtThePointOfUnloading(null);
            //shipmentDetail.setKmsOfGateOutFromUnloading(null);
            //shipmentDetail.setTimeOfSettlement(null);
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