package com.example.fleatmanagmentsystem.models.login.imageupload;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadImageData implements Parcelable
{

    @SerializedName("fileName")
    @Expose
    private String fileName;
    public final static Creator<UploadImageData> CREATOR = new Creator<UploadImageData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UploadImageData createFromParcel(android.os.Parcel in) {
            return new UploadImageData(in);
        }

        public UploadImageData[] newArray(int size) {
            return (new UploadImageData[size]);
        }

    }
            ;

    protected UploadImageData(android.os.Parcel in) {
        this.fileName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UploadImageData() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(fileName);
    }

    public int describeContents() {
        return 0;
    }

}
