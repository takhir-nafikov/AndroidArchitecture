package com.example.aac.tasklist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.aac.R;
import com.example.aac.TaskAdd.TaskAddActivity;
import com.example.aac.database.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity implements View.OnLongClickListener {

    private TaskViewModel taskViewModel;
    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        FloatingActionButton fabAddTask = findViewById(R.id.fab_add);

        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTaskIntent = new Intent(TaskActivity.this, TaskAddActivity.class);
                startActivity(addTaskIntent);
            }
        });

        taskRecyclerView = findViewById(R.id.rv_list);
        taskAdapter = new TaskAdapter(new ArrayList<TaskModel>(), this);
        layoutManager = new LinearLayoutManager(this);
        taskRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(taskRecyclerView.getContext(),
                layoutManager.getOrientation());
        taskRecyclerView.addItemDecoration(dividerItemDecoration);

        taskRecyclerView.setAdapter(taskAdapter);

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        taskViewModel.getTaskList().observe(TaskActivity.this, new Observer<List<TaskModel>>() {
            @Override
            public void onChanged(@Nullable List<TaskModel> taskModels) {
                taskAdapter.addTask(taskModels);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        TaskModel taskModel = (TaskModel)view.getTag();
        taskViewModel.deleteTask(taskModel);
        Toast.makeText(this, taskModel.getTaskTitle()+" - Удалено!", Toast.LENGTH_SHORT).show();
        return true;
    }
}
