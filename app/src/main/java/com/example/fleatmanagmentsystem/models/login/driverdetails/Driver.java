package com.example.fleatmanagmentsystem.models.login.driverdetails;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Driver implements Parcelable {

    private String id;
    private String organizationIdName;
    private String driverId;
    private String driverName;
    private String dateOfBirth;
    private String dateOfJoining;
    private String linkAccount;
    private String driverType;
    private String driverBadgeNo;
    private String photo;
    private String addressLine;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String emailId;
    private String mobileNumber;
    private String languageKnown;
    private String languageWrite;
    private String qualification;
    private String panNo;
    private String adharNo;
    private String identificationfileUpload;
    private String bloodGroup;
    private String bodyIdentificationMarks;
    private String thumbImage;
    private String signature;
    private List<Object> adharImage = new ArrayList<Object>();
    private String licenseNo;
    private String issueDate;
    private String licenseClass;
    private String expiryDate;
    private String authority;
    private String licenceType;
    private String licenseDetailsFileUpload;
    private String licenseImage;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String cashOrPrepaidCardNo;
    private String fuelCardNo;
    private String cvv;
    private String documentCategoryId;
    private List<Object> documentsHelper = new ArrayList<Object>();
    private String tripStatus;
    private String statutoryRequirementStatus;
    private String driverBehaviour;
    private Boolean isTagged;
    private String driverStatus;

    protected Driver(Parcel in) {
        id = in.readString();
        organizationIdName = in.readString();
        driverId = in.readString();
        driverName = in.readString();
        dateOfBirth = in.readString();
        dateOfJoining = in.readString();
        linkAccount = in.readString();
        driverType = in.readString();
        driverBadgeNo = in.readString();
        photo = in.readString();
        addressLine = in.readString();
        city = in.readString();
        state = in.readString();
        country = in.readString();
        pin = in.readString();
        emailId = in.readString();
        mobileNumber = in.readString();
        languageKnown = in.readString();
        languageWrite = in.readString();
        qualification = in.readString();
        panNo = in.readString();
        adharNo = in.readString();
        identificationfileUpload = in.readString();
        bloodGroup = in.readString();
        bodyIdentificationMarks = in.readString();
        thumbImage = in.readString();
        signature = in.readString();
        licenseNo = in.readString();
        issueDate = in.readString();
        licenseClass = in.readString();
        expiryDate = in.readString();
        authority = in.readString();
        licenceType = in.readString();
        licenseDetailsFileUpload = in.readString();
        licenseImage = in.readString();
        bankName = in.readString();
        accountNumber = in.readString();
        ifscCode = in.readString();
        cashOrPrepaidCardNo = in.readString();
        fuelCardNo = in.readString();
        cvv = in.readString();
        documentCategoryId = in.readString();
        tripStatus = in.readString();
        statutoryRequirementStatus = in.readString();
        driverBehaviour = in.readString();
        byte tmpIsTagged = in.readByte();
        isTagged = tmpIsTagged == 0 ? null : tmpIsTagged == 1;
        driverStatus = in.readString();
    }

    public static final Creator<Driver> CREATOR = new Creator<Driver>() {
        @Override
        public Driver createFromParcel(Parcel in) {
            return new Driver(in);
        }

        @Override
        public Driver[] newArray(int size) {
            return new Driver[size];
        }
    };

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOrganizationIdName() {
        return organizationIdName;
    }
    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }
    public String getDriverId() {
        return driverId;
    }
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public String getLinkAccount() {
        return linkAccount;
    }
    public void setLinkAccount(String linkAccount) {
        this.linkAccount = linkAccount;
    }
    public String getDriverType() {
        return driverType;
    }
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }
    public String getDriverBadgeNo() {
        return driverBadgeNo;
    }
    public void setDriverBadgeNo(String driverBadgeNo) {
        this.driverBadgeNo = driverBadgeNo;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getLanguageKnown() {
        return languageKnown;
    }
    public void setLanguageKnown(String languageKnown) {
        this.languageKnown = languageKnown;
    }
    public String getLanguageWrite() {
        return languageWrite;
    }
    public void setLanguageWrite(String languageWrite) {
        this.languageWrite = languageWrite;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getPanNo() {
        return panNo;
    }
    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
    public String getAdharNo() {
        return adharNo;
    }
    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }
    public String getIdentificationfileUpload() {
        return identificationfileUpload;
    }
    public void setIdentificationfileUpload(String identificationfileUpload) {
        this.identificationfileUpload = identificationfileUpload;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public String getBodyIdentificationMarks() {
        return bodyIdentificationMarks;
    }
    public void setBodyIdentificationMarks(String bodyIdentificationMarks) {
        this.bodyIdentificationMarks = bodyIdentificationMarks;
    }
    public String getThumbImage() {
        return thumbImage;
    }
    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public List<Object> getAdharImage() {
        return adharImage;
    }
    public void setAdharImage(List<Object> adharImage) {
        this.adharImage = adharImage;
    }
    public String getLicenseNo() {
        return licenseNo;
    }
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getLicenseClass() {
        return licenseClass;
    }
    public void setLicenseClass(String licenseClass) {
        this.licenseClass = licenseClass;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public String getLicenceType() {
        return licenceType;
    }
    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }
    public String getLicenseDetailsFileUpload() {
        return licenseDetailsFileUpload;
    }
    public void setLicenseDetailsFileUpload(String licenseDetailsFileUpload) {
        this.licenseDetailsFileUpload = licenseDetailsFileUpload;
    }
    public String getLicenseImage() {
        return licenseImage;
    }
    public void setLicenseImage(String licenseImage) {
        this.licenseImage = licenseImage;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getIfscCode() {
        return ifscCode;
    }
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    public String getCashOrPrepaidCardNo() {
        return cashOrPrepaidCardNo;
    }
    public void setCashOrPrepaidCardNo(String cashOrPrepaidCardNo) {
        this.cashOrPrepaidCardNo = cashOrPrepaidCardNo;
    }
    public String getFuelCardNo() {
        return fuelCardNo;
    }
    public void setFuelCardNo(String fuelCardNo) {
        this.fuelCardNo = fuelCardNo;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getDocumentCategoryId() {
        return documentCategoryId;
    }
    public void setDocumentCategoryId(String documentCategoryId) {
        this.documentCategoryId = documentCategoryId;
    }
    public List<Object> getDocumentsHelper() {
        return documentsHelper;
    }
    public void setDocumentsHelper(List<Object> documentsHelper) {
        this.documentsHelper = documentsHelper;
    }
    public String getTripStatus() {
        return tripStatus;
    }
    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }
    public String getStatutoryRequirementStatus() {
        return statutoryRequirementStatus;
    }
    public void setStatutoryRequirementStatus(String statutoryRequirementStatus) {
        this.statutoryRequirementStatus = statutoryRequirementStatus;
    }
    public String getDriverBehaviour() {
        return driverBehaviour;
    }
    public void setDriverBehaviour(String driverBehaviour) {
        this.driverBehaviour = driverBehaviour;
    }
    public Boolean getIsTagged() {
        return isTagged;
    }
    public void setIsTagged(Boolean isTagged) {
        this.isTagged = isTagged;
    }
    public String getDriverStatus() {
        return driverStatus;
    }
    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(organizationIdName);
        dest.writeString(driverId);
        dest.writeString(driverName);
        dest.writeString(dateOfBirth);
        dest.writeString(dateOfJoining);
        dest.writeString(linkAccount);
        dest.writeString(driverType);
        dest.writeString(driverBadgeNo);
        dest.writeString(photo);
        dest.writeString(addressLine);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(country);
        dest.writeString(pin);
        dest.writeString(emailId);
        dest.writeString(mobileNumber);
        dest.writeString(languageKnown);
        dest.writeString(languageWrite);
        dest.writeString(qualification);
        dest.writeString(panNo);
        dest.writeString(adharNo);
        dest.writeString(identificationfileUpload);
        dest.writeString(bloodGroup);
        dest.writeString(bodyIdentificationMarks);
        dest.writeString(thumbImage);
        dest.writeString(signature);
        dest.writeString(licenseNo);
        dest.writeString(issueDate);
        dest.writeString(licenseClass);
        dest.writeString(expiryDate);
        dest.writeString(authority);
        dest.writeString(licenceType);
        dest.writeString(licenseDetailsFileUpload);
        dest.writeString(licenseImage);
        dest.writeString(bankName);
        dest.writeString(accountNumber);
        dest.writeString(ifscCode);
        dest.writeString(cashOrPrepaidCardNo);
        dest.writeString(fuelCardNo);
        dest.writeString(cvv);
        dest.writeString(documentCategoryId);
        dest.writeString(tripStatus);
        dest.writeString(statutoryRequirementStatus);
        dest.writeString(driverBehaviour);
        dest.writeByte((byte) (isTagged == null ? 0 : isTagged ? 1 : 2));
        dest.writeString(driverStatus);
    }
}
