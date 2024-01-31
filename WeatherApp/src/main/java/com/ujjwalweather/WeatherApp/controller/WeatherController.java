package com.ujjwalweather.WeatherApp.controller;

import com.ujjwalweather.WeatherApp.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        String weatherData = weatherService.getWeather(city);
        return ResponseEntity.ok(weatherData);
    }
}
