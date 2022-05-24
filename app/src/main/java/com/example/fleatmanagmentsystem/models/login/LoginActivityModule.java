package com.example.fleatmanagmentsystem.models.login;

import androidx.lifecycle.ViewModelProvider;

import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.di.ViewModelProviderFactory;
import com.example.fleatmanagmentsystem.viewmodel.LoginViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
    @Provides
    ViewModelProvider.Factory mainActivityViewModelProvider(LoginViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    LoginViewModel provideAddAccountViewModel(DataRepository repository) {
        return new LoginViewModel(repository);
    }
}
