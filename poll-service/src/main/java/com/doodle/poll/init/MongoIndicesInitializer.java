package com.doodle.poll.init;

import com.doodle.poll.domain.Poll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MongoIndicesInitializer implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    private final MongoTemplate mongoTemplate;
    private final MongoConverter mongoConverter;

    @Autowired
    public MongoIndicesInitializer(MongoTemplate mongoTemplate, MongoConverter mongoConverter) {
        this.mongoTemplate = mongoTemplate;
        this.mongoConverter = mongoConverter;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initializeIndices();
    }

    public void initializeIndices() {

        log.info("Initializing mongoDB indices...");
        IndexOperations indexOps = mongoTemplate.indexOps(Poll.class);

        IndexResolver resolver = new MongoPersistentEntityIndexResolver(this.mongoConverter.getMappingContext());
        resolver.resolveIndexFor(Poll.class).forEach(indexOps::ensureIndex);
        log.info("Successfully initialized mongoDB indices");
    }

}