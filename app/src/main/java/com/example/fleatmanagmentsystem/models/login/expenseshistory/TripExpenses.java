package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripExpenses implements Parcelable
{

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
    @SerializedName("actualTripStartDateTime")
    @Expose
    private String actualTripStartDateTime;
    @SerializedName("actualTripEndDateTime")
    @Expose
    private String actualTripEndDateTime;
    @SerializedName("loadSequenceHelper")
    @Expose
    private List<LoadSequenceHelper> loadSequenceHelper = null;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("invoiceId")
    @Expose
    private String invoiceId;
    @SerializedName("invoicePaymentDate")
    @Expose
    private String invoicePaymentDate;
    @SerializedName("PaymentDueDate")
    @Expose
    private String paymentDueDate;
    @SerializedName("transactionDateTime")
    @Expose
    private String transactionDateTime;
    @SerializedName("previousFuelingOdoMeterReading")
    @Expose
    private String previousFuelingOdoMeterReading;
    @SerializedName("generalExpenses")
    @Expose
    private List<GeneralExpense> generalExpenses = null;
    @SerializedName("generalExpensesTotal")
    @Expose
    private Double generalExpensesTotal;
    @SerializedName("fuelCharges")
    @Expose
    private List<FuelCharge> fuelCharges = null;
    @SerializedName("fuelChargesTotal")
    @Expose
    private Double fuelChargesTotal;
    @SerializedName("tollCharges")
    @Expose
    private List<TollCharge> tollCharges = null;
    @SerializedName("tollChargesTotal")
    @Expose
    private Double tollChargesTotal;
    @SerializedName("taxCharges")
    @Expose
    private List<TaxCharge> taxCharges = null;
    @SerializedName("taxChargesTotal")
    @Expose
    private Double taxChargesTotal;
    @SerializedName("chargesTotal")
    @Expose
    private Double chargesTotal;
    @SerializedName("podDetails")
    @Expose
    private List<Object> podDetails = null;
    public final static Creator<TripExpenses> CREATOR = new Creator<TripExpenses>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripExpenses createFromParcel(android.os.Parcel in) {
            return new TripExpenses(in);
        }

        public TripExpenses[] newArray(int size) {
            return (new TripExpenses[size]);
        }

    }
            ;

    protected TripExpenses(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.actualTripStartDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.actualTripEndDateTime = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadSequenceHelper, (LoadSequenceHelper.class.getClassLoader()));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.invoiceId = ((String) in.readValue((String.class.getClassLoader())));
        this.invoicePaymentDate = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentDueDate = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.previousFuelingOdoMeterReading = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.generalExpenses, (GeneralExpense.class.getClassLoader()));
        this.generalExpensesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.fuelCharges, (FuelCharge.class.getClassLoader()));
        this.fuelChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.tollCharges, (TollCharge.class.getClassLoader()));
        this.tollChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.taxCharges, (TaxCharge.class.getClassLoader()));
        this.taxChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        this.chargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.podDetails, (java.lang.Object.class.getClassLoader()));
    }

    public TripExpenses() {
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

    public String getActualTripStartDateTime() {
        return actualTripStartDateTime;
    }

    public void setActualTripStartDateTime(String actualTripStartDateTime) {
        this.actualTripStartDateTime = actualTripStartDateTime;
    }

    public String getActualTripEndDateTime() {
        return actualTripEndDateTime;
    }

    public void setActualTripEndDateTime(String actualTripEndDateTime) {
        this.actualTripEndDateTime = actualTripEndDateTime;
    }

    public List<LoadSequenceHelper> getLoadSequenceHelper() {
        return loadSequenceHelper;
    }

    public void setLoadSequenceHelper(List<LoadSequenceHelper> loadSequenceHelper) {
        this.loadSequenceHelper = loadSequenceHelper;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoicePaymentDate() {
        return invoicePaymentDate;
    }

    public void setInvoicePaymentDate(String invoicePaymentDate) {
        this.invoicePaymentDate = invoicePaymentDate;
    }

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getPreviousFuelingOdoMeterReading() {
        return previousFuelingOdoMeterReading;
    }

    public void setPreviousFuelingOdoMeterReading(String previousFuelingOdoMeterReading) {
        this.previousFuelingOdoMeterReading = previousFuelingOdoMeterReading;
    }

    public List<GeneralExpense> getGeneralExpenses() {
        return generalExpenses;
    }

    public void setGeneralExpenses(List<GeneralExpense> generalExpenses) {
        this.generalExpenses = generalExpenses;
    }

    public Double getGeneralExpensesTotal() {
        return generalExpensesTotal;
    }

    public void setGeneralExpensesTotal(Double generalExpensesTotal) {
        this.generalExpensesTotal = generalExpensesTotal;
    }

    public List<FuelCharge> getFuelCharges() {
        return fuelCharges;
    }

    public void setFuelCharges(List<FuelCharge> fuelCharges) {
        this.fuelCharges = fuelCharges;
    }

    public Double getFuelChargesTotal() {
        return fuelChargesTotal;
    }

    public void setFuelChargesTotal(Double fuelChargesTotal) {
        this.fuelChargesTotal = fuelChargesTotal;
    }

    public List<TollCharge> getTollCharges() {
        return tollCharges;
    }

    public void setTollCharges(List<TollCharge> tollCharges) {
        this.tollCharges = tollCharges;
    }

    public Double getTollChargesTotal() {
        return tollChargesTotal;
    }

    public void setTollChargesTotal(Double tollChargesTotal) {
        this.tollChargesTotal = tollChargesTotal;
    }

    public List<TaxCharge> getTaxCharges() {
        return taxCharges;
    }

    public void setTaxCharges(List<TaxCharge> taxCharges) {
        this.taxCharges = taxCharges;
    }

    public Double getTaxChargesTotal() {
        return taxChargesTotal;
    }

    public void setTaxChargesTotal(Double taxChargesTotal) {
        this.taxChargesTotal = taxChargesTotal;
    }

    public Double getChargesTotal() {
        return chargesTotal;
    }

    public void setChargesTotal(Double chargesTotal) {
        this.chargesTotal = chargesTotal;
    }

    public List<Object> getPodDetails() {
        return podDetails;
    }

    public void setPodDetails(List<Object> podDetails) {
        this.podDetails = podDetails;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(actualTripStartDateTime);
        dest.writeValue(actualTripEndDateTime);
        dest.writeList(loadSequenceHelper);
        dest.writeValue(vehicleId);
        dest.writeValue(driverId);
        dest.writeValue(invoiceId);
        dest.writeValue(invoicePaymentDate);
        dest.writeValue(paymentDueDate);
        dest.writeValue(transactionDateTime);
        dest.writeValue(previousFuelingOdoMeterReading);
        dest.writeList(generalExpenses);
        dest.writeValue(generalExpensesTotal);
        dest.writeList(fuelCharges);
        dest.writeValue(fuelChargesTotal);
        dest.writeList(tollCharges);
        dest.writeValue(tollChargesTotal);
        dest.writeList(taxCharges);
        dest.writeValue(taxChargesTotal);
        dest.writeValue(chargesTotal);
        dest.writeList(podDetails);
    }

    public int describeContents() {
        return 0;
    }

}
