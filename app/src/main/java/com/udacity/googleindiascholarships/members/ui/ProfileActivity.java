package com.udacity.googleindiascholarships.members.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.udacity.googleindiascholarships.R;
import com.udacity.googleindiascholarships.members.ui.adapters.ProfileViewPagerAdapter;

public class ProfileActivity extends AppCompatActivity {

    ViewPager vpProfile;
    TabLayout tabsProfile;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vpProfile = (ViewPager) findViewById(R.id.vpProfile);
        tabsProfile = (TabLayout)findViewById(R.id.tabsProfile);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        vpProfile.setOffscreenPageLimit(3);
        setupViewPager();
        tabsProfile.setupWithViewPager(vpProfile);

    }
    private void setupViewPager() {
        ProfileViewPagerAdapter adapter = new ProfileViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileAboutTabFragment(), "About");
        adapter.addFragment(new ProfileGISTabFragment(), "GIS");
        adapter.addFragment(new ProfileProjectsTabFragment(), "Projects");
        vpProfile.setAdapter(adapter);
    }
}

