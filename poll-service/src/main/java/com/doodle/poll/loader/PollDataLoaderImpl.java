package com.doodle.poll.loader;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.exception.PollDataLoadingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class PollDataLoaderImpl implements PollDataLoader {

    @Override
    public List<Poll> loadPolls(String fileToLoad) {

        log.info("Loading poll data from file: {}", fileToLoad);

        List<Poll> loadedPolls;
        try {
            loadedPolls = new ObjectMapper().readValue(new FileInputStream(fileToLoad), new TypeReference<List<Poll>>() {});
        } catch (IOException e) {
            log.error("Poll data loading from file: {} failed! Reason: {}", fileToLoad, e.getLocalizedMessage());
            throw new PollDataLoadingException("Failed to load poll data from file!", e);
        }

        log.info("Successfully loaded {} polls", loadedPolls.size());

        return loadedPolls;
    }

}
