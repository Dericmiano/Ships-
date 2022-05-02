package com.example.ships.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ShipViewModel extends ViewModel {
    private final MutableLiveData<Ship> selectedShip = new MutableLiveData<>();
    private final MutableLiveData<List<Ship>> selectedShips = new MutableLiveData<>();

    public LiveData<Ship> getSelectedShip() {
        return selectedShip;
    }
    public void setSelectedShip(Ship ship) {
        selectedShip.setValue(ship);
    }
    public LiveData<List<Ship>> getShips() { return  selectedShips; }
    public void setSelectedParks(List<Ship> ships) { selectedShips.setValue(ships); }


}
