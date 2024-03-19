package net.connectionchecker.springboot.service.impl;

import net.connectionchecker.springboot.entity.GeneratedSequence;
import net.connectionchecker.springboot.service.GeneratedSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class GeneratedSequenceServiceImpl implements GeneratedSequenceService {
    @Autowired
    private MongoOperations mongoOperations;

    public Long getSequenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1L);
        GeneratedSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), GeneratedSequence.class);
        return !Objects.isNull(counter)? counter.getSeq() : 1L;
    }
}
