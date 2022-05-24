package com.example.fleatmanagmentsystem.viewmodel.tripdetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.tripdetail.TripDetailResponseModule;
import com.example.fleatmanagmentsystem.models.login.tripstatus.TripStatusResponseModule;

import javax.inject.Inject;

public class TripDetailsViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<TripDetailResponseModule> tripDetailResponseModuleLiveData;
    private LiveData<TripStatusResponseModule> tripStatusResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public TripDetailsViewModel(DataRepository repository) {
        this.repository = repository;
        this.tripDetailResponseModuleLiveData = repository.getTripsData();
        this.tripStatusResponseModuleLiveData = repository.tripStatus();
    }

    public void getUserTripDetails(String accepted, String accessToken, String tenantId) {
        repository.getTripDetailsData(accepted,accessToken,tenantId);
    }

    public LiveData<TripDetailResponseModule> getTripInfo(){
        return tripDetailResponseModuleLiveData;
    }

    public void getTripAcceptOrReject(String role, String tripId, String status, String organizationIdName, String accessToken, String tenantId) {
        repository.getTripStatusAcptOrRej(role,tripId,status,organizationIdName,accessToken,tenantId);
    }

    public LiveData<TripStatusResponseModule> getTripStatusActorRej(){
        return tripStatusResponseModuleLiveData;
    }
}
