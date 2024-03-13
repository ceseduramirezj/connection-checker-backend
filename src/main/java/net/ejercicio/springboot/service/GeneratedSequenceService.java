package net.ejercicio.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.ejercicio.springboot.entity.GeneratedSequence;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

@Service
public class GeneratedSequenceService {
    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        GeneratedSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), GeneratedSequence.class);
        return !Objects.isNull(counter)? counter.getSeq() : 1;
    }
}
