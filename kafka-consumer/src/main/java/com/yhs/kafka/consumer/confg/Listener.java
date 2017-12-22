package com.yhs.kafka.consumer.confg;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author Charles
 * @Title: Listener
 * @Package com.yhs.kafka.consumer.confg
 * @Description: TODO
 * @date 2017/11/28 15:06
 */
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
    }

   /* @KafkaListener(topics = {"first"})
    public void listen1(ConsumerRecord<?, ?> record) {
        logger.info("kafka的first的key: " + record.key());
        logger.info("kafka的first的value: " + record.value().toString());
    }*/
}