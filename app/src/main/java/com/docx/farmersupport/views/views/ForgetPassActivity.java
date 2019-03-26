package com.docx.farmersupport.views.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.docx.farmersupport.R;

public class ForgetPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
    }

    @Override
    public void onBackPressed() {
       finish();
    }
}
