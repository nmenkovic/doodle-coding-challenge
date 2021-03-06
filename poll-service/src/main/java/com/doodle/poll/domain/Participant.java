package com.doodle.poll.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

    private long id;
    private String name;
    private Short[] preferences;
}
