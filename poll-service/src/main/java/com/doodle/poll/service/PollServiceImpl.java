package com.doodle.poll.service;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.exception.PollCreationException;
import com.doodle.poll.repository.PollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> savePolls(List<Poll> pollsToSave) {

        if (CollectionUtils.isEmpty(pollsToSave)) {
            log.error("Failed to save polls - the input list is empty!");
            throw new PollCreationException("Failed to save polls - the input list is empty!");
        }
        return pollRepository.saveAll(pollsToSave);
    }

}
