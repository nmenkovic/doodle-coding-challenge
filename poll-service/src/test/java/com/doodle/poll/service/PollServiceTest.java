package com.doodle.poll.service;

import com.doodle.poll.domain.Poll;
import com.doodle.poll.exception.PollCreationException;
import com.doodle.poll.repository.PollRepository;
import com.doodle.poll.util.TestPolls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PollServiceTest {

    @Mock
    private PollRepository pollRepository;

    @InjectMocks
    private PollServiceImpl pollService;

    @Test
    public void savePollsTest_HappyPath() {

        Poll pollToSave = TestPolls.createPoll();
        List<Poll> pollsToSave = Collections.singletonList(pollToSave);

        Mockito.when(pollRepository.saveAll(any()))
                .thenReturn(pollsToSave);

        List<Poll> savedPolls = pollService.savePolls(Collections.singletonList(pollToSave));

        Assertions.assertIterableEquals(pollsToSave, savedPolls);
        Mockito.verify(pollRepository, Mockito.times(1)).saveAll(pollsToSave);
    }

    @Test
    public void savePollsTest_GivenNullInputListShouldThrowAnException() {

        PollCreationException exception = null;
        try {
            pollService.savePolls(null);
        } catch (PollCreationException e) {
            exception = e;
        }
        Assertions.assertNotNull(exception);

        Mockito.verifyNoInteractions(pollRepository);
    }

    @Test
    public void savePollsTest_GivenEmptyInputListShouldThrowAnException() {

        PollCreationException exception = null;
        try {
            pollService.savePolls(Collections.emptyList());
        } catch (PollCreationException e) {
            exception = e;
        }
        Assertions.assertNotNull(exception);

        Mockito.verifyNoInteractions(pollRepository);
    }
}
