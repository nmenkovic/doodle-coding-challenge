package com.doodle.poll.transformer;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.dto.PollDTO;
import org.springframework.data.domain.Page;


public interface PollDataTransformer {

    /**
     * Transforms a list of {@link PollDTO}s to a list of {@Poll}s
     *
     * @param polls polls to be transformed
     *
     * @return paged {@link PollDTO} list created from given {@link Poll} list
     */
    Page<PollDTO> pollDTOsFromPolls(Page<Poll> polls);
}
