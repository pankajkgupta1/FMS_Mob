package com.example.fleatmanagmentsystem.screens.user.driver.shipment_exceuption;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.FragmentShipmentExecutionBinding;

import java.util.ArrayList;
import java.util.List;

public class ShipmentExecutionFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener{

    FragmentShipmentExecutionBinding binding;
    private ShipmentLoadingFragment shipmentLoadingFragment;
    private ShipmentUnloadingFragment shipmentUnloadingFragment;
    private ShipmentDocumentFragment shipmentDocumentFragment;

    private int adapterPos;

    public ShipmentExecutionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shipment_execution,container,false);

        setUpViewPager(binding.shipmentExecutionViewPager);

        return binding.getRoot();
    }

    private void setUpViewPager(ViewPager viewPager) {
        shipmentLoadingFragment = new ShipmentLoadingFragment();
        shipmentUnloadingFragment = new ShipmentUnloadingFragment();
        shipmentDocumentFragment = new ShipmentDocumentFragment();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        //binding.titleLayout.textViewBarTitle.setText("Product List");
            adapter.addFragment(shipmentLoadingFragment, "LOADING");
            adapter.addFragment(shipmentUnloadingFragment, "UNLOADING");
            adapter.addFragment(shipmentDocumentFragment, "DOCUMENT");


        viewPager.setAdapter(adapter);
        binding.tabLayoutShipment.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(adapterPos);
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
}