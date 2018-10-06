package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private final Integer id;
    private final String title;
    private final boolean done;

    private final Date data;

    @Ignore
    public Task(String title, boolean done) {
        this.id = null;
        this.title = title;
        this.done = done;
        this.data = new Date();
    }

    public Task(Integer id, String title, boolean done, Date data) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Date getData() {
        return data;
    }
}
