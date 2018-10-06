package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;
    private TasksViewModel viewModel;
    //private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        //helper = new DatabaseHelper(this);

        int id = getIntent().getIntExtra("id", 0);

        viewModel = ViewModelProviders.of(this).get(TasksViewModel.class);
        viewModel.taskLiveData.observe(this, task -> {
            if (task != null) {
                this.task = task;
                setTitle(task.getTitle());
            }
        });
        viewModel.findTaskById(id);


        //task = getIntent().getParcelableExtra("task");
        //task = TasksStore.getInstance(this).getTasksDAO().fintById(id);
        //setTitle(task.getTitle());

        Button buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helper.deleteTask(task);
                //TasksStore.getInstance(getApplicationContext()).getTasksDAO().delete(task);
                viewModel.delete(task);
                finish();
            }
        });

        Button buttonDone = findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helper.markTaskAsDone(task);
                //TasksStore.getInstance(getApplicationContext()).getTasksDAO().update(new Task(task.getId(), task.getTitle(), true, task.getData()));
                viewModel.update(new Task(task.getId(), task.getTitle(), true, task.getData()));
                finish();
            }
        });
    }
}
