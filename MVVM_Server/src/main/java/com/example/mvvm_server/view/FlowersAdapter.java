package com.example.mvvm_server.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvvm_server.R;
import com.example.mvvm_server.model.Flowers;
import com.example.mvvm_server.viewmodel.FlowersViewModel;
import com.example.mvvm_server.databinding.ItemFlowersBinding;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.FlowersViewHolder> {

    private List<Flowers> flowers;

    public FlowersAdapter(List<Flowers> flowers) {
        this.flowers = flowers;
    }

    @Override
    public FlowersAdapter.FlowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFlowersBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_flowers,parent,false);
        return new FlowersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(FlowersAdapter.FlowersViewHolder holder, int position) {
        ItemFlowersBinding binding = holder.binding;
        // TODO 
        //binding.setItem(new FlowersViewModel(flowers.get(position)));
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public class FlowersViewHolder extends RecyclerView.ViewHolder {
        ItemFlowersBinding binding;

        public FlowersViewHolder(ItemFlowersBinding binding) {
            super(binding.flowerItem);
            this.binding = binding;
        }
    }
}