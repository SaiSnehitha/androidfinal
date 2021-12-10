package com.example.finalexamandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlacesAdapter extends BaseAdapter {
    ArrayList<Countries> data=new ArrayList<>();
    //to connect the list with the corresponding row_xml file
    LayoutInflater inflater;

    //constructor
    public PlacesAdapter(Context context, ArrayList<Countries> data){
        this.data=data;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.places_row,null);
            holder=new ViewHolder();
            holder.placeName=convertView.findViewById(R.id.txvPlacesName);
            holder.placePrice=convertView.findViewById(R.id.txvPricePlaces);
            holder.placeImage=convertView.findViewById(R.id.imgViewPlaces);
            convertView.setTag(holder);
        }else
            holder=(ViewHolder) convertView.getTag();
        holder.placeName.setText(data.get(position).getPlaces());
        holder.placePrice.setText(String.valueOf(data.get(position).getPrice()));
        holder.placeImage.setImageResource(data.get(position).getImage());
        return convertView;
    }
    static class ViewHolder{
        private TextView placeName;
        private TextView placePrice;
        private ImageView placeImage;
    }
}
