package net.connectionchecker.springboot.service.impl;

import net.connectionchecker.springboot.dto.ConnectionRecordDto;
import net.connectionchecker.springboot.entity.ConnectionRecord;
import net.connectionchecker.springboot.repository.ConnectionRecordRepo;
import net.connectionchecker.springboot.service.ConnectionRecordService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConnectionRecordServiceImpl implements ConnectionRecordService {

    @Autowired
    private ConnectionRecordRepo connectionRecordRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConnectionRecordDto createConnectionRecord(ConnectionRecordDto connectionRecordDto){
        ConnectionRecord connectionRecord = modelMapper.map(connectionRecordDto, ConnectionRecord.class);
        String id = UUID.nameUUIDFromBytes(connectionRecord.getConnectionTimeStamp().getBytes()).toString();
        connectionRecord.setId(id);
        ConnectionRecord savedConnectionRecord = connectionRecordRepo.save(connectionRecord);
        ConnectionRecordDto savedConnectionRecordDto = modelMapper.map(savedConnectionRecord, ConnectionRecordDto.class);
        return savedConnectionRecordDto;
    }
}
