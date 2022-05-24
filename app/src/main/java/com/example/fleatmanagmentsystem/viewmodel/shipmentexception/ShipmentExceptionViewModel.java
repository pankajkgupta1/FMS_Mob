package com.example.fleatmanagmentsystem.viewmodel.shipmentexception;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.imageupload.UploadImageResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.MaintenanceClosureResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusRequestModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecution.ShipmentExecutionResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;

import javax.inject.Inject;

import okhttp3.MultipartBody;

public class ShipmentExceptionViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<DriverTripIdListResponseModule> driverTripIdListResponseModuleLiveData;
    private LiveData<ShipmentLoadedResponseModule> shipmentLoadedResponseModuleLiveData;
    private LiveData<ShipmentExecutionResponseModule> shipmentExecutionResponseModuleLiveData;
    private LiveData<AdvanceExpensesResponseModule> advanceExpensesResponseModuleLiveData;
    private LiveData<ShipmentExecutionUpdateResponseModule> shipmentExecutionUpdateResponseModuleLiveData;
    private LiveData<UploadImageResponseModule> uploadImageResponseModuleLiveData;
    private LiveData<MaintenanceResponseModule> maintenanceResponseModuleLiveData;
    private LiveData<MaintenanceClosureResponseModule> maintenanceClosureResponseModuleLiveData;
    private LiveData<MaintenanceUpdateStatusResponseModule> maintenanceUpdateStatusResponseModuleLiveData;

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public ShipmentExceptionViewModel(DataRepository repository) {
        this.repository = repository;
        this.driverTripIdListResponseModuleLiveData = repository.getDriverTripIds();
        this.shipmentLoadedResponseModuleLiveData = repository.getShipmentLoadedLoadId();
        this.shipmentExecutionResponseModuleLiveData = repository.getShipmentExecutionDataStating();
        this.advanceExpensesResponseModuleLiveData = repository.getAdvanceExpensesStaringData();
        this.shipmentExecutionUpdateResponseModuleLiveData = repository.getShipmentExecutionDataUpdate();
        this.uploadImageResponseModuleLiveData = repository.getImageName();
        this.maintenanceResponseModuleLiveData = repository.getMaintenanceAssign();
        this.maintenanceClosureResponseModuleLiveData = repository.getMaintenanceCloserData();
        this.maintenanceUpdateStatusResponseModuleLiveData = repository.getMaintenanceUpdate();
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

    public void getShipmentExceptionStartDetails(String tripId, String accessToken, String tenantId) {
        repository.getShipmentExceptionStart(tripId,accessToken,tenantId);
    }

    public LiveData<ShipmentExecutionResponseModule>getShipmentExceptionStartData(){
        return shipmentExecutionResponseModuleLiveData;
    }

    public void getAdvanceExpenses(String tripId, String accessToken, String tenantId) {
        repository.getAdvanceExpensesTripDetail(tripId,accessToken,tenantId);
    }

    public LiveData<AdvanceExpensesResponseModule> getAdvanceExpensesStartData(){
        return advanceExpensesResponseModuleLiveData;
    }

    public void getShipmentExceptionUpdate(ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule, String accessToken, String tenantId) {
        repository.getShipmentExecutionWholeData(shipmentExecutionUpdateRequestModule,accessToken,tenantId);
    }

    public LiveData<ShipmentExecutionUpdateResponseModule> getShipmentExecutionUpdateSavaData(){
        return shipmentExecutionUpdateResponseModuleLiveData;
    }

    public void uploadImage(MultipartBody.Part filePart,String accessToken,String tenantId) {
        repository.getImageNewName(filePart,accessToken,tenantId);
    }

    public LiveData<UploadImageResponseModule> getImage(){
        return uploadImageResponseModuleLiveData;
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
