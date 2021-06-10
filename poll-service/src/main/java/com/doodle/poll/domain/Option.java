package com.doodle.poll.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Option {

    private String text;
    private Date start;
    private Date end;
    private Date startDate;
    private Date endDate;
    private Date startDateTime;
    private Date endDateTime;
    private Date date;
    private Date dateTime;
    @JsonProperty("allday")
    private boolean allDay;
    private boolean available;
}
