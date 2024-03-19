package net.connectionchecker.springboot.controller;

import net.connectionchecker.springboot.entity.ConnectionRecord;
import net.connectionchecker.springboot.service.ConnectionRecordService;
import net.connectionchecker.springboot.service.GeneratedSequenceService;
import net.connectionchecker.springboot.dto.ConnectionRecordDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connection_record")
public class ConnectionRecordController {

    @Autowired
    private ConnectionRecordService connectionRecordService;

    @Autowired
    private GeneratedSequenceService generatedSequenceService;

    @PostMapping("/insert")
    public ResponseEntity<ConnectionRecordDto> insert(@RequestBody ConnectionRecordDto connectionRecord){
        connectionRecord.setId(generatedSequenceService.getSequenceNumber(ConnectionRecord.SEQUENCE_NAME));
        ConnectionRecordDto savedConnectionRecord = connectionRecordService.createConnectionRecord(connectionRecord);
        return new ResponseEntity<>(savedConnectionRecord, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/insertMany")
    public ResponseEntity<List<ConnectionRecordDto>> insertMany(@RequestBody List<ConnectionRecordDto> connectionRecords){
        List<ConnectionRecordDto> savedConnectionRecords = new ArrayList<>();

        for(ConnectionRecordDto connectionRecord : connectionRecords){
            connectionRecord.setId(generatedSequenceService.getSequenceNumber(ConnectionRecord.SEQUENCE_NAME));
            ConnectionRecordDto savedConnectionRecord = connectionRecordService.createConnectionRecord(connectionRecord);
            savedConnectionRecords.add(savedConnectionRecord);
        }

        return new ResponseEntity<>(savedConnectionRecords, HttpStatus.CREATED);
    }
}
