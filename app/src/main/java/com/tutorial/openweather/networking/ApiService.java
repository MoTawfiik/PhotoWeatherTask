package com.tutorial.openweather.networking;

import com.tutorial.openweather.model.weather.CurrentWeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService
{
    @GET("weather")
    Single<CurrentWeatherResponse> getCurrentWeather(@Query("lat") double lat,
                                                     @Query("lon") double lon, @Query("appid")String apiKey);
}
