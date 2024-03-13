package net.ejercicio.springboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import net.ejercicio.springboot.entity.Conexion;

public interface ConexionRepo extends MongoRepository<Conexion, Integer>{

}
