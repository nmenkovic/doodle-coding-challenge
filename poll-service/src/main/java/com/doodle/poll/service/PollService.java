package com.doodle.poll.service;

import com.doodle.poll.domain.Poll;

import java.time.LocalDate;
import java.util.List;

public interface PollService {

    /**
     * Saves given {@link Poll}s into db.
     *
     * @param pollsToSave
     *
     * @return saved {@link Poll}s
     */
    List<Poll> savePolls(List<Poll> pollsToSave);

    /**
     * Finds {@link Poll}s by given fields' values.
     * If parameters' values are omitted, returns all {@link Poll}s.
     *
     * @param user will be compared to initiator.email
     * @param title will be compared to title
     * @param fromDate will be compared to initiated
     *
     * @return filtered {@link Poll}s
     */
    List<Poll> findPollsByTitleAndDate(String user, String title, LocalDate fromDate);
}
