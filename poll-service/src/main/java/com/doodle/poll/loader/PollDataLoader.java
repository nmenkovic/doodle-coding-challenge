package com.doodle.poll.loader;

import com.doodle.poll.domain.Poll;

import java.util.List;

public interface PollDataLoader {

    /**
     * The method loads poll data from json file, unmarshals the data, and returns the list of  {@link Poll} objects.
     *
     * @param fileToLoad file which contains {@link Poll} objects in json format
     *
     * @return list of {@link Poll} objects
     */
    List<Poll> loadPolls(String fileToLoad);

}
