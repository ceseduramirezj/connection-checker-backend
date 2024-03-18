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
@Document(collection = "connections_collection")
public class ConnectionRecord {

    @Transient
    public static final String SEQUENCE_NAME="sequence";

    @Id
    private Long id;
    private String connectionTimeStamp;
    private boolean wasConnected;
}
