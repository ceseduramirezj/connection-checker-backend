package net.ejercicio.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "conexiones")
public class Conexion {

    @Transient
    public static final String SEQUENCE_NAME="conexion_sequence";

    @Id
    private int id;
    private String timestampConexion;
    private boolean hayConexion;
}
