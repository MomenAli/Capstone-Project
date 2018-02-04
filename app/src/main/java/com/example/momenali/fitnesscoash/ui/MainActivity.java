package com.example.momenali.fitnesscoash.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.momenali.fitnesscoash.custom.ViewPagerAdapter;
import com.example.momenali.fitnesscoash.R;
import com.example.momenali.fitnesscoash.ui.SessionsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);


    }

    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SessionsFragment(), getString(R.string.sessions_tab_label));
        adapter.addFragment(new MusclesFragment(), getString(R.string.exercises_tab_label));
        viewPager.setAdapter(adapter);
    }

}

