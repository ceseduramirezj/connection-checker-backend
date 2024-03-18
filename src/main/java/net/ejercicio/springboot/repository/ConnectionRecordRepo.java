package net.ejercicio.springboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import net.ejercicio.springboot.entity.ConnectionRecord;

public interface ConnectionRecordRepo extends MongoRepository<ConnectionRecord, Long>{

}
