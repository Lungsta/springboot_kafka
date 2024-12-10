package za.co.zalumabo.stream.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import za.co.zalumabo.stream.springboot_kafka.model.User;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "za.co.zalumabo.stream.springboot_kafka.json_topic", groupId = "zalu")
    public void consume(User user) {
        LOGGER.info("Json message: {}", user.toString());
    }
}
