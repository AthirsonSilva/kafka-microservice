package api.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGEr = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "demoGroup")
    public void consume(String message) {
        LOGGEr.info(String.format("Consumed message --> %s", message));
        System.out.println("Consumed message: " + message);
    }
}
