package com.example.mvvm_server.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.mvvm_server.R;
import com.example.mvvm_server.network.Call;
import com.example.mvvm_server.network.FlowersResponse;
import com.example.mvvm_server.databinding.ActivityFlowersBinding;

public class FlowersActivity extends AppCompatActivity {

    private ActivityFlowersBinding binding;
    private Call call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_flowers);
        binding.flowersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        call = new Call(this, new Call.Delegate() {
            @Override
            public void onSuccess(FlowersResponse flowersResponse) {
                binding.flowersRecyclerView.setAdapter(new FlowersAdapter(flowersResponse.listFlowers));
            }

            @Override
            public void onFailure(Object t) {
                Toast.makeText(getApplicationContext(), "Error = "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        call.execute();

    }
}
