package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    private Button buttonSave = null;
    private EditText inputTask = null;
    private TasksViewModel viewModel;
    //private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        viewModel = ViewModelProviders.of(this).get(TasksViewModel.class);
        viewModel.success.observe(this, success -> {
            if (Boolean.TRUE.equals(success)) {
                finish();
            }
        });

        //helper = new DatabaseHelper(this);
        inputTask = findViewById(R.id.input_new_task);
        inputTask.requestFocus();

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(v -> {
            String value = inputTask.getText().toString();
            if (!value.isEmpty()) {
                //helper.createTask(value);
                //TasksStore.getInstance(getApplicationContext()).getTasksDAO().insert(new Task(value, false));
                viewModel.saveTask(new Task(value, false));
                //finish();
            }
        });
    }
}
