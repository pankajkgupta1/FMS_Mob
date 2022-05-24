package com.example.fleatmanagmentsystem.models.login.imageupload;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadImageResponseModule implements Parcelable
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
    private UploadImageData data;
    public final static Creator<UploadImageResponseModule> CREATOR = new Creator<UploadImageResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UploadImageResponseModule createFromParcel(android.os.Parcel in) {
            return new UploadImageResponseModule(in);
        }

        public UploadImageResponseModule[] newArray(int size) {
            return (new UploadImageResponseModule[size]);
        }

    }
            ;

    protected UploadImageResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((UploadImageData) in.readValue((UploadImageData.class.getClassLoader())));
    }

    public UploadImageResponseModule() {
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

    public UploadImageData getData() {
        return data;
    }

    public void setData(UploadImageData data) {
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
