package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        task = getIntent().getParcelableExtra("task");
        setTitle(task.getTitle());
    }
}
