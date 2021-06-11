package com.doodle.poll.service;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.exception.PollCreationException;
import com.doodle.poll.repository.PollQueryRepository;
import com.doodle.poll.repository.PollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;
    private final PollQueryRepository pollQueryRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository, PollQueryRepository pollQueryRepository) {

        this.pollRepository = pollRepository;
        this.pollQueryRepository = pollQueryRepository;
    }

    @Override
    public List<Poll> savePolls(List<Poll> pollsToSave) {

        if (CollectionUtils.isEmpty(pollsToSave)) {
            log.error("Failed to save polls - the input list is empty!");
            throw new PollCreationException("Failed to save polls - the input list is empty!");
        }
        return pollRepository.saveAll(pollsToSave);
    }

    @Override
    public Page<Poll> findPollsByTitleAndDate(String user, String title, LocalDate fromDate, Pageable pageable) {

        Date queryDate = null;
        if (fromDate != null) {
            queryDate = Date.from(fromDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }

        return pollQueryRepository.findPollsByTitleAndDate(user, title, queryDate, pageable);
    }

}
