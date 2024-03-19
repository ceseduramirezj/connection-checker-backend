package net.connectionchecker.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "connections_collection")
public class ConnectionRecord {
    @Id
    private String id;
    private String connectionTimeStamp;
    private boolean wasConnected;
}
