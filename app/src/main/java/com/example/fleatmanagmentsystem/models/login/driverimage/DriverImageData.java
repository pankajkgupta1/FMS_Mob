package com.example.fleatmanagmentsystem.models.login.driverimage;

import android.os.Parcel;
import android.os.Parcelable;

public class DriverImageData implements Parcelable {

    private String filesOrImages;

    protected DriverImageData(Parcel in) {
        filesOrImages = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(filesOrImages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DriverImageData> CREATOR = new Creator<DriverImageData>() {
        @Override
        public DriverImageData createFromParcel(Parcel in) {
            return new DriverImageData(in);
        }

        @Override
        public DriverImageData[] newArray(int size) {
            return new DriverImageData[size];
        }
    };

    public String getFilesOrImages() {
        return filesOrImages;
    }
    public void setFilesOrImages(String filesOrImages) {
        this.filesOrImages = filesOrImages;
    }
}
