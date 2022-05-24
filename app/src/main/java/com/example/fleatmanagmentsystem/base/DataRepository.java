package com.example.fleatmanagmentsystem.base;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.fleatmanagmentsystem.models.login.LoginRequestModel;
import com.example.fleatmanagmentsystem.models.login.LoginResponseModel;
import com.example.fleatmanagmentsystem.models.login.advanceexpenses.AdvanceExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.driverdetails.DriverDetailsResponseModule;
import com.example.fleatmanagmentsystem.models.login.driverimage.DriverImageResponseModule;
import com.example.fleatmanagmentsystem.models.login.drivertripIdlist.DriverTripIdListResponseModule;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.ExpensesHistoryResponseModule;
import com.example.fleatmanagmentsystem.models.login.forgetpassword.ForgotPasswordResponseModel;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.AdvanceDetailResponseModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelExpensesRequestModule;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.FuelExpensesResponseModule;
import com.example.fleatmanagmentsystem.models.login.imageupload.UploadImageResponseModule;
import com.example.fleatmanagmentsystem.models.login.logout.LogoutResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.MaintenanceClosureResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusRequestModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecution.ShipmentExecutionResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentExecutionUpdateResponseModule;
import com.example.fleatmanagmentsystem.models.login.shipmentloaded.ShipmentLoadedResponseModule;
import com.example.fleatmanagmentsystem.models.login.tripdetail.TripDetailResponseModule;
import com.example.fleatmanagmentsystem.models.login.tripstatus.TripStatusResponseModule;
import com.example.fleatmanagmentsystem.models.login.useremaildetails.UserEmailDetailsResponseModule;
import com.example.fleatmanagmentsystem.networking.NetworkConfig;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

public class DataRepository implements BaseViewModel {

    private AppSchedulerProvider appSchedulerProvider;
    private Context context;
    private NetworkConfig networkConfig;

