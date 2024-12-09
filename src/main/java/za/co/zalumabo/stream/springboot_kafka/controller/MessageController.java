package za.co.zalumabo.stream.springboot_kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.zalumabo.stream.springboot_kafka.kafka.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private final KafkaProducer KAFKA_PRODUCER;

    public MessageController(KafkaProducer kafkaProducer) {
        this.KAFKA_PRODUCER = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        KAFKA_PRODUCER.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic.");

    }
}
