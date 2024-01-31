package com.ujjwalweather.WeatherApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather(String city) {
        String apiUrlWithCity = apiUrl + "/current.json?key=" + apiKey + "&q=" + city;
        return restTemplate.getForObject(apiUrlWithCity, String.class);
    }

}
