package com.example.fleatmanagmentsystem.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fleatmanagmentsystem.viewmodel.DriverDetailViewModel;
import com.example.fleatmanagmentsystem.viewmodel.LoginViewModel;
import com.example.fleatmanagmentsystem.viewmodel.advanceexpenses.AdvanceExpensesViewModel;
import com.example.fleatmanagmentsystem.viewmodel.expenseshistory.ExpensesHistoryViewModel;
import com.example.fleatmanagmentsystem.viewmodel.lrpod.LrPodViewModel;
import com.example.fleatmanagmentsystem.viewmodel.maintenances.MaintenancesViewModel;
import com.example.fleatmanagmentsystem.viewmodel.shipmentexception.ShipmentExceptionViewModel;
import com.example.fleatmanagmentsystem.viewmodel.tripdetails.TripDetailsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@SuppressWarnings("WeakerAccess")
@Module
public abstract class ViewModelModule {



    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindsLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DriverDetailViewModel.class)
    abstract ViewModel bindsDriverDetailViewModel(DriverDetailViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(TripDetailsViewModel.class)
    abstract ViewModel bindsTripDetailsViewModel(TripDetailsViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AdvanceExpensesViewModel.class)
    abstract ViewModel bindsAdvanceExpensesViewModel(AdvanceExpensesViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ExpensesHistoryViewModel.class)
    abstract ViewModel bindsExpensesHistoryViewModel(ExpensesHistoryViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ShipmentExceptionViewModel.class)
    abstract ViewModel bindsShipmentExceptionViewModel(ShipmentExceptionViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MaintenancesViewModel.class)
    abstract ViewModel bindsMaintenancesViewModel(MaintenancesViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LrPodViewModel.class)
    abstract ViewModel bindsLrPodViewModel(LrPodViewModel loginViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}