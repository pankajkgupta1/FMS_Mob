package com.example.fleatmanagmentsystem.screens.user.driver.vehicle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentVehicleTakeoverHandoverBinding;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.Handover;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.MaintenanceClosureResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.Takeover;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.HandOver;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.LoadSequenceHelper;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetail;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetailsDocumentsInfo;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.TakeOver;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentDocumentFragment;
import com.example.fleatmanagmentsystem.viewmodel.shipmentexception.ShipmentExceptionViewModel;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class VehicleTakeoverHandoverFragment extends BaseFragment<FragmentVehicleTakeoverHandoverBinding,ShipmentExceptionViewModel> {

    FragmentVehicleTakeoverHandoverBinding binding;
    ShipmentExceptionViewModel shipmentExceptionViewModel;
    private ArrayAdapter<String> tripTypeList;
    private ArrayAdapter<String> loadTypeList;
    public ArrayList<String> tripIdListShipment = new ArrayList<>();
    public ArrayList<String> loadIdListShipment = new ArrayList<>();

    public HandOver handOver = new HandOver();
    public TakeOver takeOver = new TakeOver();
    public LoadSequenceHelper loadSequenceHelper = new LoadSequenceHelper();
    ShipmentDetailsDocumentsInfo shipmentDetailsDocumentsInfo = new ShipmentDetailsDocumentsInfo();
    public ShipmentDetail shipmentDetail = new ShipmentDetail();

    AdvanceExpensesResponseModule advanceExpensesResponseModuleData = new AdvanceExpensesResponseModule();
    ShipmentLoadedResponseModule shipmentLoadedResponseModuleData = new ShipmentLoadedResponseModule();
    private ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule = new ShipmentExecutionUpdateRequestModule();

    String tripId = "";
    public static int position;
    String dateTime;

    Double kmUnloading;//1
    String unloadingEnd = null;//2
    Double kmGateout;//3
    String unloadingGate = null;//4
    String dopReceived = null;//5
    String settlement = null;//6
    String unloadingStarts = null;//7
    String unloadingGateOut = null;

    String atGate = null, loadingEnd = null, placeLoading = null, documentRecived = null, loadingStart = null, gateout = null;
    int kmGateout1;

    String phyDoc = null;

    String srtImgFuel = "";
    String srtImgSpeedMeter = "";
    String srtImgFrontPart = "";
    String srtImgBackPart = "";
    String srtImgTier = "";
    String srtImgSideView = "";

    String currentPhotoPath;
    private static final int pic_fuel = 123;
    private static final int pic_speedMeter = 124;
    private static final int pic_frontPart = 125;
    private static final int pic_backPart = 126;
    private static final int pic_tier = 127;
    private static final int pic_sideView = 128;
    //String imgStr1="";
    ArrayList<String> arrImgFuel = new ArrayList<>();
    ArrayList<String> arrImgSpeedMeter = new ArrayList<>();
    ArrayList<String> arrImgFrontPart = new ArrayList<>();
    ArrayList<String> arrImgBackPart = new ArrayList<>();
    ArrayList<String> arrImgTier = new ArrayList<>();
    ArrayList<String> arrImgSideView = new ArrayList<>();
    String imgFuel;

    MaintenanceResponseModule maintenanceResponseModuleData = new MaintenanceResponseModule();
    MaintenanceClosureResponseModule maintenanceClosureResponseModuleData = new MaintenanceClosureResponseModule();
    public static ArrayList<String> workId = new ArrayList<>();
    public static ArrayList<String> vehicleId = new ArrayList<>();
    String gateEntry= null,testDriver=null,driverStatus=null,vehiclePlaced=null/*,gateout=null*/;
    MaintenanceUpdateStatusRequestModule maintenanceUpdateStatusRequestModule = new MaintenanceUpdateStatusRequestModule();
    public Handover handoverM = new Handover();
    public Takeover takeoverT = new Takeover();

    String type = "";
    public VehicleTakeoverHandoverFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<ShipmentExceptionViewModel> getViewModel() {
        return ShipmentExceptionViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_vehicle_takeover_handover;
    }

    @Override
    protected void onCreateView(Bundle instance, ShipmentExceptionViewModel viewModel, FragmentVehicleTakeoverHandoverBinding binding, Context context) {
        this.binding = binding;
        this.shipmentExceptionViewModel = viewModel;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        type = getArguments().getString("type");

        if(type.equals("takeover") || type.equals("takeover1")){
            binding.title.setText(getResources().getString(R.string.takeover));
            binding.takeover.setClickable(false);
            binding.handover.setClickable(false);
            binding.takeover.setChecked(true);
            binding.handover.setChecked(false);
        }else{
            binding.title.setText(getResources().getString(R.string.handover));
            binding.takeover.setClickable(false);
            binding.handover.setClickable(false);
            binding.takeover.setChecked(false);
            binding.handover.setChecked(true);
        }

        if(type.equals("takeover1") || type.equals("handover1")){
            binding.txtTrip.setText(getResources().getString(R.string.work_order_id));
            binding.txtLoad.setText(getResources().getString(R.string.vehicle_id));
            shipmentExceptionViewModel.getMaintenanceAssignedServices(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);
        }else {
            shipmentExceptionViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);
        }



        binding.spinnerTripsIds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    tripId = binding.spinnerTripsIds.getSelectedItem().toString();
                    if(type.equals("takeover1") || type.equals("handover1")){
                        shipmentExceptionViewModel.getMaintenanceStatusDetails(tripId, LoginActivity.accessToken, LoginActivity.tenantId);
                    }else{
                        shipmentExceptionViewModel.getAdvanceExpenses(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken, LoginActivity.tenantId);
                        shipmentExceptionViewModel.getShipmentExceptionLoadId(tripId, LoginActivity.accessToken, LoginActivity.tenantId);
                    }

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

        binding.ok.setOnClickListener(v -> {
            dateAndTime();

            if(type.equals("takeover") || type.equals("handover")){

                ArrayList<ShipmentDetail> shipmentDetails = new ArrayList<>();
                ArrayList<TakeOver> takeOvers = new ArrayList<>();
                ArrayList<HandOver> handOvers = new ArrayList<>();
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

                shipmentDetail.setKmsAtThePointOfUnloading(kmUnloading);
                shipmentDetail.setUnloadingEndedTime(unloadingEnd);
                shipmentDetail.setKmsOfGateOutFromUnloading(kmGateout);
                shipmentDetail.setTimeAtUnloadingDock(unloadingGate);
                shipmentDetail.setPodReceivedTime(dopReceived);
                shipmentDetail.setTimeOfSettlement(settlement);
                shipmentDetail.setUnloadingStartedTime(unloadingStarts);
                shipmentDetail.setUnloadingTimeOfGateOut(unloadingGateOut);

            /*shipmentDetail.setTimeOfPlacementAtGate(null);
            shipmentDetail.setLoadingEndedTime(null);
            shipmentDetail.setPlacedTimeForLoading(null);
            shipmentDetail.setDocumentsReceivedTime(null);
            shipmentDetail.setLoadingStartedTime(null);
            shipmentDetail.setTimeOfGateOut(null);
            shipmentDetail.setKmsOfGateOutFromLoading(null);*/

                shipmentDetail.setTimeOfPlacementAtGate(atGate);
                shipmentDetail.setLoadingEndedTime(loadingEnd);
                shipmentDetail.setPlacedTimeForLoading(placeLoading);
                shipmentDetail.setDocumentsReceivedTime(documentRecived);
                shipmentDetail.setLoadingStartedTime(loadingStart);
                shipmentDetail.setTimeOfGateOut(gateout);
                shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);

                shipmentDetail.setTypeOfOperation(null);
                shipmentDetail.setTripStatus(null);

                shipmentDetailsDocumentsInfo.setDocumentName(ShipmentDocumentFragment.docName);
                shipmentDetailsDocumentsInfo.setDocumentType(ShipmentDocumentFragment.docType);
                shipmentDetailsDocumentsInfo.setAttachments(null);
                shipmentDetailsDocumentsInfos.add(shipmentDetailsDocumentsInfo);
                shipmentDetail.setShipmentDetailsDocumentsInfo(shipmentDetailsDocumentsInfos);

                shipmentDetails.add(shipmentDetail);

                shipmentExecutionUpdateRequestModule.setCountry(LoginActivity.country);
                shipmentExecutionUpdateRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                shipmentExecutionUpdateRequestModule.setTripId(tripId);

                shipmentExecutionUpdateRequestModule.setPhysicalDocumentsHandover(phyDoc);

                shipmentExecutionUpdateRequestModule.setOdoMeterEnd(null);
                shipmentExecutionUpdateRequestModule.setOdoMeterStart(null);

                if (binding.handover.isChecked()) {
                    handOver.setFuelAttachments(arrImgFuel);
                    handOver.setSpeedometerAttachments(arrImgSpeedMeter);
                    handOver.setFrontpartAttachments(arrImgFrontPart);
                    handOver.setBackpartAttachments(arrImgBackPart);
                    handOver.setTireAttachments(arrImgTier);
                    handOver.setSideviewAttachments(arrImgSideView);
                    handOvers.add(handOver);
                } else {
                    shipmentExecutionUpdateRequestModule.setHandOver(null);
                }

                if (binding.takeover.isChecked()) {
                    takeOver.setFuelAttachments(arrImgFuel);
                    takeOver.setSpeedometerAttachments(arrImgSpeedMeter);
                    takeOver.setFrontpartAttachments(arrImgFrontPart);
                    takeOver.setBackpartAttachments(arrImgBackPart);
                    takeOver.setTireAttachments(arrImgTier);
                    takeOver.setSideviewAttachments(arrImgSideView);
                    takeOvers.add(takeOver);
                } else {
                    shipmentExecutionUpdateRequestModule.setTakeOver(null);
                }

                shipmentExecutionUpdateRequestModule.setShipmentDetails(shipmentDetails);


                shipmentExceptionViewModel.getShipmentExceptionUpdate(shipmentExecutionUpdateRequestModule, LoginActivity.accessToken, LoginActivity.tenantId);
            }

            else if(type.equals("takeOver1") || type.equals("handover1")){
                ArrayList<Takeover> takeOvers = new ArrayList<>();
                ArrayList<Handover> handOvers = new ArrayList<>();

                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(gateEntry);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(testDriver);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(driverStatus);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(vehiclePlaced);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(dateTime);
                if(type.equals("takeOver1")){
                    takeoverT.setFuelAttachments(arrImgFuel);
                    takeoverT.setTireAttachments(arrImgTier);
                    takeoverT.setSpeedometerAttachments(arrImgSpeedMeter);
                    takeoverT.setSideviewAttachments(arrImgSideView);
                    takeoverT.setFrontpartAttachments(arrImgFrontPart);
                    takeoverT.setBackpartAttachments(arrImgBackPart);
                    handOvers.add(null);
                }if(type.equals("handover1")){
                    takeOvers.add(null);
                    handoverM.setFuelAttachments(arrImgFuel);
                    handoverM.setTireAttachments(arrImgTier);
                    handoverM.setSpeedometerAttachments(arrImgSpeedMeter);
                    handoverM.setSideviewAttachments(arrImgSideView);
                    handoverM.setFrontpartAttachments(arrImgFrontPart);
                    handoverM.setBackpartAttachments(arrImgBackPart);
                }

                //maintenanceUpdateStatusRequestModule.setHandover(handOver);

                shipmentExceptionViewModel.getMaintenanceUpdateStatus(maintenanceUpdateStatusRequestModule,LoginActivity.accessToken,LoginActivity.tenantId);
            }

        });

        binding.fuelCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(123);
        });

        binding.speedometerCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(124);
        });

        binding.vehicleLightsCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(125);
        });

        binding.vehicleBackLightsCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(126);
        });

        binding.tireCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(127);
        });

        binding.sideViewCam.setOnClickListener(v -> {
            dispatchTakePictureIntent(128);
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
            if (shipmentLoadedResponseModule != null) {
                if (shipmentLoadedResponseModule.getData() != null) {
                    shipmentLoadedResponseModuleData = shipmentLoadedResponseModule;
                    loadIdListShipment.clear();
                    loadIdListShipment.add("Select");
                    for (int i = 0; i < shipmentLoadedResponseModule.getData().getTrip().getLoadSequenceHelper().size(); i++) {
                        loadIdListShipment.add(shipmentLoadedResponseModule.getData().getTrip().getLoadSequenceHelper().get(i).getLoadId());
                        position = i;
                    }
                    selectLoadId(loadIdListShipment);
                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getAdvanceExpensesStartData().observe(this, advanceExpensesResponseModule -> {
            if (advanceExpensesResponseModule != null) {
                if (advanceExpensesResponseModule.getData() != null) {
                    advanceExpensesResponseModuleData = advanceExpensesResponseModule;
                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getShipmentExceptionStartData().observe(this, shipmentExecutionResponseModule -> {
            if (shipmentExecutionResponseModule != null) {
                if (shipmentExecutionResponseModule.getData() != null) {
                    if (shipmentExecutionResponseModule.getData().getShipmentExecution() != null) {

                        for (int i = 0; i < shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().size(); i++) {
                            //shipmentDetailList.add(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfPlacementAtGate());
                            if (binding.spinnerTripsLoads.getSelectedItem().toString().equals(shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadSequenceHelper().getLoadId())) {

                                phyDoc = shipmentExecutionResponseModule.getData().getShipmentExecution().getPhysicalDocumentsHandover();

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
                                //kmGateout = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsOfGateOutFromUnloading();
                                unloadingGate = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading();
                                dopReceived = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime();
                                settlement = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime();
                                unloadingStarts = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();
                                unloadingGateOut = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();
                            }
                        }

                    } else {

                    }

                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getShipmentExecutionUpdateSavaData().observe(this, shipmentExecutionUpdateResponseModule -> {
            if (shipmentExecutionUpdateResponseModule != null) {
                if (shipmentExecutionUpdateResponseModule.getData() != null) {
                    showToast(shipmentExecutionUpdateResponseModule.getStatusMsg());
                    //getActivity().onBackPressed();
                } else {
                    getResources().getString(R.string.no_data);
                }

            } else {
                getResources().getString(R.string.something_wrong);
            }
        });

        shipmentExceptionViewModel.getImage().observe(this, uploadImageResponseModule -> {
            if (uploadImageResponseModule != null) {
                if (uploadImageResponseModule.getData() != null) {
                    if (srtImgFuel.equals("")) {
                        srtImgFuel = uploadImageResponseModule.getData().getFileName();
                        arrImgFuel.add(uploadImageResponseModule.getData().getFileName());
                    } else if (srtImgSpeedMeter.equals("")) {
                        srtImgSpeedMeter = uploadImageResponseModule.getData().getFileName();
                        arrImgSpeedMeter.add(uploadImageResponseModule.getData().getFileName());
                    } else if (srtImgFrontPart.equals("")) {
                        srtImgFrontPart = uploadImageResponseModule.getData().getFileName();
                        arrImgFrontPart.add(uploadImageResponseModule.getData().getFileName());
                    } else if (srtImgBackPart.equals("")) {
                        srtImgBackPart = uploadImageResponseModule.getData().getFileName();
                        arrImgBackPart.add(uploadImageResponseModule.getData().getFileName());
                    } else if (srtImgTier.equals("")) {
                        srtImgTier = uploadImageResponseModule.getData().getFileName();
                        arrImgTier.add(uploadImageResponseModule.getData().getFileName());
                    } else if (srtImgSideView.equals("")) {
                        srtImgSideView = uploadImageResponseModule.getData().getFileName();
                        arrImgSideView.add(uploadImageResponseModule.getData().getFileName());
                    }
                } else {
                    getResources().getString(R.string.no_data);
                }
            } else {
                getResources().getString(R.string.something_wrong);
            }
        });



        shipmentExceptionViewModel.getMaintenanceAssServ().observe(this, maintenanceResponseModule -> {
            if(maintenanceResponseModule != null){
                if(maintenanceResponseModule.getData() != null){
                    maintenanceResponseModuleData = maintenanceResponseModule;
                    workId.clear();
                    vehicleId.clear();
                    workId.add("Select");
                    vehicleId.add("Select");
                    //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                    for (int i = 0; i < maintenanceResponseModule.getData().getMaintanenceWorkOrders().size(); i++) {
                        workId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getWorkOrderId());
                        vehicleId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getVehicleId());
                    }
                    selectTrip(workId);
                    selectLoadId(vehicleId);

                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getMaintenanceCloser().observe(this,maintenanceClosureResponseModule -> {
            if(maintenanceClosureResponseModule != null){
                if(maintenanceClosureResponseModule.getData() != null){
                    if(maintenanceClosureResponseModule.getData().getMaintanenceStatusLog() != null){
                        maintenanceClosureResponseModuleData = maintenanceClosureResponseModule;
                        gateEntry = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getGateEntryDateTime();
                        testDriver = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getTestDriveBy();
                        driverStatus = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getTestDriveStatus();
                        vehiclePlaced = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getVehiclePlacedDateTime();
                        gateout = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getGateOutDateTime();
                    }

                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else{
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        shipmentExceptionViewModel.getMaintenanceUpdate().observe(this,maintenanceUpdateStatusResponseModule -> {
            if(maintenanceUpdateStatusResponseModule != null){
                if(maintenanceUpdateStatusResponseModule.getData() != null){
                    showToast(maintenanceUpdateStatusResponseModule.getStatusMsg());
                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
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

    private void dateAndTime() {
        Calendar cal = Calendar.getInstance();
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


        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        Date newDate = null;
        try {
            newDate = spf.parse(calDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("MM");
        String month_no = spf.format(newDate);
        dateTime = String.valueOf(formattedDate + " " + currentTime);
    }

    private void dispatchTakePictureIntent(int pic_id) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.fleatmanagmentsystem.provider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, pic_id);
            }
        } else {

        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_fuel) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.fuelImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.fuelCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));

                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        } else if (requestCode == pic_speedMeter) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.speedometerImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.speedometerCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));
                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        } else if (requestCode == pic_frontPart) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.vehicleLightsImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.vehicleLightsCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));
                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        } else if (requestCode == pic_backPart) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.vehicleBackLightsImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.vehicleBackLightsCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));
                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        } else if (requestCode == pic_tier) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.tireImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.tireCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));
                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        } else if (requestCode == pic_sideView) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.sideViewImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgFuel = f.getName();
                binding.sideViewCheck.setImageResource(R.drawable.ic_check);
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgFuel, RequestBody.create(MediaType.parse("image/*"), f));
                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        }
    }
}