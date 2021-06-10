package com.doodle.poll.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {

    private long id;
    private String name;
    private Short[] preferences;
}
