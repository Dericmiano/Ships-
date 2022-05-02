package com.example.ships.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ships.R;
import com.example.ships.model.Ship;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShipRecyclerViewAdapter extends RecyclerView.Adapter<ShipRecyclerViewAdapter.ViewHolder> {
    private final List<Ship> shipList;
    private final OnShipClickListener onShipClickListener;

    public ShipRecyclerViewAdapter(List<Ship> shipList, OnShipClickListener onShipClickListener) {
        this.shipList = shipList;
        this.onShipClickListener = onShipClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ship_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Ship ship = shipList.get(position);
    holder.shipName.setText(ship.getShip_name());
    holder.shipHome_port.setText(ship.getHome_port());
    holder.shipType.setText(ship.getShip_type());
    Picasso.get().load(ship.getUrl_image())
            .placeholder(android.R.drawable.stat_sys_download)
            .error(android.R.drawable.stat_notify_error)
            .resize(100,100)
            .centerCrop()
            .into(holder.shipImage);

    }

    @Override
    public int getItemCount() {
        return shipList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView shipImage;
        public TextView shipName;
        public TextView shipType;
        public  TextView shipHome_port;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            shipImage = itemView.findViewById(R.id.row_ship_imageView);
            shipName = itemView.findViewById(R.id.row_shipName);
            shipType = itemView.findViewById(R.id.row_ship_type);
            shipHome_port = itemView.findViewById(R.id.row_ship_home);
        }
        @Override
        public void onClick(View v) {
            Ship curr_shipPark = shipList.get(getAdapterPosition());
            onShipClickListener.onShipClicked(curr_shipPark);



        }
    }
}
