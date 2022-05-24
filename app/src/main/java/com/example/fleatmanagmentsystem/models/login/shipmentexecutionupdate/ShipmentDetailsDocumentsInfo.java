package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentDetailsDocumentsInfo implements Parcelable
{

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("sequenceNumber")
    @Expose
    private Integer sequenceNumber;
    @SerializedName("documentId")
    @Expose
    private String documentId;
    @SerializedName("documentName")
    @Expose
    private String documentName;
    @SerializedName("documentType")
    @Expose
    private String documentType;
    @SerializedName("attachments")
    @Expose
    private List<String> attachments = null;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    public final static Creator<ShipmentDetailsDocumentsInfo> CREATOR = new Creator<ShipmentDetailsDocumentsInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentDetailsDocumentsInfo createFromParcel(android.os.Parcel in) {
            return new ShipmentDetailsDocumentsInfo(in);
        }

        public ShipmentDetailsDocumentsInfo[] newArray(int size) {
            return (new ShipmentDetailsDocumentsInfo[size]);
        }

    }
            ;

    protected ShipmentDetailsDocumentsInfo(android.os.Parcel in) {
        this.prefix = ((String) in.readValue((String.class.getClassLoader())));
        this.sequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.documentId = ((String) in.readValue((String.class.getClassLoader())));
        this.documentName = ((String) in.readValue((String.class.getClassLoader())));
        this.documentType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.attachments, (java.lang.String.class.getClassLoader()));
        this.remarks = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ShipmentDetailsDocumentsInfo() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(prefix);
        dest.writeValue(sequenceNumber);
        dest.writeValue(documentId);
        dest.writeValue(documentName);
        dest.writeValue(documentType);
        dest.writeList(attachments);
        dest.writeValue(remarks);
    }

    public int describeContents() {
        return 0;
    }

}
