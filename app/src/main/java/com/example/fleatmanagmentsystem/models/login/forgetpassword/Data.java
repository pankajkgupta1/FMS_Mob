package com.example.fleatmanagmentsystem.models.login.forgetpassword;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable
{

    @SerializedName("resetPassword link sending failed")
    @Expose
    private Boolean resetPasswordLinkSendingFailed;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(android.os.Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(android.os.Parcel in) {
        this.resetPasswordLinkSendingFailed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param resetPasswordLinkSendingFailed
     */
    public Data(Boolean resetPasswordLinkSendingFailed) {
        super();
        this.resetPasswordLinkSendingFailed = resetPasswordLinkSendingFailed;
    }

    public Boolean getResetPasswordLinkSendingFailed() {
        return resetPasswordLinkSendingFailed;
    }

    public void setResetPasswordLinkSendingFailed(Boolean resetPasswordLinkSendingFailed) {
        this.resetPasswordLinkSendingFailed = resetPasswordLinkSendingFailed;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(resetPasswordLinkSendingFailed);
    }

    public int describeContents() {
        return 0;
    }

}
