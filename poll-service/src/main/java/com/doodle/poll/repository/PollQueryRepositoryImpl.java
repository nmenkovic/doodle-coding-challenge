package com.doodle.poll.repository;

import com.doodle.poll.domain.Poll;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PollQueryRepositoryImpl implements PollQueryRepository {

    private MongoTemplate mongoTemplate;

    @Autowired
    public PollQueryRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Poll> findPollsByTitleAndDate(String user, String title, LocalDate fromDate) {

        Query query = new Query();

        if (!StringUtils.isEmpty(user)) {
            query.addCriteria(Criteria.where("initiator.email").regex(user));
        }

        if (!StringUtils.isEmpty(title)) {
            query.addCriteria(TextCriteria.forDefaultLanguage().matchingAny(title));
        }

        if (fromDate != null) {
            query.addCriteria(Criteria.where("initiated").gte(fromDate));
        }

        return mongoTemplate.find(query, Poll.class);
    }
}
