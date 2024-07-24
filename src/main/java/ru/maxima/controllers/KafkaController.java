package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.kafka.KafkaProducer;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/kafka")
    public ResponseEntity<String> sendMessage(@RequestParam("key") String message) {
        kafkaProducer.writeMsg(message);
        return ResponseEntity.ok(message);
    }
}
