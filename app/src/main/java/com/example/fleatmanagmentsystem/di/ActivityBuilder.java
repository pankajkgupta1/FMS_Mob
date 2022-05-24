package com.example.fleatmanagmentsystem.di;


import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.AdvanceExpensesFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.ExpensesHistoryActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.maintenance.MaintenanceClosureFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.maintenance.MaintenanceFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentDocumentFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentLoadingFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption.ShipmentUnloadingFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.trips.DriverTripFragment;
import com.example.fleatmanagmentsystem.screens.user.driver.trips.TripDetailsActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.vehicle.VehicleTakeoverHandoverFragment;
import com.example.fleatmanagmentsystem.screens.user.lrpod.LrpodDriverFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

   @ContributesAndroidInjector()
    abstract LoginActivity bindSplashActivity();

   @ContributesAndroidInjector()
    abstract DriverDetailsActivity bindDriverDetailsActivity();

   @ContributesAndroidInjector()
    abstract DriverTripFragment bindDriverTripFragment();

   @ContributesAndroidInjector()
    abstract TripDetailsActivity bindTripDetailsActivity();

   @ContributesAndroidInjector()
    abstract AdvanceExpensesFragment bindAdvanceExpensesFragment();

   @ContributesAndroidInjector()
    abstract ExpensesHistoryActivity bindExpensesHistoryActivity();

   @ContributesAndroidInjector()
    abstract ShipmentLoadingFragment bindShipmentLoadingFragment();

   @ContributesAndroidInjector()
    abstract ShipmentUnloadingFragment bindShipmentUnloadingFragment();

   @ContributesAndroidInjector()
    abstract ShipmentDocumentFragment bindShipmentDocumentFragment();

   @ContributesAndroidInjector()
    abstract VehicleTakeoverHandoverFragment bindVehicleTakeoverHandoverFragment();

   @ContributesAndroidInjector()
    abstract MaintenanceClosureFragment bindMaintenanceClosureFragment();

   @ContributesAndroidInjector()
    abstract LrpodDriverFragment bindLrpodDriverFragment();

   @ContributesAndroidInjector()
    abstract MaintenanceFragment bindMaintenanceFragment();

}
