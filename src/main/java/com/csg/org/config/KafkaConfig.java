package com.csg.org.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Object> stringProducerFactory() {
        Map<String, Object> configProperties = new HashMap<>();

        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        return new DefaultKafkaProducerFactory<>(configProperties);
    }

    @Bean("stringKafkaTemplate")
    public KafkaTemplate<String, Object> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    public ConsumerFactory<String, Object> stringConsumerFactory() {
        Map<String, Object> configProperties = new HashMap<>();

        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        configProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earlist");
        configProperties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 600000);
        configProperties.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, 600000);

        return new DefaultKafkaConsumerFactory<>(configProperties);

    }


}
