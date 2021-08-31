package com.apoalim.changedatacapture.configuration

import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}

@Configuration
@ComponentScan
case class Config() {
  @Bean def sc: SparkContext = {
    val conf = new SparkConf().setAppName("change-data-capture").setMaster("local[*]")
    new SparkContext(conf)
  }


}