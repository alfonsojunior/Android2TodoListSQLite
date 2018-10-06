package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = Task.class, version = 2)
@TypeConverters({DateConverter.class})
public abstract class TasksStore extends RoomDatabase {

    public abstract TasksDAO getTasksDAO();

    private static TasksStore instance = null;

    public static TasksStore getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    TasksStore.class,
                    "Tasks.db")
                    //.allowMainThreadQueries() // Executar sem ser async
                    //.fallbackToDestructiveMigration() // Usado para destruir o banco e recriar
                    .addMigrations(Migrations.FROM_1_TO_2)
                    .build();
        }
        return instance;
    }

}
