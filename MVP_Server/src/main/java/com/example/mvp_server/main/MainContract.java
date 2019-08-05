package com.example.mvp_server.main;

import com.example.mvp_server.model.Flower;

import java.util.List;

public interface MainContract {
    interface MainView {
        void showMessage(String message);
        void showAllFlowers(List<Flower> flowers);
    }

    interface MainPresenter {
        void getAllFlowers();
    }
}
