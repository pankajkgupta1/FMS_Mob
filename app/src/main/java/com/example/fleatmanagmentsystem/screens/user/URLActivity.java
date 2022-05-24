package com.example.fleatmanagmentsystem.screens.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.ActivityUrlactivityBinding;

import java.io.File;

public class URLActivity extends AppCompatActivity {

    public static final String TEXT = "text";
    public static final String FLAG = "";
    public static final String SHARED_PREFS = "sharedPrefs";
    public String text;
    public boolean flag = false;
    public static String base;

    ActivityUrlactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_urlactivity);
        //setContentView(R.layout.activity_urlactivity);

        //binding.baseUrl.setText("https://dev.fruisce.in/fms/");

        try {
            File dir = this.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}

        loadData();
        updateView();

        if(TEXT.equals("text")){
            base = binding.baseUrl.getText().toString();
        }


        /*if(flag){
            loadActivity();
        }*/

        binding.submit.setOnClickListener(v -> {



            base = binding.baseUrl.getText().toString();
            saveData(binding.baseUrl.getText().toString());
            //loadData();
            loadActivity();
        });

        loadData();

    }

    private void loadActivity() {
        Intent intent = new Intent(URLActivity.this,LoginActivity.class);
        startActivity(intent);
    }


    public void saveData(String url){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,url);
        editor.putBoolean(FLAG,true);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
        flag = sharedPreferences.getBoolean(FLAG,false);
    }

    public void updateView(){
        binding.baseUrl.setText(text);
        //binding.edtPassword.setText(password);
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}