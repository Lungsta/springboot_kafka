package za.co.zalumabo.stream.springboot_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.zalumabo.stream.springboot_kafka.kafka.JsonKafkaProducer;
import za.co.zalumabo.stream.springboot_kafka.model.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer KAFKA_PRODUCER;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.KAFKA_PRODUCER = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User user) {
        KAFKA_PRODUCER.send(user);
        return ResponseEntity.ok("Json message published successfully.");
    }
}
