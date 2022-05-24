package com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseActivity;
import com.example.fleatmanagmentsystem.databinding.ActivityExpensesHistoryBinding;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.ExpensesHistoryResponseModule;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.FuelCharge;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.GeneralExpense;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.viewmodel.expenseshistory.ExpensesHistoryViewModel;

import java.util.ArrayList;

public class ExpensesHistoryActivity extends BaseActivity<ActivityExpensesHistoryBinding, ExpensesHistoryViewModel> implements ExpensesHistoryAdapter.AdapterExceptionClickLisner{

    ActivityExpensesHistoryBinding binding;
    ExpensesHistoryViewModel expensesHistoryViewModel;
    ExpensesHistoryResponseModule expensesHistoryResponseModuleData = new ExpensesHistoryResponseModule();
    ArrayList<GeneralExpense> generalExpenseArrayList = new ArrayList<GeneralExpense>();
    ArrayList<FuelCharge> fuelChargeArrayList = new ArrayList<com.example.fleatmanagmentsystem.models.login.expenseshistory.FuelCharge>();

    ExpensesHistoryAdapter expensesHistoryAdapter;
    public static Boolean check = false;

    private ArrayAdapter<String> expenseHistoryList;
    String tripId;

    @Override
    protected Class<ExpensesHistoryViewModel> getViewModel() {
        return ExpensesHistoryViewModel.class;
    }

    @Override
    protected void onCreate(Bundle instance, ExpensesHistoryViewModel viewModel, ActivityExpensesHistoryBinding binding) {
        this.binding = binding;
        this.expensesHistoryViewModel = viewModel;

        /*if(getArguments() != null){
            tripId = getArguments().getString("tripId");
            expensesHistoryModel.getExpensesHistoryReport(AdvanceExpensesFragment.tripId, LoginActivity.accessToken);
        }*/

        expensesHistoryViewModel.getExpensesHistoryReport(AdvanceExpensesFragment.tripId, LoginActivity.accessToken, LoginActivity.tenantId);
        selectType();

        binding.expensesTypSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 && check){
                    expensesHistoryAdapter = new ExpensesHistoryAdapter(getBaseContext(), ExpensesHistoryActivity.this ,expensesHistoryResponseModuleData,"fuel");
                    binding.recyclerExpensesHistory.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerExpensesHistory.setAdapter(expensesHistoryAdapter);
                    expensesHistoryAdapter.notifyDataSetChanged();
                    //tripDetailsViewModel.getUserTripDetails("Assigned", LoginActivity.accessToken);
                }else if(position == 1){
                    expensesHistoryAdapter = new ExpensesHistoryAdapter(getBaseContext(), ExpensesHistoryActivity.this,expensesHistoryResponseModuleData,"toll");
                    binding.recyclerExpensesHistory.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerExpensesHistory.setAdapter(expensesHistoryAdapter);
                    expensesHistoryAdapter.notifyDataSetChanged();
                    //tripDetailsViewModel.getUserTripDetails("Assigned", LoginActivity.accessToken);
                }else if(position == 2){
                    expensesHistoryAdapter = new ExpensesHistoryAdapter(getBaseContext(), ExpensesHistoryActivity.this,expensesHistoryResponseModuleData,"tax");
                    binding.recyclerExpensesHistory.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerExpensesHistory.setAdapter(expensesHistoryAdapter);
                    expensesHistoryAdapter.notifyDataSetChanged();
                    //tripDetailsViewModel.getUserTripDetails("Accepted", LoginActivity.accessToken);
                }else if(position == 3){
                    expensesHistoryAdapter = new ExpensesHistoryAdapter(getBaseContext(), ExpensesHistoryActivity.this,expensesHistoryResponseModuleData,"generalExp");
                    binding.recyclerExpensesHistory.setItemAnimator(new DefaultItemAnimator());
                    binding.recyclerExpensesHistory.setAdapter(expensesHistoryAdapter);
                    expensesHistoryAdapter.notifyDataSetChanged();
                    //tripDetailsViewModel.getUserTripDetails("Rejected", LoginActivity.accessToken);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initView();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_expenses_history;
    }

