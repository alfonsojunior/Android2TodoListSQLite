package br.edu.unidavi.alfonso.android2todolistsqlite;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskBKP implements Parcelable {

    private final int id;
    private final String title;
    private final boolean done;

    public TaskBKP(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    protected TaskBKP(Parcel in) {
        id = in.readInt();
        title = in.readString();
        done = in.readByte() != 0;
    }

    public static final Creator<TaskBKP> CREATOR = new Creator<TaskBKP>() {
        @Override
        public TaskBKP createFromParcel(Parcel in) {
            return new TaskBKP(in);
        }

        @Override
        public TaskBKP[] newArray(int size) {
            return new TaskBKP[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeByte((byte) (done ? 1 : 0));
    }
}
