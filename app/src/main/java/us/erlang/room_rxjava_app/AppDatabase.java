package us.erlang.room_rxjava_app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 2, entities = {Person.class}, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
