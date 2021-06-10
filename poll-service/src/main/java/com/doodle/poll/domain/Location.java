package com.doodle.poll.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Location {

    @JsonProperty("locationId")
    private String id;
    private String name;
    private String address;
    private String countryCode;
}
