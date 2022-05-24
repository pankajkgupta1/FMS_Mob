package com.example.fleatmanagmentsystem.helper;


import android.content.Context;

import com.example.fleatmanagmentsystem.R;

import java.io.IOException;

public class NoConnectivityException extends IOException {
    private Context context;

    public NoConnectivityException(Context context) {
        this.context = context;
    }

    @Override
    public String getMessage() {
        return context.getString(R.string.error_no_internet_connection);
    }
}

