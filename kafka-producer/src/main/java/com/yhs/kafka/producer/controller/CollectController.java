package com.yhs.kafka.producer.controller;

import com.yhs.kafka.producer.util.Response;
import com.yhs.kafka.producer.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Charles
 * @Title: CollectController
 * @Package com.yhs.kafka.producer.controller
 * @Description: TODO
 * @date 2017/11/28 10:46
 */

@RestController
@RequestMapping("/kafka")
public class CollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public Response sendKafka(HttpServletRequest request, HttpServletResponse response) {
        try {
            String message = request.getParameter("message");
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("test", "key", message);
            logger.info("发送kafka成功.");
            return new Response(ResultCode.SUCCESS, "发送kafka成功", null);
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return new Response(ResultCode.EXCEPTION, "发送kafka失败", null);
        }
    }

    @RequestMapping(value = "/send2", method = RequestMethod.POST)
    @ResponseBody
    public Map send2Kafka(@RequestBody Map map){
        Map returnMap = new HashMap();
        try {
            if(map != null){
                logger.info("kafka的消息={}", map.get("first"));
                kafkaTemplate.send("first", "key", map.get("first"));
                logger.info("发送kafka成功.");
                returnMap.put("success",ResultCode.SUCCESS);
                returnMap.put("content","发送kafka成功");
                returnMap.put("code",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("success",ResultCode.EXCEPTION);
            returnMap.put("content","发送kafka失败");
            returnMap.put("code",null);

        }
        return returnMap;
    }

}