package net.connectionchecker.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionRecordDto {
    private Long id;
    private String connectionTimeStamp;
    private boolean wasConnected;
}
