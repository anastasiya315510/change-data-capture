///*
//  author Anastasiya
//  created on 31/08/2021
//  */
//
//package com.apoalim.changedatacapture.service
//
//import com.apoalim.changedatacapture.model.KafkaRecord
//import com.apoalim.changedatacapture.producer.KafkaProducer
//import lombok.extern.slf4j.Slf4j
//import org.apache.spark.SparkContext
//import org.apache.spark.rdd.RDD
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//import scala.collection.JavaConverters._
//@Service
//@Slf4j
//case class ProcessImpl(@Autowired sc: SparkContext, @Autowired producer: KafkaProducer){
//
//
//  def processRecord(list:
//                    java.util.List[KafkaRecord]):Any = {
//
//    val scalaList = list.asScala.toList
//    val rdd: RDD[KafkaRecord] = sc.makeRDD(scalaList)
//    val res:java.util.List[KafkaRecord] = rdd
//      .collect()
//      .toList
//      .sortWith((a,b) => a.getHeaders.getStreamPosition < b.getHeaders.getStreamPosition)
//      .asJava
//
//    producer.writeMessage(res);
//   res
//
//  }
//
//}
