package com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses;

import static com.example.fleatmanagmentsystem.screens.user.LoginActivity.tenantId;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentAdvanceExpensesBinding;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.AdvanceDetailResponseModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelCharge;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelExpensesRequestModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.GeneralExpense;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.LoadSequenceHelper;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.TaxCharge;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.TollCharge;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.viewmodel.advanceexpenses.AdvanceExpensesViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AdvanceExpensesFragment extends BaseFragment<FragmentAdvanceExpensesBinding, AdvanceExpensesViewModel> implements OnMapReadyCallback {

    FragmentAdvanceExpensesBinding binding;
    AdvanceExpensesViewModel advanceExpensesViewModel;
    DriverTripIdListResponseModule driverTripIdListResponseModuleData = new DriverTripIdListResponseModule();
    AdvanceExpensesResponseModule advanceExpensesResponseModuleData = new AdvanceExpensesResponseModule();
    AdvanceDetailResponseModule advanceDetailResponseModuleData = new AdvanceDetailResponseModule();

    private ArrayAdapter<String> tripTypeList;
    ArrayList<String> tripIdList = new ArrayList<>();
    ArrayList<String> arrImgName1 = new ArrayList<>();
    ArrayList<String> arrImgName2 = new ArrayList<>();
    ArrayList<String> arrImgName3 = new ArrayList<>();

    FuelExpensesRequestModule fuelExpensesRequestModule = new FuelExpensesRequestModule();
    FuelCharge fuelCharge = new FuelCharge();
    LoadSequenceHelper loadSequenceHelp = new LoadSequenceHelper();
    GeneralExpense generalExpense = new GeneralExpense();
    TollCharge tollCharge = new TollCharge();
    TaxCharge taxCharge = new TaxCharge();

    private static final int pic_id = 123;
    private static final int pic_fuel = 124;
    private static final int pic_odometer = 125;
    private static final int pic_toll_bill = 126;
    private static final int pic_gen_bill = 127;
    private static final int pic_tax_bill = 128;

    boolean checkFuel = true;

    String imgStr1="";
    String imgStr2="";
    String imgStr3="";

    double total ;

    String currentPhotoPath;

    //FuelExp
    EditText fuelTripId;
    EditText fuelPetroCard;
    EditText fuelCurrentOdometer;
    EditText fuelStation;
    EditText fuelLocation;
    EditText fuelRate;
    EditText fuelQuantity;
    EditText fuelAmount;
    EditText fuelCreateDateTime;
    //TollExp
    EditText tollTripId,tollPlazzo,tollLocation,tollAmount,tollFasttag,tollCreateDateTime;
    ImageView tollCamBill,tollBillImg;
    //General Exp
    EditText genTripId,genExpName,genDescription,genRate,genQuantity,genAmount,genDiscountAmt,genDiscountPer,genCreateDateTime;
    ImageView genCamAmount,genAmountImg;
    //Tax Exp
    EditText taxTripId,taxType,taxLocation,taxAmount,taxCreateDateTime;
    ImageView taxBillImg,taxCamBill;
    //Advance
    EditText advTripId,advanceBalance,advPetrolCard,advFastag,advCashBank,advTaxCard,advTotalAdvance,advCreateDateTime;

    private int currentYear;
    private String month_no;

    String dateTime;
    Location currentLocation;
    private static final int REQUEST_CODE = 101;
    FusedLocationProviderClient fusedLocationProviderClient;
    String areaName;

    public static String tripId;

    AlertDialog alertDialog;

    public static double  rate,qunt;

    public AdvanceExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<AdvanceExpensesViewModel> getViewModel() {
        return AdvanceExpensesViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_advance_expenses;
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_advance_expenses, container, false);




        return binding.getRoot();
    }*/

    @Override
    protected void onCreateView(Bundle instance, AdvanceExpensesViewModel viewModel, FragmentAdvanceExpensesBinding binding, Context context) {
        this.binding = binding;
        this.advanceExpensesViewModel = viewModel;

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, pic_id);

        }

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        fetchLocation();

        advanceExpensesViewModel.getDriverTripIdList(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);


        binding.fuel.setOnClickListener(v -> {
            fuelExpensesPopup();
        });

        binding.generalExpenses.setOnClickListener(v -> {
            generalExpensesPopup();
        });

        binding.expensesToll.setOnClickListener(v -> {
            tollPopup();
        });

        binding.expensesAdvance.setOnClickListener(v -> {
            advancePopup();
        });

        binding.advanceTax.setOnClickListener(v -> {
            taxPopup();
        });

        binding.back.setOnClickListener(v -> {
            getActivity().getFragmentManager().popBackStack();
        });

        binding.report.setOnClickListener(v -> {
            if(binding.spinnerTripsIds.getSelectedItem().equals("Select")){
                showToast(getString(R.string.select_trip_id));
            }else{
                Intent intent = new Intent(getContext(), ExpensesHistoryActivity.class);
                //intent.putExtra("tripId",binding.spinnerTripsIds.getSelectedItem().toString());
                getContext().startActivity(intent);

            }

            //startActivity(new Intent(getContext(), ExpensesHistoryActivity.class));
        });

        binding.spinnerTripsIds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    tripId = binding.spinnerTripsIds.getSelectedItem().toString();
                    advanceExpensesViewModel.getAdvanceExpenses(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken, LoginActivity.tenantId);
                    advanceExpensesViewModel.getAdvanceDetails(binding.spinnerTripsIds.getSelectedItem().toString(), LoginActivity.accessToken, LoginActivity.tenantId);
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

        advanceExpensesViewModel.getDriverTripId().observe(this, driverTripIdListResponseModule -> {
            if (driverTripIdListResponseModule != null) {
                driverTripIdListResponseModuleData = driverTripIdListResponseModule;
                tripIdList.clear();
                tripIdList.add("Select");
                //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                for (int i = 0; i < driverTripIdListResponseModule.getData().getConfirmationList().size(); i++) {
                    tripIdList.add(driverTripIdListResponseModule.getData().getConfirmationList().get(i).getTripId());
                }
                selectTrip(tripIdList);
            }
        });

        advanceExpensesViewModel.getAdvanceExpensesStartData().observe(this, advanceExpensesResponseModule -> {
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

        advanceExpensesViewModel.getImage().observe(this, uploadImageResponseModule -> {
            if (uploadImageResponseModule != null) {
                if (uploadImageResponseModule.getData() != null) {

                    if(imgStr1.equals("")){
                        imgStr1 = uploadImageResponseModule.getData().getFileName();
                        arrImgName1.add(uploadImageResponseModule.getData().getFileName());
                    }else if(imgStr2.equals("")){
                        imgStr2 = uploadImageResponseModule.getData().getFileName();
                        arrImgName2.add(uploadImageResponseModule.getData().getFileName());
                    }else {
                        imgStr3 = uploadImageResponseModule.getData().getFileName();
                        arrImgName3.add(uploadImageResponseModule.getData().getFileName());
                    }

                    /*Log.e("imagesName",""+imgStr1+imgStr2+imgStr3);
                    for (int i=0; i<arrImgName.size(); i++) {
                        if (arrImgName.get(i) == null) {
                            arrImgName.add(i,uploadImageResponseModule.getData().getFileName());
                            break;
                        }
                    }
                    Log.e("imagesName",""+arrImgName);*/
                }
            }
        });

        advanceExpensesViewModel.getFuelExp().observe(this,fuelExpensesResponseModule -> {
            if(fuelExpensesResponseModule != null){
                if(fuelExpensesResponseModule.getData() != null){
                    //alertDialog.dismiss();
                    showToast(fuelExpensesResponseModule.statusMsg);
                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        advanceExpensesViewModel.getAdvanceExp().observe(this,advanceDetailResponseModule -> {
            if(advanceDetailResponseModule != null){
                if(advanceDetailResponseModule.getData() != null){
                    advanceDetailResponseModuleData = advanceDetailResponseModule;
                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }


    private void taxPopup() {
        fetchLocation();
        dateAndTime();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.tax_expenses_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;
        ImageView closePopup;
        Button ok;
        closePopup = dialogView.findViewById(R.id.closeTax);
        ok = dialogView.findViewById(R.id.ok);
        taxTripId = dialogView.findViewById(R.id.tripId);
        taxType = dialogView.findViewById(R.id.taxType);
        taxLocation = dialogView.findViewById(R.id.location);
        taxAmount = dialogView.findViewById(R.id.amount);
        taxCreateDateTime = dialogView.findViewById(R.id.createDateTime);
        taxCamBill = dialogView.findViewById(R.id.taxCamBill);
        taxBillImg = dialogView.findViewById(R.id.taxBillImg);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        taxTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());
        taxLocation.setText(areaName);
        taxCreateDateTime.setText(dateTime);

        closePopup.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        ok.setOnClickListener(v -> {
            alertDialog.dismiss();
            allExpensesCall("taxCharge");
        });

        taxCamBill.setOnClickListener(v -> {
            //camOpen();
            dispatchTakePictureIntent(128);
        });

    }

    @SuppressLint("SetTextI18n")
    private void advancePopup() {
        dateAndTime();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.advance_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;
        ImageView closePopup;
        closePopup = dialogView.findViewById(R.id.closeAdvance);
        advTripId = dialogView.findViewById(R.id.tripId);
        advanceBalance = dialogView.findViewById(R.id.advanceBalance);
        advPetrolCard = dialogView.findViewById(R.id.petroCard);
        advFastag = dialogView.findViewById(R.id.fasTag);
        advCashBank = dialogView.findViewById(R.id.cashBank);
        advTaxCard = dialogView.findViewById(R.id.advanceTaxCard);
        advTotalAdvance = dialogView.findViewById(R.id.totalAdvance);
        advCreateDateTime = dialogView.findViewById(R.id.createDateTime);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        if(binding.spinnerTripsIds.getSelectedItem().toString().length() > 0){
            advTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());
        }else{
            advTripId.setText("");
        }
        if(binding.spinnerTripsIds.getSelectedItem().toString().length() >0){
            advTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());
        }else{
            advTripId.setText("");
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getPetroCardAmount() == null/*||advanceDetailResponseModuleData.getData().getTripAdvance().getPetroCardAmount().toString().length()>0*/){
            //advPetrolCard.setText(advanceDetailResponseModuleData.getData().getTripAdvance().getPetroCardAmount().toString());
            advPetrolCard.setText("");
        }else{
            advPetrolCard.setText(advanceDetailResponseModuleData.getData().getTripAdvance().getPetroCardAmount().toString());
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getAmount().toString().length()>0){
            advFastag.setText((advanceDetailResponseModuleData.getData().getTripAdvance().getFastagAmount().toString()));
        }else{
            advFastag.setText("");
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getCash().toString().length()>0){
            advCashBank.setText((advanceDetailResponseModuleData.getData().getTripAdvance().getCash().toString()));
        }else{
            advCashBank.setText("");
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getTaxCardAmount()==null){
            advTaxCard.setText("");
        }else{
            advTaxCard.setText(advanceDetailResponseModuleData.getData().getTripAdvance().getTaxCardAmount().toString());
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getBalance()==null){
            advanceBalance.setText("");
        }else{

            advanceBalance.setText((advanceDetailResponseModuleData.getData().getTripAdvance().getBalance().toString()));
        }
        if(advanceDetailResponseModuleData.getData().getTripAdvance().getAmount().toString().length()>0){
            advTotalAdvance.setText((advanceDetailResponseModuleData.getData().getTripAdvance().getAmount().toString()));
        }else{
            advTotalAdvance.setText("");
        }

        advCreateDateTime.setText(dateTime);

        closePopup.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
    }

    private void tollPopup() {
        fetchLocation();
        dateAndTime();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.toll_expenses_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;
        ImageView closePopup;
        Button ok;
        closePopup = dialogView.findViewById(R.id.closeToll);
        ok = dialogView.findViewById(R.id.ok);
        tollTripId = dialogView.findViewById(R.id.tripId);
        tollPlazzo = dialogView.findViewById(R.id.tollPlazzo);
        tollLocation = dialogView.findViewById(R.id.location);
        tollAmount = dialogView.findViewById(R.id.amount);
        tollFasttag = dialogView.findViewById(R.id.fas_tag_no);
        tollCreateDateTime = dialogView.findViewById(R.id.createDateTime);
        tollCamBill = dialogView.findViewById(R.id.tollCamBill);
        tollBillImg = dialogView.findViewById(R.id.tollBillImg);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        tollTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());
        tollLocation.setText(areaName);
        tollCreateDateTime.setText(dateTime);

        tollFasttag.setText(advanceDetailResponseModuleData.getData().getTripAdvance().getFastagNumber());


        closePopup.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        ok.setOnClickListener(v -> {
            alertDialog.dismiss();
            allExpensesCall("tollCharge");
        });

        tollCamBill.setOnClickListener(v -> {
            //camOpen();
            dispatchTakePictureIntent(126);
        });
    }

    private void generalExpensesPopup() {
        dateAndTime();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.general_expenses_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;
        ImageView closePopup;
        Button ok;
        closePopup = dialogView.findViewById(R.id.closeGeneral);
        ok = dialogView.findViewById(R.id.ok);
        genTripId = dialogView.findViewById(R.id.tripId);
        genExpName = dialogView.findViewById(R.id.expenseName);
        genDescription = dialogView.findViewById(R.id.description);
        genRate = dialogView.findViewById(R.id.rate);
        genQuantity = dialogView.findViewById(R.id.quantity);
        genDiscountAmt = dialogView.findViewById(R.id.discountAmt);
        genCreateDateTime = dialogView.findViewById(R.id.createDateTime);
        genDiscountPer = dialogView.findViewById(R.id.discountPer);
        genAmount = dialogView.findViewById(R.id.amount);
        genCamAmount = dialogView.findViewById(R.id.genCamBill);
        genAmountImg = dialogView.findViewById(R.id.billDetails);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();
        /*int rate = Integer.parseInt(genRate.getText().toString());
        int qunt = Integer.parseInt(genQuantity.getText().toString());
        int amount = rate*qunt;

        genAmount.setText(amount);*/
        genCreateDateTime.setText(dateTime);
        genTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());

        closePopup.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        genCamAmount.setOnClickListener(v -> {
            dispatchTakePictureIntent(127);
        });

        ok.setOnClickListener(v -> {
            alertDialog.dismiss();
            allExpensesCall("generalExpenses");
        });


        genQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if((genRate.getText().equals("") && genQuantity.getText().equals("")) || (genRate.getText().equals("") || genQuantity.getText().equals(""))){
                    showToast(getString(R.string.enter_data));
                }else{
                    int rate = Integer.parseInt(genRate.getText().toString());
                    int qunt = Integer.parseInt(genQuantity.getText().toString());
                    total = rate*qunt;
                    genAmount.setText(total+"");
                }
            }
        });

        genRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if((genRate.getText().equals("") && genQuantity.getText().equals("")) || (genRate.getText().equals("") || genQuantity.getText().equals(""))){
                    showToast(getString(R.string.enter_data));
                }else{
                    int rate = Integer.parseInt(genRate.getText().toString());
                    int qunt = Integer.parseInt(genQuantity.getText().toString());
                    total = rate*qunt;
                    genAmount.setText(total+"");
                }
            }
        });
    }

    ImageView petrolMachineImg,imgFuelBill,imgOdometer;

    private void fuelExpensesPopup() {

        dateAndTime();

        checkFuel = false;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fuel_expenses_popup, null);
        alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;
        ImageView closePopup, petrolMachineCam,camFuelBill,camOdometer;
        Button ok;
        closePopup = dialogView.findViewById(R.id.closeFuel);
        petrolMachineCam = dialogView.findViewById(R.id.petrolMachineCam);
        camFuelBill = dialogView.findViewById(R.id.camFuelBill);
        camOdometer = dialogView.findViewById(R.id.camOdometer);
        petrolMachineImg = dialogView.findViewById(R.id.petrolMachineImg);
        imgFuelBill = dialogView.findViewById(R.id.imgFuelBill);
        imgOdometer = dialogView.findViewById(R.id.imgOdometer);

        fuelTripId= dialogView.findViewById(R.id.tripId);
        fuelPetroCard= dialogView.findViewById(R.id.petroCard);
        fuelCurrentOdometer= dialogView.findViewById(R.id.currentOdometer);
        fuelStation= dialogView.findViewById(R.id.fuelStation);
        fuelLocation= dialogView.findViewById(R.id.location);
        fuelRate= dialogView.findViewById(R.id.rate);
        fuelQuantity= dialogView.findViewById(R.id.quantity);
        fuelAmount= dialogView.findViewById(R.id.amount);
        fuelCreateDateTime= dialogView.findViewById(R.id.createDateTime);

        ok = dialogView.findViewById(R.id.ok);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        fuelTripId.setText(binding.spinnerTripsIds.getSelectedItem().toString());

        fuelCreateDateTime.setText(dateTime);
        fuelLocation.setText(areaName);

        fuelPetroCard.setText(advanceDetailResponseModuleData.getData().getTripAdvance().getPetroCardNumber().toString());

        closePopup.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        petrolMachineCam.setOnClickListener(v -> {
            //camOpen();
            dispatchTakePictureIntent(123);
        });

        camFuelBill.setOnClickListener(v -> {
            //camOpen();
            dispatchTakePictureIntent(124);
        });

        camOdometer.setOnClickListener(v -> {
            //camOpen();
            dispatchTakePictureIntent(125);
        });


        fuelQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if((fuelRate.getText().equals("") && fuelQuantity.getText().equals("")) || (fuelRate.getText().equals("") || fuelQuantity.getText().equals(""))){
                    showToast(getString(R.string.enter_data));
                }else{
                    rate = Integer.parseInt(fuelRate.getText().toString());
                    qunt = Integer.parseInt(fuelQuantity.getText().toString());
                    total = rate*qunt;
                    fuelAmount.setText(total+"");
                }
            }
        });

        /*fuelRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if((fuelRate.getText().equals("") && fuelQuantity.getText().equals("")) || (fuelRate.getText().equals("") || fuelQuantity.getText().equals(""))){
                    showToast(getString(R.string.enter_data));
                }else{
                    rate = Integer.parseInt(fuelRate.getText().toString());
                    qunt = Integer.parseInt(fuelQuantity.getText().toString());
                    total = rate*qunt;
                    fuelAmount.setText(total+"");
                }
            }
        });*/

        ok.setOnClickListener(v -> {
            if(fuelRate.getText().equals("") && fuelQuantity.getText().equals("")){
                showToast(getString(R.string.enter_data));
            }else{
                alertDialog.dismiss();
                allExpensesCall("fuel");
            }



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

    private void allExpensesCall(String type) {

        ArrayList<LoadSequenceHelper> loadSequenceHelpers = new ArrayList<>();
        ArrayList<GeneralExpense> generalExpenses = new ArrayList<>();
        ArrayList<FuelCharge> fuelCharges = new ArrayList<>();
        ArrayList<TollCharge> tollCharges = new ArrayList<>();
        ArrayList<TaxCharge> taxCharges = new ArrayList<>();

        fuelExpensesRequestModule.setTripId(binding.spinnerTripsIds.getSelectedItem().toString());

        //All Initial data
        fuelExpensesRequestModule.setVehicleId(binding.spinnerTripsIds.getSelectedItem().toString());
        fuelExpensesRequestModule.setDriverId("");
        fuelExpensesRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
        fuelExpensesRequestModule.setCountry(LoginActivity.country);
        fuelExpensesRequestModule.setInvoiceId("");
        fuelExpensesRequestModule.setInvoiceOrPaymentDate("");
        fuelExpensesRequestModule.setCurrentOdometer(null);
        fuelExpensesRequestModule.setPaymentDueDate(null);
        fuelExpensesRequestModule.setVendorId(null);
        fuelExpensesRequestModule.setTransactionDateTime(null);
        fuelExpensesRequestModule.setPreviousFuelingOdoMeterReading(null);
        fuelExpensesRequestModule.setGeneralExpensesTotal(null);
        fuelExpensesRequestModule.setFuelChargesTotal(null);
        fuelExpensesRequestModule.setTollChargesTotal(null);
        fuelExpensesRequestModule.setTaxChargesTotal(null);
        fuelExpensesRequestModule.setChargesTotal(null);

        //LoadSequenceData

        loadSequenceHelp.setLoadId(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getLoadId());
        loadSequenceHelp.setSourceLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getSourceLocation());
        loadSequenceHelp.setDestinationLocation(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getDestinationLocation());
        loadSequenceHelp.setShipperPickupDateAndTime(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getShipperPickupDateAndTime());
        loadSequenceHelp.setCustomerDeliveryDateAndTime(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getCustomerDeliveryDateAndTime());
        loadSequenceHelp.setTripSequence(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getTripSequence());
        loadSequenceHelp.setPurchaseOrderId(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getPurchaseOrderId());
        loadSequenceHelp.setDistance(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getDistance());
        loadSequenceHelp.setInvoiceStatus(advanceExpensesResponseModuleData.getData().getTrip().getLoadSequenceHelper().get(0).getInvoiceStatus());

        //generalExpensesData

        if(type.equals("generalExpenses")){
            generalExpense.setExpensesName(genExpName.getText().toString());
            generalExpense.setDescription(genDescription.getText().toString());
            generalExpense.setQuantity(Double.valueOf(genQuantity.getText().toString()));
            generalExpense.setRate(Double.valueOf(genRate.getText().toString()));
            generalExpense.setDiscount(/*Double.valueOf(genDiscountPer.getText().toString())*/null);
            generalExpense.setDiscountAmount(/*Double.valueOf(genDiscountAmt.getText().toString())*/null);
            generalExpense.setAmount(Double.valueOf(genAmount.getText().toString()));
            generalExpense.setTax(null);
            generalExpense.setTaxAmount(null);
            generalExpense.setTotalAmount(null);
            generalExpense.setBillAttachments(arrImgName3);
            generalExpense.setCreatedDateTime(null);
            generalExpenses.add(generalExpense);
            fuelExpensesRequestModule.setGeneralExpenses(generalExpenses);
        }else{
            generalExpenses.add(generalExpense);
            fuelExpensesRequestModule.setGeneralExpenses(null);
            /*generalExpense.setExpensesName(null);
            generalExpense.setDescription(null);
            generalExpense.setQuantity(null);
            generalExpense.setRate(null);
            generalExpense.setDiscount(null);
            generalExpense.setDiscountAmount(null);
            generalExpense.setAmount(null);
            generalExpense.setTax(null);
            generalExpense.setTaxAmount(null);
            generalExpense.setTotalAmount(null);
            generalExpense.setBillAttachments(null);
            generalExpense.setCreatedDateTime(null);*/
        }

        //tollChargeData

        if(type.equals("tollCharge")){
            tollCharge.setTollPlazaName(tollPlazzo.getText().toString());
            tollCharge.setLocation(tollLocation.getText().toString());
            tollCharge.setTollAmount(Double.valueOf(tollAmount.getText().toString()));
            tollCharge.setFastagCardNumber(tollFasttag.getText().toString());
            tollCharge.setBillAttachments(arrImgName3);
            tollCharge.setCreatedDateTime(tollCreateDateTime.getText().toString());
            tollCharges.add(tollCharge);
            fuelExpensesRequestModule.setTollCharges(tollCharges);
        }else{
            tollCharges.add(tollCharge);
            fuelExpensesRequestModule.setTollCharges(null);
            /*tollCharge.setTollPlazaName(null);
            tollCharge.setLocation(null);
            tollCharge.setTollAmount(null);
            tollCharge.setFastagCardNumber(null);
            tollCharge.setBillAttachments(null);
            tollCharge.setCreatedDateTime(null);*/
        }

        //taxChargeData

        if(type.equals("taxCharge")){
            taxCharge.setTaxType(taxType.getText().toString());
            taxCharge.setLocation(taxLocation.getText().toString());
            taxCharge.setTaxAmount(Double.valueOf(taxAmount.getText().toString()));
            taxCharge.setBillAttachments(arrImgName3);
            taxCharge.setCreatedDateTime(taxCreateDateTime.getText().toString());
            taxCharges.add(taxCharge);
            fuelExpensesRequestModule.setTaxCharges(taxCharges);
        }else{
            taxCharges.add(taxCharge);
            fuelExpensesRequestModule.setTaxCharges(null);
            /*taxCharge.setTaxType(null);
            taxCharge.setLocation(null);
            taxCharge.setTaxAmount(null);
            taxCharge.setBillAttachments(null);
            taxCharge.setCreatedDateTime(null);*/
        }

        //fuelData

        if(type.equals("fuel")){
            fuelCharge.setPetroCardNumber(fuelPetroCard.getText().toString());
            fuelCharge.setCurrentOdometer(Double.valueOf(fuelCurrentOdometer.getText().toString()));
            fuelCharge.setFuelStation(fuelStation.getText().toString());
            fuelCharge.setFuelLocation(fuelLocation.getText().toString());
            //fuelCharge.setFuelRate(Integer.valueOf(fuelRate.getText().toString()));
            fuelCharge.setFuelQuantity(qunt);
            fuelCharge.setFuelAmount(total);
            fuelCharge.setFuelRate(rate);
            fuelCharge.setPetroMachineAttatchments(arrImgName1);
            fuelCharge.setFuelBillAttatchments(arrImgName2);
            fuelCharge.setCurrentOdometerAttatchments(arrImgName3);
            fuelCharge.setFuelUom("");
            fuelCharge.setVendorId("");
            fuelCharge.setCreatedDateTime(dateTime);
            fuelCharges.add(fuelCharge);
            fuelExpensesRequestModule.setFuelCharges(fuelCharges);
        }
        else{
            fuelCharges.add(fuelCharge);
            fuelExpensesRequestModule.setFuelCharges(null);
            /*fuelCharge.setPetroCardNumber(null);
            fuelCharge.setCurrentOdometer(null);
            fuelCharge.setFuelStation(null);
            fuelCharge.setFuelLocation(null);
            fuelCharge.setFuelRate(null);
            fuelCharge.setPetroMachineAttatchments(null);
            fuelCharge.setFuelBillAttatchments(null);
            fuelCharge.setCurrentOdometerAttatchments(null);
            fuelCharge.setFuelUom("");
            fuelCharge.setVendorId("");*/
        }

        //All to its values

        //tollCharges.add(tollCharge);
        //fuelCharges.add(fuelCharge);
        loadSequenceHelpers.add(loadSequenceHelp);
        //generalExpenses.add(generalExpense);

        //Set data to class

        //fuelExpensesRequestModule.setTaxCharges(taxCharges);
        //fuelExpensesRequestModule.setTollCharges(tollCharges);
        //fuelExpensesRequestModule.setGeneralExpenses(generalExpenses);
        //fuelExpensesRequestModule.setFuelCharges(fuelCharges);
        fuelExpensesRequestModule.setLoadSequenceHelper(loadSequenceHelpers);

        Log.e("json",fuelExpensesRequestModule+"");
        advanceExpensesViewModel.getFuelExpensesDone(fuelExpensesRequestModule,LoginActivity.accessToken,LoginActivity.tenantId);

    }

    /*private void camOpen() {

        Intent camera_intent
                = new Intent(MediaStore
                .ACTION_IMAGE_CAPTURE);

        // Start the activity with camera_intent,
        // and request pic id
        startActivityForResult(camera_intent, pic_id);

    }*/

    private void selectTrip(ArrayList<String> tripIdList) {

        tripTypeList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, tripIdList) {

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

    String imgName1,imgName2,imgName3;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                petrolMachineImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName1 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName1, RequestBody.create(MediaType.parse("image/*"), f));

                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
        }else if (requestCode == pic_fuel) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                imgFuelBill.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName2 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName2, RequestBody.create(MediaType.parse("image/*"), f));
                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
        }else if (requestCode == pic_odometer) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                imgOdometer.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName3 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName3, RequestBody.create(MediaType.parse("image/*"), f));
                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
        }else if (requestCode == pic_toll_bill) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                tollBillImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName3 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName3, RequestBody.create(MediaType.parse("image/*"), f));
                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
        }else if (requestCode == pic_gen_bill) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                genAmountImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName3 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName3, RequestBody.create(MediaType.parse("image/*"), f));
                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
        }else if (requestCode == pic_tax_bill) {
            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                taxBillImg.setImageURI(Uri.fromFile(f));
                Log.e("filePath",""+f.getName());
                imgName3 = f.getName();

                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imgName3, RequestBody.create(MediaType.parse("image/*"), f));
                advanceExpensesViewModel.uploadImage(filePart,LoginActivity.accessToken,LoginActivity.tenantId);
            }
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng1 = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions().position(latLng1).title("I am here!");
        //MarkerOptions markerOptions1 = new MarkerOptions().position(latLng1).title("I am here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng1));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 5));
        googleMap.addMarker(markerOptions);

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

    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;

                    try {
                        Geocoder geo = new Geocoder(getContext(), Locale.getDefault());
                        List<Address> addresses = null;

                        try {
                            addresses = geo.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);
                            areaName = addresses.get(0).getLocality();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (addresses.isEmpty()) {
                            fuelLocation.setText("Waiting for Location");
                        }
                        else {
                            //fuelLocation.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                            //Log.e("location",addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName()+"");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), branchLocationData.get(position).getLatitude()/*currentLocation.getLatitude()*/ + "" + branchLocationData.get(position).getLongitude()/*currentLocation.getLongitude()*/, Toast.LENGTH_SHORT).show();
                    //SupportMapFragment supportMapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.myMap);
                    //assert supportMapFragment != null;
//                    supportMapFragment.getMapAsync((OnMapReadyCallback) getContext());
                }
            }
        });
    }
}
