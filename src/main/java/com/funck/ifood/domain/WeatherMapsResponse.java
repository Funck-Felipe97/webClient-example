package com.funck.ifood.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherMapsResponse (
    @JsonProperty("weather") List<WeatherInfo> weatherInfo,
    @JsonProperty("main")    MeteorologicalInfo meteorologicalInfo
) {}
