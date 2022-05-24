package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TripExpenses implements Parcelable {

    public String _id;
    public String tripId;
    public String organizationIdName;
    public String country;
    public String actualTripStartDateTime;
    public String actualTripEndDateTime;
    public List<LoadSequenceHelper> loadSequenceHelper;
    public String vehicleId;
    public String driverId;
    public String invoiceId;
    public String invoicePaymentDate;
    public String paymentDueDate;
    public String transactionDateTime;
    public String previousFuelingOdoMeterReading;
    public List<Object> generalExpenses;
    public double generalExpensesTotal;
    public List<FuelCharge> fuelCharges;
    public double fuelChargesTotal;
    public List<Object> tollCharges;
    public double tollChargesTotal;
    public List<Object> taxCharges;
    public double taxChargesTotal;
    public double chargesTotal;
    public List<Object> podDetails;

    protected TripExpenses(Parcel in) {
        _id = in.readString();
        tripId = in.readString();
        organizationIdName = in.readString();
        country = in.readString();
        loadSequenceHelper = in.createTypedArrayList(LoadSequenceHelper.CREATOR);
        vehicleId = in.readString();
        driverId = in.readString();
        generalExpensesTotal = in.readDouble();
        fuelCharges = in.createTypedArrayList(FuelCharge.CREATOR);
        fuelChargesTotal = in.readDouble();
        tollChargesTotal = in.readDouble();
        taxChargesTotal = in.readDouble();
        chargesTotal = in.readDouble();
    }

    public static final Creator<TripExpenses> CREATOR = new Creator<TripExpenses>() {
        @Override
        public TripExpenses createFromParcel(Parcel in) {
            return new TripExpenses(in);
        }

        @Override
        public TripExpenses[] newArray(int size) {
            return new TripExpenses[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public List<Object> getGeneralExpenses() {
        return generalExpenses;
    }

    public void setGeneralExpenses(List<Object> generalExpenses) {
        this.generalExpenses = generalExpenses;
    }

    public double getGeneralExpensesTotal() {
        return generalExpensesTotal;
    }

    public void setGeneralExpensesTotal(double generalExpensesTotal) {
        this.generalExpensesTotal = generalExpensesTotal;
    }

    public List<FuelCharge> getFuelCharges() {
        return fuelCharges;
    }

    public void setFuelCharges(List<FuelCharge> fuelCharges) {
        this.fuelCharges = fuelCharges;
    }

    public double getFuelChargesTotal() {
        return fuelChargesTotal;
    }

    public void setFuelChargesTotal(double fuelChargesTotal) {
        this.fuelChargesTotal = fuelChargesTotal;
    }

    public List<Object> getTollCharges() {
        return tollCharges;
    }

    public void setTollCharges(List<Object> tollCharges) {
        this.tollCharges = tollCharges;
    }

    public double getTollChargesTotal() {
        return tollChargesTotal;
    }

    public void setTollChargesTotal(double tollChargesTotal) {
        this.tollChargesTotal = tollChargesTotal;
    }

    public List<Object> getTaxCharges() {
        return taxCharges;
    }

    public void setTaxCharges(List<Object> taxCharges) {
        this.taxCharges = taxCharges;
    }

    public double getTaxChargesTotal() {
        return taxChargesTotal;
    }

    public void setTaxChargesTotal(double taxChargesTotal) {
        this.taxChargesTotal = taxChargesTotal;
    }

    public double getChargesTotal() {
        return chargesTotal;
    }

    public void setChargesTotal(double chargesTotal) {
        this.chargesTotal = chargesTotal;
    }

    public List<Object> getPodDetails() {
        return podDetails;
    }

    public void setPodDetails(List<Object> podDetails) {
        this.podDetails = podDetails;
    }

    public static Creator<TripExpenses> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(tripId);
        dest.writeString(organizationIdName);
        dest.writeString(country);
        dest.writeTypedList(loadSequenceHelper);
        dest.writeString(vehicleId);
        dest.writeString(driverId);
        dest.writeDouble(generalExpensesTotal);
        dest.writeTypedList(fuelCharges);
        dest.writeDouble(fuelChargesTotal);
        dest.writeDouble(tollChargesTotal);
        dest.writeDouble(taxChargesTotal);
        dest.writeDouble(chargesTotal);
    }
}
