package com.doodle.poll.transformer;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.dto.PollDTO;

import java.util.List;

public interface PollDataTransformer {

    /**
     * Transforms a list of {@link PollDTO}s to a list of {@Poll}s
     *
     * @param polls polls to be transformed
     *
     * @return {@link PollDTO} list created from given {@link Poll} list
     */
    List<PollDTO> pollDTOsFromPolls(List<Poll> polls);
}
