package com.example.aac_server.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aac_server.R;
import com.example.aac_server.model.Flowers;
import com.example.aac_server.viewmodel.FlowersViewModel;

import java.util.List;

public class FlowersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FlowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        recyclerView = findViewById(R.id.rv_flowers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FlowersViewModel flowersViewModel = ViewModelProviders.of(this).get(FlowersViewModel.class);

        flowersViewModel.getFlowers().observe(this, new Observer<List<Flowers>>() {
            @Override
            public void onChanged(@Nullable List<Flowers> flowerList) {
                adapter = new FlowersAdapter(FlowersActivity.this, flowerList);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
