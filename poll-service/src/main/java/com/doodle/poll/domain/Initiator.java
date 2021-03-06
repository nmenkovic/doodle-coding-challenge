package com.doodle.poll.domain;

import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.TimeZone;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Initiator {

    private String name;
    @TextIndexed
    private String email;
    private TimeZone timeZone;
    private boolean notify;
}
