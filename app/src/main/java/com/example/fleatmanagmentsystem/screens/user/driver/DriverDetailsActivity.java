package com.example.fleatmanagmentsystem.screens.user.driver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseActivity;
import com.example.fleatmanagmentsystem.databinding.ActivityDriverDetailsBinding;
import com.example.fleatmanagmentsystem.models.login.LoginRequestModel;
import com.example.fleatmanagmentsystem.models.login.LoginResponseModel;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentExecutionActivity;
import com.example.fleatmanagmentsystem.screens.user.lrpod.LrPodActivity;
import com.example.fleatmanagmentsystem.viewmodel.DriverDetailViewModel;
import com.example.fleatmanagmentsystem.viewmodel.LoginViewModel;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class DriverDetailsActivity extends BaseActivity<ActivityDriverDetailsBinding, DriverDetailViewModel> {

    ActivityDriverDetailsBinding binding;
    DriverDetailViewModel driverDetailViewModel;
    private ArrayAdapter<String> languageClassification;
    LoginResponseModel loginResponseModelData = new LoginResponseModel();
    public static String DriverId = "";

    ArrayList<String> mob = new ArrayList<>();

    @Override
    protected Class<DriverDetailViewModel> getViewModel() {
        return DriverDetailViewModel.class;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle instance, DriverDetailViewModel viewModel, ActivityDriverDetailsBinding binding) {

        this.binding = binding;
        driverDetailViewModel = viewModel;

        if(getIntent() != null){
            loginResponseModelData = getIntent().getParcelableExtra("loginResponseModel");
        }

        driverDetailViewModel.getDriveDetailsByEmail(/*loginResponseModel.getUser().getEmailId()*/LoginActivity.emailId,LoginActivity.accessToken,LoginActivity.tenantId);

        loadLocal();

        if(LoginActivity.loginResponseModelData.getMobileAppFunctionalitiesAccess().getMobileAppMainFunctionalities() != null){
            for(int i=0 ; i<LoginActivity.loginResponseModelData.getMobileAppFunctionalitiesAccess().getMobileAppMainFunctionalities().size(); i++){
                mob.add(LoginActivity.loginResponseModelData.getMobileAppFunctionalitiesAccess().getMobileAppMainFunctionalities().get(i).getName());
            }

            if(mob.contains("Advance And Expenses")){
                    binding.driverAdvanceExpenses.setVisibility(View.VISIBLE);
            }else {
                binding.driverAdvanceExpenses.setVisibility(View.GONE);
            }
            if(mob.contains("Trips")){
                binding.driverTrip.setVisibility(View.VISIBLE);
            }else{
                binding.driverTrip.setVisibility(View.GONE);
            }
            if(mob.contains("Vehicle Takeover")){
                binding.driverTakeover.setVisibility(View.VISIBLE);
            }else{
                binding.driverTakeover.setVisibility(View.GONE);
            }
            if(mob.contains("Vehicle Handover")){
                binding.driverHandover.setVisibility(View.VISIBLE);
            }else{
                binding.driverHandover.setVisibility(View.GONE);
            }
            if(mob.contains("Shipment Execution")){
                binding.driverShipment.setVisibility(View.VISIBLE);
            }else{
                binding.driverShipment.setVisibility(View.GONE);
            }
            if(mob.contains("Maintenance")){
                binding.driverMaintenance.setVisibility(View.VISIBLE);
            }else{
                binding.driverMaintenance.setVisibility(View.GONE);
            }
            if(mob.contains("LR or POD")){
                binding.lrpod.setVisibility(View.VISIBLE);
            }else{
                binding.lrpod.setVisibility(View.GONE);
            }
            if(mob.contains("Maintenance Closure")){
                binding.maintenanceClosure.setVisibility(View.VISIBLE);
            }else{
                binding.maintenanceClosure.setVisibility(View.GONE);
            }

        }else{}

        binding.driverTrip.setOnClickListener(v -> {
            /*Intent trip = new Intent(DriverDetailsActivity.this ,DriverFeaturesActivity.class);
            trip.putExtra("from","trip");
            startActivity(trip);*/
            Intent intent = new Intent(DriverDetailsActivity.this,DriverFeaturesActivity.class);
            intent.putExtra("from","trip");
            startActivity(intent);
        });

        binding.driverAdvanceExpenses.setOnClickListener(v -> {
            Intent trip = new Intent(this ,DriverFeaturesActivity.class);
            trip.putExtra("from","advanceExpenses");
            startActivity(trip);
        });

        binding.driverTakeover.setOnClickListener(v -> {
            Intent trip = new Intent(this ,DriverFeaturesActivity.class);
            trip.putExtra("from","takeover");
            trip.putExtra("type","takeover");
            startActivity(trip);
        });

        binding.driverShipment.setOnClickListener(v -> {
            Intent trip = new Intent(this , ShipmentExecutionActivity.class);
            trip.putExtra("from","shipment");
            startActivity(trip);
        });

        binding.driverMaintenance.setOnClickListener(v -> {
            Intent trip = new Intent(this ,DriverFeaturesActivity.class);
            trip.putExtra("from","maintenance");
            startActivity(trip);
        });

        binding.driverHandover.setOnClickListener(v -> {
            Intent trip = new Intent(this ,DriverFeaturesActivity.class);
            trip.putExtra("from","handover");
            trip.putExtra("type","handover");
            startActivity(trip);
        });

        binding.maintenanceClosure.setOnClickListener(v -> {
            Intent trip = new Intent(this ,DriverFeaturesActivity.class);
            trip.putExtra("from","maintenanceClosure");
            startActivity(trip);
        });
        binding.lrpod.setOnClickListener(v -> {
            Intent trip = new Intent(this , LrPodActivity.class);
            trip.putExtra("from","lrpod");
            startActivity(trip);
        });

        binding.languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    setLocale("en");
                    //recreate();
                    Intent refresh = new Intent(getBaseContext(), DriverDetailsActivity.class);
                    startActivity(refresh);//Start the same Activity
                    finish();
                }else if(i == 2){
                    setLocale("hi");
                    //recreate();
                    Intent refresh = new Intent(getBaseContext(), DriverDetailsActivity.class);
                    startActivity(refresh);//Start the same Activity
                    finish();
                }else if(i == 3){
                    setLocale("te");
                    //recreate();
                    Intent refresh = new Intent(getBaseContext(), DriverDetailsActivity.class);
                    startActivity(refresh);//Start the same Activity
                    finish();
                }else{}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.logout.setOnClickListener(v -> {
            driverDetailViewModel.getUserLogout(LoginActivity.accessToken,LoginActivity.tenantId);
        });

        selectLanguage();

        initModel();
    }

    //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initModel() {
        driverDetailViewModel.gerDriverDetailsEmail().observe(this, driverDetailsResponseModule -> {
            if(driverDetailsResponseModule != null){
                String pic = "";
                DriverId = driverDetailsResponseModule.getData().getDriver().getDriverId();
                binding.driverId.setText(driverDetailsResponseModule.getData().getDriver().getDriverId());
                binding.driverName.setText(driverDetailsResponseModule.getData().getDriver().getDriverName());
                binding.driverBadgeNo.setText(driverDetailsResponseModule.getData().getDriver().getDriverBadgeNo());
                pic = driverDetailsResponseModule.getData().getDriver().getPhoto();
                driverDetailViewModel.getImageDetails(pic,LoginActivity.accessToken,LoginActivity.tenantId);
                newView();
            }
        });


        driverDetailViewModel.getLogout().observe(this,logoutResponseModule -> {
            if(logoutResponseModule != null){
                if(logoutResponseModule.getData() != null){
                    showToast(logoutResponseModule.getStatusMsg());
                    Intent intent = new Intent(DriverDetailsActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    private void newView() {
        driverDetailViewModel.getImage().observe(this,driverImageResponseModel -> {
            if(driverImageResponseModel != null){

                String pic = driverImageResponseModel.getData().getFilesOrImages();
                byte[] decodedString = Base64.decode(pic, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                //imageView.setImageBitmap(decodedByte);
                binding.driverImage.setImageBitmap(decodedByte);

            }
        });

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_driver_details;
    }

    private void selectLanguage() {
        String[] countryNames={"Language","English","हिंदी","Telugu"};

        languageClassification = new ArrayAdapter<String>(this, R.layout.spinner_text_view, countryNames) {

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView,  parent);

                return v;
            }
        };
        binding.languageSpinner.setAdapter(languageClassification);
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale =locale ;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting",MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocal(){
        SharedPreferences prefs = getSharedPreferences("Setting" , Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }
}