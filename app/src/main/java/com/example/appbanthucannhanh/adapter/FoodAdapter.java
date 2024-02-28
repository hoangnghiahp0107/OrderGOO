package com.example.appbanthucannhanh.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appbanthucannhanh.R;
import com.example.appbanthucannhanh.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends  RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    Activity context;
    ArrayList<Food> arr_Food;
    public FoodAdapter(Activity context, ArrayList<Food> arr_Food){
        this.context=context;
        this.arr_Food=arr_Food;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewFood = layoutInflater.inflate(R.layout.foods, parent, false);
        ViewHolder viewHolderFood = new ViewHolder(viewFood);
        return viewHolderFood;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = arr_Food.get(position);
        holder.imageFood.setImageResource(food.getImageFood());
        holder.nameFood.setText(food.getNameFood());
        holder.priceFood.setText(food.getPriceFood()+ ".000đ");
        holder.introFood.setText(food.getIntroFood());
    }

    @Override
    public int getItemCount() {
        return arr_Food.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageFood;
        TextView nameFood, priceFood, introFood;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFood = itemView.findViewById(R.id.imageFood);
            nameFood = itemView.findViewById(R.id.nameFood);
            priceFood = itemView.findViewById(R.id.priceFood);
            introFood = itemView.findViewById(R.id.introFood);
        }
    }
}
