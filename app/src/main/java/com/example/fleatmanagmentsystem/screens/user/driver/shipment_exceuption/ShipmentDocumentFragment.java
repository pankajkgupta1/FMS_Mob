package com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.core.content.FileProvider;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentShipmentDocumentBinding;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.LoadSequenceHelper;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetail;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetailsDocumentsInfo;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.viewmodel.shipmentexception.ShipmentExceptionViewModel;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ShipmentDocumentFragment extends BaseFragment<FragmentShipmentDocumentBinding, ShipmentExceptionViewModel> {

    FragmentShipmentDocumentBinding binding;
    ShipmentExceptionViewModel shipmentExceptionViewModel;
    private ArrayAdapter<String> tripTypeList;
    private ArrayAdapter<String> loadTypeList;
    public ArrayList<String> tripIdListShipment = new ArrayList<>();
    public ArrayList<String> loadIdListShipment = new ArrayList<>();

    public LoadSequenceHelper loadSequenceHelper = new LoadSequenceHelper();
    ShipmentDetailsDocumentsInfo shipmentDetailsDocumentsInfo = new ShipmentDetailsDocumentsInfo();
    public ShipmentDetail shipmentDetail = new ShipmentDetail();

    AdvanceExpensesResponseModule advanceExpensesResponseModuleData = new AdvanceExpensesResponseModule();
    ShipmentLoadedResponseModule shipmentLoadedResponseModuleData = new ShipmentLoadedResponseModule();
    private ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule = new ShipmentExecutionUpdateRequestModule();

    String tripId = "";
    public static int position ;

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

    public static String docName = null ;
    public static String docType = null ;

    String currentPhotoPath;
    private static final int pic_id = 123;
    String imgStr1="";
    ArrayList<String> arrImgName1 = new ArrayList<>();

    public ShipmentDocumentFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<ShipmentExceptionViewModel> getViewModel() {
        return ShipmentExceptionViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_shipment_document;
    }

    @Override
    protected void onCreateView(Bundle instance, ShipmentExceptionViewModel viewModel, FragmentShipmentDocumentBinding binding, Context context) {
        this.binding = binding;
        this.shipmentExceptionViewModel = viewModel;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        shipmentExceptionViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

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

        binding.ok.setOnClickListener(v -> {
            dateAndTime();

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

            shipmentDetail.setTimeOfPlacementAtGate(dateTime);
            shipmentDetail.setLoadingEndedTime(loadingEnd);
            shipmentDetail.setPlacedTimeForLoading(placeLoading);
            shipmentDetail.setDocumentsReceivedTime(documentRecived);
            shipmentDetail.setLoadingStartedTime(loadingStart);
            shipmentDetail.setTimeOfGateOut(gateout);
            shipmentDetail.setKmsOfGateOutFromLoading(kmGateout1);

            shipmentDetail.setTypeOfOperation(null);
            shipmentDetail.setTripStatus(null);

            docName = binding.documentName.getText().toString();
            docType = binding.documentType.getText().toString();

            shipmentDetailsDocumentsInfo.setDocumentName(binding.documentName.getText().toString());
            shipmentDetailsDocumentsInfo.setDocumentType(binding.documentType.getText().toString());
            shipmentDetailsDocumentsInfo.setAttachments(arrImgName1);
            shipmentDetailsDocumentsInfos.add(shipmentDetailsDocumentsInfo);
            shipmentDetail.setShipmentDetailsDocumentsInfo(shipmentDetailsDocumentsInfos);

            shipmentDetails.add(shipmentDetail);

            shipmentExecutionUpdateRequestModule.setCountry(LoginActivity.country);
            shipmentExecutionUpdateRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
            shipmentExecutionUpdateRequestModule.setTripId(tripId);
            if(binding.yes.isChecked()){
                shipmentExecutionUpdateRequestModule.setPhysicalDocumentsHandover("Yes");
            }else {
                shipmentExecutionUpdateRequestModule.setPhysicalDocumentsHandover("No");
            }
            shipmentExecutionUpdateRequestModule.setOdoMeterEnd(null);
            shipmentExecutionUpdateRequestModule.setOdoMeterStart(null);
            shipmentExecutionUpdateRequestModule.setHandOver(null);
            shipmentExecutionUpdateRequestModule.setTakeOver(null);

            shipmentExecutionUpdateRequestModule.setShipmentDetails(shipmentDetails);


            shipmentExceptionViewModel.getShipmentExceptionUpdate(shipmentExecutionUpdateRequestModule,LoginActivity.accessToken,LoginActivity.tenantId );
        });

        binding.captureDoc.setOnClickListener(v -> {
            dispatchTakePictureIntent(123);
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
                                //kmGateout = shipmentExecutionUpdateResponseModule.getData().getShipmentExecution().getShipmentDetails().get(0).getKmsOfGateOutFromUnloading();
                                unloadingGate = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getPlacedTimeForLoading();
                                dopReceived = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getDocumentsReceivedTime();
                                settlement = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getLoadingStartedTime();
                                unloadingStarts = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();
                                unloadingGateOut = shipmentExecutionResponseModule.getData().getShipmentExecution().getShipmentDetails().get(i).getTimeOfGateOut();
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

                }else{
                    getResources().getString(R.string.no_data);
                }

            }else {
                getResources().getString(R.string.something_wrong);
            }
        });

        shipmentExceptionViewModel.getImage().observe(this, uploadImageResponseModule -> {
            if (uploadImageResponseModule != null) {
                if (uploadImageResponseModule.getData() != null) {
                    if(imgStr1.equals("")){
                        imgStr1 = uploadImageResponseModule.getData().getFileName();
                        arrImgName1.add(uploadImageResponseModule.getData().getFileName());
                        Log.e("images1",""+imgStr1);
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
        }
        else{

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

    String imgName1;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                binding.attachedDoc.setImageURI(Uri.fromFile(f));
                Log.e("filePath", "" + f.getName());
                imgName1 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName1, RequestBody.create(MediaType.parse("image/*"), f));

                shipmentExceptionViewModel.uploadImage(filePart, LoginActivity.accessToken, LoginActivity.tenantId);
            }
        }
    }
}