/*
 author Anastasiya
 created on 29/08/2021
 */


package com.apoalim.changedatacapture.controller;

import com.apoalim.changedatacapture.model.EventOperation;
import com.apoalim.changedatacapture.model.HeaderKafkaRecord;
import com.apoalim.changedatacapture.model.KafkaRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CDCController {


   @PostMapping
   public KafkaRecord processRecord(KafkaRecord record){
       //        a.    If the event occurred in the source DB was an Update or Insert => output the new row value ("data" field)
       //        b.    If the event occurred in the source DB was a Delete => output a tombstone Kafka record (a record with null value).
        if(record.getHeaders().getOperation().equals(EventOperation.DELETE)){
            return KafkaRecord.builder().build();
        }
      return   KafkaRecord.builder().pk(record.getPk())
              .beforeData(record.getData())
              .data(LocalDateTime.now())
              .headers(HeaderKafkaRecord.builder()
                        .operation(record.getHeaders().getOperation())
                        .streamPosition(record.getHeaders().getStreamPosition())
                        .timestamp(record.getHeaders().getTimestamp())
                        .build())
                .build();


    }

}
