///*
// author Anastasiya
// created on 31/08/2021
// */
//
//
//package com.apoalim.changedatacapture.configuration;
//
//import com.fasterxml.jackson.databind.JsonSerializer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaProducerConfig {
//    @Bean
//    public ProducerFactory<String, ?> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "localhost:9092");
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, ?> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}