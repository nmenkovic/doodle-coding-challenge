package com.doodle.poll.dto;

import lombok.*;

import java.util.TimeZone;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InitiatorDTO {

    private String name;
    private String email;
    private TimeZone timeZone;
    private boolean notify;
}
