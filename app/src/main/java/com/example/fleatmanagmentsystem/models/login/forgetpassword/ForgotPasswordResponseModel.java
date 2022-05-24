package com.example.fleatmanagmentsystem.models.login.forgetpassword;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponseModel implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Creator<ForgotPasswordResponseModel> CREATOR = new Creator<ForgotPasswordResponseModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ForgotPasswordResponseModel createFromParcel(android.os.Parcel in) {
            return new ForgotPasswordResponseModel(in);
        }

        public ForgotPasswordResponseModel[] newArray(int size) {
            return (new ForgotPasswordResponseModel[size]);
        }

    }
            ;

    protected ForgotPasswordResponseModel(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ForgotPasswordResponseModel() {
    }

    /**
     *
     * @param statusMsg
     * @param data
     * @param errorCode
     * @param status
     */
    public ForgotPasswordResponseModel(String status, String statusMsg, String errorCode, Data data) {
        super();
        this.status = status;
        this.statusMsg = statusMsg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(statusMsg);
        dest.writeValue(errorCode);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }
}
