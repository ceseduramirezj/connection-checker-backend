package net.ejercicio.springboot.service.impl;

import net.ejercicio.springboot.dto.ConnectionRecordDto;
import net.ejercicio.springboot.entity.ConnectionRecord;
import net.ejercicio.springboot.repository.ConnectionRecordRepo;
import net.ejercicio.springboot.service.ConnectionRecordService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionRecordServiceImpl implements ConnectionRecordService {

    @Autowired
    private ConnectionRecordRepo connectionRecordRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConnectionRecordDto createConnectionRecord(ConnectionRecordDto connectionRecordDto){
        ConnectionRecord connectionRecord = modelMapper.map(connectionRecordDto, ConnectionRecord.class);
        ConnectionRecord savedConnectionRecord = connectionRecordRepo.save(connectionRecord);
        ConnectionRecordDto savedConnectionRecordDto = modelMapper.map(savedConnectionRecord, ConnectionRecordDto.class);
        return savedConnectionRecordDto;
    }
}
