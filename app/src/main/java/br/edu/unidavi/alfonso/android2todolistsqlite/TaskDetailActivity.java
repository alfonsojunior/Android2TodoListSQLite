package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;
    //private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        //helper = new DatabaseHelper(this);

        //task = getIntent().getParcelableExtra("task");
        int id = getIntent().getIntExtra("id", 0);
        task = TasksStore.getInstance(this).getTasksDAO().fintById(id);

        setTitle(task.getTitle());

        Button buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helper.deleteTask(task);
                TasksStore.getInstance(getApplicationContext()).getTasksDAO().delete(task);
                finish();
            }
        });

        Button buttonDone = findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //helper.markTaskAsDone(task);
                TasksStore.getInstance(getApplicationContext()).getTasksDAO().update(new Task(task.getId(), task.getTitle(), true, task.getData()));
                finish();
            }
        });
    }
}
