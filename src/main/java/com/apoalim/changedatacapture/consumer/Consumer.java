/*
 author Anastasiya
 created on 29/08/2021
 */


package com.apoalim.changedatacapture.consumer;


import com.apoalim.changedatacapture.controller.CDCController;
import com.apoalim.changedatacapture.model.KafkaRecord;
import com.apoalim.changedatacapture.producer.KafkaProducer;
import com.apoalim.changedatacapture.service.ProcessSortingRecord;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import scala.sys.process.ProcessImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
@Slf4j
public class Consumer {
    static List<KafkaRecord> list = new ArrayList<>();

    @Autowired
    KafkaProducer producer;

    @Autowired
    CDCController cdcController;

    @Autowired
    ProcessSortingRecord process;



    @KafkaListener(topics = "my-cdc-input-topic",groupId = "my_group_id")
    public void consume(KafkaRecord record){
        log.info("record"+record);
        KafkaRecord processRecord = cdcController.processRecord(record);
        list.add(processRecord);
        if(list.size()%5==0) {
            process.processRecord(list);

        }
    }

}
