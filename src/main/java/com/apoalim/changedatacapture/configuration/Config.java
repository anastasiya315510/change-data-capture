/*
 author Anastasiya
 created on 01/09/2021
 */


package com.apoalim.changedatacapture.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
    public JavaSparkContext getContext(){
    SparkConf sparkConf = new SparkConf().setAppName("GroupActionsJob").setMaster("local");
    return  new JavaSparkContext(sparkConf);
  }
}
