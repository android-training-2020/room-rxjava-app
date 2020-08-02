package us.erlang.room_rxjava_app;

import android.app.Activity;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSource {
    PersonDao personDao;

    public LocalDataSource(Context context) {
        AppDatabase db = Room.databaseBuilder(context,
                AppDatabase.class, "users").build();
        personDao = db.getPersonDao();
    }

    Single<Long> createPerson(Person person) {
        return personDao.createPerson(person);
    }

    Single<List<Person>> getPersons() {
        return personDao.getPersons();
    }
}
