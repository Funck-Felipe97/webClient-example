package com.funck.ifood.resource;

import com.funck.ifood.application.WeatherService;
import com.funck.ifood.domain.WeatherMapsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherResource {

    private final WeatherService weatherService;

    @GetMapping
    public Mono<WeatherMapsResponse> findWeatherInfoByCity(@RequestParam final String city) {
        return weatherService.findWeatherInfoByCity(city);
    }

}
