package com.example.mad_cafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> foodArrayList){
        super(context, 0, foodArrayList );
    }

    public View getView(int position, View convertView, ViewGroup parent){

        Food myFood = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView FoodName = (TextView) convertView.findViewById(R.id.foodName);
        TextView FoodDescription = (TextView) convertView.findViewById(R.id.foodDescription);
        TextView FoodCost = (TextView) convertView.findViewById(R.id.foodCost);

        FoodName.setText(myFood.getName());
        FoodDescription.setText(myFood.getDesc());
        FoodCost.setText("$" + myFood.getPrice());

        return convertView;

    }

}
