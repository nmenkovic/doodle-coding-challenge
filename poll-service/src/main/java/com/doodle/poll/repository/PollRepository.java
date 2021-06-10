package com.doodle.poll.repository;

import com.doodle.poll.domain.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<Poll, String> {
}
