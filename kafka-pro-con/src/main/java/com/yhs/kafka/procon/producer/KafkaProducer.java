package com.yhs.kafka.procon.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Charles
 * @Title: KafkaProducer
 * @Package com.yhs.kafka.procon.producer
 * @Description: TODO
 * @date 2017/11/29 11:38
 */
@Component
public class KafkaProducer {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendTest(){
        String data = "{\"name\":\"zhangsan\",\"age\":"+new Random().nextInt(100)+"}";
        kafkaTemplate.send("haha",data);
    }
}