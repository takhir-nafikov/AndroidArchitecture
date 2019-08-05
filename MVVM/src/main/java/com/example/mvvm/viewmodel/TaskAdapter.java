package com.example.mvvm.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm.R;
import com.example.mvvm.databinding.TaskItemBinding;
import com.example.mvvm.model.TaskItem;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<TaskItem> taskItemList;
    private final LayoutInflater inflater;
    private Context context;
    TaskItemBinding binding;

    public TaskAdapter(Context context, List<TaskItem> taskItemList) {
        inflater = LayoutInflater.from(context);
        this.taskItemList = taskItemList;
        this.context = context;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
        TaskItem item = taskItemList.get(position);
        holder.takeItem(item);
    }

    @Override
    public int getItemCount() {
        if(taskItemList != null) {
            return taskItemList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }

        public void takeItem(final TaskItem item) {
            getBinding().setVariable(com.example.mvvm.BR.taskitem, item);
            getBinding().executePendingBindings();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.state.get().equals(context.getString(R.string.undo_status))) {
                        item.state.set(context.getString(R.string.done_status));
                    } else {
                        item.state.set(context.getString(R.string.undo_status));
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    taskItemList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return false;
                }
            });
        }
    }
}
