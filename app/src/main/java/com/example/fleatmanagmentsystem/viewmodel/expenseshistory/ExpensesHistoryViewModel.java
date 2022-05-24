package com.example.fleatmanagmentsystem.viewmodel.expenseshistory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.ExpensesHistoryResponseModule;

import javax.inject.Inject;

public class ExpensesHistoryViewModel extends ViewModel {

    private DataRepository repository;
    private LiveData<ExpensesHistoryResponseModule> expensesHistoryResponseModuleLiveData;


    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClear();
    }

    @Inject
    public ExpensesHistoryViewModel(DataRepository repository) {
        this.repository = repository;
        this.expensesHistoryResponseModuleLiveData = repository.getExpensesHistory();
    }

    public void getExpensesHistoryReport(String tripId, String accessToken, String tenantId) {
        repository.getExpensesHistory(tripId,accessToken,tenantId);
    }

    public LiveData<ExpensesHistoryResponseModule> getExpensesReport(){
        return expensesHistoryResponseModuleLiveData;
    }
}
