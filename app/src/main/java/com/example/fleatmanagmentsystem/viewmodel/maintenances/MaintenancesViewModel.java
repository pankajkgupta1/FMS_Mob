package com.example.fleatmanagmentsystem.viewmodel.maintenances;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.MaintenanceClosureResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusRequestModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusResponseModule;

import javax.inject.Inject;

public class MaintenancesViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<MaintenanceResponseModule> maintenanceResponseModuleLiveData;
    private LiveData<MaintenanceClosureResponseModule> maintenanceClosureResponseModuleLiveData;
    private LiveData<MaintenanceUpdateStatusResponseModule> maintenanceUpdateStatusResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public MaintenancesViewModel(DataRepository repository) {
        this.repository = repository;
        this.maintenanceResponseModuleLiveData = repository.getMaintenanceAssign();
        this.maintenanceClosureResponseModuleLiveData = repository.getMaintenanceCloserData();
        this.maintenanceUpdateStatusResponseModuleLiveData = repository.getMaintenanceUpdate();
    }

    public void getMaintenanceAssignedServices(String driverId, String accessToken, String tenantId) {
        repository.getMaintenanceAssignSer(driverId,accessToken,tenantId);
    }

    public LiveData<MaintenanceResponseModule> getMaintenanceAssServ(){
        return maintenanceResponseModuleLiveData;
    }

    public void getMaintenanceStatusDetails(String loadId, String accessToken, String tenantId) {
        repository.getMaintenanceClosureDetails(loadId,accessToken,tenantId);
    }

    public LiveData<MaintenanceClosureResponseModule> getMaintenanceCloser(){
        return maintenanceClosureResponseModuleLiveData;
    }

    public void getMaintenanceUpdateStatus(MaintenanceUpdateStatusRequestModule maintenanceUpdateStatusRequestModule, String accessToken, String tenantId) {
        repository.getMaintenanceUpdateStatusDetail(maintenanceUpdateStatusRequestModule,accessToken,tenantId);
    }

    public LiveData<MaintenanceUpdateStatusResponseModule> getMaintenanceUpdate(){
        return maintenanceUpdateStatusResponseModuleLiveData;
    }
}
