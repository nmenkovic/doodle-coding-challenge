package com.doodle.poll.repository;

import com.doodle.poll.domain.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PollQueryRepositoryImpl implements PollQueryRepository {

    private MongoTemplate mongoTemplate;

    @Autowired
    public PollQueryRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Poll> findPollsByTitleAndDate(String user, String title, Date fromDate, Pageable pageable) {

        Query query = new Query();

        if (user != null && !user.isEmpty()) {
            query.addCriteria(Criteria.where("initiator.email").regex(user));
        }

        if (title != null && !title.isEmpty()) {
            query.addCriteria(TextCriteria.forDefaultLanguage().matchingAny(title));
        }

        if (fromDate != null) {
            query.addCriteria(Criteria.where("initiated").gte(fromDate));
        }
        query.with(pageable);

        List<Poll> polls = mongoTemplate.find(query, Poll.class);

        return PageableExecutionUtils.getPage(polls, pageable, () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Poll.class));

    }
}
