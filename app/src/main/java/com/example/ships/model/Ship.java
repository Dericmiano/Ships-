package com.example.ships.model;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String ship_id;
    private String ship_name;
    private String ship_model;
    private String ship_type;
    private String home_port;
    private Boolean active;
    private int imo;
    private int mmsi;
    private int abs;
    private  int class2;
    private int weight;
    private int year;
    private List<Missions> missions;
    private String url;
    private String url_image;
    static Ship fill(JSONObject jsonobj) throws JSONException {
        Ship entity = new Ship();
        if (jsonobj.has("ship_id")) {
            entity.setShip_id(jsonobj.getString("ship_id"));
        }
        if (jsonobj.has("home_port")) {
            entity.setHome_port(jsonobj.getString("home_port"));
        }
        if (jsonobj.has("ship_name")) {
            entity.setShip_name(jsonobj.getString("ship_name"));
        }
        if (jsonobj.has("ship_model")) {
            entity.setShip_model(jsonobj.getString("ship_model"));
        }
        if (jsonobj.has("ship_type")) {
            entity.setShip_type(jsonobj.getString("ship_type"));
        }
        if (jsonobj.has("active")) {
            entity.setActive(jsonobj.getBoolean("active"));
        }
        if (jsonobj.has("imo")) {
            entity.setImo(jsonobj.getInt("imo"));
        }
        if (jsonobj.has("mmsi")) {
            entity.setMmsi(jsonobj.getInt("mmsi"));
        }
        if (jsonobj.has("abs")) {
            entity.setAbs(jsonobj.getInt("abs"));
        }
        if (jsonobj.has("class")) {
            entity.setClass2(jsonobj.getInt("class"));
        }
        if (jsonobj.has("weight")) {
            entity.setWeight(jsonobj.getInt("weight"));
        }
        if (jsonobj.has("year")) {
            entity.setYear(jsonobj.getInt("year"));
        }
        if (jsonobj.has("url")) {
            entity.setUrl(jsonobj.getString("url"));
        }
        if (jsonobj.has("url_image")) {
            entity.setUrl_image(jsonobj.getString("url_image"));
        }
        if (jsonobj.has("missions")) {
            entity.setMissions((List<Missions>) jsonobj.getJSONArray("missions"));
        }
        return entity;
    }
    static List<Ship> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return null;
        List<Ship> olist = new ArrayList<Ship>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

    public String getHome_port() {
        return home_port;
    }

    public void setHome_port(String home_port) {
        this.home_port = home_port;
    }

    public int getClass2() {
        return class2;
    }

    public void setClass2(int class2) {
        this.class2 = class2;
    }

    public String getShip_id() {
        return ship_id;
    }

    public void setShip_id(String ship_id) {
        this.ship_id = ship_id;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getShip_model() {
        return ship_model;
    }

    public void setShip_model(String ship_model) {
        this.ship_model = ship_model;
    }

    public String getShip_type() {
        return ship_type;
    }

    public void setShip_type(String ship_type) {
        this.ship_type = ship_type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getImo() {
        return imo;
    }

    public void setImo(int imo) {
        this.imo = imo;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Missions> getMissions() {
        return missions;
    }

    public void setMissions(List<Missions> missions) {
        this.missions = missions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