   /* @Override
    protected void onCreateView(Bundle instance, ExpensesHistoryViewModel viewModel, ActivityExpensesHistoryBinding binding, Context context) {


    }*/

    @SuppressLint("FragmentLiveDataObserve")
    private void initView() {

        expensesHistoryViewModel.getExpensesReport().observe(this, expensesHistoryResponseModule -> {
            if(expensesHistoryResponseModule != null){
                if(expensesHistoryResponseModule.getData() != null){
                    if(expensesHistoryResponseModule.getData().getTripExpenses() == null){
                        showToast(expensesHistoryResponseModule.getStatusMsg());
                        binding.expensesTypSpinner.setClickable(false);
                    }else{
                        check = true;
                        binding.expensesTypSpinner.setClickable(true);
                        expensesHistoryResponseModuleData = expensesHistoryResponseModule;
                        fuelChargeArrayList.addAll(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges());
                        expensesHistoryAdapter = new ExpensesHistoryAdapter(getBaseContext(),this, expensesHistoryResponseModule,"fuel");
                        binding.recyclerExpensesHistory.setItemAnimator(new DefaultItemAnimator());
                        binding.recyclerExpensesHistory.setAdapter(expensesHistoryAdapter);
                        expensesHistoryAdapter.notifyDataSetChanged();
                    }

                }else {

                }
            }else {

            }
        });

    }

    private void selectType() {
        String[] countryNames={"Fuel","Toll","Tax","General Exp"};

        expenseHistoryList = new ArrayAdapter<String>(this, R.layout.spinner_text_view, countryNames) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,  parent);

