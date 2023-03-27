package api.kafka.controller;

import api.kafka.kafka.JsonKafkaProducer;
import api.kafka.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json")
@RequiredArgsConstructor
public class JsonMessageController {
    private final JsonKafkaProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<User> publish(@RequestBody User request) {
        producer.publish(request);

        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
}
