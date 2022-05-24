package com.example.fleatmanagmentsystem.models.login.drivertripIdlist;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverTripIdListData implements Parcelable {

    @SerializedName("confirmationList")
    @Expose
    private List<Confirmation> confirmationList = null;
    public final static Creator<DriverTripIdListData> CREATOR = new Creator<DriverTripIdListData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DriverTripIdListData createFromParcel(android.os.Parcel in) {
            return new DriverTripIdListData(in);
        }

        public DriverTripIdListData[] newArray(int size) {
            return (new DriverTripIdListData[size]);
        }

    }
            ;

    protected DriverTripIdListData(android.os.Parcel in) {
        in.readList(this.confirmationList, (Confirmation.class.getClassLoader()));
    }

    public DriverTripIdListData() {
    }

    public List<Confirmation> getConfirmationList() {
        return confirmationList;
    }

    public void setConfirmationList(List<Confirmation> confirmationList) {
        this.confirmationList = confirmationList;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(confirmationList);
    }

    public int describeContents() {
        return 0;
    }

}