                return v;
            }
        };
        binding.expensesTypSpinner.setAdapter(expenseHistoryList);
    }


    @Override
    public void onItemClickLisner(int position,String type) {
        if(type.equals("fuel")){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.fuel_expenses_popup, null);
            AlertDialog alertDialog = dialogBuilder.create();
            //String userId,email,mobileNo;
            ImageView closePopup, petrolMachineCam,camFuelBill,camOdometer;
            ImageView petrolMachineImg,imgFuelBill,imgOdometer;
            Button ok;
            EditText fuelTripId;
            EditText fuelPetroCard;
            EditText fuelCurrentOdometer;
            EditText fuelStation;
            EditText fuelLocation;
            EditText fuelRate;
            EditText fuelQuantity;
            EditText fuelAmount;
            EditText fuelCreateDateTime;
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

            petrolMachineCam.setVisibility(View.GONE);
            camFuelBill.setVisibility(View.GONE);
            camOdometer.setVisibility(View.GONE);

            String crtOdometer = String.valueOf(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getCurrentOdometer());

            fuelPetroCard.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getPetroCardNumber());
            fuelPetroCard.setEnabled(false);
            //fuelCurrentOdometer.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getCurrentOdometer());
            fuelCurrentOdometer.setText(crtOdometer);
            fuelCurrentOdometer.setEnabled(false);
            fuelStation.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getFuelStation());
            fuelStation.setEnabled(false);
            fuelAmount.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getFuelAmount());
            fuelAmount.setEnabled(false);
            fuelRate.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getFuelRate().toString());
            fuelRate.setEnabled(false);
            fuelTripId.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTripId());

            fuelCreateDateTime.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getCreatedDateTime());
            fuelLocation.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getFuelLocation());

            closePopup.setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            /*petrolMachineCam.setOnClickListener(v -> {
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
            });*/


            fuelQuantity.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getFuelCharges().get(position).getFuelQuantity());

            ok.setOnClickListener(v -> {
                alertDialog.dismiss();
            });
        }
        else if(type.equals("generalExp")){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.general_expenses_popup, null);
            final AlertDialog alertDialog = dialogBuilder.create();
            //String userId,email,mobileNo;
            EditText genTripId,genExpName,genDescription,genRate,genQuantity,genAmount,genDiscountAmt,genDiscountPer,genCreateDateTime;
            ImageView genCamBill,genAmountImg;
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
            genCamBill = dialogView.findViewById(R.id.genCamBill);
            genAmountImg = dialogView.findViewById(R.id.billDetails);
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.setView(dialogView);
            alertDialog.setCancelable(false);
            alertDialog.show();
        /*int rate = Integer.parseInt(genRate.getText().toString());
        int qunt = Integer.parseInt(genQuantity.getText().toString());
        int amount = rate*qunt;

        genAmount.setText(amount);*/
            genCreateDateTime.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getCreatedDateTime());
            genExpName.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getExpensesName());
            genExpName.setEnabled(false);
            genDescription.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getDescription());
            genDescription.setEnabled(false);
            genRate.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getRate().toString());
            genRate.setEnabled(false);
            genDiscountAmt.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getDiscountAmount());
            genDiscountAmt.setEnabled(false);
            genDiscountPer.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getDiscount());
            genDiscountPer.setEnabled(false);
            genAmount.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getAmount().toString());
            genAmount.setEnabled(false);
            genQuantity.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getGeneralExpenses().get(position).getQuantity().toString());
            genQuantity.setEnabled(false);

            genTripId.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTripId());

            closePopup.setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            genCamBill.setVisibility(View.GONE);

            ok.setOnClickListener(v -> {
                alertDialog.dismiss();
            });



        }
        else if(type.equals("toll")){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.toll_expenses_popup, null);
            final AlertDialog alertDialog = dialogBuilder.create();
            //String userId,email,mobileNo;
            EditText tollTripId,tollPlazzo,tollLocation,tollAmount,tollFasttag,tollCreateDateTime;
            ImageView tollCamBill,tollBillImg;
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

            tollTripId.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTripId());
            tollLocation.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTollCharges().get(position).getLocation());
            tollCreateDateTime.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTollCharges().get(position).getCreatedDateTime());

            tollFasttag.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTollCharges().get(position).getFastagCardNumber());
            tollFasttag.setEnabled(false);
            tollPlazzo.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTollCharges().get(position).getTollPlazaName());
            tollPlazzo.setEnabled(false);
            tollAmount.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTollCharges().get(position).getTollAmount().toString());
            tollAmount.setEnabled(false);


            closePopup.setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            ok.setOnClickListener(v -> {
                //allExpensesCall("tollCharge");
                alertDialog.dismiss();
            });
            tollCamBill.setVisibility(View.GONE);

            tollCamBill.setOnClickListener(v -> {
                //camOpen();
                //dispatchTakePictureIntent(126);
            });
        }
        else if(type.equals("tax")){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.tax_expenses_popup, null);
            final AlertDialog alertDialog = dialogBuilder.create();
            //String userId,email,mobileNo;
            EditText taxTripId,taxType,taxLocation,taxAmount,taxCreateDateTime;
            ImageView taxBillImg,taxCamBill;
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

            taxTripId.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTripId());
            taxLocation.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTaxCharges().get(position).getLocation());
            taxCreateDateTime.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTaxCharges().get(position).getCreatedDateTime());
            taxType.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTaxCharges().get(position).getTaxType());
            taxType.setEnabled(false);
            taxAmount.setText(expensesHistoryResponseModuleData.getData().getTripExpenses().getTaxCharges().get(position).getTaxAmount().toString());
            taxAmount.setEnabled(false);

            taxCamBill.setVisibility(View.GONE);

            closePopup.setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            ok.setOnClickListener(v -> {
                alertDialog.dismiss();
            });

            taxCamBill.setOnClickListener(v -> {
                //camOpen();
                //dispatchTakePictureIntent(128);
            });
        }
    }
}