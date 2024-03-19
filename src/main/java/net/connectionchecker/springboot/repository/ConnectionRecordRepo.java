package net.connectionchecker.springboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import net.connectionchecker.springboot.entity.ConnectionRecord;

public interface ConnectionRecordRepo extends MongoRepository<ConnectionRecord, Long>{

}
