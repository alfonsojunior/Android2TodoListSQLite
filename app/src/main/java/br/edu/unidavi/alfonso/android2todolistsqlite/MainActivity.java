package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.edu.unidavi.alfonso.android2todolistsqlite.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView taskList = null;
    private FloatingActionButton buttonCreate = null;
    private TasksAdapter adapter = new TasksAdapter(new TasksAdapter.OnTaskClickListener() {
        @Override
        public void onClick(Task task) {
//            Toast.makeText(
//                    getApplicationContext(),
//                    task.getTitle(),
//                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), TaskDetailActivity.class);
            intent.putExtra("task", task);
            startActivity(intent);
        }
    });
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DatabaseHelper(this);

        taskList = findViewById(R.id.task_list);
        taskList.setLayoutManager(new LinearLayoutManager(this));
        taskList.setAdapter(adapter);

        buttonCreate = findViewById(R.id.button_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NewTaskActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Task> tasks = helper.fetchTasks();
        adapter.setup(tasks);
    }
}
