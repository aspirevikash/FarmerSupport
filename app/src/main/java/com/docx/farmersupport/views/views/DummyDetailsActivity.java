package com.docx.farmersupport.views.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.docx.farmersupport.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class DummyDetailsActivity extends AppCompatActivity {
    private SliderLayout sliderLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sponsors_farmer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Framer Support");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                onBackPressed();
            }
        });


        dummySliderMethod();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            startActivity(new Intent(DummyDetailsActivity.this,UserProfileActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void dummySliderMethod(){
        sliderLayout = findViewById(R.id.imageSlider2);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(5); //set scroll delay in seconds :
        setSliderViews();
    }

    private void setSliderViews() {
        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    // sliderView.setImageDrawable(R.drawable.ic_launcher_background);
                    sliderView.setImageUrl("https://image.shutterstock.com/image-photo/smart-farming-using-modern-technologies-450w-682729996.jpg");
                    break;
                case 1://750 1280
                    sliderView.setImageUrl("https://image.shutterstock.com/image-photo/smart-agriculture-farm-sensor-technology-450w-710293657.jpg");
                    break;
                case 2:
                    sliderView.setImageUrl("https://image.shutterstock.com/image-vector/urban-farming-gardening-agriculture-set-450w-1008907699.jpg");
                    break;
                case 3:
                    sliderView.setImageUrl("https://image.shutterstock.com/image-vector/vector-farming-illustration-rural-landscape-450w-739395688.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER);
            sliderView.setDescription("Agriculture Image " + (i + 1));
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(DummyDetailsActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
