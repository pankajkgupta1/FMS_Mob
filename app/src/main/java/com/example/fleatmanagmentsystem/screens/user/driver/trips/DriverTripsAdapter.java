package com.example.fleatmanagmentsystem.screens.user.driver.trips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.RecyclerTripLayoutBinding;
import com.example.fleatmanagmentsystem.models.login.tripdetail.LoadInfo;
import com.example.fleatmanagmentsystem.models.login.tripdetail.TripDetailResponseModule;

import java.util.List;

public class DriverTripsAdapter extends RecyclerView.Adapter<DriverTripsAdapter.MyViewHolder> {

    private Context context;
    private TripDetailResponseModule tripDetailResponseModule;

    public DriverTripsAdapter(Context context, TripDetailResponseModule tripDetailResponseModuleData) {
        this.context = context;
        this.tripDetailResponseModule = tripDetailResponseModuleData;
    }

    @NonNull
    @Override
    public DriverTripsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerTripLayoutBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.recycler_trip_layout,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverTripsAdapter.MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return tripDetailResponseModule.getData().getTripInfoList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerTripLayoutBinding binding;

        public MyViewHolder(@NonNull RecyclerTripLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bind(int position) {
            String s1="",s2="",s3="",s4="",s5="";
            List<LoadInfo> loadInfoList = tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo();

            for (LoadInfo l : loadInfoList){
                s2 = l.getSourceLocation();
                s3 = l.getDestinationLocation();
                s4 = l.getShipperPickupDateAndTime();
                s5 = l.getCustomerDeliveryDateAndTime();
            }


            s1 = tripDetailResponseModule.getData().getTripInfoList().get(position).getTripId();


            /*binding.tripDiscription.setText(tripDetailResponseModule.getData().getTripInfoList().get(position).getTripId()+","+
                    tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo().get(position).getSourceLocation()+","+
                    tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo().get(position).getDestinationLocation()+","+
                    tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo().get(position).getShipperPickupDateAndTime()+","+
                    tripDetailResponseModule.getData().getTripInfoList().get(position).getLoadInfo().get(position).getCustomerDeliveryDateAndTime());*/

            binding.tripVehicle.setText(s1+","+
                    s2+","+ s3+","+ s4+","+ s5);

            binding.tripDiscription.setText(R.string.trip_details_adapter);

            if(tripDetailResponseModule.getData().getTripInfoList().get(position).getTripStatus().equals("Closed")){
                binding.tripStatus.setImageResource(R.drawable.ic_dot_green);
            }else if(tripDetailResponseModule.getData().getTripInfoList().get(position).getTripStatus().equals("Open")){
                binding.tripStatus.setImageResource(R.drawable.ic_dot_green);
            }else if(tripDetailResponseModule.getData().getTripInfoList().get(position).getTripStatus().equals("NotYetStarted")){
                binding.tripStatus.setImageResource(R.drawable.ic_dot_red);
            }else{
                binding.tripStatus.setImageResource(R.drawable.ic_dot_red);
            }


            binding.viewTripDetails.setOnClickListener(v -> {
                Intent intent = new Intent(context,TripDetailsActivity.class);
                intent.putExtra("tripDetailResponseModule",tripDetailResponseModule);
                intent.putExtra("position",position);
                context.startActivity(intent);
            });
        }
    }
}
