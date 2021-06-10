package com.doodle.poll.service;

import com.doodle.poll.domain.Poll;

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
}
