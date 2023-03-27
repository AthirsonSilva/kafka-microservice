package api.kafka.kafka;

import api.kafka.payload.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void publish(User request) {
        String[] list = request.getFirstName().split(" ");

        IntStream
                .range(0, list.length)
                .forEach(i -> LOGGER.info("Publishing message to Kafka: {}", list[i]));


        LOGGER.info("Publishing message to Kafka: {}", request);

        Message<User> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "javaguides_json")
                .build();

        kafkaTemplate.send(message);
    }
}
