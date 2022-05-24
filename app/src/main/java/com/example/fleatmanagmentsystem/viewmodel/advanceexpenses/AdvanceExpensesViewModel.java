package com.example.fleatmanagmentsystem.viewmodel.advanceexpenses;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListData;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.AdvanceDetailData;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.AdvanceDetailResponseModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelExpensesRequestModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.imageupload.UploadImageResponseModule;

import javax.inject.Inject;

import okhttp3.MultipartBody;

public class AdvanceExpensesViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<DriverTripIdListResponseModule> driverTripIdListResponseModuleLiveData;
    private LiveData<AdvanceExpensesResponseModule> advanceExpensesResponseModuleLiveData;
    private LiveData<UploadImageResponseModule> uploadImageResponseModuleLiveData;
    private LiveData<FuelExpensesResponseModule> fuelExpensesResponseModuleLiveData;
    private LiveData<AdvanceDetailResponseModule> advanceDetailResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public AdvanceExpensesViewModel(DataRepository repository) {
        this.repository = repository;
        this.driverTripIdListResponseModuleLiveData = repository.getDriverTripIds();
        this.advanceExpensesResponseModuleLiveData = repository.getAdvanceExpensesStaringData();
        this.uploadImageResponseModuleLiveData = repository.getImageName();
        this.fuelExpensesResponseModuleLiveData = repository.getFuelExpenseAdvanceAndExp();
        this.advanceDetailResponseModuleLiveData = repository.getAdvanceDetailExp();
    }

    public void getAdvanceExpenses(String tripId, String accessToken, String tenantId) {
        repository.getAdvanceExpensesTripDetail(tripId,accessToken,tenantId);
    }

    public void getDriverTripIdList(String driverId, String accessToken, String tenantId) {
        repository.getAllDriverTripIds(driverId,accessToken,tenantId);
    }

    public LiveData<DriverTripIdListResponseModule> getDriverTripId(){
        return driverTripIdListResponseModuleLiveData;
    }

    public void uploadImage(MultipartBody.Part filePart,String accessToken,String tenantId) {
        repository.getImageNewName(filePart,accessToken,tenantId);
    }

    public LiveData<AdvanceExpensesResponseModule> getAdvanceExpensesStartData(){
        return advanceExpensesResponseModuleLiveData;
    }

    public LiveData<UploadImageResponseModule> getImage(){
        return uploadImageResponseModuleLiveData;
    }


    public void getFuelExpensesDone(FuelExpensesRequestModule fuelExpensesRequestModule, String accessToken, String tenantId) {
        repository.getFuelExpense(fuelExpensesRequestModule,accessToken,tenantId);
    }

    public LiveData<FuelExpensesResponseModule> getFuelExp(){
        return fuelExpensesResponseModuleLiveData;
    }

    public void getAdvanceDetails(String tripId, String accessToken, String tenantId) {
        repository.getAdvanceDetailData(tripId,accessToken,tenantId);
    }

    public LiveData<AdvanceDetailResponseModule> getAdvanceExp(){
        return advanceDetailResponseModuleLiveData;
    }
}
