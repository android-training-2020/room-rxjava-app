package us.erlang.room_rxjava_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PersonDao {
    @Insert
    Single<Long> createPerson(Person person);

    @Query("select * from users")
    Single<List<Person>> getPersons();
}
