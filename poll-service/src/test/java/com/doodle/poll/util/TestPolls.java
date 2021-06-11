package com.doodle.poll.util;

import com.doodle.poll.domain.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestPolls {

    public static Poll createPoll() {
        return Poll.builder()
                .id("xsd4cv89t5f5um4b")
                .adminKey("r44d7piq")
                .latestChange(Date.from(Instant.parse("2017-01-27T12:52:53.482+00:00")))
                .initiated(Date.from(Instant.parse("2017-01-27T12:52:49.056+00:00")))
                .participantsCount(4)
                .inviteesCount(0)
                .type(PollType.TEXT)
                .hidden(true)
                .preferencesType(PreferencesType.YESNO)
                .state(State.OPEN)
                .locale("fr_CH")
                .title("Qui sont les superhéros Marvel les plus oufs?")
                .initiator(createInitiator())
                .options(createOptions())
                .optionsHash("509166a0b12ed8e4ec658f0060aaf38e")
                .participants(createParticipants())
                .device(Device.WEB)
                .levels(PreferencesType.YESNO)
                .build();
    }

    private static Initiator createInitiator() {
        return Initiator.builder()
                .name("John Doe")
                .email("mh+sample@doodle.com")
                .notify(false)
                .build();
    }

    private static List<Option> createOptions() {

        Option spiderman = Option.builder().text("Spider-Man").available(true).allDay(false).build();
        Option hulk = Option.builder().text("Hulk").available(true).allDay(false).build();
        Option thor = Option.builder().text("Thor").available(true).allDay(false).build();

        return Arrays.asList(spiderman, hulk, thor);
    }

    private static List<Participant> createParticipants() {

        Participant ringo = Participant.builder().id(1722022335).name("Ringo").preferences(new Short[] { 1, 0, 0}).build();
        Participant peter = Participant.builder().id(1873740236).name("Peter").preferences(new Short[] { 0, 0, 1}).build();
        Participant john = Participant.builder().id(1035270451).name("John").preferences(new Short[] { 0, 0, 1}).build();
        Participant paul = Participant.builder().id(1985279871).name("Paul").preferences(new Short[] { 0, 1, }).build();

        return Arrays.asList(ringo, peter, john, paul);
    }
}