    private MutableLiveData<LoginResponseModel> loginResponseModelMutableLiveData;
    private MutableLiveData<UserEmailDetailsResponseModule> userEmailDetailsResponseModuleMutableLiveData;
    private MutableLiveData<DriverDetailsResponseModule> driverDetailsResponseModuleMutableLiveData;
    private MutableLiveData<DriverImageResponseModule> driverImageResponseModelMutableLiveData;
    private MutableLiveData<TripDetailResponseModule> tripDetailResponseModuleMutableLiveData;
    private MutableLiveData<TripStatusResponseModule> tripStatusResponseModuleMutableLiveData;
    private MutableLiveData<LogoutResponseModule> logoutResponseModuleMutableLiveData;
    private MutableLiveData<DriverTripIdListResponseModule> driverTripIdListResponseModuleMutableLiveData;
    private MutableLiveData<AdvanceExpensesResponseModule> advanceExpensesResponseModuleMutableLiveData;
    private MutableLiveData<UploadImageResponseModule> uploadImageResponseModuleMutableLiveData;
    private MutableLiveData<FuelExpensesResponseModule> fuelExpensesResponseModuleMutableLiveData;
    private MutableLiveData<AdvanceDetailResponseModule> advanceDetailResponseModuleMutableLiveData;
    private MutableLiveData<ExpensesHistoryResponseModule> expensesHistoryResponseModuleMutableLiveData;
    private MutableLiveData<ShipmentLoadedResponseModule> shipmentLoadedResponseModuleMutableLiveData;
    private MutableLiveData<ShipmentExecutionResponseModule> shipmentExecutionResponseModuleMutableLiveData;
    private MutableLiveData<ShipmentExecutionUpdateResponseModule> shipmentExecutionUpdateResponseModuleMutableLiveData;
    private MutableLiveData<MaintenanceResponseModule> maintenanceResponseModuleMutableLiveData;
    private MutableLiveData<MaintenanceClosureResponseModule> maintenanceClosureResponseModuleMutableLiveData;
    private MutableLiveData<MaintenanceUpdateStatusResponseModule> maintenanceUpdateStatusResponseModuleMutableLiveData;
    private MutableLiveData<ForgotPasswordResponseModel> forgotPasswordResponseModelMutableLiveData;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    public DataRepository(AppSchedulerProvider appSchedulerProvider, Context context, NetworkConfig networkConfig) {
        this.appSchedulerProvider = appSchedulerProvider;
        this.context = context;
        this.networkConfig = networkConfig;
        loginResponseModelMutableLiveData = new MutableLiveData<>();
        userEmailDetailsResponseModuleMutableLiveData = new MutableLiveData<>();
        driverDetailsResponseModuleMutableLiveData = new MutableLiveData<>();
        driverImageResponseModelMutableLiveData = new MutableLiveData<>();
        tripDetailResponseModuleMutableLiveData = new MutableLiveData<>();
        tripStatusResponseModuleMutableLiveData = new MutableLiveData<>();
        logoutResponseModuleMutableLiveData = new MutableLiveData<>();
        driverTripIdListResponseModuleMutableLiveData = new MutableLiveData<>();
        advanceExpensesResponseModuleMutableLiveData = new MutableLiveData<>();
        uploadImageResponseModuleMutableLiveData = new MutableLiveData<>();
        fuelExpensesResponseModuleMutableLiveData = new MutableLiveData<>();
        advanceDetailResponseModuleMutableLiveData = new MutableLiveData<>();
        expensesHistoryResponseModuleMutableLiveData = new MutableLiveData<>();
        shipmentLoadedResponseModuleMutableLiveData = new MutableLiveData<>();
        shipmentExecutionResponseModuleMutableLiveData = new MutableLiveData<>();
        shipmentExecutionUpdateResponseModuleMutableLiveData = new MutableLiveData<>();
        maintenanceResponseModuleMutableLiveData = new MutableLiveData<>();
        maintenanceClosureResponseModuleMutableLiveData = new MutableLiveData<>();
        maintenanceUpdateStatusResponseModuleMutableLiveData = new MutableLiveData<>();
        forgotPasswordResponseModelMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public void onClear() {
        disposables.clear();
    }

    public void getLoginData(/*String tanent ,*/LoginRequestModel loginRequestModel,String tenantId) {
        networkConfig.getLoginDetail(/*tanent,*/loginRequestModel.getgrant_type(),loginRequestModel.getusername(),loginRequestModel.getPassword(),tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<LoginResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(LoginResponseModel loginResponseModel) {
                        loginResponseModelMutableLiveData.postValue(loginResponseModel);
                        //Log.e("working","yes");
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginResponseModelMutableLiveData.postValue(null);
                        e.printStackTrace();
                        //Log.e("fail","no");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<LoginResponseModel> loginResponseData(){
        return loginResponseModelMutableLiveData;
    }

    public void getUserEmailData(String emailId) {
        networkConfig.getUserEmailDataByEmail(emailId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<UserEmailDetailsResponseModule>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(UserEmailDetailsResponseModule userEmailDetailsResponseModule) {
                        userEmailDetailsResponseModuleMutableLiveData.postValue(userEmailDetailsResponseModule);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userEmailDetailsResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<UserEmailDetailsResponseModule> UserEmailDetails(){
        return userEmailDetailsResponseModuleMutableLiveData;
    }

    public void getDriverDetailsWithEmail(String emailId, String accessToken, String tenantId) {
        networkConfig.getDriverDetails(emailId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<DriverDetailsResponseModule>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(DriverDetailsResponseModule driverDetailsResponseModule) {
                        driverDetailsResponseModuleMutableLiveData.postValue(driverDetailsResponseModule);
                    }

                    @Override
                    public void onError(Throwable e) {
                        driverDetailsResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<DriverDetailsResponseModule> getDriver(){
        return driverDetailsResponseModuleMutableLiveData;
    }

    public void getDriverImage(String pic, String accessToken, String tenantId) {
        networkConfig.getDriverImageView(pic, accessToken, tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<DriverImageResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull DriverImageResponseModule driverImageResponseModule) {
                        driverImageResponseModelMutableLiveData.postValue(driverImageResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        driverImageResponseModelMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<DriverImageResponseModule> getDriverImageData(){
        return driverImageResponseModelMutableLiveData;
    }

    public void getTripDetailsData(String accepted, String accessToken, String tenantId) {
        networkConfig.getTripDetailsData(accepted,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<TripDetailResponseModule>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(TripDetailResponseModule tripDetailResponseModule) {
                        tripDetailResponseModuleMutableLiveData.postValue(tripDetailResponseModule);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tripDetailResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<TripDetailResponseModule> getTripsData(){
        return tripDetailResponseModuleMutableLiveData;
    }

    public void getTripStatusAcptOrRej(String role, String tripId, String status, String organizationIdName, String accessToken, String tenantId) {
        networkConfig.getTripAcceptOrRejectData(role,tripId,status,organizationIdName,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<TripStatusResponseModule>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(TripStatusResponseModule tripStatusResponseModule) {
                        tripStatusResponseModuleMutableLiveData.postValue(tripStatusResponseModule);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tripStatusResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<TripStatusResponseModule> tripStatus(){
        return tripStatusResponseModuleMutableLiveData;
    }

    public void getLogoutUserData(String accessToken,String tenantId) {
        networkConfig.getLogout(accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<LogoutResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull LogoutResponseModule logoutResponseModule) {
                        logoutResponseModuleMutableLiveData.postValue(logoutResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        logoutResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<LogoutResponseModule> getLogout(){
        return logoutResponseModuleMutableLiveData;
    }

    public void getAdvanceExpensesTripDetail(String tripId, String accessToken, String tenantId) {
        networkConfig.getAdvanceExpensesFullData(tripId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<AdvanceExpensesResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull AdvanceExpensesResponseModule advanceExpensesResponseModule) {
                        advanceExpensesResponseModuleMutableLiveData.postValue(advanceExpensesResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        advanceExpensesResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<AdvanceExpensesResponseModule> getAdvanceExpensesStaringData(){
        return advanceExpensesResponseModuleMutableLiveData;
    }

    public void getAllDriverTripIds(String driverId, String accessToken, String tenantId) {
        networkConfig.getTripIdList(driverId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<DriverTripIdListResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull DriverTripIdListResponseModule driverTripIdListResponseModule) {
                        driverTripIdListResponseModuleMutableLiveData.postValue(driverTripIdListResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        driverTripIdListResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<DriverTripIdListResponseModule> getDriverTripIds(){
        return driverTripIdListResponseModuleMutableLiveData;
    }

    public void getImageNewName(MultipartBody.Part filePart,String accessToken,String tenantId) {
        networkConfig.getAdvanceExpensesTripImages(filePart,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<UploadImageResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull UploadImageResponseModule uploadImageResponseModule) {
                        uploadImageResponseModuleMutableLiveData.postValue(uploadImageResponseModule);
                        Log.e("imageData","----->"+uploadImageResponseModule.getData().getFileName());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        uploadImageResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<UploadImageResponseModule> getImageName(){
        return uploadImageResponseModuleMutableLiveData;
    }

    public void getFuelExpense(FuelExpensesRequestModule fuelExpensesRequestModule, String accessToken, String tenantId) {
        networkConfig.getFuelExpensesData(fuelExpensesRequestModule,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                    .subscribe(new Observer<FuelExpensesResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull FuelExpensesResponseModule fuelExpensesResponseModule) {
                        fuelExpensesResponseModuleMutableLiveData.postValue(fuelExpensesResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        fuelExpensesResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<FuelExpensesResponseModule> getFuelExpenseAdvanceAndExp(){
        return fuelExpensesResponseModuleMutableLiveData;
    }

    public void getAdvanceDetailData(String tripId, String accessToken, String tenantId) {
        networkConfig.getAdvanceDetail(tripId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<AdvanceDetailResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull AdvanceDetailResponseModule advanceDetailResponseModule) {
                        advanceDetailResponseModuleMutableLiveData.postValue(advanceDetailResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        advanceDetailResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<AdvanceDetailResponseModule> getAdvanceDetailExp(){
        return advanceDetailResponseModuleMutableLiveData;
    }

    public void getExpensesHistory(String tripId, String accessToken, String tenantId) {
        networkConfig.getReport(tripId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<ExpensesHistoryResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull ExpensesHistoryResponseModule expensesHistoryResponseModule) {
                        expensesHistoryResponseModuleMutableLiveData.postValue(expensesHistoryResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        expensesHistoryResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ExpensesHistoryResponseModule> getExpensesHistory(){
        return expensesHistoryResponseModuleMutableLiveData;
    }

    public void getShipmentLoadId(String tripId, String accessToken, String tenantId) {
        networkConfig.getShipmentLoadId(tripId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<ShipmentLoadedResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull ShipmentLoadedResponseModule shipmentLoadedResponseModule) {
                        shipmentLoadedResponseModuleMutableLiveData.postValue(shipmentLoadedResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        shipmentLoadedResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ShipmentLoadedResponseModule> getShipmentLoadedLoadId(){
        return shipmentLoadedResponseModuleMutableLiveData;
    }

    public void getShipmentExceptionStart(String tripId, String accessToken, String tenantId) {
        networkConfig.getShipmentExecutionStatingDetail(tripId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<ShipmentExecutionResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull ShipmentExecutionResponseModule shipmentExecutionResponseModule) {
                        shipmentExecutionResponseModuleMutableLiveData.postValue(shipmentExecutionResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        shipmentExecutionResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ShipmentExecutionResponseModule> getShipmentExecutionDataStating(){
        return shipmentExecutionResponseModuleMutableLiveData;
    }

    public void getShipmentExecutionWholeData(ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule, String accessToken, String tenantId) {
        networkConfig.getShipmentExecutionUpdateDetail(shipmentExecutionUpdateRequestModule,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<ShipmentExecutionUpdateResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull ShipmentExecutionUpdateResponseModule shipmentExecutionUpdateResponseModule) {
                        shipmentExecutionUpdateResponseModuleMutableLiveData.postValue(shipmentExecutionUpdateResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        shipmentExecutionUpdateResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ShipmentExecutionUpdateResponseModule> getShipmentExecutionDataUpdate(){
        return shipmentExecutionUpdateResponseModuleMutableLiveData;
    }

    public void getMaintenanceAssignSer(String driverId, String accessToken, String tenantId) {
        networkConfig.getMaintanenceAssignedServ(driverId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<MaintenanceResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull MaintenanceResponseModule maintenanceResponseModule) {
                        maintenanceResponseModuleMutableLiveData.postValue(maintenanceResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        maintenanceResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<MaintenanceResponseModule> getMaintenanceAssign(){
        return maintenanceResponseModuleMutableLiveData;
    }

    public void getMaintenanceClosureDetails(String loadId, String accessToken, String tenantId) {
        networkConfig.getMaintenanceClosureDetailsData(loadId,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<MaintenanceClosureResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull MaintenanceClosureResponseModule maintenanceClosureResponseModule) {
                        maintenanceClosureResponseModuleMutableLiveData.postValue(maintenanceClosureResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        maintenanceClosureResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<MaintenanceClosureResponseModule> getMaintenanceCloserData(){
        return maintenanceClosureResponseModuleMutableLiveData;
    }

    public void getMaintenanceUpdateStatusDetail(MaintenanceUpdateStatusRequestModule maintenanceUpdateStatusRequestModule, String accessToken, String tenantId) {
        networkConfig.getMaintenanceUpdatedStatusData(maintenanceUpdateStatusRequestModule,accessToken,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<MaintenanceUpdateStatusResponseModule>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull MaintenanceUpdateStatusResponseModule maintenanceUpdateStatusResponseModule) {
                        maintenanceUpdateStatusResponseModuleMutableLiveData.postValue(maintenanceUpdateStatusResponseModule);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        maintenanceUpdateStatusResponseModuleMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public LiveData<MaintenanceUpdateStatusResponseModule> getMaintenanceUpdate(){
        return maintenanceUpdateStatusResponseModuleMutableLiveData;
    }

    public void getForgetPass(String email, String tenantId) {
        networkConfig.getForgotPasswordData(email,tenantId)
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe(new Observer<ForgotPasswordResponseModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(@NonNull ForgotPasswordResponseModel forgotPasswordResponseModel) {
                        forgotPasswordResponseModelMutableLiveData.postValue(forgotPasswordResponseModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        forgotPasswordResponseModelMutableLiveData.postValue(null);
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<ForgotPasswordResponseModel> getForgotPassword(){
        return forgotPasswordResponseModelMutableLiveData;
    }
}
