package com.example.aac.tasklist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aac.R;
import com.example.aac.database.TaskModel;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<TaskModel> tasksList;
    private View.OnLongClickListener longClickListener;

    public TaskAdapter(List<TaskModel> taskList, View.OnLongClickListener longClickListener) {
        tasksList = taskList;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        TaskModel taskModel = tasksList.get(position);
        holder.itemTaskTitle.setText(taskModel.getTaskTitle());
        holder.itemTaskDesc.setText(taskModel.getTaskDesc());
        holder.itemView.setTag(taskModel);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public void addTask(List<TaskModel> taskList){
        this.tasksList = taskList;
        notifyDataSetChanged();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView itemTaskTitle;
        TextView itemTaskDesc;

        public TaskViewHolder(View itemView) {
            super(itemView);

            itemTaskTitle = itemView.findViewById(R.id.item_task_title);
            itemTaskDesc = itemView.findViewById(R.id.item_task_desc);
        }
    }
}
