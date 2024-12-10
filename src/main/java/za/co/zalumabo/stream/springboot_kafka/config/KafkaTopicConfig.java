package za.co.zalumabo.stream.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaTopic() {
        return new NewTopic("za.co.zalumabo.stream.springboot_kafka.topic", 3, (short) 1);
    }

    @Bean
    public NewTopic kafkaJsonTopic() {
        return new NewTopic("za.co.zalumabo.stream.springboot_kafka.jason_topic", 3, (short) 1);
    }
}
