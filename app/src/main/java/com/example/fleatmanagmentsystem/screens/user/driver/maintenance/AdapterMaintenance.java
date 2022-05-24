package com.example.fleatmanagmentsystem.screens.user.driver.maintenance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses.AdvanceExpensesFragment;

public class AdapterMaintenance extends RecyclerView.Adapter<AdapterMaintenance.MyViewHolder>{

    Context context;
    MaintenanceResponseModule maintenanceResponseModuleData;

    private AdapterMaintenanceClickLisner clickLisner;

    public AdapterMaintenance(Context context, MaintenanceFragment activity, MaintenanceResponseModule maintenanceResponseModule) {
        this.context = context;
        this.clickLisner = activity;
        maintenanceResponseModuleData = maintenanceResponseModule;
    }

    @NonNull
    @Override
    public AdapterMaintenance.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_trip_layout,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMaintenance.MyViewHolder holder, int position) {
        holder.viewMaintenanceDetails.setOnClickListener(v -> {
            clickLisner.onItemClickLisner(position);
        });

        holder.maintenanceDiscription.setText("Service Id ,Name ,Vehicle Name");
        holder.maintenanceVehicle.setText(maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getServiceType()+" "+
                maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getDepotName()+" "+
                maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().get(position).getVehicleId());
        holder.tripStatus.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return maintenanceResponseModuleData.getData().getMaintanenceWorkOrders().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Button viewMaintenanceDetails;
        TextView maintenanceDiscription,maintenanceVehicle;
        ImageView tripStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            viewMaintenanceDetails = itemView.findViewById(R.id.viewTripDetails);
            maintenanceDiscription = itemView.findViewById(R.id.tripDiscription);
            maintenanceVehicle = itemView.findViewById(R.id.tripVehicle);
            tripStatus = itemView.findViewById(R.id.tripStatus);
        }
    }

    public interface AdapterMaintenanceClickLisner{

        void onItemClickLisner(int position);

    }
}
