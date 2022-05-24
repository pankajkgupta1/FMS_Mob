package com.example.fleatmanagmentsystem.screens.user.driver.maintenance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fleatmanagmentsystem.R;
import com.example.fleatmanagmentsystem.base.BaseFragment;
import com.example.fleatmanagmentsystem.databinding.FragmentMaintenanceClosureBinding;
import com.example.fleatmanagmentsystem.models.login.maintenance.MaintenanceResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceclosure.MaintenanceClosureResponseModule;
import com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus.MaintenanceUpdateStatusRequestModule;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetail;
import com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate.ShipmentDetailsDocumentsInfo;
import com.example.fleatmanagmentsystem.screens.user.LoginActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverDetailsActivity;
import com.example.fleatmanagmentsystem.screens.user.driver.DriverFeaturesActivity;
import com.example.fleatmanagmentsystem.viewmodel.maintenances.MaintenancesViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MaintenanceClosureFragment extends BaseFragment<FragmentMaintenanceClosureBinding, MaintenancesViewModel> {

    public static ArrayList<String> workId = new ArrayList<>();
    public static ArrayList<String> vehicleId = new ArrayList<>();
    FragmentMaintenanceClosureBinding binding;
    MaintenancesViewModel maintenancesViewModel;
    MaintenanceResponseModule maintenanceResponseModuleData = new MaintenanceResponseModule();
    MaintenanceClosureResponseModule maintenanceClosureResponseModuleData = new MaintenanceClosureResponseModule();
    MaintenanceUpdateStatusRequestModule maintenanceUpdateStatusRequestModule = new MaintenanceUpdateStatusRequestModule();
    String dateTime;
    String workOrderId = "";
    String gateEntry = null, testDriver = null, takeover = null, handover = null, driverStatus = null, vehiclePlaced = null, gateout = null;
    private ArrayAdapter<String> workOrderList;
    private ArrayAdapter<String> vehicleIdList;

    public MaintenanceClosureFragment() {
        // Required empty public constructor
    }

    @Override
    protected Class<MaintenancesViewModel> getViewModel() {
        return MaintenancesViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_maintenance_closure;
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maintenance_closure, container, false);
    }*/

    @Override
    protected void onCreateView(Bundle instance, MaintenancesViewModel viewModel, FragmentMaintenanceClosureBinding binding, Context context) {
        this.binding = binding;
        this.maintenancesViewModel = viewModel;
        maintenancesViewModel.getMaintenanceAssignedServices(DriverDetailsActivity.DriverId, LoginActivity.accessToken, LoginActivity.tenantId);

        binding.gateEntry.setOnClickListener(view -> {
            popup("gateEntry");
        });
        binding.testDrive.setOnClickListener(view -> {
            popup("testDriver");
        });
        binding.takeover.setOnClickListener(view -> {
            Intent trip = new Intent(getContext(), DriverFeaturesActivity.class);
            trip.putExtra("from", "takeover");
            trip.putExtra("type", "takeover1");
            startActivity(trip);
        });
        binding.handover.setOnClickListener(view -> {
            Intent trip = new Intent(getContext(), DriverFeaturesActivity.class);
            trip.putExtra("from", "handover");
            trip.putExtra("type", "handover1");
            startActivity(trip);
        });
        binding.driverStatus.setOnClickListener(view -> {
            popup("driverStatus");
        });
        binding.vehiclePlaced.setOnClickListener(view -> {
            popup("vehiclePlaced");
        });
        binding.gateout.setOnClickListener(view -> {
            popup("gateout");
        });

        binding.spinnerTripsIds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else {
                    workOrderId = binding.spinnerTripsIds.getSelectedItem().toString();
                    //shipmentExceptionViewModel.getShipmentExceptionLoadId(tripId, LoginActivity.accessToken);
                    maintenancesViewModel.getMaintenanceStatusDetails(workOrderId, LoginActivity.accessToken, LoginActivity.tenantId);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initView();
    }

    @SuppressLint("FragmentLiveDataObserve")
    private void initView() {
        maintenancesViewModel.getMaintenanceAssServ().observe(this, maintenanceResponseModule -> {
            if (maintenanceResponseModule != null) {
                if (maintenanceResponseModule.getData() != null) {
                    maintenanceResponseModuleData = maintenanceResponseModule;
                    workId.clear();
                    vehicleId.clear();
                    workId.add("Select");
                    vehicleId.add("Select");
                    //advanceExpensesViewModel.getAdvanceExpenses(LoginActivity.accessToken);
                    for (int i = 0; i < maintenanceResponseModule.getData().getMaintanenceWorkOrders().size(); i++) {
                        workId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getWorkOrderId());
                        vehicleId.add(maintenanceResponseModule.getData().getMaintanenceWorkOrders().get(i).getVehicleId());
                    }
                    selectTrip(workId, "work");
                    selectTrip(vehicleId, "vehicel");

                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        maintenancesViewModel.getMaintenanceCloser().observe(this, maintenanceClosureResponseModule -> {
            if (maintenanceClosureResponseModule != null) {
                if (maintenanceClosureResponseModule.getData() != null) {
                    if (maintenanceClosureResponseModule.getData().getMaintanenceStatusLog() != null) {
                        maintenanceClosureResponseModuleData = maintenanceClosureResponseModule;
                        gateEntry = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getGateEntryDateTime();
                        testDriver = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getTestDriveBy();
                        driverStatus = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getTestDriveStatus();
                        vehiclePlaced = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getVehiclePlacedDateTime();
                        gateout = maintenanceClosureResponseModule.getData().getMaintanenceStatusLog().getGateOutDateTime();

                        if (gateEntry != null) {
                            binding.gateEntry.setEnabled(true);
                            binding.gateEntry.setBackground(getResources().getDrawable(R.color.dark_green));
                            binding.gateEntry.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            binding.gateEntry.setEnabled(true);
                            binding.gateEntry.setBackground(getResources().getDrawable(R.color.light_brown));
                            binding.gateEntry.setTextColor(getResources().getColor(R.color.black));
                        }
                        if (testDriver != null) {
                            binding.testDrive.setEnabled(true);
                            binding.testDrive.setBackground(getResources().getDrawable(R.color.dark_green));
                            binding.testDrive.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            binding.testDrive.setEnabled(true);
                            binding.testDrive.setBackground(getResources().getDrawable(R.color.light_brown));
                            binding.testDrive.setTextColor(getResources().getColor(R.color.black));
                        }
                        if (driverStatus != null) {
                            binding.driverStatus.setEnabled(true);
                            binding.driverStatus.setBackground(getResources().getDrawable(R.color.dark_green));
                            binding.driverStatus.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            binding.driverStatus.setEnabled(true);
                            binding.driverStatus.setBackground(getResources().getDrawable(R.color.light_brown));
                            binding.driverStatus.setTextColor(getResources().getColor(R.color.black));
                        }
                        if (vehiclePlaced != null) {
                            binding.vehiclePlaced.setEnabled(true);
                            binding.vehiclePlaced.setBackground(getResources().getDrawable(R.color.dark_green));
                            binding.vehiclePlaced.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            binding.vehiclePlaced.setEnabled(true);
                            binding.vehiclePlaced.setBackground(getResources().getDrawable(R.color.light_brown));
                            binding.vehiclePlaced.setTextColor(getResources().getColor(R.color.black));
                        }
                        if (gateout != null) {
                            binding.gateout.setEnabled(true);
                            binding.gateout.setBackground(getResources().getDrawable(R.color.dark_green));
                            binding.gateout.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            binding.gateout.setEnabled(true);
                            binding.gateout.setBackground(getResources().getDrawable(R.color.light_brown));
                            binding.gateout.setTextColor(getResources().getColor(R.color.black));
                        }
                    }
                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });

        maintenancesViewModel.getMaintenanceUpdate().observe(this, maintenanceUpdateStatusResponseModule -> {
            if (maintenanceUpdateStatusResponseModule != null) {
                if (maintenanceUpdateStatusResponseModule.getData() != null) {

                    if (gateEntry != null) {
                        binding.gateEntry.setEnabled(true);
                        binding.gateEntry.setBackground(getResources().getDrawable(R.color.dark_green));
                        binding.gateEntry.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        binding.gateEntry.setEnabled(true);
                        binding.gateEntry.setBackground(getResources().getDrawable(R.color.light_brown));
                        binding.gateEntry.setTextColor(getResources().getColor(R.color.black));
                    }
                    if (testDriver != null) {
                        binding.testDrive.setEnabled(true);
                        binding.testDrive.setBackground(getResources().getDrawable(R.color.dark_green));
                        binding.testDrive.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        binding.testDrive.setEnabled(true);
                        binding.testDrive.setBackground(getResources().getDrawable(R.color.light_brown));
                        binding.testDrive.setTextColor(getResources().getColor(R.color.black));
                    }
                    if (driverStatus != null) {
                        binding.driverStatus.setEnabled(true);
                        binding.driverStatus.setBackground(getResources().getDrawable(R.color.dark_green));
                        binding.driverStatus.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        binding.driverStatus.setEnabled(true);
                        binding.driverStatus.setBackground(getResources().getDrawable(R.color.light_brown));
                        binding.driverStatus.setTextColor(getResources().getColor(R.color.black));
                    }
                    if (vehiclePlaced != null) {
                        binding.vehiclePlaced.setEnabled(true);
                        binding.vehiclePlaced.setBackground(getResources().getDrawable(R.color.dark_green));
                        binding.vehiclePlaced.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        binding.vehiclePlaced.setEnabled(true);
                        binding.vehiclePlaced.setBackground(getResources().getDrawable(R.color.light_brown));
                        binding.vehiclePlaced.setTextColor(getResources().getColor(R.color.black));
                    }
                    if (gateout != null) {
                        binding.gateout.setEnabled(true);
                        binding.gateout.setBackground(getResources().getDrawable(R.color.dark_green));
                        binding.gateout.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        binding.gateout.setEnabled(true);
                        binding.gateout.setBackground(getResources().getDrawable(R.color.light_brown));
                        binding.gateout.setTextColor(getResources().getColor(R.color.black));
                    }

                    showToast(maintenanceUpdateStatusResponseModule.getStatusMsg());

                } else {
                    showToast(getResources().getString(R.string.no_data));
                }
            } else {
                showToast(getResources().getString(R.string.something_wrong));
            }
        });
    }

    private void selectTrip(ArrayList<String> workList, String type) {

        if (type.equals("work")) {
            workOrderList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, workList) {

                public View getView(int position, View convertView, ViewGroup parent) {
                    View v = super.getView(position, convertView, parent);

                    return v;
                }

                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = super.getDropDownView(position, convertView, parent);

                    return v;
                }
            };
            binding.spinnerTripsIds.setAdapter(workOrderList);
        }

        if (type.equals("vehicel")) {
            workOrderList = new ArrayAdapter<String>(getContext(), R.layout.spinner_text_view, workList) {

                public View getView(int position, View convertView, ViewGroup parent) {
                    View v = super.getView(position, convertView, parent);

                    return v;
                }

                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = super.getDropDownView(position, convertView, parent);

                    return v;
                }
            };
            binding.spinnerTripsLoads.setAdapter(workOrderList);
        }
    }

    private void popup(String type) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.accept_trip_popup, null);
        final AlertDialog alertDialog = dialogBuilder.create();
        //String userId,email,mobileNo;

        TextView acceptTrip = (TextView) dialogView.findViewById(R.id.accept_trip);
        TextView tripYes = (TextView) dialogView.findViewById(R.id.tripYes);
        TextView tripNo = (TextView) dialogView.findViewById(R.id.tripNo);
        EditText kilometerGate = (EditText) dialogView.findViewById(R.id.kilometerGate);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setView(dialogView);
        alertDialog.setCancelable(false);
        alertDialog.show();

        alertDialog.show();

        if (type.equals("gateEntry")) {
            acceptTrip.setText(R.string.gate_entry);
        } else if (type.equals("testDriver")) {
            acceptTrip.setText(R.string.driver_test);
        }/*else if(type.equals("takeover")){

        }else if(type.equals("handover")){

        }*/ else if (type.equals("driverStatus")) {
            acceptTrip.setText(R.string.driver_status);
            tripYes.setText(R.string.good);
            tripNo.setText(R.string.bad);
        } else if (type.equals("vehiclePlaced")) {
            acceptTrip.setText(R.string.vehicle_placed_);
        } else if (type.equals("gateout")) {
            acceptTrip.setText(R.string.placed_gate);
        }
        //acceptTrip.setText(R.string.placed_gate);

        tripYes.setOnClickListener(v1 -> {
            alertDialog.dismiss();
            Toast.makeText(getContext(), "Yes", Toast.LENGTH_SHORT).show();

            if (type.equals("gateEntry")) {
                dateAndTime();
                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(dateTime);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(testDriver);
                maintenanceUpdateStatusRequestModule.setTakeover(null);
                maintenanceUpdateStatusRequestModule.setHandover(null);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(driverStatus);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(vehiclePlaced);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(gateout);
                maintenanceUpdateStatusRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                maintenanceUpdateStatusRequestModule.setVehicleId(binding.spinnerTripsLoads.getSelectedItem().toString());
                maintenanceUpdateStatusRequestModule.setWorkOrderId(binding.spinnerTripsIds.getSelectedItem().toString());
            }
            if (type.equals("testDriver")) {
                dateAndTime();
                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(gateEntry);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(dateTime);
                maintenanceUpdateStatusRequestModule.setTakeover(null);
                maintenanceUpdateStatusRequestModule.setHandover(null);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(driverStatus);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(vehiclePlaced);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(gateout);
                maintenanceUpdateStatusRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                maintenanceUpdateStatusRequestModule.setCountry(LoginActivity.country);
                maintenanceUpdateStatusRequestModule.setVehicleId(binding.spinnerTripsLoads.getSelectedItem().toString());
                maintenanceUpdateStatusRequestModule.setWorkOrderId(binding.spinnerTripsIds.getSelectedItem().toString());
            }
            if (type.equals("driverStatus")) {
                dateAndTime();
                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(gateEntry);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(testDriver);
                maintenanceUpdateStatusRequestModule.setTakeover(null);
                maintenanceUpdateStatusRequestModule.setHandover(null);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(tripYes.getText().toString());
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(vehiclePlaced);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(gateout);
                maintenanceUpdateStatusRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                maintenanceUpdateStatusRequestModule.setCountry(LoginActivity.country);
                maintenanceUpdateStatusRequestModule.setVehicleId(binding.spinnerTripsLoads.getSelectedItem().toString());
                maintenanceUpdateStatusRequestModule.setWorkOrderId(binding.spinnerTripsIds.getSelectedItem().toString());
            }
            if (type.equals("vehiclePlaced")) {
                dateAndTime();
                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(gateEntry);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(testDriver);
                maintenanceUpdateStatusRequestModule.setTakeover(null);
                maintenanceUpdateStatusRequestModule.setHandover(null);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(tripYes.getText().toString());
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(dateTime);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(gateout);
                maintenanceUpdateStatusRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                maintenanceUpdateStatusRequestModule.setCountry(LoginActivity.country);
                maintenanceUpdateStatusRequestModule.setVehicleId(binding.spinnerTripsLoads.getSelectedItem().toString());
                maintenanceUpdateStatusRequestModule.setWorkOrderId(binding.spinnerTripsIds.getSelectedItem().toString());
            }
            if (type.equals("gateout")) {
                dateAndTime();
                maintenanceUpdateStatusRequestModule.setGateEntryDateTime(gateEntry);
                maintenanceUpdateStatusRequestModule.setTestDriveBy(testDriver);
                maintenanceUpdateStatusRequestModule.setTakeover(null);
                maintenanceUpdateStatusRequestModule.setHandover(null);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(tripYes.getText().toString());
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(vehiclePlaced);
                maintenanceUpdateStatusRequestModule.setTestDriveStatus(dateTime);
                maintenanceUpdateStatusRequestModule.setOrganizationIdName(LoginActivity.organizationIdName);
                maintenanceUpdateStatusRequestModule.setCountry(LoginActivity.country);
                maintenanceUpdateStatusRequestModule.setVehicleId(binding.spinnerTripsLoads.getSelectedItem().toString());
                maintenanceUpdateStatusRequestModule.setWorkOrderId(binding.spinnerTripsIds.getSelectedItem().toString());
            }

            maintenancesViewModel.getMaintenanceUpdateStatus(maintenanceUpdateStatusRequestModule, LoginActivity.accessToken, LoginActivity.tenantId);

        });

        tripNo.setOnClickListener(v1 -> {
            alertDialog.dismiss();
        });
    }

    private void dateAndTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        String calDate = currentDay + "/" + (currentMonth + 1) + "/" + currentYear;


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formattedDate = df.format(c);


        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        Date newDate = null;
        try {
            newDate = spf.parse(calDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("MM");
        String month_no = spf.format(newDate);
        dateTime = String.valueOf(formattedDate + " " + currentTime);
    }
}