package net.connectionchecker.springboot.repository;


import net.connectionchecker.springboot.entity.ConnectionRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConnectionRecordRepo extends MongoRepository<ConnectionRecord, Long>{

}
