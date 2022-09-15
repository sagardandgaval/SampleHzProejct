package com.csg.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaService {

    @Autowired
    private KafkaTemplate<String, Object> stringKafkaTemplate;

}


