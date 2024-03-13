package net.ejercicio.springboot.service.impl;

import net.ejercicio.springboot.entity.Conexion;
import net.ejercicio.springboot.repository.ConexionRepo;
import net.ejercicio.springboot.service.ConexionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexionServiceImpl implements ConexionService{
    @Autowired
    private ConexionRepo conexionRepo;

    @Override
    public Conexion addConexion(Conexion conexion){
        return conexionRepo.save(conexion);
    }
}
