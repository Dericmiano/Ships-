package com.example.ships;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ships.adapter.OnShipClickListener;
import com.example.ships.adapter.ShipRecyclerViewAdapter;
import com.example.ships.model.Ship;
import com.example.ships.model.ShipViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Fragment implements OnShipClickListener {
    private RecyclerView recyclerView;
    private ShipRecyclerViewAdapter shipRecyclerViewAdapter;
    private List<Ship> shipList;
    private ShipViewModel shipViewModel;

    public MainActivity(){

    }
    public static MainActivity newInstance() {
        MainActivity fragment = new MainActivity();
        Bundle args = new Bundle();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shipList = new ArrayList<>();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shipViewModel = new ViewModelProvider(requireActivity())
                .get(ShipViewModel.class);
        if (shipViewModel.getShips().getValue() != null){
            shipList = shipViewModel.getShips().getValue();
            shipRecyclerViewAdapter = new ShipRecyclerViewAdapter(shipList, this);
            recyclerView.setAdapter(shipRecyclerViewAdapter);//
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    @Override
    public void onShipClicked(Ship ship) {
        shipViewModel.setSelectedShip(ship);
        getFragmentManager().beginTransaction()
                .replace(R.id.activity_main, DetailsActivity.newInstance())
                .commit();

    }
}