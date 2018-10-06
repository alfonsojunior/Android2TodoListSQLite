package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TasksDAO {

    @Query("SELECT * FROM tasks")
    public List<Task> fetchTasks();

    @Query("SELECT * FROM tasks WHERE id=:id")
    public Task fintById(int id);

    @Insert
    public void insert(Task task);

    @Update
    public void update(Task task);

    @Delete
    public void delete(Task task);

}
