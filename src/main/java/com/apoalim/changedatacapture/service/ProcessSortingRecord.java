/*
 author Anastasiya
 created on 01/09/2021
 */


package com.apoalim.changedatacapture.service;

import com.apoalim.changedatacapture.model.KafkaRecord;
import com.apoalim.changedatacapture.producer.KafkaProducer;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProcessSortingRecord {

    @Autowired
    private JavaSparkContext sparkContext;
    @Autowired
    private KafkaProducer producer;

    public List<KafkaRecord> processRecord(List<KafkaRecord> list) {
        JavaRDD<KafkaRecord> recordJavaRDD = sparkContext.parallelize(list);
        List<KafkaRecord> recordList = recordJavaRDD
                .sortBy(el -> Integer.parseInt(el.getHeaders().getStreamPosition()), true, 1)
                .takeOrdered(10);
        producer.writeMessage(recordList);
        return new ArrayList<>();
    }
}
