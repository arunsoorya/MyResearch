package com.arunsoorya.myresearch.dagger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.arunsoorya.myresearch.MyApplication;
import com.arunsoorya.myresearch.R;

import javax.inject.Inject;


public class DaggerActivity extends AppCompatActivity {
    @Inject
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dagger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyApplication myApplication = (MyApplication) getApplication();
        myApplication.getComponent().inject(this);



    }

}
