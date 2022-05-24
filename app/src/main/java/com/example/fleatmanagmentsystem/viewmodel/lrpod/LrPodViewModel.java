package com.example.fleatmanagmentsystem.viewmodel.lrpod;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;

import javax.inject.Inject;

public class LrPodViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<DriverTripIdListResponseModule> driverTripIdListResponseModuleLiveData;
    private LiveData<ShipmentLoadedResponseModule> shipmentLoadedResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();

    }

    @Inject
    public LrPodViewModel(DataRepository repository) {
        this.repository = repository;
        this.driverTripIdListResponseModuleLiveData = repository.getDriverTripIds();
        this.shipmentLoadedResponseModuleLiveData = repository.getShipmentLoadedLoadId();
    }

    public void getDriverTripIdList(String driverId, String accessToken, String tenantId) {
        repository.getAllDriverTripIds(driverId,accessToken,tenantId);
    }

    public LiveData<DriverTripIdListResponseModule> getDriverTripId(){
        return driverTripIdListResponseModuleLiveData;
    }

    public void getShipmentExceptionLoadId(String tripId, String accessToken, String tenantId) {
        repository.getShipmentLoadId(tripId,accessToken,tenantId);
    }

    public LiveData<ShipmentLoadedResponseModule> getLoadId(){
        return shipmentLoadedResponseModuleLiveData;
    }
}
