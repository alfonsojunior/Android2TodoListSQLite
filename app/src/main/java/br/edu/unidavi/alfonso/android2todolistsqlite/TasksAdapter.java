package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private final OnTaskClickListener listener;
    private List<Task> tasks = new ArrayList<>();
    private DateFormat format = new SimpleDateFormat("dd MMM yyyy, hh:mm");

    public TasksAdapter(OnTaskClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(
                    android.R.layout.simple_list_item_2,
                    parent,
                    false
            ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Task task = tasks.get(position);
        holder.title.setText(task.getTitle());
        holder.date.setText(format.format(task.getData()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(task);
            }
        });

        if (task.isDone()) {
            holder.title.setTextColor(Color.RED);
        } else {
            holder.title.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setup(List<Task> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }

    class  ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
            date = itemView.findViewById(android.R.id.text2);
        }
    }

    interface OnTaskClickListener {
        void onClick(Task task);
    }
}
