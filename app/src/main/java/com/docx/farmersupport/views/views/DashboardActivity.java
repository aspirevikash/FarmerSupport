package com.docx.farmersupport.views.views;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.docx.farmersupport.R;
import com.docx.farmersupport.views.dummyAdapters.DashboardAdapter;
import com.docx.farmersupport.views.dummyAdapters.GridSpacingItemDecoration;
import com.docx.farmersupport.views.dummymodels.DashboardMenuModels;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SliderLayout sliderLayout;

    private RecyclerView recyclerView;
    private DashboardAdapter adapter;
    private List<DashboardMenuModels> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dummySliderMethod();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new DashboardAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(0), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareMenu();
    }

    /**
     * Adding few albums for testing
     */
    private void prepareMenu() {
        int[] covers = new int[]{
                R.drawable.sponsor,
                R.drawable.micro_credit,
                R.drawable.farming_store,
                R.drawable.tractor,
                R.drawable.agri_land,
                R.drawable.contract_farming,
                R.drawable.skill_dev};

        DashboardMenuModels a = new DashboardMenuModels("1","Sponsor Farming", covers[0]);
        albumList.add(a);

        a = new DashboardMenuModels("2","Micro Credit ", covers[1]);
        albumList.add(a);

        a = new DashboardMenuModels("3","Farming Store ", covers[2]);
        albumList.add(a);

        a = new DashboardMenuModels("4","Tractor Sale    and  Purchase ", covers[3]);
        albumList.add(a);

        a = new DashboardMenuModels("5","Agriculture Land Sale and  Purchase ", covers[4]);
        albumList.add(a);

        a = new DashboardMenuModels("6","Contract Farming ", covers[5]);
        albumList.add(a);

        a = new DashboardMenuModels("7","Skill Development ", covers[6]);
        albumList.add(a);


        adapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            startActivity(new Intent(DashboardActivity.this,UserProfileActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void dummySliderMethod(){
        sliderLayout = findViewById(R.id.imageSlider);
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
                Toast.makeText(DashboardActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

            }
        });

        //at last add this view in your layout :
        sliderLayout.addSliderView(sliderView);
    }

    }
}
