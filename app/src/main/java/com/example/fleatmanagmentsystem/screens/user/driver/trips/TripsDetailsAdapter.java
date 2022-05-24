package com.example.fleatmanagmentsystem.screens.user.driver.trips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.RecyclerTripDetailsBinding;
import com.example.fleatmanagmentsystem.models.login.tripdetail.LoadInfo;

import java.util.List;

public class TripsDetailsAdapter extends RecyclerView.Adapter<TripsDetailsAdapter.MyViewHolder> {

    private Context context;
    private List<LoadInfo> tripDetailResponseModule;

    public TripsDetailsAdapter(Context context, List<LoadInfo> tripDetailResponseModuleData) {
        this.context = context;
        this.tripDetailResponseModule = tripDetailResponseModuleData;
    }

    @NonNull
    @Override
    public TripsDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerTripDetailsBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.recycler_trip_details,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsDetailsAdapter.MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return tripDetailResponseModule.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerTripDetailsBinding binding;

        public MyViewHolder(@NonNull RecyclerTripDetailsBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bind(int position) {
            List<LoadInfo> loadInfoList = tripDetailResponseModule;
            binding.loadId.setText(loadInfoList.get(position).getLoadId());

            binding.sourceLocation.setText(loadInfoList.get(position).getSourceLocation());

            binding.driverLocation.setText(loadInfoList.get(position).getDestinationLocation());

            binding.pickupTAndD.setText(loadInfoList.get(position).getShipperPickupDateAndTime());

            binding.deliveryTAndD.setText(loadInfoList.get(position).getCustomerDeliveryDateAndTime());

        }
    }
}
