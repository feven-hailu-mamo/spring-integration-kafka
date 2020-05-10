package com.spring.kafka.api.kafkapublisher;

import com.spring.kafka.api.kafkapublisher.config.SampleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private String topic = "demoTopic";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        kafkaTemplate.send(topic, "Hi " + name + " Welcome to kafka");
        return "Data published";
    }

    @GetMapping("/publishJson")
    public String publishMessage() {
        SampleUser user = new SampleUser(2532, "user-one", new String[] { "Irving", "Texas", "apartment 100" });
        kafkaTemplate.send(topic, user);
        return "Json Data published";
    }
    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherApplication.class, args);
    }

}
