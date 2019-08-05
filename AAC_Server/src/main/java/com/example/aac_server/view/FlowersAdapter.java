package com.example.aac_server.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aac_server.R;
import com.example.aac_server.model.Flowers;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowersHolder> {

    private Context context;
    private List<Flowers> flowersList;

    public FlowersAdapter(Context context, List<Flowers> flowersList) {
        this.context = context;
        this.flowersList = flowersList;
    }

    @NonNull
    @Override
    public FlowersAdapter.FlowersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_flowers, parent,
                false);
        return new FlowersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowersAdapter.FlowersHolder holder, int position) {
        Flowers flowers = flowersList.get(position);

        holder.flowerImgFile.setText(flowers.getFlower_img_file());
        holder.flowerRus.setText(flowers.getFlower_rus());
        holder.flowerLat.setText(flowers.getFlower_lat());
        holder.flowerDesc.setText(flowers.getFlower_desc());

        Glide.with(context)
                .load(flowers.getFlower_img())
                .into(holder.flowerImg);
    }

    @Override
    public int getItemCount() {
        return flowersList.size();

    }

    public class FlowersHolder extends RecyclerView.ViewHolder {

        ImageView flowerImg;
        TextView flowerImgFile, flowerRus, flowerLat, flowerDesc;

        public FlowersHolder(View itemView) {
            super(itemView);

            flowerImgFile = itemView.findViewById(R.id.flower_img_file);
            flowerImg = itemView.findViewById(R.id.flower_img);
            flowerRus = itemView.findViewById(R.id.flower_rus);
            flowerLat = itemView.findViewById(R.id.flower_lat);
            flowerDesc = itemView.findViewById(R.id.flower_desc);

        }
    }
}
