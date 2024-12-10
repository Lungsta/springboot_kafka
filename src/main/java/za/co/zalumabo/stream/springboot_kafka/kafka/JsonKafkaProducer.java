package za.co.zalumabo.stream.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import za.co.zalumabo.stream.springboot_kafka.model.User;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate<String, User> KAFKA_TEMPLATE;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.KAFKA_TEMPLATE = kafkaTemplate;
    }

    public void send(User user) {
        LOGGER.info("Sending user to kafka: {}", user.toString());
        KAFKA_TEMPLATE.send("za.co.zalumabo.stream.springboot_kafka.json_topic", user);
    }
}
