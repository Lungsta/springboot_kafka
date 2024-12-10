package za.co.zalumabo.stream.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "za.co.zalumabo.stream.springboot_kafka.topic", groupId = "zalu")
    public void consume(String message) {
        LOGGER.info("Consumed message: {}", message);
    }
}
