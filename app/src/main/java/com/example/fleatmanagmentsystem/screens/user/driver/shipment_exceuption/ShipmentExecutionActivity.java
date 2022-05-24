package com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption;

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
import com.example.fleatmanagmentsystem.databinding.ActivityShipmentExecutionBinding;

import java.util.ArrayList;
import java.util.List;

public class ShipmentExecutionActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    ActivityShipmentExecutionBinding binding;

    private ShipmentLoadingFragment shipmentLoadingFragment;
    private ShipmentUnloadingFragment shipmentUnloadingFragment;
    private ShipmentDocumentFragment shipmentDocumentFragment;

    private int adapterPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_shipment_execution);
        this.binding = DataBindingUtil.setContentView(this,R.layout.activity_shipment_execution);

        setUpViewPager(binding.shipmentExecutionViewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        shipmentLoadingFragment = new ShipmentLoadingFragment();
        shipmentUnloadingFragment = new ShipmentUnloadingFragment();
        shipmentDocumentFragment = new ShipmentDocumentFragment();
        ShipmentExecutionActivity.ViewPagerAdapter adapter = new ShipmentExecutionActivity.ViewPagerAdapter(getSupportFragmentManager());
        //binding.titleLayout.textViewBarTitle.setText("Product List");
        adapter.addFragment(shipmentLoadingFragment, "LOADING");
        adapter.addFragment(shipmentUnloadingFragment, "UNLOADING");
        adapter.addFragment(shipmentDocumentFragment, "DOCUMENT");


        viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(adapterPos);
    }

    @Override
    public void onClick(View v) {

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