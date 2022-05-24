package com.example.fleatmanagmentsystem.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.driverdetails.DriverDetailsResponseModule;
import com.example.fleatmanagmentsystem.models.login.driverimage.DriverImageResponseModule;
import com.example.fleatmanagmentsystem.models.login.logout.LogoutResponseModule;

import javax.inject.Inject;

public class DriverDetailViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<DriverDetailsResponseModule> driverDetailsResponseModuleLiveData;
    private LiveData<DriverImageResponseModule> driverImageResponseModelLiveData;
    private LiveData<LogoutResponseModule> logoutResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public DriverDetailViewModel(DataRepository repository) {
        this.repository = repository;
        this.driverDetailsResponseModuleLiveData= repository.getDriver();
        this.driverImageResponseModelLiveData= repository.getDriverImageData();
        this.logoutResponseModuleLiveData= repository.getLogout();
    }

    public void getDriveDetailsByEmail(String emailId, String accessToken, String tenantId) {
        repository.getDriverDetailsWithEmail(emailId,accessToken,tenantId);
    }

    public LiveData<DriverDetailsResponseModule> gerDriverDetailsEmail(){
        return driverDetailsResponseModuleLiveData;
    }

    public void getImageDetails(String pic, String accessToken, String tenantId) {
        repository.getDriverImage(pic,accessToken,tenantId);
    }

    public LiveData<DriverImageResponseModule> getImage(){
        return driverImageResponseModelLiveData;
    }

    public void getUserLogout(String accessToken,String tenantId) {
        repository.getLogoutUserData(accessToken,tenantId);
    }

    public LiveData<LogoutResponseModule> getLogout(){
        return logoutResponseModuleLiveData;
    }
}
