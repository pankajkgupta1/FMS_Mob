package com.example.fleatmanagmentsystem.networking;
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

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkConfig {

    @FormUrlEncoded
    //@POST("oauth/token?{tenant}")
    @POST("oauth/token")
    Observable<LoginResponseModel> getLoginDetail(/*@Query("tenant") String tenant,*/@Field("grant_type")String grant_type, @Field("username")String username
            ,@Field("password")String password,@Field("tenantId")String tenantId/*,LoginRequestModel requestBody@Path("userId") String userId, @Path("password") String password, @Path("loginType") String loginType*/);

    @POST("user/logout")
    Observable<LogoutResponseModule> getLogout( @Query("access_token") String access_token,@Query("tenantId") String tenantId);

    @Multipart
    @POST("fileStore/uploadFilesAndImages")
    Observable<UploadImageResponseModule> getAdvanceExpensesTripImages(@Part MultipartBody.Part file, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    //@GET("https://dev.fruisce.in/fms/driver/getDriverByEmailId?{emailId},{access_token}")
    @GET("driver/getDriverByEmailId")
    Observable<DriverDetailsResponseModule> getDriverDetails(@Query("emailId") String emailId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("itinerary/getTripsData")
    Observable<TripDetailResponseModule> getTripDetailsData(@Query("type") String type, @Query("access_token") String access_token, @Query("tenantId") String tenantId);


    //Get tripId list
    @GET("confirmation/getAcceptedTripsByDriverId")
    Observable<DriverTripIdListResponseModule> getTripIdList(@Query("driverId") String driverId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("confirmation/getConfirmationStatus")
    Observable<TripStatusResponseModule> getTripAcceptOrRejectData(@Query("designation") String designation, @Query("tripId") String tripId
            , @Query("status") String status, @Query("organizationIdName") String organizationIdName, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("fileStore/viewFilesAndImages/fileName:{fileName}")
    Observable<DriverImageResponseModule> getDriverImageView(@Path("fileName")String fileName, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("trip/getTripDataByTripId/tripId:{tripId}")
    Observable<AdvanceExpensesResponseModule> getAdvanceExpensesFullData(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("fileStore/viewFilesAndImages/tripId:{tripId}")
    Observable<AdvanceExpensesResponseModule> getAdvanceExpenses(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("tripAdvance/getTripAdvanceDataByTripId/tripId:{tripId}")
    Observable<AdvanceDetailResponseModule> getAdvanceDetail(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    //@GET("tripExpenses/getTripExpensesDataByTripId/tripId:{tripId}")
    //Observable<> getTripExpensesDataByTripId(@Path("tripId")String tripId, @Query("access_token") String access_token);

    @POST("tripExpenses/saveorUpdateTripExpensesData")
    Observable<FuelExpensesResponseModule> getFuelExpensesData(@Body FuelExpensesRequestModule fuelExpensesRequestModule, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("user/getUserDataByEmailId/emailId:{emailId}")
    Observable<UserEmailDetailsResponseModule> getUserEmailDataByEmail(@Path("emailId")String emailId);

    @GET("tripExpenses/getTripExpensesDataByTripId/tripId:{tripId}")
    Observable<ExpensesHistoryResponseModule> getReport(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("trip/getTripDataByTripId/tripId:{tripId}")
    Observable<ShipmentLoadedResponseModule> getShipmentLoadId(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("shipmentExecution/getShipmentExecutionDataByTripId/tripId:{tripId}")
    Observable<ShipmentExecutionResponseModule> getShipmentExecutionStatingDetail(@Path("tripId")String tripId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("maintanenceWorkOrderPlan/getOpenMaintanenceWorkOrdersByDriverId")
    Observable<MaintenanceResponseModule> getMaintanenceAssignedServ(@Query("driverId") String driverId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @GET("maintanenceStatusLog/getMaintanenceStatusLogByWorkOrderId")
    Observable<MaintenanceClosureResponseModule> getMaintenanceClosureDetailsData(@Query("workOrderId") String workOrderId, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @POST("user/sendResetPasswordLink")
    Observable<ForgotPasswordResponseModel> getForgotPasswordData(@Query("emailId") String emailId, @Query("tenantId") String tenantId);

    @POST("shipmentExecution/saveorUpdateShipmentExecutionData")
    Observable<ShipmentExecutionUpdateResponseModule> getShipmentExecutionUpdateDetail(@Body ShipmentExecutionUpdateRequestModule shipmentExecutionUpdateRequestModule, @Query("access_token") String access_token, @Query("tenantId") String tenantId);

    @POST("maintanenceStatusLog/saveorUpdateMaintanenceStatusLog")
    Observable<MaintenanceUpdateStatusResponseModule> getMaintenanceUpdatedStatusData(@Body MaintenanceUpdateStatusRequestModule maintenanceUpdateStatusRequestModule, @Query("access_token") String access_token, @Query("tenantId") String tenantId);
}