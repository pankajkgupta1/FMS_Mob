package com.example.fleatmanagmentsystem.helper;

import com.example.fleatmanagmentsystem.screens.user.URLActivity;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HostSelectionInterceptor implements Interceptor {
    private volatile String host;

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String host = this.host;
        //if (host != null) {
            //HttpUrl newUrl = request.url().newBuilder()
            //    .host(host)
            //    .build();
            HttpUrl newUrl = HttpUrl.parse(URLActivity.base);
            request = request.newBuilder()
                    .url(newUrl)
                    .build();
        //}
        return chain.proceed(request);
    }
}
