package com.example.ships.data;

import com.example.ships.model.Ship;

import java.util.List;

public interface AsyncResponse {
    void processShip(List<Ship> ships);
}
