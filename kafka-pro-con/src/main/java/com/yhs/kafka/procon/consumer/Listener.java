package com.yhs.kafka.procon.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Charles
 * @Title: Listener
 * @Package com.yhs.kafka.procon.consumer
 * @Description: TODO
 * @date 2017/11/29 11:37
 */
@Component
public class Listener {

    Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(topics = {"haha"})
    public void listen(ConsumerRecord<?,?> record){
        logger.info("========fetch record============"+record);
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.out.println("listen message = "+message);
        }
    }
}