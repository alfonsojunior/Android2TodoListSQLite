package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    private Button buttonSave = null;
    private EditText inputTask = null;
    //private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        //helper = new DatabaseHelper(this);
        inputTask = findViewById(R.id.input_new_task);
        inputTask.requestFocus();

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(v -> {
            String value = inputTask.getText().toString();
            if (!value.isEmpty()) {
                //helper.createTask(value);
                TasksStore.getInstance(getApplicationContext()).getTasksDAO().insert(new Task(value, false));
                finish();
            }
        });
    }
}
