package com.spring.kafka.api.kafkaconsumer;

import com.spring.kafka.api.kafkaconsumer.config.SampleUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class KafkaConsumerApplication {

    List<String> messages = new ArrayList<>();

    SampleUser userFromTopic = null;

    @GetMapping("/consume-string-message")
    public List<String> consumeMsg() {
        return messages;
    }

    @GetMapping("/consume-json-message")
    public SampleUser consumeJsonMessage() {
        return userFromTopic;
    }

    @KafkaListener(groupId = "demo-group-string", topics = "demoTopic", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messages.add(data);
        return messages;
    }

    @KafkaListener(groupId = "demo-group-json", topics = "demoTopic", containerFactory = "userKafkaListenerContainerFactory")
    public SampleUser getJsonMsgFromTopic(SampleUser user) {
        userFromTopic = user;
        return userFromTopic;
    }
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

}
