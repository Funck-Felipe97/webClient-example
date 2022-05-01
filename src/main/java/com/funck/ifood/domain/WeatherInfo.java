package com.funck.ifood.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherInfo (
    @JsonProperty("id")          String id,
    @JsonProperty("main")        String main,
    @JsonProperty("description") String description,
    @JsonProperty("icon")        String icon
) {}
