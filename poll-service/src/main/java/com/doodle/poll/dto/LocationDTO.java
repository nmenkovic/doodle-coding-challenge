package com.doodle.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    @JsonProperty("locationId")
    private String id;
    private String name;
    private String address;
    private String countryCode;
}
