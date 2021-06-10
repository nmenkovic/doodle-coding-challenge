package com.doodle.poll.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "polls")
public class Poll {

    @Id
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
    @TextIndexed
    private String title;
    private String description;
    private Location location;
    private Initiator initiator;
    private List<Option> options;
    private String optionsHash;
    private List<Participant> participants;
    private List<String> invitees;
    private Device device;
    private PreferencesType levels;
    private Boolean multiDay;
    private Boolean dateText;
}
