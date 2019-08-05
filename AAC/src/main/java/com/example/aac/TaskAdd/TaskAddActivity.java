package com.example.aac.TaskAdd;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aac.R;
import com.example.aac.database.TaskModel;

public class TaskAddActivity extends AppCompatActivity {

    private EditText inputTaskTitle;
    private EditText inputTaskDescription;
    private TaskAddViewModel taskAddViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);

        inputTaskTitle = findViewById(R.id.task_title);
        inputTaskDescription = findViewById(R.id.task_desc);

        taskAddViewModel = ViewModelProviders.of(this).get(TaskAddViewModel.class);

        FloatingActionButton fabDoneTask = findViewById(R.id.fab_done);
        fabDoneTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskTitle = inputTaskTitle.getText().toString();
                String taskDescription = inputTaskDescription.getText().toString();

                if(taskTitle.isEmpty() || taskDescription.isEmpty()){
                    Toast.makeText(TaskAddActivity.this, R.string.input_error, Toast.LENGTH_SHORT).show();
                }else{
                    taskAddViewModel.addTask(new TaskModel(inputTaskTitle.getText().toString(),
                            inputTaskDescription.getText().toString()
                    ));
                    finish();
                }
            }
        });
    }
}
