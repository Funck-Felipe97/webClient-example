package com.funck.ifood.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MeteorologicalInfo(
        @JsonProperty("temp")       Long temperature,
        @JsonProperty("feels_like") Long feelsLike,
        @JsonProperty("temp_min")   Long temperatureMin,
        @JsonProperty("temp_max")   Long temperatureMax,
        @JsonProperty("pressure")   Long pressure,
        @JsonProperty("humidity")   Long humidity
) {}
