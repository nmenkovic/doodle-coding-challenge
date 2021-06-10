package com.doodle.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionDTO {

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
