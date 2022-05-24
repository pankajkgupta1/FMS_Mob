package com.example.fleatmanagmentsystem.di;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.fleatmanagmentsystem.BuildConfig;
import com.example.fleatmanagmentsystem.base.AppSchedulerProvider;
import com.example.fleatmanagmentsystem.base.DataRepository;
import com.example.fleatmanagmentsystem.base.ViewModelModule;
import com.example.fleatmanagmentsystem.helper.AppPref;
import com.example.fleatmanagmentsystem.helper.ConnectivityInterceptor;
import com.example.fleatmanagmentsystem.helper.HostSelectionInterceptor;
import com.example.fleatmanagmentsystem.helper.UnauthorizedInterceptor;
import com.example.fleatmanagmentsystem.networking.NetworkConfig;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.URLActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelModule.class})
public class AppModule {
    /*@Provides
    @Singleton
    AppPrefHelper provideAppPrefHelper(AppPrefHelper appPrefHelper) {
        return appPrefHelper;
    }

    @Provides
    @Singleton
    AppDatabaseHelper provideAppDatabaseHelper(AppDatabaseHelper appDatabaseHelper) {
        return appDatabaseHelper;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase() {
        return new AppDatabase();
    }*/



  /*  @Provides
    @Singleton
    AppDatabase provideAppDatabase() {
        return new AppDatabase();
    }*/

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    AppSchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

/*  @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppPref.PREF_NAME;
    }*/

    @Provides
    @Singleton
    AppPref provideAppPrefs() {
        return AppPref.getInstance();
    }




    @Provides
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                //.baseUrl(BuildConfig.BASE_ENDPOINT)
                .baseUrl(URLActivity.base)
                //.baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                //.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

/*    @AppScope
    @Provides
    BaseUrlHolder provideBaseUrlHolder() {
        return new BaseUrlHolder("https://www.default.com")
    }*/

    @Provides
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Context context, AppPref appPref) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.MINUTES)
                .writeTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.MINUTES);
        builder.hostnameVerifier((hostname, session) -> true);

        if (BuildConfig.DEBUG) {
            // Added interceptor for http logging
            builder.addInterceptor(httpLoggingInterceptor);
        }

        //if(LoginActivity.loginFirst){
            builder.addInterceptor(new BasicAuthInterceptor("client","secret"));
            //Log.e("module","yes");
        //}
        //Log.e("moduleNo","no");
        builder.addInterceptor(new UnauthorizedInterceptor());
        builder.addInterceptor(new ConnectivityInterceptor(context));
        //builder.addInterceptor(new HostSelectionInterceptor());

        builder.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json");

            String userToken = appPref.getAuthToken();
            if (!TextUtils.isEmpty(userToken)) {
                requestBuilder.addHeader("Authorization", "Bearer " + userToken);
            }

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return builder.build();
    }



    @Provides
    @Singleton
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    NetworkConfig providesApiService(Retrofit retrofit) {
        return retrofit.create(NetworkConfig.class);
    }

    @Provides
    @Singleton
    DataRepository provideDataRepository(AppSchedulerProvider appSchedulerProvider, Context context, NetworkConfig networkConfig ) {
        return new DataRepository(appSchedulerProvider,context ,networkConfig);
    }
}
