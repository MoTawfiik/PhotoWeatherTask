package com.tutorial.openweather.db;

import androidx.room.RoomDatabase;

public abstract class appDatabase extends RoomDatabase
{
    public abstract HistoryDAO historyDAO();


}
