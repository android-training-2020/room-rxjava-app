package us.erlang.room_rxjava_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Person {
    @PrimaryKey
    public int id;

    @ColumnInfo
    public String name;
    @ColumnInfo
    public int gender;
    @ColumnInfo
    public int age;

    public Person(String name, int gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
