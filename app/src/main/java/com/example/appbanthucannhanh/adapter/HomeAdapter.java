package com.example.appbanthucannhanh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanthucannhanh.R;
import com.example.appbanthucannhanh.model.Home;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<Home> comboList;

    public HomeAdapter(Context context, List<Home> comboList) {
        this.context = context;
        this.comboList = comboList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_comboitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Home data = comboList.get(position);
        holder.imageView.setImageResource(data.getImageResource());
        holder.nameTextView.setText(data.getName());
        holder.priceTextView.setText(data.getPrice());
        holder.descriptionTextView.setText(data.getDescription());

        // Set a click listener for the "Add" button if needed
        // holder.addButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         // Handle button click
        //     }
        // });
    }

    @Override
    public int getItemCount() {
        return comboList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView priceTextView;
        TextView descriptionTextView;
        Button addButton;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_comboitems_img);
            nameTextView = itemView.findViewById(R.id.home_comboitems_txtname);
            priceTextView = itemView.findViewById(R.id.home_comboitems_txtprice);
            descriptionTextView = itemView.findViewById(R.id.home_comboitems_des);
            addButton = itemView.findViewById(R.id.addcard_combo);
        }
    }
}
