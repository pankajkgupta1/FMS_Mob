package com.example.fleatmanagmentsystem.screens.user.driver.advance_expenses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.databinding.RecyclerTripDetailsBinding;
import com.example.fleatmanagmentsystem.databinding.RecyclerTripLayoutBinding;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.ExpensesHistoryResponseModule;
import com.example.fleatmanagmentsystem.models.login.expenseshistory.FuelCharge;
import com.example.fleatmanagmentsystem.models.login.fuleexpence.GeneralExpense;
import com.example.fleatmanagmentsystem.screens.user.driver.trips.TripsDetailsAdapter;

import java.util.ArrayList;


public class ExpensesHistoryAdapter extends RecyclerView.Adapter<ExpensesHistoryAdapter.MyViewHolder> {

    ExpensesHistoryResponseModule expensesHistoryResponseModule;
    Context context;
    String type;
    private AdapterExceptionClickLisner clickLisner;

/*    public ExpensesHistoryAdapter(Context context, ExpensesHistoryResponseModule expensesHistoryResponseModule,String type) {
        this.context = context;
        this.expensesHistoryResponseModule = expensesHistoryResponseModule;
        this.type = type;
    }*/

    public ExpensesHistoryAdapter(Context context, ExpensesHistoryActivity expensesHistoryActivity, ExpensesHistoryResponseModule expensesHistoryResponseModule, String type) {
        this.context = context;
        this.type = type;
        this.clickLisner = expensesHistoryActivity;
        this.expensesHistoryResponseModule = expensesHistoryResponseModule;

    }

    /*public ExpensesHistoryAdapter(Context context, ArrayList<FuelCharge> fuelChargeArrayList,String type) {
        this.context = context;
        this.fuelChargeArrayList = fuelChargeArrayList;
        this.type = type;
    }*/

    @NonNull
    @Override
    public ExpensesHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*RecyclerTripLayoutBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.recycler_trip_layout,parent,false);*/

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_trip_layout,parent, false);

        //return new MyViewHolder(binding);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesHistoryAdapter.MyViewHolder holder, int position) {
        //holder.bind(position);

        holder.viewTripDetails.setOnClickListener(v -> {
            clickLisner.onItemClickLisner(position,type);
        });

        if(type.equals("fuel")){
            holder.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
            holder.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getFuelLocation()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getFuelAmount()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getCreatedDateTime());
            holder.tripStatus.setVisibility(View.GONE);
        }else if(type.equals("toll")){
            holder.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
            holder.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getLocation()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getTollAmount()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getCreatedDateTime());
            holder.tripStatus.setVisibility(View.GONE);
        }else if(type.equals("tax")){
            holder.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
            holder.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getLocation()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getTaxAmount()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getCreatedDateTime());
            holder.tripStatus.setVisibility(View.GONE);
        }else if(type.equals("generalExp")){
            holder.tripDiscription.setText("Trip id, Expenses Name, Amount,Date&Time");
            holder.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getExpensesName()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getAmount()+" "+
                    expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getCreatedDateTime());
            holder.tripStatus.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        if(type!=null && type.equals("fuel")){
            if(expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges()==null){
                return 0;
            }else{
                return expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().size();
            }

        }else if(type!=null && type.equals("toll")){
            if(expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges() == null){
                return 0;
            }else{
                return expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().size();
            }

        }else if(type!=null && type.equals("tax")){
            if(expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges() == null){
                return 0;
            }else {
                return expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().size();
            }

        }else if(type!=null && type.equals("generalExp")){
            if(expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses() == null){
                return 0;
            }else {
                return expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().size();
            }
        }else{
            return 0;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //RecyclerTripLayoutBinding binding;

        Button viewTripDetails;
        TextView tripDiscription,tripVehicle;
        ImageView tripStatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            viewTripDetails = itemView.findViewById(R.id.viewTripDetails);
            tripDiscription = itemView.findViewById(R.id.tripDiscription);
            tripVehicle = itemView.findViewById(R.id.tripVehicle);
            tripStatus = itemView.findViewById(R.id.tripStatus);
        }

        /*public MyViewHolder(@NonNull RecyclerTripLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

            binding.viewTripDetails.setOnClickListener(v -> {
                clickLisner.onItemClickLisner();
            });

            txtProductList = binding.findViewById(R.id.viewTripDetails);

        }*/

        /*public void bind(int position){

            if(type.equals("fuel")){
                binding.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
                binding.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getFuelLocation()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getFuelAmount()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getFuelCharges().get(position).getCreatedDateTime());
                binding.tripStatus.setVisibility(View.GONE);
            }else if(type.equals("toll")){
                binding.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
                binding.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getLocation()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getTollAmount()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTollCharges().get(position).getCreatedDateTime());
                binding.tripStatus.setVisibility(View.GONE);
            }else if(type.equals("tax")){
                binding.tripDiscription.setText("Trip id ,Location ,Amount ,Date&Tim");
                binding.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getLocation()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getTaxAmount()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getTaxCharges().get(position).getCreatedDateTime());
                binding.tripStatus.setVisibility(View.GONE);
            }else if(type.equals("generalExp")){
                binding.tripDiscription.setText("Trip id, Expenses Name, Amount,Date&Time");
                binding.tripVehicle.setText(AdvanceExpensesFragment.tripId+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getExpensesName()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getAmount()+" "+
                        expensesHistoryResponseModule.getData().getTripExpenses().getGeneralExpenses().get(position).getCreatedDateTime());
                binding.tripStatus.setVisibility(View.GONE);
            }

            binding.viewTripDetails.setOnClickListener(v -> {

            });
        }*/
    }

    public interface AdapterExceptionClickLisner{

        void onItemClickLisner(int position,String type);

    }
}
