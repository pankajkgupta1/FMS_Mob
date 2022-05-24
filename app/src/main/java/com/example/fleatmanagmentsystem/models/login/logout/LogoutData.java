package com.example.fleatmanagmentsystem.models.login.logout;

import android.os.Parcelable;

public class LogoutData implements Parcelable {
    public final static Creator<LogoutData> CREATOR = new Creator<LogoutData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LogoutData createFromParcel(android.os.Parcel in) {
            return new LogoutData(in);
        }

        public LogoutData[] newArray(int size) {
            return (new LogoutData[size]);
        }

    }
            ;

    protected LogoutData(android.os.Parcel in) {
    }

    public LogoutData() {
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
    }

    public int describeContents() {
        return 0;
    }
}
