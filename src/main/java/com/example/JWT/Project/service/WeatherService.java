package com.example.JWT.Project.service;

import com.example.JWT.Project.entity.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_KEY = "31572450d8fa88057c31f9bd3d298c1f";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={apiKey}&units=metric";

    public String getFullWeatherReport(String city) {
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                WeatherResponse.class,
                city,
                API_KEY
        );

        WeatherResponse data = response.getBody();

        if (data == null) {
            return "Weather data not available.";
        }

        String cityName = data.getName();
        double temperature = data.getMain().getTemp();
        int humidity = data.getMain().getHumidity();
        String description = data.getWeather().get(0).getDescription();
        double windSpeed = data.getWind().getSpeed();

        return String.format(
                "City: %s\nTemperature: %.1f°C\nHumidity: %d%%\nCondition: %s\nWind Speed: %.1f m/s",
                cityName, temperature, humidity, description, windSpeed
        );
    }
}
