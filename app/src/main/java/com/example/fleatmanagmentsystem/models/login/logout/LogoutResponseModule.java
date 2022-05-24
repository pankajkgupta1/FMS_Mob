package com.example.fleatmanagmentsystem.models.login.logout;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResponseModule implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("errorCode")
    @Expose
    private Object errorCode;
    @SerializedName("data")
    @Expose
    private LogoutData data;
    public final static Creator<LogoutResponseModule> CREATOR = new Creator<LogoutResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LogoutResponseModule createFromParcel(android.os.Parcel in) {
            return new LogoutResponseModule(in);
        }

        public LogoutResponseModule[] newArray(int size) {
            return (new LogoutResponseModule[size]);
        }

    }
            ;

    protected LogoutResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((LogoutData) in.readValue((LogoutData.class.getClassLoader())));
    }

    public LogoutResponseModule() {
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

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public LogoutData getData() {
        return data;
    }

    public void setData(LogoutData data) {
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
