package com.doodle.poll.transformer;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.dto.PollDTO;

import java.util.List;

public interface PollDataTransformer {

    List<PollDTO> pollDTOsFromPolls(List<Poll> poll);
}
