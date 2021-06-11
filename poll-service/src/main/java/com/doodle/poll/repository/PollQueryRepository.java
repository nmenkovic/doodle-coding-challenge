package com.doodle.poll.repository;


import com.doodle.poll.domain.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface PollQueryRepository {

    /**
     * Finds {@link Poll}s by given fields' values.
     * If parameters' values are omitted, returns all {@link Poll}s.
     *
     * @param user will be compared to initiator.email
     * @param title will be compared to title
     * @param fromDate will be compared to initiated
     * @param pageable size of the page that will be returned, its number, and sorting criteria
     *
     * @return filtered {@link Poll}s
     */
    Page<Poll> findPollsByTitleAndDate(String user, String title, Date fromDate, Pageable pageable);
}
