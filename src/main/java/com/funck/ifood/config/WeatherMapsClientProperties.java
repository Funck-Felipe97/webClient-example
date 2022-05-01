package com.funck.ifood.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class WeatherMapsClientProperties {

    @Value("${api.weather-maps.base-url}")
    private String baseUrl;

    @Value("${api.weather-maps.api-key}")
    private String apiKey;

}
