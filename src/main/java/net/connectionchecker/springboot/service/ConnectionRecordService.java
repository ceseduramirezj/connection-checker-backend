package net.connectionchecker.springboot.service;

import net.connectionchecker.springboot.dto.ConnectionRecordDto;

public interface ConnectionRecordService {
    public ConnectionRecordDto createConnectionRecord(ConnectionRecordDto connectionRecordDto);
}
