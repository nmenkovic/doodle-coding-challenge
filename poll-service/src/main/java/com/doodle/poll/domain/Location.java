package com.doodle.poll.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @JsonProperty("locationId")
    private String id;
    private String name;
    private String address;
    private String countryCode;
}
