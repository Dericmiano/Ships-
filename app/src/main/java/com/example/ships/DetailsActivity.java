package com.example.ships;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ships.model.ShipViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DetailsActivity extends Fragment {
    private ShipViewModel shipViewModel;
    private TextView shipName;
    private TextView shipType;
    private TextView shipModel;
    private TextView active;
    private TextView imo;
    private TextView mmsi;
    private TextView abs;
    private TextView class2;
    private TextView weight;
    private TextView year;
    private ImageView imageView;
    private TextView missions;
    private TextView homePort;


    public DetailsActivity() {
    }

    public static DetailsActivity newInstance() {
        DetailsActivity fragment = new DetailsActivity();

        Bundle args = new Bundle();

        return fragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        {
            shipViewModel = new ViewModelProvider(requireActivity())
                    .get(ShipViewModel.class);
//        View view = inflater.inflate(R.layout.activity_details, container, false);
            shipName = view.findViewById(R.id.details_ship_name);
            shipModel = view.findViewById(R.id.details_ship_model);
            shipType = view.findViewById(R.id.details_ship_typ);
            mmsi = view.findViewById(R.id.details_mmsi);
            missions = view.findViewById(R.id.details_missions);
            year = view.findViewById(R.id.details_year);
            weight = view.findViewById(R.id.details_weight);
            class2 = view.findViewById(R.id.details_class);
            imo = view.findViewById(R.id.details_imo);
            active = view.findViewById(R.id.details_active);
            imageView = view.findViewById(R.id.details_image);
            abs = view.findViewById(R.id.details_abs);
            homePort = view.findViewById(R.id.details_home_port);

            shipViewModel.getSelectedShip().observe(getViewLifecycleOwner(), ship -> {
                shipModel.setText(ship.getShip_model());
                mmsi.setText(ship.getMmsi());
                shipName.setText(ship.getShip_name());
                shipType.setText(ship.getShip_type());
                homePort.setText(ship.getHome_port());
                year.setText(ship.getYear());
                weight.setText(ship.getWeight());
                class2.setText(ship.getClass2());
                imo.setText(ship.getImo());
                active.setText(ship.getActive().toString());
//                imageView.setImageURI(ship.getUrl_image());
                abs.setText(ship.getAbs());



                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < ship.getMissions().size(); i++) {
                    stringBuilder.append(ship.getMissions().get(i).getName())
                            .append(" | ");

                }
                missions.setText(stringBuilder);

            });



        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_details, container, false);
    }
}
