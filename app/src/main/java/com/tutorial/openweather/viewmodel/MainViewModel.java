package com.tutorial.openweather.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.tutorial.openweather.model.weather.CurrentWeatherResponse;
import com.tutorial.openweather.networking.NetworkState;
import com.tutorial.openweather.repository.MainRepository;

public class MainViewModel extends ViewModel
{
    private MainRepository repository;

    public MainViewModel()
    {
        repository = new MainRepository();
    }

    public LiveData<CurrentWeatherResponse> getCurrentWeather(double latitude, double longitude)
    {
        repository.getCurrentWeather(latitude, longitude);

        return repository.getWeatherResponseLiveData();
    }

    public LiveData<NetworkState> getNetworkState()
    {
        return repository.getNetworkStateLiveData();
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();
        repository.getDisposable().dispose();
    }
}
