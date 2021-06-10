package com.doodle.poll.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Participant {

    private long id;
    private String name;
    private Short[] preferences;
}
