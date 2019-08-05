package com.example.aac_server.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.aac_server.model.Flowers;
import com.example.aac_server.network.ApiFlowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlowersViewModel extends ViewModel {

    private MutableLiveData<List<Flowers>> flowerList;

    public LiveData<List<Flowers>> getFlowers() {
        //если список пуст
        if (flowerList == null) {
            flowerList = new MutableLiveData<List<Flowers>>();
            //загружаем данные с сервера
            loadFlowers();
        }
        return flowerList;
    }

    private void loadFlowers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiFlowers.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiFlowers api = retrofit.create(ApiFlowers.class);
        Call<List<Flowers>> call = api.getFlowers();


        call.enqueue(new Callback<List<Flowers>>() {
            @Override
            public void onResponse(@NonNull Call<List<Flowers>> call,
                                   @NonNull Response<List<Flowers>> response) {

                //устанавливаем список через MutableLiveData
                flowerList.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Flowers>> call, @NonNull Throwable t) {

            }
        });
    }
}
