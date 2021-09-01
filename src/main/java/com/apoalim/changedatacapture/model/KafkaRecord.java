/*
 author Anastasiya
 created on 29/08/2021
 */


package com.apoalim.changedatacapture.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KafkaRecord implements Serializable, Comparable<KafkaRecord>{
     private Long pk;
     private LocalDateTime data;
     private LocalDateTime beforeData;
     private HeaderKafkaRecord headers;


     @Override
     public int compareTo(KafkaRecord record) {
          return Integer.compare(Integer.parseInt(this.getHeaders().getStreamPosition()),
                  Integer.parseInt(record.getHeaders().getStreamPosition()));

     }
}
