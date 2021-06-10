package com.doodle.poll.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class Initiator {

    private String name;
    @TextIndexed
    private String email;
    private TimeZone timeZone;
    private boolean notify;
}
