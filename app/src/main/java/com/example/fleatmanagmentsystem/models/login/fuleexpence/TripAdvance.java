package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TripAdvance implements Parcelable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("loadSequenceHelper")
    @Expose
    private List<LoadSequenceHelper> loadSequenceHelper = null;
    @SerializedName("voucherNumber")
    @Expose
    private String voucherNumber;
    @SerializedName("voucherDate")
    @Expose
    private String voucherDate;
    @SerializedName("voucherReason")
    @Expose
    private String voucherReason;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("plannedExpensesAmount")
    @Expose
    private Double plannedExpensesAmount;
    @SerializedName("fromAccount")
    @Expose
    private String fromAccount;
    @SerializedName("toAccount")
    @Expose
    private String toAccount;
    @SerializedName("paidBy")
    @Expose
    private String paidBy;
    @SerializedName("paidTo")
    @Expose
    private String paidTo;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("balance")
    @Expose
    private Double balance;
    @SerializedName("petroCardNumber")
    @Expose
    private String petroCardNumber;
    @SerializedName("petroCardAmount")
    @Expose
    private Double petroCardAmount;
    @SerializedName("fastagNumber")
    @Expose
    private String fastagNumber;
    @SerializedName("fastagAmount")
    @Expose
    private Double fastagAmount;
    @SerializedName("taxCardNumber")
    @Expose
    private String taxCardNumber;
    @SerializedName("taxCardAmount")
    @Expose
    private Double taxCardAmount;
    @SerializedName("cash")
    @Expose
    private Double cash;
    @SerializedName("settlement")
    @Expose
    private String settlement;
    @SerializedName("expensesType")
    @Expose
    private String expensesType;
    public final static Creator<TripAdvance> CREATOR = new Creator<TripAdvance>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripAdvance createFromParcel(android.os.Parcel in) {
            return new TripAdvance(in);
        }

        public TripAdvance[] newArray(int size) {
            return (new TripAdvance[size]);
        }

    }
            ;

    protected TripAdvance(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.createDate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadSequenceHelper, (LoadSequenceHelper.class.getClassLoader()));
        this.voucherNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.voucherDate = ((String) in.readValue((String.class.getClassLoader())));
        this.voucherReason = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentType = ((String) in.readValue((String.class.getClassLoader())));
        this.plannedExpensesAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fromAccount = ((String) in.readValue((String.class.getClassLoader())));
        this.toAccount = ((String) in.readValue((String.class.getClassLoader())));
        this.paidBy = ((String) in.readValue((String.class.getClassLoader())));
        this.paidTo = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.balance = ((Double) in.readValue((Double.class.getClassLoader())));
        this.petroCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.petroCardAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fastagNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.fastagAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.taxCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.taxCardAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cash = ((Double) in.readValue((Double.class.getClassLoader())));
        this.settlement = ((String) in.readValue((String.class.getClassLoader())));
        this.expensesType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TripAdvance() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getOrganizationIdName() {
        return organizationIdName;
    }

    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<LoadSequenceHelper> getLoadSequenceHelper() {
        return loadSequenceHelper;
    }

    public void setLoadSequenceHelper(List<LoadSequenceHelper> loadSequenceHelper) {
        this.loadSequenceHelper = loadSequenceHelper;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherReason() {
        return voucherReason;
    }

    public void setVoucherReason(String voucherReason) {
        this.voucherReason = voucherReason;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getPlannedExpensesAmount() {
        return plannedExpensesAmount;
    }

    public void setPlannedExpensesAmount(Double plannedExpensesAmount) {
        this.plannedExpensesAmount = plannedExpensesAmount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPetroCardNumber() {
        return petroCardNumber;
    }

    public void setPetroCardNumber(String petroCardNumber) {
        this.petroCardNumber = petroCardNumber;
    }

    public Double getPetroCardAmount() {
        return petroCardAmount;
    }

    public void setPetroCardAmount(Double petroCardAmount) {
        this.petroCardAmount = petroCardAmount;
    }

    public String getFastagNumber() {
        return fastagNumber;
    }

    public void setFastagNumber(String fastagNumber) {
        this.fastagNumber = fastagNumber;
    }

    public Double getFastagAmount() {
        return fastagAmount;
    }

    public void setFastagAmount(Double fastagAmount) {
        this.fastagAmount = fastagAmount;
    }

    public String getTaxCardNumber() {
        return taxCardNumber;
    }

    public void setTaxCardNumber(String taxCardNumber) {
        this.taxCardNumber = taxCardNumber;
    }

    public Double getTaxCardAmount() {
        return taxCardAmount;
    }

    public void setTaxCardAmount(Double taxCardAmount) {
        this.taxCardAmount = taxCardAmount;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getExpensesType() {
        return expensesType;
    }

    public void setExpensesType(String expensesType) {
        this.expensesType = expensesType;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(createDate);
        dest.writeList(loadSequenceHelper);
        dest.writeValue(voucherNumber);
        dest.writeValue(voucherDate);
        dest.writeValue(voucherReason);
        dest.writeValue(driverId);
        dest.writeValue(paymentType);
        dest.writeValue(plannedExpensesAmount);
        dest.writeValue(fromAccount);
        dest.writeValue(toAccount);
        dest.writeValue(paidBy);
        dest.writeValue(paidTo);
        dest.writeValue(amount);
        dest.writeValue(balance);
        dest.writeValue(petroCardNumber);
        dest.writeValue(petroCardAmount);
        dest.writeValue(fastagNumber);
        dest.writeValue(fastagAmount);
        dest.writeValue(taxCardNumber);
        dest.writeValue(taxCardAmount);
        dest.writeValue(cash);
        dest.writeValue(settlement);
        dest.writeValue(expensesType);
    }

    public int describeContents() {
        return 0;
    }
}
