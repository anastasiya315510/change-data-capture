/*
 author Anastasiya
 created on 29/08/2021
 */


package com.apoalim.changedatacapture.producer;

import com.apoalim.changedatacapture.model.KafkaRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
public class KafkaProducer {
    private static final String TOPIC_OUTPUT = "my-cdc-output-topic";

     @Autowired
    private KafkaTemplate<String, KafkaRecord> kafkaTemplate;

     public void writeMessage(List<KafkaRecord> list){
         list.forEach(el->{
             this.kafkaTemplate.send(TOPIC_OUTPUT, el);
         log.info(String.format("record create -> %s", el));
         });

     }
}
