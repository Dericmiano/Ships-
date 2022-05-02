package com.example.ships.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Missions {
    private String name;
    private int flight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }
    static Missions fill(JSONObject jsonobj) throws JSONException {
        Missions entity = new Missions();
        if (jsonobj.has("flight")) {
            entity.setFlight(jsonobj.getInt("flight"));
        }
        if (jsonobj.has("name")) {
            entity.setName(jsonobj.getString("name"));
        }
        return entity;
    }
    static List<Missions> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Missions> olist = new ArrayList<Missions>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
