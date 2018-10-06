package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.unidavi.alfonso.android2todolistsqlite.data.DatabaseHelper;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        helper = new DatabaseHelper(this);

        task = getIntent().getParcelableExtra("task");
        setTitle(task.getTitle());

        Button buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteTask(task);
                finish();
            }
        });

        Button buttonDone = findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.markTaskAsDone(task);
                finish();
            }
        });
    }
}
