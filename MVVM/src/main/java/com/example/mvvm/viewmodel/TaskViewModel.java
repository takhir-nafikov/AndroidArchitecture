package com.example.mvvm.viewmodel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvvm.R;
import com.example.mvvm.databinding.TaskListBinding;
import com.example.mvvm.model.TaskItem;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends Fragment {
    public List<TaskItem> taskItemList;

    public TaskAdapter adapter;

    TaskListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.task_list, container, false);

        binding = DataBindingUtil.setContentView(getActivity(), R.layout.task_list);

        taskItemList = new ArrayList<>();
        adapter = new TaskAdapter(getActivity(), taskItemList);

        LinearLayoutManager LayoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(LayoutManager);
        binding.recyclerView.setAdapter(adapter);

        binding.addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddItem();
            }
        });

        return view;
    }

    public void onAddItem() {
        String inputStr = binding.editNewItem.getText().toString();

        if(TextUtils.isEmpty(inputStr)) {
            Toast.makeText(getActivity(), R.string.no_task, Toast.LENGTH_LONG).show();
            return;
        }

        TaskItem taskItem = new TaskItem();

        taskItem.event.set(inputStr);
        taskItem.state.set(getResources().getString(R.string.undo_status));

        taskItemList.add(taskItem);

        adapter.notifyDataSetChanged();
    }
}
