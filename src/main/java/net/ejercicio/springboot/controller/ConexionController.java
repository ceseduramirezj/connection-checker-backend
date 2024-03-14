package net.ejercicio.springboot.controller;

import net.ejercicio.springboot.entity.Conexion;
import net.ejercicio.springboot.service.ConexionService;
import net.ejercicio.springboot.service.GeneratedSequenceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/conexiones")
public class ConexionController {

    @Autowired
    private ConexionService conexionService;

    @Autowired
    private GeneratedSequenceService generatedSequenceService;

    @PostMapping("/insert")
    public Conexion insert(@RequestBody Conexion conexion){
        //generar id
        conexion.setId(generatedSequenceService.getSequenceNumber(Conexion.SEQUENCE_NAME));
        return conexionService.addConexion(conexion);
    }

    @PostMapping("/insertMany")
    public List<Conexion> insertMany(@RequestBody List<Conexion> conexiones){
        for(Conexion conexion: conexiones){
            conexion.setId(generatedSequenceService.getSequenceNumber(Conexion.SEQUENCE_NAME));
            conexionService.addConexion(conexion);
        }
        return conexiones;
    }
}
