package ru.maxima.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final String TOPIC = "my_first_topic";

    @KafkaListener(topics = TOPIC, groupId = "my_group_id")
    public void listenTopic(String message) {
        System.out.println(message);
    }
}
