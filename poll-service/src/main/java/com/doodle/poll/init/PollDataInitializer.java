package com.doodle.poll.init;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.loader.PollDataLoader;
import com.doodle.poll.service.PollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PollDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final String fileToLoad;

    private final PollDataLoader pollDataLoader;

    private final PollService pollService;

    @Autowired
    public PollDataInitializer(
            @Value("${poll-service.file-to-load}") String fileToLoad,
            PollDataLoader pollDataLoader,
            PollService pollService
    ) {

        this.fileToLoad = fileToLoad;
        this.pollDataLoader = pollDataLoader;
        this.pollService = pollService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        createPolls();
    }

    private void createPolls() {

        log.info("Started creating polls...");
        List<Poll> loadedPolls = pollDataLoader.loadPolls(fileToLoad);
        List<Poll> savedPolls = pollService.savePolls(loadedPolls);

        log.info("Successfully created {} polls", savedPolls.size());
    }

}
