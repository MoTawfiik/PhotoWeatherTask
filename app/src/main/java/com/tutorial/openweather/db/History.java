package com.tutorial.openweather.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class History
{
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "image")
    private String imageUri;


    @ColumnInfo(name = "city")
    private String city;

    private String temp;

    private String maxTemp;

    private String minTemp;

    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public String getImageUri()
    {
        return imageUri;
    }

    public void setImageUri(String imageUri)
    {
        this.imageUri = imageUri;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getTemp()
    {
        return temp;
    }

    public void setTemp(String temp)
    {
        this.temp = temp;
    }

    public String getMaxTemp()
    {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp)
    {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp()
    {
        return minTemp;
    }

    public void setMinTemp(String minTemp)
    {
        this.minTemp = minTemp;
    }
}
