package com.github.kadehar.inno.network.auth.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Token(@JsonProperty("userToken") String value) {
}
