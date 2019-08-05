package com.example.mvvm_server.network;

import android.content.Context;
import android.support.annotation.NonNull;

import retrofit2.Callback;
import retrofit2.Response;

public class Call {

    private retrofit2.Call<FlowersResponse> call;
    private Delegate delegate;


    public Call(Context context, Delegate delegate) {
        this.delegate = delegate;
    }

    public void execute() {
        ICall callInterface = Api.getClient().create(ICall.class);
        call = callInterface.getAllFlowers();
        call.enqueue(new Callback<FlowersResponse>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<FlowersResponse> call,
                                   @NonNull Response<FlowersResponse> response) {
                int statusCode = response.code();
                if(statusCode == Config.RESP_OK) {
                    delegate.onSuccess(response.body());
                } else {
                    delegate.onFailure("On Failure - " + statusCode);
                }
            }
            @Override
            public void onFailure(@NonNull retrofit2.Call<FlowersResponse> call, @NonNull Throwable t) {
                delegate.onFailure(t.getMessage());
            }
        });
    }

    public interface Delegate {
        void onSuccess(FlowersResponse flowersResponse);
        void onFailure(Object t);
    }
}
