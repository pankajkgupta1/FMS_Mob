package com.example.fleatmanagmentsystem.screens.user;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseActivity;
import com.example.fleatmanagmentsystem.databinding.ActivityLoginBinding;
import com.example.fleatmanagmentsystem.helper.AppPref;
import com.example.fleatmanagmentsystem.models.login.LoginRequestModel;
import com.example.fleatmanagmentsystem.models.login.LoginResponseModel;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.viewmodel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> {

    // Define the pic id

    @Inject
    AppPref appPref;

    private static final int pic_id = 123;
    ActivityLoginBinding binding;
    LoginRequestModel loginRequestModel = new LoginRequestModel();
    public static LoginResponseModel loginResponseModelData = new LoginResponseModel();
    LoginViewModel loginViewModel;
    public static String clientId = "";
    public static boolean loginFirst = false;
    public static String accessToken="";
    public static String tenantId="";
    public static String organizationIdName="";
    public static String country="";
    public static String emailId="";
    public static List<String> role=new ArrayList<>();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //public static String role="";
    // Define the button and imageview type variable

 /*   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_login);


    }
*/
    @Override
    protected Class<LoginViewModel> getViewModel() {
        return LoginViewModel.class;
    }

    @Override
    protected void onCreate(Bundle instance, LoginViewModel viewModel, ActivityLoginBinding binding) {

        this.binding = binding;
        this.loginViewModel = viewModel;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, pic_id);

        }

        binding.editTextUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(binding.editTextUserName.getText().toString().matches(emailPattern)){
                    if(binding.editTextUserName.getText().toString().contains(".com") || binding.editTextUserName.getText().toString().contains(".in")){
                        loginViewModel.getUserData(/*"14pankajhcu@gmail.com"*/binding.editTextUserName.getText().toString());
                    }else {
                        showToast(getResources().getString(R.string.enter_valid_email));
                    }

                }else {
                    if(binding.editTextUserName.getText().toString().length() >=6)
                        showToast(getResources().getString(R.string.enter_valid_email));
                }
            }
        });

        binding.loginSubmit.setOnClickListener(v -> {

            loginRequestModel.setusername(binding.editTextUserName.getText().toString());
            loginRequestModel.setPassword(binding.editPassword.getText().toString());
            //loginRequestModel.setusername("14pankajhcu@gmail.com");
            //loginRequestModel.setusername("m.tejaswini@datalabsindia.com");
            //loginRequestModel.setPassword("datalabs");


            loginRequestModel.setgrant_type("password");

            loginViewModel.getLoginData(/*clientId,*/loginRequestModel,tenantId);

            //startActivity(new Intent(LoginActivity.this , DriverDetailsActivity.class));

        });

        binding.forgotPass.setOnClickListener(view -> {
            if(binding.editTextUserName.getText().equals("")){
                showToast(getResources().getString(R.string.enter_username));
            }else {
                loginViewModel.getForget(binding.editTextUserName.getText().toString(),tenantId);
            }
        });

        /*camera_open_id = (Button)findViewById(R.id.camera_button);
        click_image_id = (ImageView)findViewById(R.id.click_image);

        // Camera_open button is for open the camera
        // and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // Create the camera_intent ACTION_IMAGE_CAPTURE
                // it will open the camera for capture the image
                Intent camera_intent
                        = new Intent(MediaStore
                        .ACTION_IMAGE_CAPTURE);

                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which stor the image in memory
            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }*/

        initViewModel();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    private void initViewModel() {
        loginViewModel.getLoginResponseData().observe(this,loginResponseModel -> {
            if(loginResponseModel != null){
                //showToast(loginResponseModel.getUser().getState().toString());
                loginResponseModelData =loginResponseModel;
                role.addAll(loginResponseModel.getUser().getRoles());
                //role = loginResponseModel.getMobileAppFunctionalitiesAccess().getRole();
                loginFirst = false;
                accessToken = loginResponseModel.getAccessToken();
                organizationIdName = loginResponseModel.getUser().getOrganizationIdName();
                country = loginResponseModel.getUser().getCountry();
                emailId = loginResponseModel.getUser().getEmailId();
                Intent intent = new Intent(LoginActivity.this,DriverDetailsActivity.class);
                intent.putExtra("loginResponseModel",loginResponseModelData);
                startActivity(intent);
                //startActivity(new Intent(LoginActivity.this , DriverDetailsActivity.class));
            }else{
                showToast(getResources().getString(R.string.bad_crediential));
            }
        });


        loginViewModel.getUserDataDetails().observe(this,userEmailDetailsResponseModule -> {
            if(userEmailDetailsResponseModule != null){
                if(userEmailDetailsResponseModule.getData() != null){
                    String clint = "";
                    if(userEmailDetailsResponseModule.getData().getUser().getClientId() != null){
                        tenantId = userEmailDetailsResponseModule.getData().getUser().getClientId();
                    }else{
                        tenantId="";
                    }

                    loginFirst = true;
                    clint = userEmailDetailsResponseModule.getData().getUser().getClientId();
                    if(/*userEmailDetailsResponseModule.getData().getUser().getClientId()*/clint != null){
                        clientId = userEmailDetailsResponseModule.getData().getUser().getClientId();
                    }else{
                        clientId = "null";
                    }

                }else{

                }
            }else {

            }
        });

        loginViewModel.getPassword().observe(this,forgotPasswordResponseModel -> {
            if(forgotPasswordResponseModel != null){
                if(forgotPasswordResponseModel.getData() != null){
                    showToast(forgotPasswordResponseModel.getStatusMsg());
                }else{
                    showToast(getResources().getString(R.string.no_data));
                }
            }else {
                showToast(getResources().getString(R.string.something_wrong));
            };
        });
    }
}