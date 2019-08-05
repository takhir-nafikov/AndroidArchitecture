package com.example.mvp_server.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_server.R;
import com.example.mvp_server.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerHolder> {

    private Context context;
    private List<Flower> flowers;

    public FlowerAdapter(Context context, List<Flower> flowers) {
        this.flowers = flowers;
        this.context = context;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
        notifyDataSetChanged();
    }

    @Override
    public FlowerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_item, parent, false);
        return new FlowerHolder(view);
    }

    @Override
    public void onBindViewHolder(FlowerHolder holder, int position) {
        Flower item = flowers.get(position);
        holder.flower = item;

        holder.flowerRus.setText(item.getFlower_rus());
        holder.flowerLat.setText(item.getFlower_lat());
        holder.flowerDesc.setText(item.getFlower_desc());

        Picasso.with(context)
                .load(item.getFlower_img())
                .error(R.drawable.ic_flower)
                .placeholder(R.drawable.ic_flower)
                .fit()
                .into(holder.flowerImg);
    }

    @Override
    public int getItemCount() {
        if (flowers == null) {
            return 0;
        } else {
            return flowers.size();
        }
    }

    static class FlowerHolder extends RecyclerView.ViewHolder{

        Flower flower;
        ImageView flowerImg;
        TextView flowerRus, flowerLat, flowerDesc;

        FlowerHolder(View itemView) {
            super(itemView);

            flowerImg = itemView.findViewById(R.id.flower_img);
            flowerRus = itemView.findViewById(R.id.flower_rus);
            flowerLat = itemView.findViewById(R.id.flower_lat);
            flowerDesc = itemView.findViewById(R.id.flower_desc);
        }
    }
}
