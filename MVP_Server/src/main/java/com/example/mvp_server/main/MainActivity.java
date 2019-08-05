package com.example.mvp_server.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mvp_server.R;
import com.example.mvp_server.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    RecyclerView recyclerView;
    FlowerAdapter flowerAdapter;
    MainContract.MainPresenter presenter;
    ArrayList<Flower> flowerArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_flowers);

        flowerAdapter = new FlowerAdapter(this,flowerArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(flowerAdapter);

        presenter = new MainPresenter(this);
        presenter.getAllFlowers();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAllFlowers(List<Flower> flowers) {
        flowerAdapter.setFlowers(flowers);
    }
}
