package com.example.fleatmanagmentsystem.base;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
//import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends ViewDataBinding, V extends ViewModel> extends Fragment {

    protected BaseActivity baseActivity;
    protected Activity activity;
    protected View mRootView;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private T bindingVariable;
    private V mViewModel;
    private Context mContext;

    protected abstract Class<V> getViewModel();

    protected abstract
    @LayoutRes
    int getLayoutResId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof BaseActivity) {
            this.activity = (BaseActivity) context;
            this.baseActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        assert getActivity() != null;

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindingVariable = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        mRootView = bindingVariable.getRoot();
        onCreateView(savedInstanceState, mViewModel, bindingVariable, mContext);

        return mRootView;
    }

    protected abstract void onCreateView(Bundle instance, V viewModel, T binding, Context context);

    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    public void checkInternetConnection(){
        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
        } else {
            Toast.makeText(getContext(), "Connection Error", Toast.LENGTH_SHORT).show();
            // display error
        }
    }

    public void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        baseActivity = null;
        super.onDetach();
    }

}