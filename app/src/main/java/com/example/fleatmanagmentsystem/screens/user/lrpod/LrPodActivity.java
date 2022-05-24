package com.example.fleatmanagmentsystem.screens.user.lrpod;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.ActivityIrPodBinding;

import java.util.ArrayList;
import java.util.List;

public class LrPodActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    ActivityIrPodBinding binding;

    private LrpodDriverFragment lrpodDriverFragment ;
    private LrpodCustomerFragment lrpodCustomerFragment ;
    private LrpodShipperFragment lrpodShipperFragment ;

    private int adapterPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_ir_pod);
        //setContentView(R.layout.activity_ir_pod);

        setUpViewPager(binding.irpodViewPager);
    }

    private void setUpViewPager(ViewPager irpodViewPager) {
        lrpodDriverFragment = new LrpodDriverFragment();
        lrpodCustomerFragment = new LrpodCustomerFragment();
        lrpodShipperFragment = new LrpodShipperFragment();

        LrPodActivity.ViewPagerAdapter adapter = new LrPodActivity.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(lrpodDriverFragment,"Driver");
        adapter.addFragment(lrpodShipperFragment,"Shipper");
        adapter.addFragment(lrpodCustomerFragment,"Customer");

        irpodViewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(irpodViewPager);
        irpodViewPager.setCurrentItem(adapterPos);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentListTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentListTitle.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentListTitle.get(position);
        }
    }
}