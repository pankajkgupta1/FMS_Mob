package com.example.fleatmanagmentsystem.viewmodel;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.LoginRequestModel;
import com.example.fleatmanagmentsystem.models.login.LoginResponseModel;
import com.example.fleatmanagmentsystem.models.login.forgetpassword.ForgotPasswordResponseModel;
import com.example.fleatmanagmentsystem.models.login.useremaildetails.UserEmailDetailsResponseModule;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<LoginResponseModel> loginResponseModelLiveData;
    private LiveData<UserEmailDetailsResponseModule> userEmailDetailsResponseModuleLiveData;
    private LiveData<ForgotPasswordResponseModel> forgotPasswordResponseModelLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public LoginViewModel(DataRepository repository) {
        this.repository = repository;
        this.loginResponseModelLiveData= repository.loginResponseData();
        this.userEmailDetailsResponseModuleLiveData= repository.UserEmailDetails();
        this.forgotPasswordResponseModelLiveData= repository.getForgotPassword();
    }

    public void getLoginData(/*String tanent,*/LoginRequestModel loginRequestModel,String tenantId) {
        repository.getLoginData(/*tanent,*/loginRequestModel,tenantId);
    }

    public LiveData<LoginResponseModel>getLoginResponseData(){
        return loginResponseModelLiveData;
    }

    public void getUserData(String emailId) {
        repository.getUserEmailData(emailId);
    }

    public LiveData<UserEmailDetailsResponseModule> getUserDataDetails(){
        return userEmailDetailsResponseModuleLiveData;
    }

    public void getForget(String email, String tenantId) {
        repository.getForgetPass(email,tenantId);
    }

    public LiveData<ForgotPasswordResponseModel> getPassword(){
        return forgotPasswordResponseModelLiveData;
    }
}
