package com.yhs.kafka.procon;

import com.yhs.kafka.procon.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Charles
 * @Title: Pro_ConApplication
 * @Package com.yhs.kafka.procon
 * @Description: TODO
 * @date 2017/11/29 11:33
 */
@SpringBootApplication
@EnableScheduling
public class Pro_ConApplication {
    @Autowired
    private KafkaProducer kafkaSender;

    public static void main(String[] args) {
        SpringApplication.run(Pro_ConApplication.class,args);
    }

    /**
     * 每隔3秒发送一次消息
     * @throws Exception
     */
    @Scheduled(fixedRate = 1000*10)
    public void testKafka() throws Exception{
        kafkaSender.sendTest();
    }


}
