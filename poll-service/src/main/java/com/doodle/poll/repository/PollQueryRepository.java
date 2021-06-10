package com.doodle.poll.repository;


import com.doodle.poll.domain.Poll;

import java.time.LocalDate;
import java.util.List;

public interface PollQueryRepository {

    List<Poll> findPollsByTitleAndDate(String user, String title, LocalDate fromDate);
}
