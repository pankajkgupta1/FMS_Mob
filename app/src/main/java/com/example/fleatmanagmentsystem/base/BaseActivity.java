package com.example.fleatmanagmentsystem.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.helper.NoConnectivityEvent;
import com.example.fleatmanagmentsystem.helper.UnauthorizedEvent;
import com.google.android.material.snackbar.Snackbar;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public abstract class BaseActivity<B extends ViewDataBinding,M extends ViewModel> extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDependencyInjection();
        ViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        ViewDataBinding binding = DataBindingUtil.setContentView(this, getLayoutResId());
        onCreate(savedInstanceState, (M) viewModel, (B) binding);
    }

    protected abstract Class<M> getViewModel();

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    protected abstract void onCreate(Bundle instance, M viewModel, B binding);

    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    protected abstract
    @LayoutRes
    int getLayoutResId();


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                    INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void enableToolbarBackNavigation() {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showNoConnectivitySnack() {
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar
                .make(rootView, getString(R.string.error_no_internet_connection), Snackbar.LENGTH_LONG);

        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public void handleApiError(Throwable throwable) {
        // TODO - handle network error
        //Timber.e("Network error:  %s", throwable.getMessage());
    }

    @Subscribe
    public final void onNoConnectivityEvent(NoConnectivityEvent e) {
        showNoConnectivitySnack();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public final void onUnauthorizedEvent(UnauthorizedEvent e) {
        handleUnauthorizedEvent();
    }

    protected void handleUnauthorizedEvent() {
        // TODO - handle 403
        // logout();
    }
}
