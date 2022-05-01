package com.funck.ifood.application;

import com.funck.ifood.config.WeatherMapsClientProperties;
import com.funck.ifood.domain.WeatherMapsResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

@Service
public class WeatherService {

    private final WebClient webClient;
    private final WeatherMapsClientProperties properties;

    public WeatherService(
            @Qualifier("weatherMapsClient") final WebClient webClient,
            final WeatherMapsClientProperties properties
    ) {
        this.webClient = webClient;
        this.properties = properties;
    }

    @Cacheable(value = "weatherInfo", key = "#city")
    public Mono<WeatherMapsResponse> findWeatherInfoByCity(final String city) {
        return webClient
                .get()
                .uri(buildUri(city))
                .retrieve()
                .bodyToMono(WeatherMapsResponse.class);
    }

    public Mono<WeatherMapsResponse> findWeatherInfoByCityFallBack(final String city) {
        return Mono.empty();
    }

    private Function<UriBuilder, URI> buildUri(String city) {
        return uriBuilder -> uriBuilder
                        .queryParam("q", city)
                        .queryParam("appid", properties.getApiKey())
                        .build();
    }

}
