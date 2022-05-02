package com.example.ships.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ships.controller.AppController;
import com.example.ships.model.Missions;
import com.example.ships.model.Ship;
import com.example.ships.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static List<Ship> shipList = new ArrayList<>();
    public static void getShips(final AsyncResponse callback){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Util.SHIPS_URL,
                null,response -> {
            for (int i = 0; i < response.length(); i++) {
                try{
                    Ship ship = new Ship();
                    JSONObject jsonObject = response.getJSONObject(String.valueOf(i));
                    ship.setYear(jsonObject.getInt("year"));
                    ship.setShip_name(jsonObject.getString("ship_name"));
                    ship.setShip_id(jsonObject.getString("ship_id"));
                    ship.setActive(jsonObject.getBoolean("active"));
                    ship.setImo(jsonObject.getInt("imo"));
                    ship.setMmsi(jsonObject.getInt("mmsi"));
                    ship.setWeight(jsonObject.getInt("weight_lbs"));
                    ship.setUrl(jsonObject.getString("url"));
                    ship.setUrl_image(jsonObject.getString("image"));
                    ship.setShip_model(jsonObject.getString("ship_model"));
                    ship.setAbs(jsonObject.getInt("abs"));
                    ship.setClass2(jsonObject.getInt("class"));
                    ship.setShip_type(jsonObject.getString("ship_type"));

                    JSONArray missionArray = jsonObject.getJSONArray("missions");
                    List<Missions> missionsList = new ArrayList<>();
                    for (int j = 0; j < missionArray.length(); j++) {
                        Missions missions = new Missions();
                        missions.setName(missionArray.getJSONObject(j).getString("name"));
                        missions.setFlight(missionArray.getJSONObject(j).getInt("flight"));

                        missionsList.add(missions);
                    }
                    ship.setMissions(missionsList);

                    shipList.add(ship);


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (null != callback){callback.processShip(shipList);}


        },error -> {
            error.printStackTrace();
        }
                );
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}

