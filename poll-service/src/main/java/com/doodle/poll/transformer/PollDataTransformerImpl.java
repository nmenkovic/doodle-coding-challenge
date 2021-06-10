package com.doodle.poll.transformer;

import com.doodle.poll.domain.*;
import com.doodle.poll.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollDataTransformerImpl implements PollDataTransformer {

    @Override
    public List<PollDTO> pollDTOsFromPolls(List<Poll> polls) {

        return polls.stream()
                .map(this::pollDTOFromPoll)
                .collect(Collectors.toList());
    }
    
    private PollDTO pollDTOFromPoll(Poll poll) {

        if (poll == null) {
            return null;
        }

        return PollDTO.builder()
                .id(poll.getId())
                .adminKey(poll.getAdminKey())
                .latestChange(poll.getLatestChange())
                .initiated(poll.getInitiated())
                .participantsCount(poll.getParticipantsCount())
                .participants(participantDTOsFromParticipants(poll.getParticipants()))
                .inviteesCount(poll.getInviteesCount())
                .invitees(poll.getInvitees())
                .type(poll.getType())
                .timeZone(poll.getTimeZone())
                .rowConstraint(poll.getRowConstraint())
                .columnConstraint(poll.getColumnConstraint())
                .hidden(poll.isHidden())
                .preferencesType(poll.getPreferencesType())
                .state(poll.getState())
                .locale(poll.getLocale())
                .title(poll.getTitle())
                .description(poll.getDescription())
                .location(locationDTOFromLocation(poll.getLocation()))
                .initiator(initiatorDTOFromInitiator(poll.getInitiator()))
                .options(optionDTOsFromOptions(poll.getOptions()))
                .optionsHash(poll.getOptionsHash())
                .device(poll.getDevice())
                .levels(poll.getLevels())
                .multiDay(poll.getMultiDay())
                .dateText(poll.getDateText())
                .build();
    }

    private LocationDTO locationDTOFromLocation(Location location) {

        if (location == null) {
            return null;
        }

        return LocationDTO.builder()
                .id(location.getId())
                .name(location.getName())
                .address(location.getAddress())
                .countryCode(location.getCountryCode())
                .build();
    }

    private InitiatorDTO initiatorDTOFromInitiator(Initiator initiator) {

        if (initiator == null) {
            return null;
        }

        return InitiatorDTO.builder()
                .name(initiator.getName())
                .email(initiator.getEmail())
                .timeZone(initiator.getTimeZone())
                .notify(initiator.isNotify())
                .build();
    }

    private List<OptionDTO> optionDTOsFromOptions(List<Option> options) {

        return options.stream()
                .map(this::optionDTOFromOption)
                .collect(Collectors.toList());
    }

    private OptionDTO optionDTOFromOption(Option option) {

        if (option == null) {
            return null;
        }

        return OptionDTO.builder()
                .text(option.getText())
                .start(option.getStart())
                .end(option.getEnd())
                .startDate(option.getStartDate())
                .endDate(option.getEndDate())
                .startDateTime(option.getStartDateTime())
                .endDateTime(option.getEndDateTime())
                .date(option.getDate())
                .dateTime(option.getDateTime())
                .allDay(option.isAllDay())
                .available(option.isAvailable())
                .build();
    }

    private List<ParticipantDTO> participantDTOsFromParticipants(List<Participant> participants) {

        return participants.stream()
                .map(this::participantDTOFromParticipant)
                .collect(Collectors.toList());
    }

    private ParticipantDTO participantDTOFromParticipant(Participant participant) {

        if (participant == null) {
            return null;
        }

        return ParticipantDTO.builder()
                .id(participant.getId())
                .name(participant.getName())
                .preferences(participant.getPreferences())
                .build();
    }

}
