package za.co.zalumabo.stream.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, String> KAFKA_TEMPLATE;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.KAFKA_TEMPLATE = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info("Sending message: {}", message);
        KAFKA_TEMPLATE.send("za.co.zalumabo.stream.springboot_kafka.topic", message);
    }
}
