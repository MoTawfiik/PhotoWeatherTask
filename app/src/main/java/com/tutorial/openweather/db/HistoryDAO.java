package com.tutorial.openweather.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHistory(History history);

    @Query("SELECT * FROM history")
    List<History> getHistories();
}
