package com.example.wenote;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    public void insert(Note note); //Note se data idhr insert kr re
    @Update
    public void update(Note note);
    @Delete
    public void delete(Note note);
    @Query("SELECT * FROM my_notes") //display all data from the table in database
    public LiveData<List<Note>> getAllData(); //LIveData is a data return type of room database
}
