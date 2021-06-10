package com.doodle.poll.dto;

import com.doodle.poll.domain.Device;
import com.doodle.poll.domain.PollType;
import com.doodle.poll.domain.PreferencesType;
import com.doodle.poll.domain.State;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollDTO {

    private String id;
    private String adminKey;
    private Date latestChange;
    private Date initiated;
    private int participantsCount;
    private int inviteesCount;
    private PollType type;
    private Boolean timeZone;
    private Integer rowConstraint;
    private Integer columnConstraint;
    private boolean hidden;
    private PreferencesType preferencesType;
    private State state;
    private String locale;
    private String title;
    private String description;
    private LocationDTO location;
    private InitiatorDTO initiator;
    private List<OptionDTO> options;
    private String optionsHash;
    private List<ParticipantDTO> participants;
    private List<String> invitees;
    private Device device;
    private PreferencesType levels;
    private Boolean multiDay;
    private Boolean dateText;
}
